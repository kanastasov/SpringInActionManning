package com.tacocloud.kirilanastasoff.tacocloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.tacocloud.kirilanastasoff.tacocloud.model.Ingredient;
import com.tacocloud.kirilanastasoff.tacocloud.model.RegistrationForm;
import com.tacocloud.kirilanastasoff.tacocloud.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
//	@Autowired
//	private UserRepository userRepo;
	
	RestTemplate rest = new RestTemplate();
	private PasswordEncoder passwordEncoder;

//	@Autowired
	public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
//		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	public RegistrationController(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
	

	public RegistrationController() {
		super();
	}

	@GetMapping
	public String registerForm() {
		return "registration";
	}

	@PostMapping
	public String processRegistration(RegistrationForm form) {
//		userRepo.save(form.toUser(passwordEncoder));
		return "redirect:/login";
	}
	
	public Ingredient getIngredientById(String ingredientId) {
		ResponseEntity<Ingredient> responseEntity =
		rest.getForEntity("http://localhost:8080/ingredients/{id}",
		Ingredient.class, ingredientId);
//		log.info("Fetched time: " +
//		responseEntity.getHeaders().getDate());
		return responseEntity.getBody();
		}
}