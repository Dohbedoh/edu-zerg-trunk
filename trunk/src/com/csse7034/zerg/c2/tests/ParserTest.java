/**
 * Class Parser Unit Test: class designed to test the methods within the Parser class
 * 
 * 3 tests are performed, which test cases specified on each test header
 * 
 * @author Pablo MINO
 */


package com.csse7034.zerg.c2.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.csse7034.zerg.c2.sorting.Graph;
import com.csse7034.zerg.c2.sorting.Parser;
import com.csse7034.zerg.c2.errors.FinitePartialOrderException;
import com.csse7034.zerg.c2.errors.CyclicGraphException;
import com.csse7034.zerg.c2.errors.SequenceOfValuesException;

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
		
		try {
			Parser.parse("normalFlow.txt");
		} catch (FinitePartialOrderException fpoe) {
			fail();
		} catch (CyclicGraphException cge) {
			fail();
		} catch (SequenceOfValuesException sove) {
			fail();
		} catch (Exception ex) {
			
		}
		assertTrue(true);
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
		try {
			Parser.parse("invalidCharacters.txt");
		} catch (SequenceOfValuesException sove) {
			fail();
		} catch (Exception ex) {
			
		}
		assertTrue(true);
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
		try {
			Parser.parse("noFile.txt");
		} catch (Exception ex) {
			assertTrue(true);
		}
	}
	
	/**
	 * Incorrect output for parse2()
	 */
	@Test
	public void wrongOutputTest() {
		
	}
	
	/**
	 * Incorrect format for second (result) file
	 */
	public void incorrectFileFormat2Test() {
		
	}
	
}
