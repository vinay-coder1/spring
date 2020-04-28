package com.xworkz.xworkzcm.exceptions;

public class ServiceException extends Exception{
     
	public String getmassage() {	
		System.out.println(this.getClass().getSimpleName());
		return "got exception in ServiceImpl";
	}
}
