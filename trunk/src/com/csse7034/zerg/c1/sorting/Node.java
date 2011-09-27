package com.csse7034.zerg.c1.sorting;

public class Node implements NodeI{
	private String name;
	private int level;
	
	public Node(String name){
		this.name = name;
		level = 0;	
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String iName) {
		name = iName;	
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int iLevel){
		level = iLevel;
	}
	
	
}
