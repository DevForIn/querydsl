package aju.querydsl.entity;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;

@Data
public class People {

	private String companyName;
	private String userEmail;
	private String userName;
	
	@QueryProjection
	public People(String companyName,String userEmail,String userName) {
		this.companyName = companyName;
		this.userEmail = userEmail;
		this.userName = userName;
	}
}
