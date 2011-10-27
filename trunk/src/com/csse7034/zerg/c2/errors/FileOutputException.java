package com.csse7034.zerg.c2.errors;

public class FileOutputException extends SorterException{

	private static final long serialVersionUID = 1L;

	public FileOutputException(){
		super();
		this.errorMessage = "File Output Error: File could not be output";
	}

}
