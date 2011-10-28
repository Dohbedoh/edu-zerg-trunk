/**
 * Class CyclicGraphException: SorterException extended class, represents Error 05
 * 
 * @author Pablo MINO
 */

package com.csse7034.zerg.c2.errors;

public class CyclicGraphException extends SorterException{

	/**
	 * Serialised number
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor used to create the Exception
	 * @return The message stored within the exception
	 */
	public CyclicGraphException(){
		super();
		this.errorMessage = "Error 05: The suggested finite partial order contains a cyclic reference";
	}
}
