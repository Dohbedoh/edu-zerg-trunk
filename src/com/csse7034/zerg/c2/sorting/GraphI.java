/**
 * GraphI: Interface to implement as a Graph
 * 
 * @see		Class Graph
 * @author 	Allan BURDAJEWICZ
 */

package com.csse7034.zerg.c2.sorting;

import com.csse7034.zerg.c2.errors.CyclicGraphException;


public interface GraphI {

	/**
	 * Add a node in the Graph
	 * @param name		The name of the node
	 */
	public void addNode(String name);
	
	/**
	 * Add en edge from the a source node to a destination node
	 * @param src		source node
	 * @param dest		destination node
	 * @return
	 * @throws CyclicGraphException 
	 */
	public void addEdge(String src, String dest) throws CyclicGraphException;
	
	/**
	 * Return the depth of the graph (Maximum)
	 */
	public int getDepth();
	
	/**
	 * Return a NodeI from the name
	 * @param name		The name of the Node
	 * @return			The node
	 */
	public NodeI getNode(String name);
	
	/**
	 * Return an array with all the node at the given level in the Graph
	 * @param level		The level
	 * @return			The array with all the node at this level
	 */
	public NodeI [] getNodesAtLevel(int level);
	
	/**
	 * Given the name of a node, return if the graph contains the node
	 * @param name		The name of the node to search for
	 * @return			The graph contains the node "name"
	 */
	public boolean contains(String name);
	
	/**
	 * Return the size of the graph that is the number of nodes
	 * @return			The size of the graph
	 */
	public int size();
	
	/**
	 * Given the name of a node, return the index of the node in the array "nodes"
	 * @param name		The name of the node
	 * @return			The index of the node in the array <nodes>
	 */
	public int indexOf(String name);
	
}
