package com.csse7034.zerg.c2.errors;

public class FileInputException extends SorterException{

	private static final long serialVersionUID = 1L;

	public FileInputException(String filepath){
		super();
		this.errorMessage = "File Input Error: Cannot open/read the file input at '"+filepath+"'";
	}
	
}
