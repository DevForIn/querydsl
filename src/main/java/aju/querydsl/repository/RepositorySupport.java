package aju.querydsl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;


import com.querydsl.jpa.impl.JPAQueryFactory;

import aju.querydsl.dto.PeopleDto;
import aju.querydsl.dto.QPeopleDto;
import aju.querydsl.entity.Company;
import aju.querydsl.entity.QCompany;
import aju.querydsl.entity.QUser;
import aju.querydsl.entity.User;
import lombok.NonNull;

@Repository
public class RepositorySupport extends QuerydslRepositorySupport{
	
	private final JPAQueryFactory queryFactory;
	
	@Autowired
	public RepositorySupport(JPAQueryFactory queryFactory) {
		super(User.class);
		this.queryFactory = queryFactory;		
	}
	
	@NonNull
	public List<User> findAll(){
		return queryFactory.selectFrom(QUser.user)
				.fetch();
	}
/* 
	@Transactional
	public void create(User user) {		
		System.out.println(user.toString());
		QUser qUser = QUser.user;		
		queryFactory.insert(qUser)
		    .columns(qUser.userAge, qUser.userName,qUser.userEmail)
		    .values(user.getUserAge(),user.getUserName(),user.getUserEmail()).execute();	
	}
*/
	
	public User findById(Long id) {
		QUser qUser = QUser.user;
		return queryFactory.select(qUser)
				.from(qUser)
				.where(qUser.userId.eq(id))
				.fetchOne();			
	}

	@Transactional
	public void updateById(Long id, User user) {
		QUser qUser = QUser.user;
		queryFactory.update(qUser)
			.where(qUser.userId.eq(id))
			.set(qUser.userName, user.getUserName())
			.set(qUser.userEmail, user.getUserEmail())
			.set(qUser.userAge, user.getUserAge())
			.set(qUser.company, user.getCompany())
			.execute();		
	}
	
	@Transactional
	public void deleteById(Long id) {
		QUser qUser = QUser.user;
		queryFactory.delete(qUser)
			.where(qUser.userId.eq(id))
			.execute();		
	}

	
	@NonNull
	public List<Company> findAllCompany(){
		return queryFactory.selectFrom(QCompany.company)
				.fetch();
	}
	
/* 	
	@Transactional
	public void createMember(Company company) {		
		QCompany qCompany = QCompany.company;		
		queryFactory.insert(qCompany)
		    .columns(qCompany.companyId, qCompany.companyName)
		    .values(company.getCompanyId(),company.getCompanyName())
		    .execute();	
	}
*/
	public Company findByCompanyId(Long id) {
		QCompany qCompany = QCompany.company;
		return queryFactory.select(qCompany)
			.from(qCompany)
			.where(qCompany.companyId.eq(id))
			.fetchOne();		
	}

	@Transactional
	public void updateByIdCompany(Long id, Company company) {
		QCompany qCompany = QCompany.company;
		queryFactory.update(qCompany)
			.where(qCompany.companyId.eq(id))
			.set(qCompany.companyName, company.getCompanyName())
			.execute();	
	}

	@Transactional
	public void deleteByIdCompany(Long id) {
		QCompany qCompany = QCompany.company;
		queryFactory.delete(qCompany)
			.where(qCompany.companyId.eq(id))
			.execute();		
	}
	

	public List<PeopleDto> findByCompanyUsers(Long id) {
		QUser qUser = QUser.user;
		QCompany qCompany = QCompany.company;
		return queryFactory
				.select(new QPeopleDto(qCompany.companyName,qUser.userName,qUser.userEmail))
//				.select(
//						Projections.constructor
//							(PeopleDto.class,
//							qCompany.companyName,
//							qUser.userName,
//							qUser.userEmail)
//						)
				.from(qUser,qCompany)
				.where(qUser.company.companyId.eq(id).and(qCompany.companyId.eq(id)))
				.fetch();		
	}
}
