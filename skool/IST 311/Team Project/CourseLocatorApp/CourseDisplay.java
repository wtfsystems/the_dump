/*
  CourseDisplay.java
*/

import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class CourseDisplay
extends JPanel {
	private static CourseDB courseList;
	
	private static Image courseImage;
	
	public CourseDisplay() {
		courseList = new CourseDB();
		
		/*****************************************/
		// test code
		courseImage = Toolkit.getDefaultToolkit().getImage("img/001.gif");
		/*****************************************/
	}
	
	public void nextCourse() {
		courseList.nextCourse();
		repaint();
	}
	
	public void previousCourse() {
		courseList.previousCourse();
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.drawString("Name:", 155, 15);
		g.drawString("Number of Holes:", 155, 30);
		g.drawString("Total Yards:", 155, 45);
		g.drawString("Par:", 155, 60);
		g.drawString("Address:", 155, 75);
		g.drawString("Phone Number:", 155, 90);
		g.drawString("Directions:", 155, 120);
		g.drawString("Signature Hole", 155, 250);
		
		g.drawString(courseList.getName(), 265, 15);
		g.drawString(""+courseList.getNumHoles()+"", 265, 30);
		g.drawString(""+courseList.getTotalYards()+"", 265, 45);
		g.drawString(""+courseList.getTotalPar()+"", 265, 60);
		g.drawString(courseList.getAddress(), 265, 75);
		g.drawString(courseList.getPhoneNum(), 265, 90);
		g.drawString(courseList.getDirections(), 155, 135);
		
		g.drawLine(380, 0, 380, 500);
		g.drawLine(150, 235, 380, 235);
		
		g.drawImage(courseImage, (600-courseImage.getWidth(this)), (470-courseImage.getHeight(this)), this);
		repaint();
	}
}
