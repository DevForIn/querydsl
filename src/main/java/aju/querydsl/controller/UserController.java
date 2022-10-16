package aju.querydsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import aju.querydsl.dto.UserDto;
import aju.querydsl.entity.User;
import aju.querydsl.service.MainServiceImpl;

@RestController
public class UserController {
	
	private MainServiceImpl mainService;
	@Autowired
	public UserController(MainServiceImpl mainService) {
		this.mainService = mainService;
	}
	
	// User List Read
	@GetMapping("/users")
	public List<User> userList(){	
		return mainService.findAll();
	}
	
	// User 해당 ID로 조회
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		return mainService.findById(id);				
	}	
	
	// User 생성	
	@PostMapping("/users")
	public ResponseEntity<?> insertUser(UserDto userDto){
		mainService.saveUser(userDto);
		return  ResponseEntity.ok().body(userDto);
	}
	
	// User 해당 ID의 테이블 수정
	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable Long id, UserDto userDto) {		
		mainService.updateById(id, userDto);
	}	
	
	// User 해당 ID 삭제 테이블
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		mainService.deleteById(id);
	}
	
	
	
	
	
	
	
	
	/* querydsl insert Controller
	
	@PostMapping("/Usersdsl/{id}")
	public void insertById(User user) {		
		repositorySupport.create(user);
	}
	
	@PostMapping("/memberdsl/{id}")
	public void insertByMemberId(Member member) {		
		repositorySupport.createMember(member);
	}
	*/
}






/* querydsl insert Controller

@PostMapping("/Usersdsl/{id}")
public void insertById(User user) {		
	repositorySupport.create(user);
}

@PostMapping("/memberdsl/{id}")
public void insertByMemberId(Member member) {		
	repositorySupport.createMember(member);
}
*/
