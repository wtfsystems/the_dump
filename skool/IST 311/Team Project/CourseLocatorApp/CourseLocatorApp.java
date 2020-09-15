/*
  CourseLocatorApp.java
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
	
	private Label searchLabel;
	
	private TextField searchIn;
	
	private static JPanel controls = new JPanel();
	private static CourseDisplay courseDisplay = new CourseDisplay();
	
	public void init() {
		setSize(700, 500);
		
		nextBtn = new Button("Next");
		prevBtn = new Button("Previous");
		sortYardBtn = new Button("Sort by Yardage");
		sortNameBtn = new Button("Sort by Name");
		searchLabel = new Label("Search:");
		searchBtn = new Button("Search");
		searchIn = new TextField(10);
		
		controls.setSize(150, 500);
		controls.setLayout(new GridLayout(11, 1, 0, 20));
		
		controls.add(nextBtn);
		controls.add(prevBtn);
		/*controls.add(sortYardBtn);
		controls.add(sortNameBtn);
		
		controls.add(searchLabel);
		controls.add(searchIn);
		controls.add(searchBtn);*/
				
		getContentPane().add(controls);
		getContentPane().add(courseDisplay);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nextBtn) {
			courseDisplay.nextCourse();
		}
		if(e.getSource() == prevBtn) {
			courseDisplay.previousCourse();
		}
		if(e.getSource() == sortYardBtn) {
			//
		}
		if(e.getSource() == sortNameBtn) {
			//
		}
		if(e.getSource() == searchBtn) {
			//
		}
		repaint();
	}
}
