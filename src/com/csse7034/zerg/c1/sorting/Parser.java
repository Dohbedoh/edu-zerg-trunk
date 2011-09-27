package com.csse7034.zerg.c1.sorting;

import java.io.*;
import java.util.*;

public class Parser {

	static Graph graph = null;
	
	public Parser() {
	}
	
	public static String parse(Graph g, String filePath) {
		
		graph = g;
		
		String CharFromSet = "[[A-Za-z0-9]|[-\\+@#\\$%\\^&\\*|<>\\?]]*";
		// String CharFromSet = "[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][-+@#$%^&*|<>?]";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
			
			String line = "";
			String parentAndChild[];
			String allTheChildren[];
			
			while ((line = br.readLine()) != null) {
				
				// get the first value name
				parentAndChild = line.split(":");
				parentAndChild[0] = parentAndChild[0].trim();
				
				// check if the value name is valid
				if (parentAndChild[0].matches(CharFromSet)) {
					//graph.addNode(parentAndChild[0]);
					// check if the node has already been added into the graph
					if (!graph.contains(parentAndChild[0])) {
						graph.addNode(parentAndChild[0]);
						System.out.println(" call");
					} else {
						System.out.println(" call");
					}
					
				} else {
					// 02: Incorrect value exception, produced when parsing 
					// and finding characters other than the ones in the specification
					System.out.println("Failed Here 1 , " + parentAndChild[0]);
					return "Error 02: Incorrect value exception";
				}
				
				// get the rest of the value name
				allTheChildren = parentAndChild[1].split(",");
				System.out.println("what's here , " + allTheChildren.length);
				for (int i = 0; i < allTheChildren.length; i++) {
					allTheChildren[i] = allTheChildren[i].trim();
					
					// check if the value name is valid
					if (allTheChildren[i].matches(CharFromSet)) {
						//graph.addNode(allTheChildren[i]);
						// check if the node has already been added into the graph
						if (!graph.contains(allTheChildren[i])) {
							graph.addNode(allTheChildren[i]);
							System.out.println(" call2");
						} else {
							System.out.println("doesnt call2");
						}
						
						String err = graph.addEdge(parentAndChild[0], allTheChildren[i]);
						
						if (!err.equals("ok")) {
							// 02: Incorrect value exception, produced when parsing 
							// and finding characters other than the ones in the specification
							System.out.println("Failed Here 2");
							return "Error 02: Incorrect value exception";
						}
						
					} else {
						// 02: Incorrect value exception, produced when parsing 
						// and finding characters other than the ones in the specification
						System.out.println("Failed Here 3");
						return "Error 02: Incorrect value exception";
					}
				}
				
			}
			
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
			ex.printStackTrace();
			return "Error 01: No File";
		}
		
		return "ok";
	}
	
}
