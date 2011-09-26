/**
 * 
 * @author Allan BURDAJEWICZ
 *
 */

package com.csse7034.zerg.c1.sorting;


public interface GraphI {

	/**
	 * 
	 * @param name
	 */
	public void addNode(String name);
	
	/**
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public String addEdge(String src, String dest);
	
	/**
	 * 
	 * @return
	 */
	public int getDepth();
	
	/**
	 * 
	 * @param level
	 * @return
	 */
	public NodeI [] getNodesAtLevel(int level);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean contains(String name);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int indexOf(String name);
	
	/**
	 * 
	 * @return
	 */
	public String toString();
	
}
