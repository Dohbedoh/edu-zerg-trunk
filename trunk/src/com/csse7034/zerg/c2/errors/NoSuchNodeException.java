/**
 * Class NoSuchNodeException: SorterException extended class, represents Error 06
 * 
 * @author Pablo MINO
 */

package com.csse7034.zerg.c2.errors;

public class NoSuchNodeException extends SorterException{

	/**
	 * Serialised number
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor used to create the Exception
	 * @param The proposed node by the sequence of value file
	 * @return The message stored within the exception
	 */
	public NoSuchNodeException(final String node){
		super();
		this.errorMessage = "Error 06: Node '"+node+"' does not exist in the graph";
	}
}
