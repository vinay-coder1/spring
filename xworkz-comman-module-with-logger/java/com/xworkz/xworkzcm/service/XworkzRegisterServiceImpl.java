<<<<<<< HEAD
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
				model.addAttribute("success", "Registered Successfully! Your Password is=" + password);
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

=======
package com.xworkz.xworkzcm.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
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

	@Autowired
	private XworkzRegisterDAO dao;

	public XworkzRegisterServiceImpl() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public String validateAndSaveUser(XworkzRegisterDTO dto, Model model,HttpServletRequest request) throws ServiceException {
		System.out.println("invoked validateAndSaveUser...");

		String agreement = dto.getAgree();
		try {
			if (!dao.fetchUserId(dto.getUserId()) && !dao.fetchEmail(dto.getEmail()) && "yes".equals(agreement)) {
				String randomPassword = RandomStringUtils.randomAlphabetic(8);
				System.out.println("Password=" + randomPassword);
				dto.setPassword(randomPassword);

				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(randomPassword);
				System.out.println();
				System.out.println("Password is         : " + randomPassword);
				System.out.println("Encoded Password is : " + encodedPassword);
				dto.setEncriptedpassword(encodedPassword);
				
				String ipAddress = request.getRemoteAddr();
				System.out.println("Clint IPAddress=" + ipAddress);
				dto.setIpaddress(ipAddress);

				XworkzCMEntity entity = new XworkzCMEntity();
				BeanUtils.copyProperties(dto, entity);
				System.out.println("originalData valid..ready to save");
				dao.saveUser(entity);

				String password = entity.getPassword();
				model.addAttribute("success", "Registered Successfully! Your Password is=" + password);
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
				System.out.println("invalid originalData!");
				return "XworkzRegister";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ServiceException exception = new ServiceException();
			throw exception;
		}
		return null;
	}

>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
}