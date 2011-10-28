/**
 * Class SorterException: Java Exception extended class which represents the top of the error hierarchy
 * 
 * @author Pablo MINO
 */

package com.csse7034.zerg.c2.errors;

public abstract class SorterException extends Exception{

	/**
	 * Serialised number
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Error message contained within the exception
	 */
	protected String errorMessage;
	
	/**
	 * Method to access the message generated by the exception
	 * @return The message stored within the exception
	 */
	public String getMessage()
	{
		return errorMessage;
	}
}
