package com.tacocloud.kirilanastasoff.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.tacocloud.kirilanastasoff.tacocloud.model.TacoOrder;
import com.tacocloud.kirilanastasoff.tacocloud.repository.OrderRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

	private OrderRepository orderRepo;

	public OrderController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	@PostMapping
	public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			return "orderForm";
		}
		orderRepo.save(order);
		sessionStatus.setComplete();
		return "redirect:/";
	}

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("tacoOrder", new TacoOrder());
		return "order";
	}

//	@PostMapping
//	public String processOrder(@Valid TacoOrder order, Errors errors) {
//		if (errors.hasErrors()) {
//			return "order";
//		}
//		return "redirect:/";
//	}

}