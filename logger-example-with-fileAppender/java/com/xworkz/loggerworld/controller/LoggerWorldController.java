package com.xworkz.loggerworld.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoggerWorldController {

	private static final Logger logger = LogManager.getLogger(LoggerWorldController.class);

	public LoggerWorldController() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@RequestMapping("/logging.odc")
	public String getLogger(ModelMap model) {
		BasicConfigurator.configure();
		if (logger.isInfoEnabled()) {
			logger.info("welcome to logger world");
		}

		logger.fatal("Sample fatal message");
		logger.error("Sample error message");
		logger.warn("Sample warn message");
		logger.info("we are in logger info mode");
		logger.debug("Sample debug message");
		logger.trace("Sample debug message");

		try {
			new Throwable("coustom exception");
		  } 
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		model.addAttribute("msg", "welcome to logger world");
		return "Welcome";
	}
}
