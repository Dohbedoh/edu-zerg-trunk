package com.csse7034.zerg.c2.errors;

public class SequenceOfValuesException extends Exception{

private static final long serialVersionUID = 1L;
	
	String errorMessage;
	
	public SequenceOfValuesException(){
		super();
		this.errorMessage = "The values parsed from the file do not obey the standard format for Sequence of Values";
	}
	
	public String getMessage(){
		return errorMessage;		
	}
	
}
