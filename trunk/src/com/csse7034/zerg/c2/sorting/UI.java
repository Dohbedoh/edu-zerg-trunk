/**
 * Class UI: Class responsable of running the main method that executes the program,
 * it also takes the errors produced by other units and returns an appropiate error message
 * 
 * @author Ding Shen Tan, Pablo MINO
 */

package com.csse7034.zerg.c2.sorting;

import java.awt.*; 
import java.awt.event.*; 

import javax.swing.*; 
import javax.swing.filechooser.*; 

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class UI extends JFrame implements ActionListener {
	
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
	  
	  JButton runButton = new JButton("Run");
	  
	  JLabel file1Label = new JLabel("File 1");
	  JTextField file1Field = new JTextField(50);
	  JFileChooser file1Chooser = new JFileChooser();
	  JButton file1Button = new JButton("Open File");
	  
	  JLabel file2Label = new JLabel("File 2");
	  JTextField file2Field = new JTextField(50);
	  JFileChooser file2Chooser = new JFileChooser();
	  JButton file2Button = new JButton("Open File");
	  
	  JTextArea outputTextArea = new JTextArea(20, 30);
	  JScrollPane bottomPanel = new JScrollPane(outputTextArea);
	  
	  /**
	   * The constructor.
	   */
	  public UI()
	  {
		super("Topological Sorter");
		
		mode = 1;
		
	    topPanel.setLayout(new FlowLayout());
	    topPanel.add(mode1Radio);
	    topPanel.add(mode2Radio);
	    topPanel.add(runButton);
	    
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
	    //mainPanel.add(outputTextArea);
	    mainPanel.add(bottomPanel);
	    
	    mode1Radio.setSelected(true);
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

            }
        }); 
	    
        //Add action listener to file select button 1
	    file1Button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	int returnVal = file1Chooser.showOpenDialog(UI.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    
                	file1Field.setText(file1Chooser.getSelectedFile().getAbsolutePath());
                	System.out.println("You choose file " + file1Chooser.getSelectedFile().getAbsolutePath());
                	
                }
            }
        }); 
	    
        //Add action listener to file select button 2
	    file2Button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	int returnVal = file2Chooser.showOpenDialog(UI.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    
                	file2Field.setText(file2Chooser.getSelectedFile().getAbsolutePath());
                	System.out.println("You choose file " + file2Chooser.getSelectedFile().getAbsolutePath());
                	
                }
            }
        }); 
	    
        //Add action listener to the run button
	    runButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	if (mode == 1){
            		System.out.println("You clicked run!");
            		String result = Parser.parse(graph, file1Field.getText());
            		
            		// Error interpretation
            		if (result.equals("!01")){
            			result = "Error !01: File was not found on the specified location";
            		} else if (result.equals("!02")){
            			result= "Error !02: A line in the input file does not obey the specified format";
            		} else if (result.equals("!03")){
            			result = "Error !03: The suggested finite partial order contains a cyclic reference";
            		} else {
            			result = Sorter.sort(graph);
            		}
            		outputTextArea.setText(result);
            	}
            	else{
            		/* *
            		 * The logic need to be changed for mode 2!
            		 * The filename for mode 1 is file1Field.getText()
            		 * The filename for mode 2 is file2Field.getText()
            		 * */
            		System.out.println("You clicked run!");
            		String result = Parser.parse(graph, file1Field.getText());
            		
            		// Error interpretation
            		if (result.equals("!01")){
            			result = "Error !01: File was not found on the specified location";
            		} else if (result.equals("!02")){
            			result= "Error !02: A line in the input file does not obey the specified format";
            		} else if (result.equals("!03")){
            			result = "Error !03: The suggested finite partial order contains a cyclic reference";
            		} else {
            			result = Sorter.sort(graph);
            		}
            		outputTextArea.setText(result);
            		
            	}
            }
        }); 
	  }


	
	/**
	 * main Java method which executes with the program call
	 * @param args	Additional parameters required for program execution
	 * 
	 */
	public static void main(String[] args) {
		
		/** Create the UI
		 */
		
	    UI myUI = new UI();
		
		/** Asking for file path */
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter file path or file name :");
		//String fName = sc.nextLine();
		
		//String result = Parser.parse(graph, fName);
		
		/*
		// Error interpretation
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
		
		if(result.startsWith("Error"))
		{
			try { 
				FileWriter outFile = new FileWriter("errlog.txt", false); 
				PrintWriter out = new PrintWriter(outFile);
				out.write(result);
				out.close(); 
			} catch (IOException e) { 
				System.out.println("Error !04: Error couldn't be output to text file");
			} 
		}
		*/
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}