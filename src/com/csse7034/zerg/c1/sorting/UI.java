package com.csse7034.zerg.c1.sorting;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UI {
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path or file name :");
		String fName = sc.nextLine();
		
		String result = Parser.parse(graph, fName);
		
		if (result.equals("!01")){
			System.out.println("Error !01: File was not found on the specified location");
		} else if (result.equals("!02")){
			System.out.println("Error !02: A line in the input file does not obey the specified format");
		} else if (result.equals("!03")){
			System.out.println("Error !03: The suggested finite partial order contains a cyclic reference");
		} else {
			try { 
				BufferedWriter out = new BufferedWriter(new FileWriter("output.txt", true)); 
				out.write(Sorter.sort(graph)); 
				out.close(); 
				} catch (IOException e) { 
					System.out.println("Error !05: Result couldn't be output to text file");
				} 		
		}
		
	}
}