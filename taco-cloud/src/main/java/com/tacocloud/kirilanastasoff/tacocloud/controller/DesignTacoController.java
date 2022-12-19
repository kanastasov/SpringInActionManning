package com.tacocloud.kirilanastasoff.tacocloud.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tacocloud.kirilanastasoff.tacocloud.model.Ingredient;
import com.tacocloud.kirilanastasoff.tacocloud.model.Ingredient.Type;
import com.tacocloud.kirilanastasoff.tacocloud.model.Taco;
import com.tacocloud.kirilanastasoff.tacocloud.repository.IngredientRepository;
import com.tacocloud.kirilanastasoff.tacocloud.repository.TacoRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/design", produces = { "application/json", "text/xml" })
@SessionAttributes("tacoOrder")
public class DesignTacoController {

	private IngredientRepository ingredientRepo;
	@Autowired
	private TacoRepository tacoRepo;

	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = (List<Ingredient>) ingredientRepo.findAll();
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
	}

//	@ModelAttribute
//	public void addIngredientsToModel(Model model) {
//		List<Ingredient> ingredients = Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//				new Ingredient("COTO", "Corn Tortilla", Type.WRAP), new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES), new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//				new Ingredient("CHED", "Cheddar", Type.CHEESE), new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
//				new Ingredient("SLSA", "Salsa", Type.SAUCE), new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
//
//		Type[] types = Ingredient.Type.values();
//		for (Type type : types) {
//			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
//		}
//	}

	@GetMapping
	public String showDesignForm(Model model) {
		model.addAttribute("taco", new Taco());
		return "design";
	}

	@PostMapping
	public String processTaco(@Valid Taco taco, Errors errors) {
		if (errors.hasErrors()) {
			return "design";
		}
		// Save the taco...
		// We'll do this in chapter 3
//	log.info("Processing taco: " + taco);
		return "redirect:/orders/current";
	}

	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}

	public DesignTacoController(TacoRepository tacoRepo) {
		this.tacoRepo = tacoRepo;
	}

//	@GetMapping("/recent")
//	public Resources<TacoEntityModel> recentTacos() {
//		PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
//		List<Taco> tacos = tacoRepo.findAll(page).getContent();
//		List<TacoEntityModel> tacoResources = new TacoEntityModelAssembler().toModels(tacos);
//		Resources<TacoEntityModel> recentResources = new Resources<TacoEntityModel>(tacoResources);
//		recentResources.add(linkTo(methodOn(DesignTacoController.class).recentTacos()).withRel("recents"));
//		return recentResources;
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
		Optional<Taco> optTaco = tacoRepo.findById(id);
		if (optTaco.isPresent()) {
			return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Taco postTaco(@RequestBody Taco taco) {
		return tacoRepo.save(taco);
	}

}