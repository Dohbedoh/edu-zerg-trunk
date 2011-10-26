package com.csse7034.zerg.c2.errors;

public class NoSuchNodeException extends Exception{
	private static final long serialVersionUID = 1L;
	
	String errorMessage;
	
	public NoSuchNodeException(){
		super();
		this.errorMessage = "Values in file 2 and file 1 do not match";
	}
	
	public String getMessage(){
		return errorMessage;		
	}
}
