package com.uniovi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Product;
import com.uniovi.repositories.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

//	public List<Product> getProducts() {
//		List<Product> products = new ArrayList<Product>();
//		productsRepository.findAll().forEach(products::add);
//		return products;
//	}
	
	public Page<Product> getProducts(Pageable pageable) {
		Page<Product> products = productsRepository.findAll(pageable);
		return products;
	}

	public List<Product> getOwnedProducts(String id) {
		return productsRepository.findByOwner("99999990A");
	}
	
}
