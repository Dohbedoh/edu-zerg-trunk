package com.csse7034.zerg.c2.errors;

public class NoSuchNodeException extends SorterException{
	
	private static final long serialVersionUID = 1L;
	
	public NoSuchNodeException(){
		super();
		this.errorMessage = "Values in file 2 and file 1 do not match";
	}
}
