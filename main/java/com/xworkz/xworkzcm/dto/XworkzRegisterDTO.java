package com.xworkz.xworkzcm.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class XworkzRegisterDTO implements Serializable {

	private int id;

	private String userId;

	private String email;

	private long phone;

	private String course;

	private String agree;

	private String password;
	
	private String encriptedpassword;
	
	private String ipaddress;

	public XworkzRegisterDTO() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	}
