/**
 * Class Parser: Parses the input file from the user and translates the data in it 
 * to a graph with nodes
 * 
 * @author Koh Thong Guan
 */

package com.csse7034.zerg.c2.sorting;

import java.io.*;
import java.util.*;

import com.csse7034.zerg.c2.errors.*;

public class Parser {

	// static Graph graph = null;

	public Parser() {
	}

	/**
	 * Parse the data in the input text file with its file path and translates
	 * the data into nodes to fill the graph.
	 * 
	 * @param g
	 *            The created empty Graph object
	 * @param filePath
	 *            The file path
	 * @return 
	 */
	public static void parse(String filePath, GraphI graph)
			throws SorterException {

		String CharFromSet = "[[A-Za-z0-9]|[-\\+@#\\$%\\^&\\*|<>\\?]]*";

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					filePath)));

			String line = "";
			String parentAndChild[];
			String allTheChildren[];
			int lineCount1 = 0;

			while ((line = br.readLine()) != null) {
				lineCount1++;
				// If it is an invalid line.
				if (!line.contains(":")) {
					// If the line is not an empty line
					if (line.length() != 0) {
						// return "!02";
						throw new FileFormatException(filePath, lineCount1);
					}
				}

				// If line is not an empty line
				if (line.length() != 0) {

					// get the first value name
					parentAndChild = line.split(":");
					parentAndChild[0] = parentAndChild[0].trim();

					// check if the value name is valid
					if (parentAndChild[0].matches(CharFromSet)) {
						// graph.addNode(parentAndChild[0]);
						// check if the node has already been added into the
						// graph
						if (!graph.contains(parentAndChild[0])) {
							graph.addNode(parentAndChild[0]);
						}

					} else {
						// 02: Incorrect value exception, produced when parsing
						// and finding characters other than the ones in the
						// specification
						// System.out.println("Failed Here 1 , " +
						// parentAndChild[0]);
						// return "!02";
						throw new SequenceValueException(filePath, lineCount1);
					}

					// get the rest of the value name
					allTheChildren = parentAndChild[1].split(",");
					// System.out.println("what's here , " +
					// allTheChildren.length);
					for (int i = 0; i < allTheChildren.length; i++) {
						allTheChildren[i] = allTheChildren[i].trim();

						// check if the value name is valid
						if (allTheChildren[i].matches(CharFromSet)) {
							// check if the node has already been added into the
							// graph
							if (!graph.contains(allTheChildren[i])) {
								graph.addNode(allTheChildren[i]);
							}

							// String err = graph.addEdge(parentAndChild[0],
							// allTheChildren[i]);
							try {
								graph.addEdge(parentAndChild[0],
										allTheChildren[i]);
							} catch (SorterException cge) {
								throw cge;
							}

							/*
							 * if (!err.equals("ok")) { // 02: Incorrect value
							 * exception, produced when parsing // and finding
							 * characters other than the ones in the
							 * specification
							 * //System.out.println("Failed Here 2"); return
							 * "!03"; }
							 */

						} else {
							// 02: Incorrect value exception, produced when
							// parsing
							// and finding characters other than the ones in the
							// specification
							// System.out.println("Failed Here 3");
							// return "!02";
							throw new SequenceValueException(filePath,
									lineCount1);
						}
					}

				}
			}
			br.close();
		} catch (IOException ex) {
			// System.out.println(ex.getStackTrace());
			// ex.printStackTrace();
			// return "!01";
			// throw new
			// FileNotFoundException("Error !01: File was not found on the specified location");
			throw new FileInputException(filePath);
		}
	}

	/**
	 * Parse the data in the input text file with its file path and translates
	 * the data into a string list containing individual nodes for topological
	 * sort checking
	 * 
	 * @param filePath2
	 *            The file path
	 * @param g
	 *            The graph to check nodes with
	 * @return String[] A String list containing individual nodes
	 */

	public static String[] parse2(String filePath2, Graph g)
			throws SorterException {

		// Initialising Variables
		String line;
		int size = 0;
		String curLine;

		// Count number of lines
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					filePath2)));
			while ((line = br.readLine()) != null) {
				size++;
			}
			br.close();
		} catch (IOException ex) {
			throw new FileInputException(filePath2);
		}

		String[] compList = new String[size];

		try {
			BufferedReader br2 = new BufferedReader(new FileReader(new File(
					filePath2)));
			int lineCount2 = 0;
			int i = 0;
			while ((curLine = br2.readLine()) != null) {
				lineCount2++;
				if (curLine.length() != 0) {
					if (g.contains(curLine.trim())) {
						compList[i] = curLine.trim();
						i++;
					} else {
						throw new NoSuchNodeException(curLine);
					}
				}
			}

			for (int j = 0; j < compList.length; j++) {
				String current = compList[j].trim();
				for (int k = 0; k < compList.length; k++) {
					String next = compList[k].trim();

					if (k != j) {
						if (current.equals(next)) {
							throw new FileFormatException(filePath2,
									lineCount2);
						}
					}
				}
			}
			br2.close();
		} catch (IOException ex) {
			// System.out.println(ex.getStackTrace());
			ex.printStackTrace();
			throw new FileInputException(filePath2);
		}

		return compList;
	}

}
