package com.tacocloud.kirilanastasoff.tacocloud.repository;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import com.tacocloud.kirilanastasoff.tacocloud.model.Taco;

public interface TacoRepository  extends CrudRepository<Taco, Long>{
	Optional<Taco> findAll(PageRequest page);
	
	Optional<Taco> findById(Long id);
}
