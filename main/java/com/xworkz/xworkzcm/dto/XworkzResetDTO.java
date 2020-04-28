package com.xworkz.xworkzcm.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class XworkzResetDTO {

	private String email;

	private String password;

	private Integer noOfAttempt;
	
	private String encriptedpassword;
	
	private String ipaddress;

	public XworkzResetDTO() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

}
