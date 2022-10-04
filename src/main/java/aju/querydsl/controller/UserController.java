package aju.querydsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void save(User user) {
		if(!userRepositorySupport.findById(user.getId()).equals(null)){
			System.out.println("데이터 입력 오류");
		}
		else userRepository.save(user);
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
