package com.csse7034.zerg.c2.errors;

public class FinitePartialOrderException extends Exception{

private static final long serialVersionUID = 1L;
	
	String errorMessage;
	
	public FinitePartialOrderException(){
		super();
		this.errorMessage = "Error !02: A line in the input file does not obey the specified format";
	}
	
	public String getMessage(){
		return errorMessage;		
	}
	
}
