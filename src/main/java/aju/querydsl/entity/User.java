package aju.querydsl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter 
@NoArgsConstructor
@AllArgsConstructor
@Table(name="User")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",nullable =false)
	private Long id;
	
	@Setter
	@Column(name="NAME")
	private String name;
	
	@Setter
	@Column(name="EMAIL")
	private String email;
	
	@Setter
	@Column(name="AGE")
	private int age;
	
	@Builder
	public User(String name,String email, int age) {
		this.name=name;
		this.email=email;
		this.age=age;
	}	
}
