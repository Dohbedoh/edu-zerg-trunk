package com.csse7034.zerg.c2.errors;

public class IncorrectFileFormatException extends SorterException{

private static final long serialVersionUID = 1L;
	
	public IncorrectFileFormatException(String filepath ,int line){
		super();
		this.errorMessage = "File Format Error: The line "+ line + " in the input file does not obey the specified format: '"+filepath+"'";
	}
}
