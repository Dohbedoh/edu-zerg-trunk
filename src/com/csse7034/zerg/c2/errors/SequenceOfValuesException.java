package com.csse7034.zerg.c2.errors;

public class SequenceOfValuesException extends SorterException{

private static final long serialVersionUID = 1L;
	
	public SequenceOfValuesException(String filepath ,int line){
		super();
		this.errorMessage = "File Parsing Error: The values parsed from the file '"+ filepath +"' does not obey the standard format for Sequence of Values at line " + line;
	}
	
}
