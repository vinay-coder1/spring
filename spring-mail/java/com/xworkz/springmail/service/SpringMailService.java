package com.xworkz.springmail.service;

public interface SpringMailService {

	public boolean validateAndSendMailByMailId(String to ,String subject ,String body);
}
