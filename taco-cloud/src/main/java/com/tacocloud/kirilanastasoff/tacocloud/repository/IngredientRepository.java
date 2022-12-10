package com.tacocloud.kirilanastasoff.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.tacocloud.kirilanastasoff.tacocloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}