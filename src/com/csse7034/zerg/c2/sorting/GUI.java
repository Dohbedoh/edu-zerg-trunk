/**
 * Class UI: Class responsible of running the main method that executes the program,
 * it also takes the errors produced by other units and returns an appropriate error message
 * 
 * @author Ding Shen Tan, Pablo MINO
 */

package com.csse7034.zerg.c2.sorting;

import java.awt.*; 
import java.awt.event.*; 
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

public class GUI extends JFrame{

	/**
	 * The members.
	 */

	int mode;

	/** Unique graph class instance */
	Graph graph = new Graph();

	JPanel mainPanel = new JPanel();

	JPanel topPanel = new JPanel();
	JPanel middlePanel = new JPanel();
	JPanel middle1Panel = new JPanel();
	JPanel middle2Panel = new JPanel();

	JRadioButton mode1Radio = new JRadioButton("Mode 1");
	JRadioButton mode2Radio = new JRadioButton("Mode 2");
	ButtonGroup buttonGroup = new ButtonGroup();

	JButton runButton = new JButton("Run");

	JTextArea statusTextArea = new JTextArea(1,1);

	JLabel file1Label = new JLabel("File 1");
	JTextField file1Field = new JTextField(50);
	JFileChooser file1Chooser = new JFileChooser();
	JButton file1Button = new JButton("Open File");

	JLabel file2Label = new JLabel("File 2");
	JTextField file2Field = new JTextField(50);
	JFileChooser file2Chooser = new JFileChooser();
	JButton file2Button = new JButton("Open File");

	JTextArea outputTextArea = new JTextArea(16, 30);
	JScrollPane bottomPanel = new JScrollPane(outputTextArea);

