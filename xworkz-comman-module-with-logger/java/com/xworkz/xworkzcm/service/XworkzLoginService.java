<<<<<<< HEAD
package com.xworkz.xworkzcm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.xworkz.xworkzcm.dto.XworkzLoginDTO;
import com.xworkz.xworkzcm.dto.XworkzResetDTO;
import com.xworkz.xworkzcm.exceptions.ServiceException;

public interface XworkzLoginService {

	 public String validateAndLogin(XworkzLoginDTO dto ,Model model ,HttpServletRequest request) throws ServiceException;
	 
	 public String validateAndResetPassword(XworkzResetDTO dto,Model model,HttpServletRequest request)throws ServiceException;

}
=======
package com.xworkz.xworkzcm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.xworkz.xworkzcm.dto.XworkzLoginDTO;
import com.xworkz.xworkzcm.dto.XworkzResetDTO;
import com.xworkz.xworkzcm.exceptions.ServiceException;

public interface XworkzLoginService {

	 public String validateAndLogin(XworkzLoginDTO dto ,Model model ,HttpServletRequest request) throws ServiceException;
	 
	 public String validateAndResetPassword(XworkzResetDTO dto,Model model,HttpServletRequest request)throws ServiceException;

}
>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
