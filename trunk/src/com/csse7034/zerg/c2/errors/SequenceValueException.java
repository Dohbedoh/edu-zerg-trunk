/**
 * Class SequenceValueException: SorterException extended class, represents Error 04
 * 
 * @author Pablo MINO
 */

package com.csse7034.zerg.c2.errors;

public class SequenceValueException extends SorterException{

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
	public SequenceValueException(final String filepath ,final int line){
		super();
		this.errorMessage = "Error 04: The values parsed from the file '"+ filepath +"' does not obey the standard format at line " + line;
	}

}
