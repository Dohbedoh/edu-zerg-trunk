/**
 * Class Node: Represents a node which will be part of a graph
 * 
 * @author 	Ding Shen Tan
 */

package com.csse7034.zerg.c1.sorting;

public class Node implements NodeI{
	
	/** The value the node will store */
	private String name;
	/** The level the node belongs to*/
	private int level;
	
	
	public Node(String name){
		this.name = name;
		level = 0;	
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String iName) {
		name = iName;	
	}
	
	@Override
	public int getLevel(){
		return level;
	}
	
	@Override
	public void setLevel(int iLevel){
		level = iLevel;
	}
	
	
}
