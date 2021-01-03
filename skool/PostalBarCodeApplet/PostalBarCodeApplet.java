/*
	PostalBarCodeApplet.java - angry version
	By:  Matthew Evans
	This applet has an atitude problem
	And this time, no japanese!
*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Integer;

public class PostalBarCodeApplet
extends Applet
implements ActionListener {

    private TextField zipText, barText; // Text fields, yay!
    private Label zipLabel, barLabel;   // Labels, yay!
    private Button zipButton, barButton, clearButton; // Buttons, booo!
    
	public void init()
	{
		setSize(500, 200);
		
		// GridBag rules!
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.NORTH;
		c.weightx = 1.0;
		c.gridwidth = 2;
		
		// Add the zip code label and text field
		zipLabel = new Label("Zip Code:");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.RELATIVE;
		gridbag.setConstraints(zipLabel, c);
		add(zipLabel);		
		zipText = new TextField("", 50);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(zipText, c);
		add(zipText);
		
		// Add the Convert to Bar Code button
		zipButton = new Button ("Convert to Bar Code");
		zipButton.addActionListener(this);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = GridBagConstraints.RELATIVE;
		gridbag.setConstraints(zipButton, c);
		add(zipButton);
		
		// Add the bar code label and text field
		barLabel = new Label("Postal Bar Code:");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = GridBagConstraints.RELATIVE;
		gridbag.setConstraints(barLabel, c);
		add(barLabel);
		barText = new TextField("", 50);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(barText, c);
		add(barText);
		
		// Add the Convert to Zip Code button
		barButton = new Button("Convert to Zip Code");
		barButton.addActionListener(this);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = GridBagConstraints.RELATIVE;
		gridbag.setConstraints(barButton, c);
		add(barButton);
	    
		// Add the Clear button
		clearButton = new Button ("Clear");
		clearButton.addActionListener(this);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = GridBagConstraints.RELATIVE;
		gridbag.setConstraints(clearButton, c);
		add(clearButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		// Action when Zip Button is clicked
		if(e.getSource() == zipButton) {
			barText.setText(toPostalBarCode(zipText.getText()));
			zipText.setText("");
		}
		// Action when Bar Button is clicked
		if(e.getSource() == barButton) {
			zipText.setText(toZipCode(barText.getText()));
			barText.setText("");
			// This is the 100th line of code
		}
		// Action when Clear Button is clicked
		if(e.getSource() == clearButton) {
			zipText.setText("");
			barText.setText("");
		}
	}
	
	// Converts a bar code to a zip code
	public String toZipCode (String bc)
	{
		String zipCode = "";
		char tempC[];
		String tempS = "";
		
		// Aparently someone needs to learn how to type!
		if(bc.length() == 0)
			return "ENTER SOMETHING!!!";
			
		else if((bc.length() == 30)||(bc.length() == 50)) {
			tempC = bc.toCharArray();
			for(int i = 0; i < (bc.length()/5)-1; i++) {
				if(i == 5) zipCode += "-";

				for(int c = 0; c < 5; c++) {
					tempS += String.valueOf(tempC[(i*5)+c]);
				}
				zipCode += reverseFigureOutBar(tempS);
				tempS = "";
			}
			
			return zipCode;
		}
		
		// If they entered something wrong, yell at them
	    return "What ever it is you entered, IT'S WRONG!";
	}
	
	// Converts a zip code to a bar code
	public String toPostalBarCode (String zc)
	{
		int totalOfZip = 0;
		int tempI;
		char tempC[];
		String tempS;
		String barCode = "";
		
		// Like I said, this applet has an atitude problem
		if(zc.length() == 0)
			return "ENTER SOMETHING!!!";		
			
		// For short zip codes
		else if(zc.length() == 5) {
			tempC = zc.toCharArray();
			for(int i = 0; i < zc.length(); i++) {
				tempS = String.valueOf(tempC[i]);
				tempI = Integer.parseInt(tempS);
				totalOfZip += tempI;
				barCode += figureOutBar(tempI);
			}
			tempI = 10 - (totalOfZip % 10);
			if(tempI == 10) tempI = 0;
			barCode += figureOutBar(tempI);
			
			return barCode;
		}
		
		// For long zip codes
		else if(zc.length() == 10) {
			tempC = zc.toCharArray();
			for(int i = 0; i < zc.length(); i++) {
				if(i == 5) i = 6;
				tempS = String.valueOf(tempC[i]);
				tempI = Integer.parseInt(tempS);
				totalOfZip += tempI;
				barCode += figureOutBar(tempI);
			}
			tempI = 10 - (totalOfZip % 10);
			if(tempI == 10) tempI = 0;
			barCode += figureOutBar(tempI);
			
			return barCode;
		}
		// And for everything else, an error message
		return "What ever it is you entered, IT'S WRONG!";
	}
	
	// This is just so the prior method don't get that messy
	public String figureOutBar(int i) {
		if(i == 1) return ":::||";
		if(i == 2) return "::|:|";
		if(i == 3) return "::||:";
		if(i == 4) return ":|::|";
		if(i == 5) return ":|:|:";
		if(i == 6) return ":||::";
		if(i == 7) return "|:::|";
		if(i == 8) return "|::|:";
		if(i == 9) return "|:|::";
		if(i == 0) return "||:::";
		// This is the 200th line of code
		return "oops";
	}
	
	// For converting back to a zip code
	public String reverseFigureOutBar(String S) {
		if(S.compareTo(":::||")==0) return "1";
		if(S.compareTo("::|:|")==0) return "2";
		if(S.compareTo("::||:")==0) return "3";
		if(S.compareTo(":|::|")==0) return "4";
		if(S.compareTo(":|:|:")==0) return "5";
		if(S.compareTo(":||::")==0) return "6";
		if(S.compareTo("|:::|")==0) return "7";
		if(S.compareTo("|::|:")==0) return "8";
		if(S.compareTo("|:|::")==0) return "9";
		if(S.compareTo("||:::")==0) return "0";
		return "oops";
	}
}
