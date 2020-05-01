<<<<<<< HEAD
package com.xworkz.xworkzcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.xworkz.xworkzcm.dto.XworkzResetDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "xworkz_register")
@NamedQueries({ @NamedQuery(name = "userCheck", query = "from XworkzCMEntity xe where xe.userId=:user"),
		@NamedQuery(name = "emailCheck", query = "from XworkzCMEntity xe where xe.email=:mail"),
		@NamedQuery(name = "byemail", query = "select xe from XworkzCMEntity xe where xe.email=:mail"),

		@NamedQuery(name = "incAttemptByEmail", query = "update XworkzCMEntity xe set xe.noOfAttempt=:noa where xe.email=:mail"),
		@NamedQuery(name = "feachAttemptByEmail", query = "select xe.noOfAttempt from XworkzCMEntity xe where xe.email=:mail"),
		@NamedQuery(name = "updatePassByEmail", query = "update XworkzCMEntity xe set xe.password=:pass,xe.encriptedpassword=:enp where xe.email=:mail"), })

public class XworkzCMEntity {

	private static final Logger logger = LogManager.getLogger(XworkzCMEntity.class);

	@Id
	@GenericGenerator(name = "vinay", strategy = "increment")
	@GeneratedValue(generator = "vinay")
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "USER_NAME")
	private String userId;

	@Column(name = "USER_EMAIL")
	private String email;

	@Column(name = "USER_PHONE")
	private long phone;

	@Column(name = "USER_AGREE")
	private String agree;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "USER_COURSE")
	private String course;

	@Column(name = "USER_ATTEMPTS")
	private Integer noOfAttempt;

	@Column(name = "USER_ENCRIPTED_PASSWORD")
	private String encriptedpassword;

	@Column(name = "USER_IPADDRESS")
	private String ipaddress;

	public XworkzCMEntity() {
		logger.info("created " + this.getClass().getSimpleName());
	}
}
=======
package com.xworkz.xworkzcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "xworkz_register")
@NamedQueries({
	@NamedQuery(name="userCheck",  query="from XworkzCMEntity xe where xe.userId=:user"),
	@NamedQuery(name="emailCheck", query="from XworkzCMEntity xe where xe.email=:mail"),
	@NamedQuery(name="byemail", query="select xe from XworkzCMEntity xe where xe.email=:mail"),
	
	@NamedQuery(name="incAttemptByEmail", query="update XworkzCMEntity xe set xe.noOfAttempt=:noa where xe.email=:mail"),
	@NamedQuery(name="feachAttemptByEmail", query="select xe.noOfAttempt from XworkzCMEntity xe where xe.email=:mail"),
	@NamedQuery(name="updatePassByEmail", query="update XworkzCMEntity xe set xe.password=:pass,xe.encriptedpassword=:enp where xe.email=:mail"),
})

public class XworkzCMEntity {
	@Id
	@GenericGenerator(name = "vinay", strategy = "increment")
	@GeneratedValue(generator = "vinay")
	@Column(name = "USER_ID")
	private int id;
	
	
	@Column(name = "USER_NAME")
	private String userId;
	
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	
	@Column(name = "USER_PHONE")
	private long phone;
	
	
	@Column(name = "USER_AGREE")
	private String agree;
	
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	
	@Column(name = "USER_COURSE")
	private String course;
	
	@Column(name = "USER_ATTEMPTS")
	private Integer noOfAttempt;

	@Column(name = "USER_ENCRIPTED_PASSWORD")
	private String encriptedpassword;
	
	@Column(name = "USER_IPADDRESS")
	private String ipaddress;

	public XworkzCMEntity() {
		System.out.println("created " + this.getClass().getSimpleName());
	}
}
>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
