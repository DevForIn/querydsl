package aju.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PeopleDto {

	private String companyName;
	private String name;
	private String email;
	
	
	@QueryProjection
	public PeopleDto(String companyName, String name, String email) {
		this.companyName = companyName;
		this.name = name;
		this.email = email;
		
	}
}
