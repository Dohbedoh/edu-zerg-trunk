package com.csse7034.zerg.c1.sorting;

import java.io.*;
import java.util.*;

public class Parser {

	private static Hashtable<String, Integer> matrix = null;
	ArrayList<ArrayList<Integer>> test = null;
	
	public Parser() {
		matrix = new Hashtable<String, Integer>();
		
	}
	
	public static int parse() {
		
		String CharFromSet = "A-Za-z0-9-+@#$%^&*|<>?";
		
		Graph graph = new Graph();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("FilePath")));
			
			String line = "";
			String parentAndChild[];
			String allTheChildren[];
			
			while ((line = br.readLine()) != null) {
				
				// get the first value name
				parentAndChild = line.split(":");
				parentAndChild[0] = parentAndChild[0].trim();
				
				// check if the value name is valid
				if (parentAndChild[0].matches(CharFromSet)) {
					graph.addNode(parentAndChild[0]);
					
				} else {
					// 02: Incorrect value exception, produced when parsing 
					// and finding characters other than the ones in the specification
					return 2;
				}
				
				// get the rest of the value name
				allTheChildren = parentAndChild[1].split(",");
				for (int i = 0; i < allTheChildren.length; i++) {
					allTheChildren[i] = allTheChildren[i].trim();
					
					// check if the value name is valid
					if (allTheChildren[i].matches(CharFromSet)) {
						graph.addNode(allTheChildren[i]);
						String err = graph.addEdge(parentAndChild[0], allTheChildren[i]);
						
						if (!err.equals("ok")) {
							// 02: Incorrect value exception, produced when parsing 
							// and finding characters other than the ones in the specification
							return 2;
						}
						
					} else {
						// 02: Incorrect value exception, produced when parsing 
						// and finding characters other than the ones in the specification
						return 2;
					}
				}
				
			}
			
		} catch (Exception ex) {
			
		}
		
		return -1;
	}
	
}
