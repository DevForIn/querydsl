package aju.querydsl.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aju.querydsl.dto.CompanyDto;
import aju.querydsl.dto.PeopleDto;
import aju.querydsl.dto.UserDto;
import aju.querydsl.entity.Company;
import aju.querydsl.entity.User;
import aju.querydsl.repository.CompanyRepository;
import aju.querydsl.repository.RepositorySupport;
import aju.querydsl.repository.UserRepository;

@Service
public class MainServiceImpl implements MainService {
 
	private UserRepository userRepository;
	private CompanyRepository companyRepository;		
	private RepositorySupport repositorySupport;
	
	@Autowired
    private EntityManager entityManager;

	@Autowired
	public MainServiceImpl(RepositorySupport repositorySupport, UserRepository userRepository,
			CompanyRepository companyRepository) {
		this.repositorySupport = repositorySupport;
		this.userRepository = userRepository;
		this.companyRepository = companyRepository;
	}

	public List<Company> findAllCompany() {		
		return repositorySupport.findAllCompany();
	}
	
	public User saveUser(UserDto userDto) {
		Company findCompany = repositorySupport.findByCompanyId(userDto.getCompanyNum());
		User entity = dtoToEntity(userDto, findCompany);
		if (findCompany == null) {
			System.out.println("해당 ID의 Company 테이블이 존재하지 않음.");
			return null;
		} 
			userRepository.save(entity);
			return entity;		
	}

	public Company saveCompany(CompanyDto companyDto) {
		Company entity = dtoToEntity(companyDto);
		return companyRepository.save(entity);		
	}

	public int updateById(Long id, UserDto userDto) {
		User findUser = repositorySupport.findById(id);
		Company findCompany = repositorySupport.findByCompanyId(userDto.getCompanyNum());
		User entity = dtoToEntity(userDto, findCompany);
		if(findUser == null) {
			System.out.println("해당 ID가 존재하지 않음.");
			return 0;
		}		
		if (findCompany == null ) {
			System.out.println("해당 Company ID의 테이블이 존재하지 않음.");
			return 0;
		} 
		
		repositorySupport.updateById(id, entity);
		return 1;		
	}

	public List<PeopleDto> findByCompanyUsers(Long id) {
		Company findCompany = repositorySupport.findByCompanyId(id);
		if (findCompany == null ) {
			System.out.println("해당 Company ID의 테이블이 존재하지 않음.");
			return null;
		} 
		List<PeopleDto> people = repositorySupport.findByCompanyUsers(id);
		System.out.println(people);
		return people;				
	}
	
	public List<User> findAll() {		
		return repositorySupport.findAll();
	}

	public User findById(Long id) {
		return repositorySupport.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		repositorySupport.deleteById(id);
		entityManager
        	.createNativeQuery("ALTER TABLE user AUTO_INCREMENT = 1")
        	.executeUpdate();				
	}


	public Company findByCompanyId(Long id) {
		return repositorySupport.findByCompanyId(id);
	}

	public int updateByIdCompany(Long id, CompanyDto companyDto) {		
		Company findCompany = repositorySupport.findByCompanyId(id);
		Company entity = dtoToEntity(companyDto);
		if (findCompany == null ) {
			System.out.println("해당 Company ID의 테이블이 존재하지 않음.");
			return 0;
		} else {
			repositorySupport.updateByIdCompany(id, entity);
			return 1;
		}
	}
	
	@Transactional
	public void deleteByIdCompany(Long id) {
		repositorySupport.deleteByIdCompany(id);	
		entityManager
        .createNativeQuery("ALTER TABLE company AUTO_INCREMENT = 1")
        .executeUpdate();		
	}

	public Company findByCompanyName(String name) {
		return repositorySupport.findByCompanyName(name);		
	}

	public User findByName(String name) {
		return repositorySupport.findByName(name);	
	}
}
