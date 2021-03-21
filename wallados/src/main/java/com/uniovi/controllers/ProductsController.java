package com.uniovi.controllers;

import java.security.Principal;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Product;
import com.uniovi.services.ProductsService;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@RequestMapping("/offert/list")
	public String getList(Model model, Pageable pageable, Principal principal) {
		Page<Product> products = new PageImpl<Product>(new LinkedList<Product>());
		
		products = productsService.getProducts(pageable);

		model.addAttribute("productsList", products.getContent());
		model.addAttribute("page", products);
		
		return "offert/list";
	}
	
	@RequestMapping("/offert/list/update")
	public String updateList(Model model, Pageable pageable, Principal principal) {
		Page<Product> products = productsService.getProducts(pageable);
		
		model.addAttribute("productsList", products.getContent());

		return "offert/list :: tableProducts";
	}
//	, @RequestParam(value="", required=false) String id
	@RequestMapping("/offertOwned/list")
	public String getListOwned(Model model) {
		model.addAttribute("productsOwnedList", productsService.getOwnedProducts("99999990A"));
		return "offert/listOwned";
	}

}
