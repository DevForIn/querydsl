package aju.querydsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import aju.querydsl.entity.User;
import aju.querydsl.repository.UserRepository;
import aju.querydsl.repository.UserRepositorySupport;

@RestController
public class UserController {
	
	private UserRepositorySupport userRepositorySupport;
	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository, UserRepositorySupport userRepositorySupport) {
		this.userRepositorySupport = userRepositorySupport;
		this.userRepository = userRepository;
	}
	
	// User List Read
	@GetMapping("/Users")
	public List<User> findAll(){
		return userRepositorySupport.findAll();
	}
	
	// User Create 
	@PostMapping("/Users")
	public ResponseEntity<?> save(User user) {
		if(user.getId() != null) {
			if(userRepositorySupport.findById(user.getId()) != null) {
				return ResponseEntity.notFound().build();
			}
		}		
		userRepository.save(user);
		return  ResponseEntity.ok().body(user);
	}
	
	// User find by id
	@GetMapping("/Users/{id}")
	public User findById(Long id) {
		return userRepositorySupport.findById(id);				
	}
	
	// User Update by id
	@PutMapping("/Users/{id}")
	public void updateById(Long id,User user) {		
		userRepositorySupport.updateById(id, user);
	}
	
	// User Delete by id
	@DeleteMapping("/Users/{id}")
	public void deleteById(Long id) {
		userRepositorySupport.deleteById(id);
	}
}
