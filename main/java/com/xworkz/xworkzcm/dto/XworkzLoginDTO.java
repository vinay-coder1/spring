package com.xworkz.xworkzcm.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class XworkzLoginDTO implements Serializable {

	private String email;

	private String password;

	private Integer noOfAttempt;
	
	private String encriptedpassword;
	
	private String ipaddress;

	public XworkzLoginDTO() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

}
