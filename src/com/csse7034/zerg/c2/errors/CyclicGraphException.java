package com.csse7034.zerg.c2.errors;

public class CyclicGraphException extends Exception{

private static final long serialVersionUID = 1L;
	
	String errorMessage;
	
	public CyclicGraphException(){
		super();
		this.errorMessage = "Error !03: The suggested finite partial order contains a cyclic reference";
	}
	
	public String getMessage(){
		return errorMessage;		
	}
	
}
