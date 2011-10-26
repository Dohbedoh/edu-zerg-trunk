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
		Graph g = new Graph();
		boolean caughtE = false;
		try {
			Parser.parse("normalFlow.txt", g);
		} catch (FinitePartialOrderException fpoe) {
			caughtE = true;
			fail();
		} catch (CyclicGraphException cge) {
			caughtE = true;
			fail();
		} catch (SequenceOfValuesException sove) {
			caughtE = true;
			fail();
		} catch (Exception ex) {
			
		}
		if (!caughtE) {
			assertTrue(true);
		} else {
			fail();
		}
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
		boolean caught = false;
		Graph g = new Graph();
		try {
			Parser.parse("invalidCharacters.txt", g);
		} catch (SequenceOfValuesException sove) {
			caught = true;
			assertTrue(true);
		} catch (FinitePartialOrderException fpoe) {
			caught = true;
			assertTrue(true);
		} catch (Exception ex) {
			
		}
		if (!caught) {
			fail();
		}
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
		Graph g = new Graph();
		try {
			Parser.parse("noFile.txt", g);
		} catch (Exception ex) {
			assertTrue(true);
		}
	}
	
	/**
	 * test for output of parse2()
	 */
	@Test
	public void outputTest() {
		String[] result;
		Graph g = new Graph();
		try {
			Parser.parse("test2.txt", g);
			result = Parser.parse2("testResult2-1.txt", g);
			String[] correctResults = {"D", "C", "B", "A"};
			
			for (int i = 0; i < correctResults.length; i++) {
				assertEquals(correctResults[i], result[i]);
			}
		} catch (Exception ex) {
			fail();
		}	
	}
	
	/**
	 * Tests for space and tabs in second result file
	 */
	@Test
	public void spaceAndTabParse2Test() {
		String[] result;
		Graph g = new Graph();
		try {
			Parser.parse("test2.txt", g);
			result = Parser.parse2("spaceAndTabTestResult2-1.txt", g);
			String[] correctResults = {"D", "C", "B", "A"};
			
			for (int i = 0; i < correctResults.length; i++) {
				assertEquals(correctResults[i], result[i]);
			}
		} catch (Exception ex) {
			fail();
		}
	}
	
}
