package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Product;

public interface ProductsRepository extends CrudRepository<Product, String> {
	
//	@Query("")
//	List<Product> searchByTitle(String title);
	
	Page<Product> findAll(Pageable pageable);

}
