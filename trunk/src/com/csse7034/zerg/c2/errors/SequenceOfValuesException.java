package com.csse7034.zerg.c2.errors;

public class SequenceOfValuesException extends SorterException{

private static final long serialVersionUID = 1L;
	
	public SequenceOfValuesException(){
		super();
		this.errorMessage = "File Parsing Error: The values parsed from the file do not obey the standard format for Sequence of Values";
	}
	
}
