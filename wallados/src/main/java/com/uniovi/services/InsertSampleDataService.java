package com.uniovi.services;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Product;
import com.uniovi.entities.User;

@Service
public class InsertSampleDataService {
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired 
	private RolesService rolesService;

	@PostConstruct
	public void init() {
		User user1 = new User("99999990A", "Pedro", "Díaz");
		user1.setPassword("123456");
		user1.setRole(rolesService.getRoles()[2]);
		User user2 = new User("99999991B", "Lucas", "Núñez");
		user2.setPassword("123456");
		user2.setRole(rolesService.getRoles()[1]);
		User user3 = new User("99999992C", "María", "Rodríguez");
		user3.setPassword("123456");
		user3.setRole(rolesService.getRoles()[1]);
		User user4 = new User("99999993D", "Marta", "Almonte");
		user4.setPassword("123456");
		user4.setRole(rolesService.getRoles()[1]);
		User user5 = new User("99999977E", "Pelayo", "Valdes");
		user5.setPassword("123456");
		user5.setRole(rolesService.getRoles()[1]);
		User user6 = new User("99999988F", "Edward", "Núñez");
		user6.setPassword("123456");
		user6.setRole(rolesService.getRoles()[1]);
		
		Product prodA1 = new Product("Producto A1", "Descripcion1", 10.0, user1);
		Product prodA2 = new Product("Producto A2", "Descripcion2", 9.0, user1);
		Product prodA3 = new Product("Producto A3", "Descripcion3", 7.0, user1);
		Product prodA4 = new Product("Producto A4", "Descripcion4", 6.5, user1);

		Product prodB1 = new Product("Producto B1", "Descripcion5", 5.0, user2);
		Product prodB2 = new Product("Producto B2", "Descripcion6", 4.3, user2);
		Product prodB3 = new Product("Producto B3", "Descripcion7", 8.0, user2);
		Product prodB4 = new Product("Producto B4", "Descripcion8", 3.5, user2);

		Product prodC1 = new Product("Producto C1", "Descripcion9", 5.5, user3);
		Product prodC2 = new Product("Producto C2", "Descripcion10", 6.6, user3);
		Product prodC3 = new Product("Producto C3", "Descripcion11", 7.0, user3);
		
		Product prodD1 = new Product("Producto D1", "Descripcion12", 10.0, user4);
		Product prodD2 = new Product("Producto D2", "Descripcion13", 8.0, user4);
		Product prodD3 = new Product("Producto D3", "Descripcion14", 9.0, user4);
		
		Set<Product> user1Products = new HashSet<Product>() {
			{
				add(prodA1);
				add(prodA2);
				add(prodA3);
				add(prodA4);
			}
		};
		user1.setProductsOwned(user1Products);
		Set<Product> user2Products = new HashSet<Product>() {
			{
				add(prodB1);
				add(prodB2);
				add(prodB3);
				add(prodB4);
			}
		};
		user2.setProductsOwned(user2Products);
		Set<Product> user3Products = new HashSet<Product>() {
			{
				;
				add(prodC1);
				add(prodC2);
				add(prodC3);
			}
		};
		user3.setProductsOwned(user3Products);
		Set<Product> user4Products = new HashSet<Product>() {
			{
				add(prodD1);
				add(prodD2);
				add(prodD3);
			}
		};
		user4.setProductsOwned(user4Products);
		
		usersService.addUser(user1);
		usersService.addUser(user2);
		usersService.addUser(user3);
		usersService.addUser(user4);
		usersService.addUser(user5);
		usersService.addUser(user6);
		
		productsService.addProduct(prodA1);
		productsService.addProduct(prodA2);
		productsService.addProduct(prodA3);
		productsService.addProduct(prodA4);
		productsService.addProduct(prodB1);
		productsService.addProduct(prodB2);
		productsService.addProduct(prodB3);
		productsService.addProduct(prodB4);
		productsService.addProduct(prodC1);
		productsService.addProduct(prodC2);
		productsService.addProduct(prodC3);
		productsService.addProduct(prodD1);
		productsService.addProduct(prodD2);
		productsService.addProduct(prodD3);
	}
}