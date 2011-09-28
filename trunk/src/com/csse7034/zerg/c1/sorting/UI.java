package com.csse7034.zerg.c1.sorting;
import java.util.Scanner;

public class UI {
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path or file name :");
		String fName = sc.nextLine();
		
		Parser p = new Parser();
		Sorter s = new Sorter();
		
		if (Parser.parse(graph, fName) == "ok") {
			String result = s.sort(graph);
			System.out.println(result);
		} else {
			System.out.println(Parser.parse(graph, fName));
		}
		
	}
}