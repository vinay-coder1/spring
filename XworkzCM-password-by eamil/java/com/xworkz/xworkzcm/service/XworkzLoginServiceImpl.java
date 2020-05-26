package com.xworkz.xworkzcm.service;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.xworkz.xworkzcm.dao.XworkzLoginDAO;
import com.xworkz.xworkzcm.dto.XworkzLoginDTO;
import com.xworkz.xworkzcm.dto.XworkzResetDTO;
import com.xworkz.xworkzcm.entity.XworkzCMEntity;
import com.xworkz.xworkzcm.exceptions.ServiceException;
import lombok.Setter;

@Setter
@Service
@EnableWebSecurity
public class XworkzLoginServiceImpl implements XworkzLoginService {

	private static final Logger logger = LogManager.getLogger(XworkzLoginServiceImpl.class);

	private static Integer noOfAttempt = 0;

	@Autowired
	private XworkzLoginDAO dao;
	
	@Autowired
	private SpringMailService mailService;

	public XworkzLoginServiceImpl() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@Override
	public String validateAndLogin(XworkzLoginDTO dto, Model model, HttpServletRequest request)
			throws ServiceException {
		logger.info("invoked validateAndLogin...");

		String givenPassword = dto.getPassword();
		logger.info("givenPassword=" + givenPassword);
		try {
			XworkzCMEntity entity = new XworkzCMEntity();
			BeanUtils.copyProperties(dto, entity);
			logger.info("ready to fecth....");
			XworkzCMEntity originalData = dao.fecthByEmailId(entity.getEmail());
			logger.info("orginal data =" + originalData);
			String originalPassword = originalData.getPassword();
			logger.info("original password=" + originalPassword);
			logger.info("original encripted password=" + originalData.getEncriptedpassword());

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			boolean isPasswordMatch = passwordEncoder.matches(givenPassword, originalData.getEncriptedpassword());
			logger.info("Given Password : " + givenPassword + "   isPasswordMatch    : " + isPasswordMatch);

			String ipAddress = request.getRemoteAddr();
			logger.info("Clint IPAddress=" + ipAddress);

			if (Objects.isNull(originalData)) {
				model.addAttribute("loginfaildbyemail", "Logined Faild! , Email , Password Or IpAddress Incorrect. ");
				return "XworkzLogin";
			}

			noOfAttempt = this.dao.feachLoginAttempt(originalData.getEmail());
			logger.info("first attempteCount =" + noOfAttempt);

			if (noOfAttempt <= 2 && noOfAttempt >= 0) {
				if (isPasswordMatch && ipAddress.equals(originalData.getIpaddress())) {
					return "loginSuccess";
				} else {
					noOfAttempt++;
					logger.info("NoOfAttempts =" + noOfAttempt);
					dao.countAndUpdateLoginAttempt(originalData.getEmail(), noOfAttempt);
				}
			} else {
				if (noOfAttempt >= 3) {
					model.addAttribute("loginfaildbycount",
							"Logined Faild! , Your Exceeded The Maximum Login Attempts.");
					logger.info("Logined Faild! , Your Exceeded The Maximum Login Attempts.");
					return "XworkzLogin";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			ServiceException exception = new ServiceException();
			throw exception;
		}
		return "XworkzLogin";
	}

	@Override
	public String validateAndResetPassword(XworkzResetDTO dto, Model model, HttpServletRequest request)
			throws ServiceException {
		logger.info("invoked validateAndResetPassword...");

		String enterdEmail = dto.getEmail();
		logger.info("Enterd Email=" + enterdEmail);
		try {
			XworkzCMEntity entity = new XworkzCMEntity();
			BeanUtils.copyProperties(dto, entity);
			logger.info("ready to fecth....");
			XworkzCMEntity originalData = dao.fecthByEmailId(entity.getEmail());

			if (Objects.isNull(originalData)) {
				model.addAttribute("resetfaildbyemail", "Password Reset Faild! , Email Does Not Exicit. ");
				return "XworkzResetPassword";
			}

			else {
				logger.info("orginal data =" + originalData);
				String oldPassword = originalData.getPassword();
				logger.info("Old Password=" + oldPassword);

				String newRandomPassword = RandomStringUtils.randomAlphabetic(8);
				entity.setPassword(newRandomPassword);

				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(newRandomPassword);
				logger.info("New Password is         : " + newRandomPassword);
				logger.info("New Encoded Password is : " + encodedPassword);
				
				boolean isPasswordMatch = passwordEncoder.matches(newRandomPassword, encodedPassword);
				logger.info("Password : " + newRandomPassword + "   isPasswordMatch    : " + isPasswordMatch);

				String ipAddress = request.getRemoteAddr();
				logger.info("Clint IPAddress=" + ipAddress);

				
				String subject = "Xworkz CM Password Reset";
				String body = "Hi "+originalData.getUserId()+"\nYour ''Xworkz CM'' Password Reset is successfull , Your New Password= "+newRandomPassword;
				boolean mailvalidation = mailService.validateAndSendMailByMailId(originalData.getEmail(), subject, body);	
				
				if (Objects.nonNull(newRandomPassword) && ipAddress.equals(originalData.getIpaddress()) && mailvalidation) {
					this.dao.upadtePassByEmail(newRandomPassword, encodedPassword, originalData.getEmail());
					dao.countAndUpdateLoginAttempt(originalData.getEmail(), 0);
					logger.info("Password Reset Successfull! ,New Password sent to your mailId");
					model.addAttribute("resetedpassword", "New Password Reset Successfull! ,Password sent to your mailId");
					return "XworkzResetPassword";
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			ServiceException exception = new ServiceException();
			logger.error(exception.getMessage(), exception);
			throw exception;
		}
		return "XworkzResetPassword";
	}

}