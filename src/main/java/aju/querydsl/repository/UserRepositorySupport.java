package aju.querydsl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import aju.querydsl.entity.QUser;
import aju.querydsl.entity.User;
import lombok.NonNull;

@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport{
	private final JPAQueryFactory queryFactory;
		
	public UserRepositorySupport(JPAQueryFactory queryFactory) {
		super(User.class);
		this.queryFactory = queryFactory;		
	}
	
	@NonNull
	public List<User> findAll(){
		return queryFactory.selectFrom(QUser.user).fetch();
	}

//	@Transactional
//	public void create(User user) {		
//		QUser qUser = QUser.user;
//		queryFactory.insert(qUser)
//		    .columns(qUser.age, qUser.name,qUser.email)
//		    .values(31, "Hello","ji1234").execute();	
//	}

	
	public User findById(Long id) {
		QUser qUser = QUser.user;
		return queryFactory.select(qUser)
				.where(qUser.id.eq(id))
				.from(qUser)
				.fetchOne();			
	}

	@Transactional
	public void updateById(Long id, User user) {
		QUser qUser = QUser.user;
		queryFactory.update(qUser)
			.where(qUser.id.eq(id))
			.set(qUser.name, user.getName())
			.set(qUser.email, user.getEmail())
			.set(qUser.age, user.getAge())
			.execute();		
	}
	
	@Transactional
	public void deleteById(Long id) {
		QUser qUser = QUser.user;
		queryFactory.delete(qUser)
			.where(qUser.id.eq(id))
			.execute();		
	}
}
