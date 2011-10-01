/**
 * Class UI: Class responsable of running the main method that executes the program,
 * it also takes the errors produced by other units and returns an appropiate error message
 * 
 * @author Ding Shen Tan, Pablo MINO
 */

package com.csse7034.zerg.c1.sorting;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UI {
	
	/**
	 * main Java method which executes with the program call
	 * @param args	Additional parameters required for program execution
	 * 
	 */
	public static void main(String[] args) {
		
		/** Unique graph class instance */
		Graph graph = new Graph();
		
		/** Asking for file path */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path or file name :");
		String fName = sc.nextLine();
		
		String result = Parser.parse(graph, fName);
		
		/** Error interpretation */
		if (result.equals("!01")){
			result = "Error !01: File was not found on the specified location";
		} else if (result.equals("!02")){
			result= "Error !02: A line in the input file does not obey the specified format";
		} else if (result.equals("!03")){
			result = "Error !03: The suggested finite partial order contains a cyclic reference";
		} else {
			result = Sorter.sort(graph);
		}
		
		System.out.println(result);
		
		try { 
			FileWriter outFile = new FileWriter("output.txt", false); 
			PrintWriter out = new PrintWriter(outFile);
			out.write(result);
			out.close(); 
			} catch (IOException e) { 
				System.out.println("Error !04: Result couldn't be output to text file");
			} 	
		
	}
}