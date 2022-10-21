package aju.querydsl.service;

import aju.querydsl.dto.CompanyDto;
import aju.querydsl.dto.UserDto;
import aju.querydsl.entity.Company;
import aju.querydsl.entity.User;

public interface MainService {	
	
    default User dtoToEntity(UserDto dto, Company findCompany){
    	System.out.println("User dtoToEntity Service 실행");
    	User entity = User.builder()
                .userAge(dto.getUserAge())
                .userName(dto.getUserName())
                .userEmail(dto.getUserEmail())  
                .company(findCompany)
                .build();
        return entity;
    }
    default Company dtoToEntity(CompanyDto dto){
    	System.out.println("Company dtoToEntity Service 실행");
    	Company entity = Company.builder()
                .companyName(dto.getCompanyName())
                .build();
        return entity;
    }
}
