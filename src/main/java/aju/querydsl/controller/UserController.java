package aju.querydsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import aju.querydsl.dto.CompanyDto;
import aju.querydsl.dto.PeopleDto;
import aju.querydsl.dto.UserDto;
import aju.querydsl.entity.Company;
import aju.querydsl.entity.User;
import aju.querydsl.repository.RepositorySupport;
import aju.querydsl.service.MainServiceImpl;

@RestController
public class UserController {
	
	private RepositorySupport repositorySupport;
	private MainServiceImpl mainService;
	
	@Autowired
	public UserController(RepositorySupport repositorySupport,MainServiceImpl mainService) {
		this.repositorySupport = repositorySupport;
		this.mainService = mainService;
	}
	
	//   USER Controller -------------------------------------------------	
	
	// User List Read
	@GetMapping("/users")
	public List<User> userList(){	
		return repositorySupport.findAll();
	}
	
	// User 해당 ID로 조회
	@GetMapping("/users/{id}")
	public User getUser(Long id) {
		return repositorySupport.findById(id);				
	}
	
	
	// User 생성	
	@PostMapping("/users")
	public ResponseEntity<?> insertUser(UserDto userDto){
		mainService.saveUser(userDto);
		return  ResponseEntity.ok().body(userDto);
	}
	
	// User 해당 ID의 테이블 수정
	@PutMapping("/users/{id}")
	public void updateUser(Long id,UserDto userDto) {		
		mainService.updateById(id, userDto);
	}	
	
	// User 해당 ID 삭제 테이블
	@DeleteMapping("/users/{id}")
	public void deleteUser(Long id) {
		repositorySupport.deleteById(id);
	}
	
	//   Company Controller -------------------------------------------------		
	
	// Company List 
	@GetMapping("/companys")
	public List<Company> companyList(){
		return repositorySupport.findAllCompany();
		
	}
	
	// Company ID로 조회 
	@GetMapping("/companys/{id}")
	public Company getCompany(Long companyId){
		return repositorySupport.findByCompanyId(companyId);
		
	}
	
	// Company Create 
	@PostMapping("/companys")
	public ResponseEntity<?> insertCompany(CompanyDto companyDto) {	
		mainService.saveCompany(companyDto);
		return  ResponseEntity.ok().body(companyDto);
	}
	
	// Company ID 수정
	@PutMapping("/companys/{id}")
	public void updateMember(Long id,Company company) {
		repositorySupport.updateByIdCompany(id, company);
	}
	
	// Company ID 삭제
	@DeleteMapping("/companys/{id}")
	public void deleteCompany(Long id) {
		repositorySupport.deleteByIdCompany(id);
	}
	
	
	
	//   JOIN  -------------------------------------------------
	
	
	// Company Id에 등록된 User 목록 + company Name
	@GetMapping("/users/company/{id}")
	public List<PeopleDto> companyPeople(Long id){		
		return mainService.findByCompanyUsers(id);
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
