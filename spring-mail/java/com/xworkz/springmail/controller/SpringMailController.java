package com.xworkz.springmail.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.springmail.service.SpringMailService;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Controller
@RequestMapping("/")
public class SpringMailController {

	private static final Logger logger = LogManager.getLogger(SpringMailController.class);

	@Autowired
	private SpringMailService mailService;

	public SpringMailController() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/pages/sendMail.odc", method = RequestMethod.POST)
	public String onSendMail(@RequestParam("toMail") String toMail, @RequestParam("subject") String subject,
			@RequestParam("body") String body, ModelMap map) {
		logger.info("invoked onSendMail of SpringMailController...");
		try {
			logger.info("To Mail=" + toMail);
			logger.info("To Mail=" + subject);
			logger.info("To Mail=" + body);

			boolean validation = mailService.validateAndSendMailByMailId(toMail, subject, body);

			if (validation) {
				map.addAttribute("success", "Mail Sent Successfully");
				logger.info("mail sent successfully");
				return "XworkzLogin";
		     }
			else {
				map.addAttribute("failure", "Mail Sent Faild!");
				logger.info("mail sent Faild!");
				return "XworkzLogin";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "XworkzLogin";

	}
}
