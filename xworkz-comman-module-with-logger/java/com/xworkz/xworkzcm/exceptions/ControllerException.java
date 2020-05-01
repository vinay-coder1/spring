<<<<<<< HEAD
package com.xworkz.xworkzcm.exceptions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ControllerException extends Exception {

	private static final Logger logger = LogManager.getLogger(ControllerException.class);

	public String getmassage() {
		logger.info(this.getClass().getSimpleName());
		return "got exception in controller";
	}
}
=======
package com.xworkz.xworkzcm.exceptions;

@SuppressWarnings("serial")
public class ControllerException extends Exception{

	public String getmassage() {	
		System.out.println(this.getClass().getSimpleName());
		return "got exception in controller";
	}
}
>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
