<<<<<<< HEAD
package com.xworkz.xworkzcm.dto;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.xworkz.xworkzcm.dao.XworkzRegisterDAOImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class XworkzLoginDTO implements Serializable {

	private static final Logger logger = LogManager.getLogger(XworkzLoginDTO.class);

	private String email;

	private String password;

	private Integer noOfAttempt;

	private String encriptedpassword;

	private String ipaddress;

	public XworkzLoginDTO() {
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
>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
