package aju.querydsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import aju.querydsl.dto.PeopleDto;
import aju.querydsl.service.MainServiceImpl;

@RestController
public class JoinController {

	private MainServiceImpl mainService;

	@Autowired
	public JoinController(MainServiceImpl mainService) {
		this.mainService = mainService;
	}
	
	// Company Id에 등록된 User 목록 + company Name
	@GetMapping("/users/company/{id}")
	public List<PeopleDto> companyPeople(@PathVariable Long id){		
		return mainService.findByCompanyUsers(id);
	}	
}
