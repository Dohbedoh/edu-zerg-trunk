/**
 * NodeI: Interface to implement as a Node
 * 
 * @see		Class Node
 * @author 	Ding Shen Tan
 */

package com.csse7034.zerg.c2.sorting;

public interface NodeI {

	/**
	 * Obtain the name of a node
	 * @return value
	 */
	public String getName();

	/**
	 * Set the text value representing the node
	 * @param iName	 The node value
	 */
	public void setName(String iName);

	/**
	 * Returns the level the node belongs to, according to the graph
	 * @return
	 */
	public int getLevel();

	/**
	 * Set the level the node belong to, according to the graph
	 * @param iLevel		The level of the node
	 */
	public void setLevel(int iLevel);

}
