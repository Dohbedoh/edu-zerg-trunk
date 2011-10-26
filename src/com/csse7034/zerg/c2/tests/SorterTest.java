/**
 * Class Sorter Unit Test: class designed to test the methods within the Sorter class
 * 
 * 1 test is performed, which test cases specified on each test header
 * 
 * @author Pablo MINO
 */

package com.csse7034.zerg.c2.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.csse7034.zerg.c2.sorting.Graph;
import com.csse7034.zerg.c2.sorting.Parser;
import com.csse7034.zerg.c2.sorting.Sorter;

public class SorterTest {

	/** Instance of graph for testing purposes */
	Graph testGraph = new Graph();
	
	/**
	 * Loads test values for the graph to be used in all tests
	 * At this point it is assumed the passed graph is entirely valid
	 * 
	 * The following test case will be used
	 * 
	 * Assume a graph with the following structure
	 * A: B
	 * B: C
	 * C: D
	 * D: E, F, H
	 * F: H, I, W
	 * H: I, J
	 * J: K, L
	 * L: M, N
	 * N: Q
	 * Q: W, X, Y
	 * Y: Z
	 */
	void initializeTest(){
		
		testGraph.addNode("A");
		testGraph.addNode("B");
		testGraph.addNode("C");
		testGraph.addNode("D");
		testGraph.addNode("E");
		testGraph.addNode("F");
		testGraph.addNode("H");
		testGraph.addNode("I");
		testGraph.addNode("J");
		testGraph.addNode("K");
		testGraph.addNode("L");
		testGraph.addNode("M");
		testGraph.addNode("N");
		testGraph.addNode("Q");
		testGraph.addNode("W");
		testGraph.addNode("X");
		testGraph.addNode("Y");
		testGraph.addNode("Z");
		try {
		testGraph.addEdge("A", "B");		
		testGraph.addEdge("B", "C");		
		testGraph.addEdge("C", "D");		
		testGraph.addEdge("D", "E");
		testGraph.addEdge("D", "F");
		testGraph.addEdge("D", "H");
		testGraph.addEdge("D", "Z");		
		testGraph.addEdge("F", "I");
		testGraph.addEdge("F", "W");
		testGraph.addEdge("F", "H");		
		testGraph.addEdge("H", "I");
		testGraph.addEdge("H", "J");	
		testGraph.addEdge("J", "K");
		testGraph.addEdge("J", "L");		
		testGraph.addEdge("L", "M");
		testGraph.addEdge("L", "N");		
		testGraph.addEdge("N", "Q");		
		testGraph.addEdge("Q", "W");
		testGraph.addEdge("Q", "X");
		testGraph.addEdge("Q", "Y");		
		testGraph.addEdge("Y", "Z");
		} catch (Exception ex) {
			
		}
	}
	
	/**
	 * Sorting test:	 
	 * 
	 * Tests the sort method, it should pass the result
	 * from the Graph class
	 * 
	 */
	@Test
	public void sorting() {
		initializeTest();
		String result = Sorter.sort(testGraph);
		assertEquals(result, "Z\nY\nX\nW\nQ\nN\nM\nL\nK\nJ" +
				"\nI\nH\nF\nE\nD\nC\nB\nA\n");
		System.out.println(result);
	}
	
	/**
	 * Compare test
	 */
	@Test
	public void testCompare (){
		Graph g = new Graph();
		String[] s;
		boolean result = false;
		try {
			Parser.parse("test2.txt", g);
			s = Parser.parse2("testResult2-1.txt", g);
			result = Sorter.compare(g, s);
			assertTrue(result);
			
			s = Parser.parse2("testResult2-2.txt", g);
			result = Sorter.compare(g, s);
			assertTrue(result);
			
			s = Parser.parse2("testResult2Incorrect.txt", g);
			result = Sorter.compare(g, s);
			assertFalse(result);
			
		} catch (Exception ex) {
			assertEquals(ex.getMessage(), "The values parsed from the file do not obey the standard format for Sequence of Values");
		}
		
	}
	
}
