/**
 * Class FileInputException: SorterException extended class, represents Error 01
 * 
 * @author Pablo MINO
 */

package com.csse7034.zerg.c2.errors;

public class FileInputException extends SorterException{

	/**
	 * Serialised number
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor used to create the Exception
	 * @param filepath The path of the file that is being read
	 * @return The message stored within the exception
	 */
	public FileInputException(final String filepath){
		super();
		this.errorMessage = "Error 01: Cannot open/read the file input: '"+filepath+"'";
	}

}
