package aju.querydsl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aju.querydsl.dto.CompanyDto;
import aju.querydsl.dto.UserDto;
import aju.querydsl.entity.Company;
import aju.querydsl.entity.User;
import aju.querydsl.service.MainServiceImpl;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class QuerydslApplicationTests {

	@Autowired
	MainServiceImpl msi;
	
	@Autowired
    private EntityManager entityManager;
	
	@Test
	@Transactional
	@Order(7)
    void 회원ID초기화() {
		System.out.println("\n---회원ID 초기화---");		
        entityManager
            .createNativeQuery("ALTER TABLE user AUTO_INCREMENT = 1")
            .executeUpdate();
    }
	
	@Test
	@Transactional
	@Order(6)
    void 회사ID초기화() {
		System.out.println("\n---회사ID 초기화---");		
        entityManager
            .createNativeQuery("ALTER TABLE company AUTO_INCREMENT = 1")
            .executeUpdate();
    }
	@Test
	@Order(5)
	void 회사삭제() {
		System.out.println("\n---회사 삭제---");
		Company com = msi.findByCompanyName("테스트회사");
		msi.deleteByIdCompany(com.getCompanyId());
	}
	
	@Test
	@Order(4)
	void 회원삭제() {
		System.out.println("\n---회원 삭제---");
		User result = msi.findByName("테스터이름");
		msi.deleteById(result.getUserId());
	}
	
	@Test
	@Order(3)
	void 회원검색() {		
		System.out.println("\n---회원 검색---");
		User result = msi.findByName("테스터이름");				
        if(!result.equals(null)){
        	System.out.println("검색 NAME : 테스터이름");
    		System.out.println("테스트 회원 ID : "+result.getUserId());
    		System.out.println("테스트 회원 Name : "+result.getUserName());
    		System.out.println("테스트 회원 Email : "+result.getUserEmail());
    		System.out.println("테스트 회원 Age : "+result.getUserAge());
    		System.out.println("테스트 회사 ID : "+result.getCompany().getCompanyId());
    		System.out.println("테스트 회사 Name : "+result.getCompany().getCompanyName());
    		
        }		
	}
	
	@Test
	@Order(2)
	void 회원생성() {		
		System.out.println("\n---회원 생성---");
		UserDto userDto = new UserDto();
		User result = new User();		
		userDto.setUserName("테스터이름");
		userDto.setUserEmail("테스터@이메일");
		userDto.setUserAge(999);
		Company com = msi.findByCompanyName("테스트회사");
		userDto.setCompanyNum(com.getCompanyId());
		
		result = msi.saveUser(userDto);
	
		System.out.println("테스트 회원 ID : "+result.getUserId());
		System.out.println("테스트 회원 Name : "+result.getUserName());
		System.out.println("테스트 회원 Email : "+result.getUserEmail());
		System.out.println("테스트 회원 Age : "+result.getUserAge());
		System.out.println("테스트 회사 ID : "+result.getCompany().getCompanyId());
		System.out.println("테스트 회사 Name : "+result.getCompany().getCompanyName());
		
	}
	
	@Test
	@Order(1)
	void 회사생성() {
		System.out.println("\n---회사 생성---");
		CompanyDto companyDto = new CompanyDto();
		Company result = new Company();		
		
		companyDto.setCompanyName("테스트회사");
		
		result = msi.saveCompany(companyDto);
	
		System.out.println("테스트 회사 ID : "+result.getCompanyId());
		System.out.println("테스트 회사 Name : "+result.getCompanyName());		
						
	}	
}
