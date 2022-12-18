package com.tacocloud.kirilanastasoff.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tacocloud.kirilanastasoff.tacocloud.security.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}