package aju.querydsl.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PeopleDto {

	private String companyName;
	private String email;
	private String name;
	
	public PeopleDto(String companyName, String email, String name) {
		this.companyName = companyName;
		this.email = email;
		this.name = name;
	}
}
