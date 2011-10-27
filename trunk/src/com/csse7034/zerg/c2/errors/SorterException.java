package com.csse7034.zerg.c2.errors;

public abstract class SorterException extends Exception{

	protected String errorMessage;
	
	public String getMessage()
	{
		return errorMessage;
	}
}
