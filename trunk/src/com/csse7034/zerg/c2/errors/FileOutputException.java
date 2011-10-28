/**
 * Class FileOutputException: SorterException extended class, represents Error 02
 * 
 * @author Pablo MINO
 */

package com.csse7034.zerg.c2.errors;

public class FileOutputException extends SorterException{

	/**
	 * Serialised number
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor used to create the Exception
	 * @param filepath The path of the file that is being read
	 * @return The message stored within the exception
	 */
	public FileOutputException(final String filepath){
		super();
		this.errorMessage = "Error 02: File could not be output: '" + filepath +"'";
	}

}
