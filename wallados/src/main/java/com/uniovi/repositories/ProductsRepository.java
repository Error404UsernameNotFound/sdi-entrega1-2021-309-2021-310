package com.uniovi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Product;

public interface ProductsRepository extends CrudRepository<Product, String> {
	
//	@Query("")
//	List<Product> searchByTitle(String title);
	
	Page<Product> findAll(Pageable pageable);
	
	@Query("SELECT r FROM Product r WHERE r.user.id = ?1 ")
	Page<Product> findBoughtByUserId(Pageable pageable, String userId);

}
