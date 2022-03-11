package com.qa.exceptions;

public class IdNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5175576209476661521L;
	
	public IdNotFoundException(String errormessage) {
		super(errormessage);
	}

}
