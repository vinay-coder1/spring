<<<<<<< HEAD
package com.xworkz.xworkzcm.exceptions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ServiceException extends Exception{
    
	private static final Logger logger = LogManager.getLogger(ServiceException.class);
	
	public String getmassage() {	
		logger.info(this.getClass().getSimpleName());
		return "got exception in ServiceImpl";
	}
}
=======
package com.xworkz.xworkzcm.exceptions;

public class ServiceException extends Exception{
     
	public String getmassage() {	
		System.out.println(this.getClass().getSimpleName());
		return "got exception in ServiceImpl";
	}
}
>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
