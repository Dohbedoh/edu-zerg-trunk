/**
 * Class Sorter: Handles the graph structure and outputs a topological sort result based
 * on the graph
 * 
 * @author Lin SHI
 */


package com.csse7034.zerg.c2.sorting;

public class Sorter {

	/** static variable to get the reference to graph object from UI */
	static Graph graph = null;
	static String[] sample = null;

	/** dummy constructor */
	public Sorter() {
	}

	/**
	 * Static method to sort the values given into topological order
	 * @param g	the Graph containing the values of the given input
	 * @return	output	A String output to be printed out unto the UI
	 */
	public static String sort(Graph g) {

		//the variable to store output
		String output = "";

		//assign the graph
		graph = g;


		//get the graph depth
		int depth = graph.getDepth();

		//loop through the graph by the level
		for (int i=0; i<=depth; i++){

			//loop through the graph to get all nodes at that level
			for (NodeI n : graph.getNodesAtLevel(i)) {

				output = n.getName() + "\n" + output;

			}

		}		

		return output;
	}


	/**
	 * 	Static method to compare the sorted result of the first input with the results of the second input
	 * @param g	the Graph containing the values from the first input text file
	 * @param s	the string of values with which the second input file is compared against the result of the firt
	 * 			input file
	 * @return	a boolean to show if the results are the same or not, true: same , false: not the same
	 */
	public static boolean compare(Graph g, String[] s){

		//assign the graph
		graph = g;

		//assign the sample
		sample = s;

		if(g.size()!=s.length)
		{
			return false;
		}
		
		int currentLvl = g.getNode(s[0]).getLevel();
		for(String temp : s) {
			if(g.getNode(temp).getLevel()>currentLvl) {
				return false;
			}
		}
		return true;
	}
	
}
