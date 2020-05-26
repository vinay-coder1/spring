
package com.xworkz.xworkzcm.exceptions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ServiceException extends Exception {

	private static final Logger logger = LogManager.getLogger(ServiceException.class);

	public String getmassage() {
		logger.info(this.getClass().getSimpleName());
		return "got exception in ServiceImpl";
	}
}
