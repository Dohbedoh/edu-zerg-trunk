/**
 * Class Sorter: Handles the graph structure and outputs a topological sort result based
 * on the graph
 * 
 * @author Lin SHI
 */


package com.csse7034.zerg.c1.sorting;

public class Sorter {

	//static variable to get the reference to graph object from UI
	static Graph graph = null;
	static String[] sample = null;

	//dummy constructor
	public Sorter() {
	}

	//static function to sort the graph based on their level
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


	//static function to sort the graph based on their level
	public static String compare(Graph g, String[] s) {

		//the variable to store output
		String output = "";

		//assign the graph
		graph = g;

		//assign the sample
		sample = s;


		try {
			//loop through the sample to see if the leve is correctly ordered.

		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
			ex.printStackTrace();
			return "Error 04: Can't compare the graph and the sample";
		}

		return output;
	}

}
