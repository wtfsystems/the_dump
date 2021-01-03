/*
	A basic extension of the java.applet.Applet class
 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class PostalBarCodeApplet extends Applet implements ActionListener
{
    
    private Button zipButton, barButton, clearButton;  // buttons
    private TextField zipText, barText; // text fields
    private Label zipLabel, barLabel;  // labels
    private Panel zipPanel, buttonPanel, barPanel;
    
	public void init()
	{
	    // Instantiate buttons
	    zipButton = new Button ("Zip");
	    zipButton.addActionListener (this);
	    
	    barButton = new Button("Bar");
	    barButton.addActionListener (this);
	    
	    clearButton = new Button ("Clear");
	    clearButton.addActionListener (this);
		
		// Instantiate Text Fields
		zipText = new TextField("18512", 52);  
	    barText = new TextField("", 52);  
	    
	    // Instantiate labels
	    zipLabel = new Label("Zip Code: ");
	    barLabel = new Label("Postal Bar Code: ");
	    
	    // format GUI layout
	    zipPanel = new Panel();  // Zip Code components
	    zipPanel.add (zipLabel);
	    zipPanel.add (zipText);
	   
	    
	    buttonPanel = new Panel();  // Buttons
	    buttonPanel.add(barButton);
	    buttonPanel.add(clearButton);
	    buttonPanel.add(zipButton);
	    	    
	    barPanel = new Panel();
	    barPanel.add (barLabel);
	    barPanel.add (barText);
	    
	    // add components to applet
	    setLayout(new GridLayout(3, 1));
	    add (zipPanel);
	    add (buttonPanel);
	    add (barPanel);
	    
	  
	}
	
	public String toZipCode (String bc)
	{
	    return "toZipCode executing";
	}
	
	public String toPostalBarCode (String zc)
	{
	    return "toBarCode executing...";
	}
	
	public void actionPerformed (ActionEvent e)
	{
	    String barCodeText = "";
	    String zipCodeText = "";
	    
	    if (e.getSource() == zipButton)  // Zip Code button
	    {
	        zipCodeText = toZipCode(barText.getText());
	        zipText.setText(zipCodeText);
	    }
	    else if (e.getSource() == barButton) // Bar Code button
	    {
	        barCodeText = toPostalBarCode(zipText.getText());
	        barText.setText(barCodeText);
	    }
	    else // Clear button
	    {
	        barText.setText("");  // Write empty string to text fields
	        zipText.setText("");
	    }
	}

}
