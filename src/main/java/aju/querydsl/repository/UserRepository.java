package aju.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aju.querydsl.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{	
		
	@SuppressWarnings("unchecked")
	User save(User user);

}
