package com.csse7034.zerg.c2.errors;

public class NoSuchNodeException extends SorterException{
	
	private static final long serialVersionUID = 1L;
	
	public NoSuchNodeException(String node){
		super();
		this.errorMessage = "Graph Error: Node '"+node+"' does not exist in the Graph";
	}
}
