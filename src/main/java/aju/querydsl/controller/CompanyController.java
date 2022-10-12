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

import aju.querydsl.dto.CompanyDto;
import aju.querydsl.entity.Company;
import aju.querydsl.service.MainServiceImpl;

@RestController
public class CompanyController {
	
	private MainServiceImpl mainService;

	@Autowired
	public CompanyController(MainServiceImpl mainService) {
		this.mainService = mainService;
	}

	// Company List
	@GetMapping("/companys")
	public List<Company> companyList() {
		return mainService.findAllCompany();
	}

	// Company ID로 조회
	@GetMapping("/companys/{id}")
	public Company getCompany(@PathVariable Long id) {
		return mainService.findByCompanyId(id);
	}

	// Company Create
	@PostMapping("/companys")
	public ResponseEntity<?> insertCompany(CompanyDto companyDto) {
		mainService.saveCompany(companyDto);
		return ResponseEntity.ok().body(companyDto);
	}

	// Company ID 수정
	@PutMapping("/companys/{id}")
	public void updateCompany(@PathVariable Long id, CompanyDto companyDto) {
		mainService.updateByIdCompany(id, companyDto);
	}

	// Company ID 삭제
	@DeleteMapping("/companys/{id}")
	public void deleteCompany(@PathVariable Long id) {
		mainService.deleteByIdCompany(id);
	}
}
