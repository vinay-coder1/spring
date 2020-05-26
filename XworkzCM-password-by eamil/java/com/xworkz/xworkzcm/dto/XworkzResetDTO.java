package com.xworkz.xworkzcm.dto;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class XworkzResetDTO {

	private static final Logger logger = LogManager.getLogger(XworkzResetDTO.class);

	private String email;

	private String password;

	private Integer noOfAttempt;

	private String encriptedpassword;

	private String ipaddress;

	public XworkzResetDTO() {
		logger.info("created " + this.getClass().getSimpleName());
	}

}