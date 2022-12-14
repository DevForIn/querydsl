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
import lombok.ToString;

@Entity @Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Company")
public class Company {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="companyId",nullable =false)
	private Long companyId;
	
	@Column(name="companyName",nullable =false)
	private String companyName;	
	
	@Builder
	public Company(String companyName) {
		this.companyName=companyName;
	}	
}
