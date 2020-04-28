package com.xworkz.xworkzcm.service;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
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
	private static Integer noOfAttempt = 0;

	@Autowired
	private XworkzLoginDAO dao;

	public XworkzLoginServiceImpl() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public String validateAndLogin(XworkzLoginDTO dto, Model model, HttpServletRequest request)
			throws ServiceException {
		System.out.println("invoked validateAndLogin...");

		String givenPassword = dto.getPassword();
		System.out.println("givenPassword=" + givenPassword);
		try {
			XworkzCMEntity entity = new XworkzCMEntity();
			BeanUtils.copyProperties(dto, entity);
			System.out.println("ready to fecth....");
			XworkzCMEntity originalData = dao.fecthByEmailId(entity.getEmail());
			System.out.println("orginal data =" + originalData);
			String originalPassword = originalData.getPassword();
			System.out.println("original password=" + originalPassword);
			System.out.println("original encripted password=" + originalData.getEncriptedpassword());

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			boolean isPasswordMatch = passwordEncoder.matches(givenPassword, originalData.getEncriptedpassword());
			System.out.println("Given Password : " + givenPassword + "   isPasswordMatch    : " + isPasswordMatch);

			String ipAddress = request.getRemoteAddr();
			System.out.println("Clint IPAddress=" + ipAddress);

			if (Objects.isNull(originalData)) {
				model.addAttribute("loginfaildbyemail", "Logined Faild! , Email , Password Or IpAddress Incorrect. ");
				return "XworkzLogin";
			}

			noOfAttempt = this.dao.feachLoginAttempt(originalData.getEmail());
			System.out.println("first attempteCount =" + noOfAttempt);

			if (noOfAttempt <= 2 && noOfAttempt >= 0) {
				if (isPasswordMatch && ipAddress.equals(originalData.getIpaddress())) {
					return "loginSuccess";
				} else {
					noOfAttempt++;
					System.out.println("NoOfAttempts =" + noOfAttempt);
					dao.countAndUpdateLoginAttempt(originalData.getEmail(), noOfAttempt);
				}
			} else {
				if (noOfAttempt >= 3) {
					model.addAttribute("loginfaildbycount",
							"Logined Faild! , Your Exceeded The Maximum Login Attempts.");
					System.out.println("Logined Faild! , Your Exceeded The Maximum Login Attempts.");
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
		System.out.println("invoked validateAndResetPassword...");

		String enterdEmail = dto.getEmail();
		System.out.println("Enterd Email=" + enterdEmail);
		try {
			XworkzCMEntity entity = new XworkzCMEntity();
			BeanUtils.copyProperties(dto, entity);
			System.out.println("ready to fecth....");
			XworkzCMEntity originalData = dao.fecthByEmailId(entity.getEmail());

			if (Objects.isNull(originalData)) {
				model.addAttribute("resetfaildbyemail", "Password Reset Faild! , Email Does Not Exicit. ");
				return "XworkzResetPassword";
			}

			else {
				System.out.println("orginal data =" + originalData);
				String oldPassword = originalData.getPassword();
				System.out.println("Old Password=" + oldPassword);

				String newRandomPassword = RandomStringUtils.randomAlphabetic(8);
				entity.setPassword(newRandomPassword);

				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(newRandomPassword);
				System.out.println();
				System.out.println("New Password is         : " + newRandomPassword);
				System.out.println("New Encoded Password is : " + encodedPassword);

				this.dao.upadtePassByEmail(newRandomPassword,encodedPassword, originalData.getEmail());

				boolean isPasswordMatch = passwordEncoder.matches(newRandomPassword, encodedPassword);
				System.out.println("Password : " + newRandomPassword + "   isPasswordMatch    : " + isPasswordMatch);

				String ipAddress = request.getRemoteAddr();
				System.out.println("Clint IPAddress=" + ipAddress);

				if (Objects.nonNull(newRandomPassword) && ipAddress.equals(originalData.getIpaddress())) {
					dao.countAndUpdateLoginAttempt(originalData.getEmail(), 0);
					System.out.println("Password Reset Successfull! , New Password=" + newRandomPassword);
					model.addAttribute("resetedpassword",
							"Password Reset Successfull! , New Password=" + newRandomPassword);
					return "XworkzResetPassword";
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			ServiceException exception = new ServiceException();
			throw exception;
		}
		return "XworkzResetPassword";
	}

}
