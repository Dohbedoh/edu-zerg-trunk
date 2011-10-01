/**
 * Class Parser Unit Test: class designed to test the methods within the Parser class
 * 
 * 3 tests are performed, which test cases specified on each test header
 * 
 * @author Pablo MINO
 */


package com.csse7034.zerg.c1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.csse7034.zerg.c1.sorting.Graph;
import com.csse7034.zerg.c1.sorting.Parser;

public class ParserTest {
	
	/**
	 * Valid file format flow test:
	 * The following test case will be used
	 * 
	 * A file is taken which contains valid characters
	 * The class should return the value "ok"
	 * 
	 */
	@Test
	public void validFile() {
		assertEquals("ok", Parser.parse(new Graph(), "normalFlow.txt"));
	}
	
	/**
	 * Incorrect line format flow test:
	 * The following test case will be used
	 * 
	 * A file is used which contains characters that are not within the charset
	 * specified on the SRS
	 * 
	 * The class should return the value: "!02"
	 * 
	 */
	@Test
	public void incorrectFormat() {
		assertEquals("!02", Parser.parse(new Graph(), "invalidCharacters.txt"));
	}

	/**
	 * Missing File flow test:
	 * The following test case will be used
	 * 
	 * A file parameter is passed but there is no physical file at the location specified
	 * 
	 * The class should return the value: "!01"
	 * 
	 */
	@Test
	public void missingFile() {
		assertEquals("!01", Parser.parse(new Graph(), "noFile.txt"));
	}
	
}
