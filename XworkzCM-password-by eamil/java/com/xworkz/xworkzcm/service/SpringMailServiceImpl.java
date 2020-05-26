package com.xworkz.xworkzcm.service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class SpringMailServiceImpl implements SpringMailService {

	private static final Logger logger = LogManager.getLogger(SpringMailServiceImpl.class);

	@Autowired
	private JavaMailSender mailSender;

	public SpringMailServiceImpl() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean validateAndSendMailByMailId(String to, String subject, String body) {
		logger.info("invoked validateAndSendMailByMailId of SpringMailServiceImpl...");

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(body);

		try {
			mailSender.send(mail);
			logger.info("mail sent successfully");
			return true;
		} catch (MailException e) {
			logger.info("mail sent Faild!");
			logger.error(e.getMessage(), e);
		}
		return false;
	}

}
