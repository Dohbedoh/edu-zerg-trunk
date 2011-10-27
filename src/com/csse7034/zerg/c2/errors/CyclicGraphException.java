package com.csse7034.zerg.c2.errors;

public class CyclicGraphException extends SorterException{

private static final long serialVersionUID = 1L;

	public CyclicGraphException(){
		super();
		this.errorMessage = "Graph Error: The suggested finite partial order contains a cyclic reference";
	}
}
