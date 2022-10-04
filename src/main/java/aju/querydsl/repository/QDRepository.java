package aju.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aju.querydsl.entity.User;

public interface QDRepository extends JpaRepository<User,Long>{

}
