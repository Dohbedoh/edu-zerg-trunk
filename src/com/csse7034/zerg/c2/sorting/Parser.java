/**
 * Class Parser: Parses the input file from the user and translates the data in it 
 * to a graph with nodes
 * 
 * @author Koh Thong Guan
 */

package com.csse7034.zerg.c2.sorting;

import java.io.*;
import java.util.*;

public class Parser {

	static Graph graph = null;
	
	public Parser() {
	}
	
	/**
	 * Parse the data in the input text file with its file path and translates the data into nodes 
	 * to fill the graph.
	 * @param g	The created empty Graph object
	 * @param filePath	The file path of the 
	 * @return
	 */
	public static String parse(Graph g, String filePath) {
		
		graph = g;
		
		String CharFromSet = "[[A-Za-z0-9]|[-\\+@#\\$%\\^&\\*|<>\\?]]*";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
			
			String line = "";
			String parentAndChild[];
			String allTheChildren[];
			
			while ((line = br.readLine()) != null) {
				
				// If it is an invalid line.
				if (!line.contains(":")) {
					// If the line is not an empty line
					if (line.length() != 0) {
					return "!02";
					}
				}
				
				// If line is not an empty line
				if (line.length() != 0) {
					
				// get the first value name
				parentAndChild = line.split(":");
				parentAndChild[0] = parentAndChild[0].trim();
				
				// check if the value name is valid
				if (parentAndChild[0].matches(CharFromSet)) {
					//graph.addNode(parentAndChild[0]);
					// check if the node has already been added into the graph
					if (!graph.contains(parentAndChild[0])) {
						graph.addNode(parentAndChild[0]);
					} 
					
				} else {
					// 02: Incorrect value exception, produced when parsing 
					// and finding characters other than the ones in the specification
					//System.out.println("Failed Here 1 , " + parentAndChild[0]);
					return "!02";
				}
				
				// get the rest of the value name
				allTheChildren = parentAndChild[1].split(",");
				//System.out.println("what's here , " + allTheChildren.length);
				for (int i = 0; i < allTheChildren.length; i++) {
					allTheChildren[i] = allTheChildren[i].trim();
					
					// check if the value name is valid
					if (allTheChildren[i].matches(CharFromSet)) {
						// check if the node has already been added into the graph
						if (!graph.contains(allTheChildren[i])) {
							graph.addNode(allTheChildren[i]);
						}
						
						String err = graph.addEdge(parentAndChild[0], allTheChildren[i]);
						
						if (!err.equals("ok")) {
							// 02: Incorrect value exception, produced when parsing 
							// and finding characters other than the ones in the specification
							//System.out.println("Failed Here 2");
							return "!03";
						}
						
					} else {
						// 02: Incorrect value exception, produced when parsing 
						// and finding characters other than the ones in the specification
						//System.out.println("Failed Here 3");
						return "!02";
					}
				}
				
			}
			}
		} catch (Exception ex) {
			//System.out.println(ex.getStackTrace());
			//ex.printStackTrace();
			return "!01";
		}
		
		return "ok";
	}
	
public static String[] parse2(Graph g, String filePath, String ordered, String filePath2) {
		
		graph = g;
		
		String CharFromSet = "[[A-Za-z0-9]|[-\\+@#\\$%\\^&\\*|<>\\?]]*";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
			
			String line = "";
			String parentAndChild[];
			String allTheChildren[];
			
			while ((line = br.readLine()) != null) {
				
				// If it is an invalid line.
				if (!line.contains(":")) {
					// If the line is not an empty line
					if (line.length() != 0) {
					return "!02";
					}
				}
				
				// If line is not an empty line
				if (line.length() != 0) {
					
				// get the first value name
				parentAndChild = line.split(":");
				parentAndChild[0] = parentAndChild[0].trim();
				
				// check if the value name is valid
				if (parentAndChild[0].matches(CharFromSet)) {
					//graph.addNode(parentAndChild[0]);
					// check if the node has already been added into the graph
					if (!graph.contains(parentAndChild[0])) {
						graph.addNode(parentAndChild[0]);
					} 
					
				} else {
					// 02: Incorrect value exception, produced when parsing 
					// and finding characters other than the ones in the specification
					//System.out.println("Failed Here 1 , " + parentAndChild[0]);
					return "!02";
				}
				
				// get the rest of the value name
				allTheChildren = parentAndChild[1].split(",");
				//System.out.println("what's here , " + allTheChildren.length);
				for (int i = 0; i < allTheChildren.length; i++) {
					allTheChildren[i] = allTheChildren[i].trim();
					
					// check if the value name is valid
					if (allTheChildren[i].matches(CharFromSet)) {
						// check if the node has already been added into the graph
						if (!graph.contains(allTheChildren[i])) {
							graph.addNode(allTheChildren[i]);
						}
						
						String err = graph.addEdge(parentAndChild[0], allTheChildren[i]);
						
						if (!err.equals("ok")) {
							// 02: Incorrect value exception, produced when parsing 
							// and finding characters other than the ones in the specification
							//System.out.println("Failed Here 2");
							return "!03";
						}
						
					} else {
						// 02: Incorrect value exception, produced when parsing 
						// and finding characters other than the ones in the specification
						//System.out.println("Failed Here 3");
						return "!02";
					}
				}
				
			}
			}
			
			try {
				BufferedReader br2 = new BufferedReader(new FileReader(new File(filePath2)));
				
				String compLine = "";
				String[] compList = "";
				
				try {
			        byte[] c = new byte[1024];
			        int count = 0;
			        int readChars = 0;
			        while ((readChars = is.read(c)) != -1) {
			            for (int i = 0; i < readChars; ++i) {
			                if (c[i] == '\n')
			                    ++count;
			            }
			        }
			        int compLines = count;
				}
			    if ( compLines != 1) {
			    	// file has more than 1 line of data.
			    	return "!02";
			    } else {
			    	while ((compLine = br2.readLine()) != null)   {
			    		compList = compLine.split(" ");
			    		for (int i = 0; i < compLine.length; i++) {
			    			  String current = compList[i];
			    			  for(int j = 0; j < compLine.length; j++) {
			    				  String next = compList[j];
			    				  if ( current == next ) {
			    					  //Compare data has repeating Name
			    					  return "!02";
			    				  }
			    			  if (!current.matches(CharFromSet)) {
			    				  //Compare data Name is not a valid char
			    				  return "!03";
			    			  }
			    		  }
			    		  
			    		  }
			    	}
			    }
			    
			}
		    
			
		} catch (Exception ex) {
			//System.out.println(ex.getStackTrace());
			//ex.printStackTrace();
			return "!01";
		}
		
		return compList;
	}
	
}
