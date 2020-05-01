<<<<<<< HEAD
package com.xworkz.xworkzcm.dto;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class XworkzRegisterDTO implements Serializable {

	private static final Logger logger = LogManager.getLogger(XworkzRegisterDTO.class);

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
		logger.info("created " + this.getClass().getSimpleName());
	}

}
=======
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
>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
