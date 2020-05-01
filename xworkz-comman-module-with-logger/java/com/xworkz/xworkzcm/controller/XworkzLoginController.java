<<<<<<< HEAD
package com.xworkz.xworkzcm.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xworkz.xworkzcm.dto.XworkzLoginDTO;
import com.xworkz.xworkzcm.dto.XworkzResetDTO;
import com.xworkz.xworkzcm.exceptions.ControllerException;
import com.xworkz.xworkzcm.service.XworkzLoginService;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Controller
public class XworkzLoginController {

	private static final Logger logger = LogManager.getLogger(XworkzLoginController.class);

	@Autowired
	private XworkzLoginService service;

	public XworkzLoginController() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/pages/login.odc", method = RequestMethod.POST)
	public String onLogin(@ModelAttribute XworkzLoginDTO dto, Model model, HttpServletRequest request)
			throws ControllerException {
		logger.info("invoked onLogin()...");

		try {
			model.addAttribute("dto", dto);
			String validation = this.service.validateAndLogin(dto, model, request);
			if (validation.equals("loginSuccess")) {
				logger.info("DETAILS = " + dto.toString());
				model.addAttribute("loginsuccess", "Logined Successfully Email Password and Ipaddress Macthed.");
				logger.info("Logined Successfully Email Password and Ipaddress Macthed.");
				return "LoginSuccess";
			}

			else {
				model.addAttribute("loginfaildbypasswod", "Login Faild! , Email, Password Or IpAddress Is Incorrect. ");
				return "XworkzLogin";
			}

		} catch (Exception e) {
			ControllerException controllerException = new ControllerException();
			throw controllerException;
		}
	}

	@RequestMapping(value = "/pages/reset.odc", method = RequestMethod.POST)
	public String onReset(@ModelAttribute XworkzResetDTO dto, Model model, HttpServletRequest request)
			throws ControllerException {
		logger.info("invoked onReset()...");

		try {
			model.addAttribute("dto", dto);
			this.service.validateAndResetPassword(dto, model, request);

		} catch (Exception e) {
			ControllerException controllerException = new ControllerException();
			logger.error(controllerException.getMessage(), controllerException);
			throw controllerException;
		}
		return "XworkzResetPassword";
	}

}
=======
package com.xworkz.xworkzcm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xworkz.xworkzcm.dto.XworkzLoginDTO;
import com.xworkz.xworkzcm.dto.XworkzResetDTO;
import com.xworkz.xworkzcm.exceptions.ControllerException;
import com.xworkz.xworkzcm.service.XworkzLoginService;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Controller
@RequestMapping("/")
public class XworkzLoginController {

	@Autowired
	private XworkzLoginService service;

	public XworkzLoginController() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/pages/login.odc", method = RequestMethod.POST)
	public String onLogin(@ModelAttribute XworkzLoginDTO dto, Model model ,HttpServletRequest request) throws ControllerException {
		System.out.println("invoked onLogin()...");

		try {
			model.addAttribute("dto", dto);
			String validation = this.service.validateAndLogin(dto, model, request);
			if (validation.equals("loginSuccess")) {
				System.out.println("DETAILS = " + dto.toString());
				model.addAttribute("loginsuccess", "Logined Successfully Email Password and Ipaddress Macthed.");
				return "LoginSuccess";
			}

			else {
				model.addAttribute("loginfaildbypasswod", "Login Faild! , Email, Password Or IpAddress Is Incorrect. ");
				return "XworkzLogin";
			}

		} catch (Exception e) {
			ControllerException controllerException = new ControllerException();
			throw controllerException;
		}
	}

	@RequestMapping(value = "/pages/reset.odc", method = RequestMethod.POST)
	public String onReset(@ModelAttribute XworkzResetDTO dto, Model model ,HttpServletRequest request) throws ControllerException {
		System.out.println("invoked onReset()...");

		try {
			model.addAttribute("dto", dto);
			this.service.validateAndResetPassword(dto, model,request);

		} catch (Exception e) {
			ControllerException controllerException = new ControllerException();
			throw controllerException;
		}
		return "XworkzResetPassword";
	}

}
>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