	/**
	 * The constructor.
	 */
	public GUI()
	{
		super("Topological Sorter");

		mode = 1;

		topPanel.setLayout(new FlowLayout());
		topPanel.add(mode1Radio);
		topPanel.add(mode2Radio);
		topPanel.add(runButton);

		// Status button - DS
		topPanel.add(statusTextArea);

		statusTextArea.setBackground(Color.GRAY);
		statusTextArea.setEditable(false);
		// End Status button

		middle1Panel.setLayout(new FlowLayout());
		middle1Panel.add(file1Label);
		middle1Panel.add(file1Field);
		middle1Panel.add(file1Button);

		middle2Panel.setLayout(new FlowLayout());
		middle2Panel.add(file2Label);
		middle2Panel.add(file2Field);
		middle2Panel.add(file2Button);

		//middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		//middlePanel.add(middle1Panel);
		//middlePanel.add(middle2Panel);

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(topPanel);
		mainPanel.add(middle1Panel);
		mainPanel.add(middle2Panel);

		outputTextArea.setMargin(new Insets(10, 10, 10, 10));
		outputTextArea.setLineWrap(true);
		//mainPanel.add(outputTextArea);
		mainPanel.add(bottomPanel);

		mode1Radio.setSelected(true);
		buttonGroup.add(mode1Radio);
		buttonGroup.add(mode2Radio);
		file1Field.setEditable(false);
		file2Field.setEditable(false);
		middle2Panel.setVisible(false);
		outputTextArea.setEditable(false);



		getContentPane().add(mainPanel, BorderLayout.CENTER);
		setResizable(true);
		getContentPane().setPreferredSize(new Dimension(800,400));
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		//Add action listener to mode 1 radio button
		mode1Radio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				mode = 1;
				mode2Radio.setSelected(false);
				//Execute when button is pressed
				System.out.println("You choose mode 1");

				middle2Panel.setVisible(false);
				if(file1Field.getText().length()>0)
				{
					runButton.setEnabled(true);
				} else {
					runButton.setEnabled(false);
					statusTextArea.setBackground(Color.GRAY);
				}
			}
		});  

		//Add action listener to mode 2 radio button
		mode2Radio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				mode = 2;
				mode1Radio.setSelected(false);
				//Execute when button is pressed
				System.out.println("You choose mode 2");

				middle2Panel.setVisible(true);
				if(file2Field.getText().length()>0)
				{
					runButton.setEnabled(true);
				}else{
					runButton.setEnabled(false);
					statusTextArea.setBackground(Color.GRAY);
				}
			}
		}); 

		//Add action listener to file select button 1
		file1Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				int returnVal = file1Chooser.showOpenDialog(GUI.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					file1Field.setText(file1Chooser.getSelectedFile().getAbsolutePath());
					System.out.println("You choose file " + file1Chooser.getSelectedFile().getAbsolutePath());

					if(mode == 2 && file2Field.getText().length()==0)
					{
						runButton.setEnabled(false);
					}else{
						runButton.setEnabled(true);
					}
				}
			}
		}); 

		//Add action listener to file select button 2
		file2Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				int returnVal = file2Chooser.showOpenDialog(GUI.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					file2Field.setText(file2Chooser.getSelectedFile().getAbsolutePath());
					System.out.println("You choose file " + file2Chooser.getSelectedFile().getAbsolutePath());

					if(file1Field.getText().length()==0)
					{
						runButton.setEnabled(false);
					}else{
						runButton.setEnabled(true);
					}
				}
			}
		}); 

		//Add action listener to the run button
		runButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if (mode == 1){
					System.out.println("You clicked run!");
					String result;
					try {
						graph.emptyGraph();
						Parser.parse(file1Field.getText(),graph);
						result = graph.toString()+"\n";
						result += "A Topological Sort possible:\n\n"+Sorter.sort(graph)+"\n";
						statusTextArea.setBackground(Color.GREEN);
						appendResult(result);
					} catch (Exception ex) {
						ex.printStackTrace();
						result = ex.getMessage();
						statusTextArea.setBackground(Color.RED);
						appendError(result);
					}

					outputTextArea.setText(result.trim());
				}
				else{
					/* *
					 * The logic need to be changed for mode 2!
					 * The filename for mode 1 is file1Field.getText()
					 * The filename for mode 2 is file2Field.getText()
					 * */
					String result="";

					try {
						graph.emptyGraph();
						Parser.parse(file1Field.getText(),graph);
						result = graph.toString()+"\n";
						// Field 2 check missing - Fixed by DS
						if (file2Field.getText().length() > 0) {
							String[] value = Parser.parse2(file2Field.getText(), graph);
							result += "The topological sort suggested:\n\n";
							for(int i=0; i<value.length; i++)
							{
								result += value[i] + "\n";
							}
							result += "\nResult: "+((Sorter.compare(graph, value))? "The sequence is valid" : "The sequence is NOT valid");

							// Extra stuff

							if (Sorter.compare(graph, value)) {
								statusTextArea.setBackground(Color.GREEN);
							} else {
								statusTextArea.setBackground(Color.RED);
							}
							// End extra stuff

							appendResult(result);
						} else {
							result = "Both files are required.";
							statusTextArea.setBackground(Color.RED);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						result += ex.getMessage();
						statusTextArea.setBackground(Color.RED);
						appendError(result);
					}
					outputTextArea.setText(result.trim());

				}
			}
		});
		runButton.setEnabled(false);
	}

	/* BEGIN Allan */ // O-kay.

	private void appendError(String message)
	{
		try { 
			File file = new File("errorlog.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			System.out.println(file.getPath());
			FileWriter outFile = new FileWriter(file, true); 
			PrintWriter out = new PrintWriter(outFile);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
			out.append("-----------------------------\n"+sdf.format(cal.getTime())+"\n");
			out.append(message+"\n");
			out.close(); 
		} catch (IOException e) { 
			outputTextArea.setText("Error couldn't be output to text file");
			statusTextArea.setBackground(Color.RED);
		} 
	}

	private void appendResult(String message)
	{
		try { 
			File file = new File("resultlog.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			System.out.println(file.getPath());
			FileWriter outFile = new FileWriter(file, true); 
			PrintWriter out = new PrintWriter(outFile);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
			out.append("-----------------------------\n"+sdf.format(cal.getTime())+"\n");
			out.append(file1Field.getText()+"\n");
			if(mode == 2)
			{
				out.append(file2Field.getText()+"\n");	
			}
			out.append(message+"\n");
			out.close(); 
		} catch (IOException e) { 
			outputTextArea.setText("Error couldn't be output to text file");
			statusTextArea.setBackground(Color.RED);
		} 
	}

	/* Allan END*/

	/**
	 * main Java method which executes with the program call
	 * @param args	Additional parameters required for program execution
	 * 
	 */
	public static void main(String[] args) {

		/** Create the UI
		 */

		GUI myUI = new GUI();

	}
}