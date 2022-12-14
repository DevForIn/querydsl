package aju.querydsl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="User")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId",nullable =false)
	private Long userId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="userEmail")
	private String userEmail;	
	
	@Column(name="userAge")
	private int userAge;
	
	@ManyToOne(targetEntity = Company.class)
	@JoinColumn(name="companyNum",referencedColumnName="companyId")
	private Company company;
	
	@Builder
	public User(String userName,String userEmail, int userAge,Company company) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAge = userAge;
		this.company = company;
	}	
}