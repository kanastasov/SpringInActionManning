package com.tacocloud.kirilanastasoff.tacocloud.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.tacocloud.kirilanastasoff.tacocloud.model.Ingredient;

@Component
public interface IngredientRepository {
	
	Iterable<Ingredient> findAll();

	Optional<Ingredient> findById(String id);

	Ingredient save(Ingredient ingredient);
}