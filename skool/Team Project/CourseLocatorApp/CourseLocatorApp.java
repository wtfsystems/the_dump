/*
  IST 311 Final Project
 
  CourseLocatorApp.java
  
  Main applet class.
  
  shinde kudasai!
*/

import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;

public class CourseLocatorApp
extends JApplet
implements ActionListener {
	private Button nextBtn;
	private Button prevBtn;
	private Button sortYardBtn;
	private Button sortNameBtn;
	private Button searchBtn;
	private Button userBtn;
	private Button adminBtn;
	
	private Label searchLabel;
	private Label spacer;
	
	private TextField searchIn;
	
	private static JPanel controls = new JPanel();
	private static JPanel temp = new JPanel();
	private static DisplayPanel displayPanel = new DisplayPanel();
	
	/*
	  Init the applet and display the main control bar
	*/
	public void init() {
		setSize(700, 500);
		controls.setSize(150, 500);
		displayPanel.setSize(650, 500);
		
		nextBtn = new Button("Next");
		nextBtn.addActionListener(this);
		prevBtn = new Button("Previous");
		prevBtn.addActionListener(this);
		sortYardBtn = new Button("Sort by Yardage");
		sortYardBtn.addActionListener(this);
		sortNameBtn = new Button("Sort by Name");
		sortNameBtn.addActionListener(this);
		searchLabel = new Label("Search by name:");
		searchBtn = new Button("Search");
		searchBtn.addActionListener(this);
		searchIn = new TextField(16);
		userBtn = new Button("User");
		userBtn.addActionListener(this);
		adminBtn = new Button("Admin");
		adminBtn.addActionListener(this);
		userBtn.setEnabled(false);
		spacer = new Label("");
		
		controls.setLayout(new GridLayout(11, 1, 0, 20));
		
		controls.add(nextBtn);
		controls.add(prevBtn);
		controls.add(sortYardBtn);
		controls.add(sortNameBtn);
		
		controls.add(searchLabel);
		controls.add(searchIn);
		controls.add(searchBtn);
		
		controls.add(spacer);
		controls.add(spacer);
		
		controls.add(userBtn);
		controls.add(adminBtn);
		
		getContentPane().add("West", controls);
		getContentPane().add(displayPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		// user hit the next btn
		if(e.getSource() == nextBtn) {
			displayPanel.nextCourse();
		}
		// user hit the previous btn
		if(e.getSource() == prevBtn) {
			displayPanel.previousCourse();
		}
		// user hit the sort by yard btn
		if(e.getSource() == sortYardBtn) {
			displayPanel.sortYard();
		}
		// user hit the sort by name btn
		if(e.getSource() == sortNameBtn) {
			displayPanel.sortABC();
		}
		// user hit the search btn
		if(e.getSource() == searchBtn) {
			// get the text to search for
			searchIn.setText(displayPanel.search(searchIn.getText()));
		}
		// user accessed the user panel
		if(e.getSource() == userBtn) {
			userBtn.setEnabled(false);
			adminBtn.setEnabled(true);
			displayPanel.showUser();
		}
		// user accessed the admin panel
		if(e.getSource() == adminBtn) {
			userBtn.setEnabled(true);
			adminBtn.setEnabled(false);
			displayPanel.showAdmin();
		}
		repaint();
	}
}
