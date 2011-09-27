package com.csse7034.zerg.c1.sorting;
import java.util.Scanner;

public class UI {
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path or file name :");
		String fName = sc.nextLine();
		
		Parser p = new Parser();
		
		if (Parser.parse(graph, fName) == "ok") {
			//Do sorting
		} else {
			System.out.println(Parser.parse(graph, fName));
		}
		
	}
}