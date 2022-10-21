package aju.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aju.querydsl.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{	
	
}
