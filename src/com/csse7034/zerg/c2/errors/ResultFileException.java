package com.csse7034.zerg.c2.errors;

public class ResultFileException extends Exception{

	private static final long serialVersionUID = 1L;
	
	String errorMessage;
	
	public ResultFileException(){
		super();
		this.errorMessage = "File could not be output";
	}
	
	public String getMessage(){
		return errorMessage;		
	}

}
