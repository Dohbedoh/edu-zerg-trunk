/**
 * Class FileFormatException: SorterException extended class, represents Error 03
 * 
 * @author Pablo MINO
 */

package com.csse7034.zerg.c2.errors;

public class FileFormatException extends SorterException{

	/**
	 * Serialised number
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor used to create the Exception
	 * @param filepath The path of the file that is being read
	 * @param line The line number that produced the error
	 * @return The message stored within the exception
	 */
	public FileFormatException(String filepath ,int line){
		super();
		this.errorMessage = "Error 03: The line "+ line + " in the input file '" + filepath + "' does not obey the specified format";
	}
}
