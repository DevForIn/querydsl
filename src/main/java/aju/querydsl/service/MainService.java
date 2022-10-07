package aju.querydsl.service;


import aju.querydsl.dto.CompanyDto;
import aju.querydsl.dto.UserDto;
import aju.querydsl.entity.Company;
import aju.querydsl.entity.User;


public interface MainService {	
	
    default User dtoToEntity(UserDto dto, Company findCompany){
    	User entity = User.builder()
                .userAge(dto.getUserAge())
                .userName(dto.getUserName())
                .userEmail(dto.getUserEmail())  
                .company(findCompany)
                .build();
        return entity;
    }
    default Company dtoToEntity(CompanyDto dto){
    	Company entity = Company.builder()
                .companyName(dto.getCompanyName())
                .build();
        return entity;
    }
	
	int saveUser(UserDto userDto);		

	int saveCompany(CompanyDto companyDto);
}
