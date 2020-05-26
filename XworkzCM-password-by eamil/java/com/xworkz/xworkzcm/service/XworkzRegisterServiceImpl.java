package com.xworkz.xworkzcm.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.xworkz.xworkzcm.dao.XworkzRegisterDAO;
import com.xworkz.xworkzcm.dto.XworkzRegisterDTO;
import com.xworkz.xworkzcm.entity.XworkzCMEntity;
import com.xworkz.xworkzcm.exceptions.ServiceException;
import lombok.Setter;

@Setter
@Service
public class XworkzRegisterServiceImpl implements XworkzRegisterService {

	private static final Logger logger = LogManager.getLogger(XworkzRegisterServiceImpl.class);

	@Autowired
	private XworkzRegisterDAO dao;
	
	@Autowired
	private SpringMailService mailService;

	public XworkzRegisterServiceImpl() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@Override
	public String validateAndSaveUser(XworkzRegisterDTO dto, Model model, HttpServletRequest request)
			throws ServiceException {
		logger.info("invoked validateAndSaveUser...");

		String agreement = dto.getAgree();
		try {
			if (!dao.fetchUserId(dto.getUserId()) && !dao.fetchEmail(dto.getEmail()) && "yes".equals(agreement)) {
				String randomPassword = RandomStringUtils.randomAlphabetic(8);
				logger.info("Password=" + randomPassword);
				dto.setPassword(randomPassword);

				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(randomPassword);
				logger.info("Password is         : " + randomPassword);
				logger.info("Encoded Password is : " + encodedPassword);
				dto.setEncriptedpassword(encodedPassword);

				String ipAddress = request.getRemoteAddr();
				logger.info("Clint IPAddress=" + ipAddress);
				dto.setIpaddress(ipAddress);

				XworkzCMEntity entity = new XworkzCMEntity();
				BeanUtils.copyProperties(dto, entity);
				logger.info("originalData valid..ready to save");
				dao.saveUser(entity);
				
				String password = entity.getPassword();
				String subject = "Xworkz CM Password";
				String body = "Hi "+entity.getUserId()+"\n Your Xworkz CM Password is ="+password;
			    boolean mailvalidation = mailService.validateAndSendMailByMailId(entity.getEmail(), subject, body);
                
			    if(mailvalidation) {
				model.addAttribute("success", "Registered Successfully! Your Password sent to your mailID");
			    }
			    else {
					model.addAttribute("success", "Registered Successfully! Password can't able send to your mailID!");
					}
				return "XworkzRegister";
			    }

			if (dao.fetchEmail(dto.getEmail())) {
				model.addAttribute("emailExicit", "Email Id Already Taken!");
				return "XworkzRegister";
			}

			if (dao.fetchUserId(dto.getUserId())) {
				model.addAttribute("userExicit", "UserId Already taken!");
				return "XworkzRegister";
			}

			if (!"yes".equals(agreement)) {
				model.addAttribute("disagree", "You Disagreed! Can't Able To Register.");
				logger.info("invalid originalData!");
				return "XworkzRegister";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ServiceException exception = new ServiceException();
			logger.error(exception.getMessage(), exception);
			throw exception;
		}
		return null;
	}
}