<<<<<<< HEAD
package com.xworkz.xworkzcm.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xworkz.xworkzcm.dto.XworkzRegisterDTO;
import com.xworkz.xworkzcm.exceptions.ControllerException;
import com.xworkz.xworkzcm.service.XworkzRegisterService;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Controller
public class XworkzRegisterController {

	private static final Logger logger = LogManager.getLogger(XworkzRegisterController.class);

	@Autowired
	private XworkzRegisterService service;

	public XworkzRegisterController() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/pages/register.odc", method = RequestMethod.POST)
	public String onSave(XworkzRegisterDTO dto, Model model, HttpServletRequest request) throws ControllerException {
		logger.info("invoked onSave");

		try {
			model.addAttribute("dto", dto);
			this.service.validateAndSaveUser(dto, model, request);
			logger.info("DETAILS = " + dto.toString());

		}

		catch (Exception e) {
			ControllerException controllerException = new ControllerException();
			logger.error(controllerException.getMessage(), controllerException);
			throw controllerException;
		}

		return "XworkzRegister";
	}

=======
package com.xworkz.xworkzcm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xworkz.xworkzcm.dto.XworkzRegisterDTO;
import com.xworkz.xworkzcm.exceptions.ControllerException;
import com.xworkz.xworkzcm.service.XworkzRegisterService;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Controller
@RequestMapping("/")
public class XworkzRegisterController {

	@Autowired
	private XworkzRegisterService service;

	public XworkzRegisterController() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/pages/register.odc", method = RequestMethod.POST)
	public String onSave(XworkzRegisterDTO dto, Model model ,HttpServletRequest request) throws ControllerException {

		try {
			model.addAttribute("dto", dto);
			this.service.validateAndSaveUser(dto, model,request);
			System.out.println("DETAILS = " + dto.toString());

		}

		catch (Exception e) {
			ControllerException controllerException = new ControllerException();
			throw controllerException;
		}

		return "XworkzRegister";
	}

>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
}