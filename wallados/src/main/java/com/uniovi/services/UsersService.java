package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.uniovi.entities.User;
import com.uniovi.repositories.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		usersRepository.findAll().forEach(users::add);
		return users;
	}

	public List<User> getUsersNotAdmin() {
		List<User> users = new ArrayList<User>();
		usersRepository.findAllNotAdmin().forEach(users::add);
		return users;
	}

	public User getUser(Long id) {
		return usersRepository.findById(id).get();
	}

	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usersRepository.save(user);
	}

	public void editUser(User user) {
		usersRepository.save(user);
	}

	public User getUserByEmail(String email) {
		return usersRepository.findByEmail(email);
	}

	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}
	
	public List<User> searchUsersByEmailAndName(String searchText) {
		List<User> users = new ArrayList<User>();
		searchText = "%"+searchText+"%";
		users = usersRepository.searchByEmailOrName(searchText);
		return users;
	}
	
	public List<User> searchUsersNotAdminByEmailAndName(String searchText) {
		List<User> users = new ArrayList<User>();
		searchText = "%"+searchText+"%";
		users = usersRepository.searchByEmailOrNameNotAdmin(searchText);
		return users;
	}

}
