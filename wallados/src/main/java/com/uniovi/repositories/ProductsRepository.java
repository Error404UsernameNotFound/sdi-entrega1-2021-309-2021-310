package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.User;

public interface ProductsRepository extends CrudRepository<User, String> {

}
