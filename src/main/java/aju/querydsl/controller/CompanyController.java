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

import com.google.gson.Gson;

import aju.querydsl.dto.CompanyDto;
import aju.querydsl.entity.Company;
import aju.querydsl.service.MainServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CompanyController {
	
	private MainServiceImpl mainService;
	private final Gson gson = new Gson();

	@Autowired
	public CompanyController(MainServiceImpl mainService) {
		this.mainService = mainService;
	}

	// Company List
	@GetMapping("/companys")
	public List<Company> companyList() {
		log.info("-----------------companyList !!!!!! -----------------");
		List<Company> listCom = mainService.findAllCompany();
		log.info("companyList --->>>> "+listCom);
		log.info("-----------------------------------------------------");
		return listCom;
	}

	// Company ID로 조회
	@GetMapping("/companys/{id}")
	public String getCompany(@PathVariable Long id) {
		log.info("-----------------getCompany !!!!!! -----------------");
		Company com = mainService.findByCompanyId(id);		
		log.info("getCompany --->>>> "+com.toString());
		
		String jcom = gson.toJson(com);
		// {"companyId":2,"companyName":"COGNET9"}
		
		log.info("getCompany to json ---->>>> "+jcom.toString());
		log.info("----------------------------------------------------");
		return jcom;
	}

	// Company Create
	@PostMapping("/companys")
	public ResponseEntity<?> insertCompany(CompanyDto companyDto) {
		log.info("-----------------insertCompany !!!!!! -----------------");
		mainService.saveCompany(companyDto);
		log.info("-------------------------------------------------------");
		return ResponseEntity.ok().body(companyDto);
	}

	// Company ID 수정
	@PutMapping("/companys/{id}")
	public void updateCompany(@PathVariable Long id, CompanyDto companyDto) {
		log.info("-----------------updateCompany !!!!!! -----------------");
		mainService.updateByIdCompany(id, companyDto);
		log.info("-------------------------------------------------------");
	}

	// Company ID 삭제
	@DeleteMapping("/companys/{id}")
	public void deleteCompany(@PathVariable Long id) {
		log.info("-----------------deleteCompany !!!!!! -----------------");
		mainService.deleteByIdCompany(id);
		log.info("-------------------------------------------------------");
	}
}
