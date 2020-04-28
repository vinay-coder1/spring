package com.xworkz.xworkzcm.exceptions;

@SuppressWarnings("serial")
public class ControllerException extends Exception{

	public String getmassage() {	
		System.out.println(this.getClass().getSimpleName());
		return "got exception in controller";
	}
}
