package com.uniovi.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String email;
	private String name;
	private String lastName;
	private String role;
	private double money;

	private String password;
	@Transient
	private String passwordConfirm;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Product> productsOwned;
	
	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
	private Set<Product> productsBuyed;

	public User(String email, String name, String lastName) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
	}

	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return this.name + " " + this.lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Set<Product> getProductsOwned() {
		return productsOwned;
	}

	public void setProductsOwned(Set<Product> productsOwned) {
		this.productsOwned = productsOwned;
	}

	public Set<Product> getProductsBuyed() {
		return productsBuyed;
	}

	public void setProductsBuyed(Set<Product> productsBuyed) {
		this.productsBuyed = productsBuyed;
	}
	
}
