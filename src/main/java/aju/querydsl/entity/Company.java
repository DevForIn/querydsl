package aju.querydsl.entity;

import java.util.ArrayList;
import java.util.List;

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

@Entity @Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Company")
public class Company {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="companyId",nullable =false)
	private Long companyId;
	
	@Column(name="companyName",nullable =false)
	private String companyName;	
		
	private List<User> users = new ArrayList<>();
	
	@Builder
	public Company(String companyName) {
		this.companyName=companyName;
	}	
}
