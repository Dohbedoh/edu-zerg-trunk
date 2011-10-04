/**
 * Class Graph Unit Test: class designed to test the methods within the Interface IGraph and
 * its implementation class Graph
 * 
 * 3 tests are performed, which test cases specified on each test header
 * 
 * @author Pablo MINO
 */

package com.csse7034.zerg.c1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.csse7034.zerg.c1.sorting.Graph;
import com.csse7034.zerg.c1.sorting.GraphI;
import com.csse7034.zerg.c1.sorting.NodeI;

public class GraphTest {

	/** Instance of graph for testing purposes */
	GraphI testGraph;
	
	/**
	 * Normal flow test:
	 * The following test case will be used
	 * 
	 * Assume a graph with the following structure
	 * A: B,C
	 * B: D
	 * C: D
	 * 
	 */
	@Test
	public void normalFlow() {
		
		testGraph = new Graph();
		
		// Add node check, should not return errors
		testGraph.addNode("A");
		testGraph.addNode("B");
		testGraph.addNode("C");
		testGraph.addNode("D");
		
		// Add edge check, should return no error
		testGraph.addEdge("A", "B");
		testGraph.addEdge("A", "C");
		testGraph.addEdge("B", "D");
		testGraph.addEdge("C", "D");
		
		// Depth check, should be 2
		assertEquals(2,testGraph.getDepth());
		
		// Insertion check, should contain 4 nodes
		assertTrue(testGraph.contains("A"));
		assertTrue(testGraph.contains("B"));
		assertTrue(testGraph.contains("C"));
		assertTrue(testGraph.contains("D"));
		
		// Insertion check, indexes match the insertion order
		assertTrue(testGraph.indexOf("A")==0);
		assertTrue(testGraph.indexOf("B")==1);
		assertTrue(testGraph.indexOf("C")==2);
		assertTrue(testGraph.indexOf("D")==3);
		
		// toString() check, should return a representation of the nodes
		// and its child, according to documentation:
		// A: B(1)C(1)
		// B: D(2)
		// C: D(2)
		// D: 
		System.out.println(testGraph.toString());
		
	}

	/**
	 * Acyclic graph error flow test:
	 * The following test case will be used
	 * 
	 * Assume a graph with the following structure
	 * A: B
	 * B: C
	 * C: D
	 * D: A
	 * 
	 */
	@Test
	public void acyclicError() {
		
		testGraph = new Graph();
		
		// Add node check, should not return errors
		testGraph.addNode("A");
		testGraph.addNode("B");
		testGraph.addNode("C");
		testGraph.addNode("D");
		
		// Add edge check, should return no error
		testGraph.addEdge("A", "B");
		testGraph.addEdge("B", "C");
		testGraph.addEdge("C", "D");
		//throwing null pointer exception instead, needs fix
		assertEquals("!03", testGraph.addEdge("D", "A"));
		
		
	}
	
	/**
	 * Graph length test:
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
	 * 
	 */
	@Test
	public void graphLengthTest() {
		
		testGraph = new Graph();
		
		// Add node check, should not return errors
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
		
		// Add edge check, should return no error
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
	
		// toString() check, should return a representation of the nodes
		// and its child, according to documentation
		//
		System.out.println(testGraph.toString());
		
	}
	
}
