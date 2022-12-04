package com.tacocloud.kirilanastasoff.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tacocloud.kirilanastasoff.tacocloud.model.TacoOrder;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("tacoOrder", new TacoOrder());
		return "order";
	}

	@PostMapping
	public String processOrder(@Valid TacoOrder order, Errors errors) {
	if (errors.hasErrors()) {
	return "order";
	}
	return "redirect:/";
	}

}