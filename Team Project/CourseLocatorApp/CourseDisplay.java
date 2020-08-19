/*
  IST 311 Final Project
 
  CourseDisplay.java
  
  Draws the selected course information to the course panel
*/

import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class CourseDisplay
extends JPanel
implements ActionListener {
	private JSlider powerSlider;
	private JSlider directionSlider;
	private Button playBtn;
	
	// variables to store object data
	private Image courseImage;
	
	private String courseName;
	private String courseAddy;
	private String courseCity;
	private String courseState;
	private String courseZip;
	private String coursePhoneNum;
	private String courseDirections[] = new String[5];
	private int courseNumHoles;
	private int courseTotalYards;
	private int courseTotalPar;
	
	private String holeNum;
	private String yardage;
	private String par;
	
	// variables for playing the game
	private int northBound, southBound;
	private int westBound, eastBound;
	private int teeX, teeY;
	private int holeX, holeY;
	private int ballX, ballY;
	private int stroke;
	
	// boolean to determine if the game is over
	private boolean ballInHole;
	
	// panels to control layout
	private static JPanel controls = new JPanel();
	private static JPanel locator = new JPanel();
	
	/*
	  CourseDisplay constructor
	  gets passed an object that contains the course info
	  and then assigns this info to the variables
	  by calling the setData method,
	  also controls the layout of the panels
	*/
	public CourseDisplay(CourseObject displayThis) {
		setLayout(new BorderLayout());
		locator.setLayout(new BorderLayout());
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		controls.setLayout(gridbag);

		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth = 2;
		c.gridheight = 2;
		
		powerSlider = new JSlider(JSlider.VERTICAL, 0, 150, 0);
		c.anchor = GridBagConstraints.EAST;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(powerSlider, c);
		
		directionSlider = new JSlider(JSlider.HORIZONTAL, -45, 45, 0);
		gridbag.setConstraints(directionSlider, c);

		playBtn = new Button("Hit Ball");
		gridbag.setConstraints(playBtn, c);
		playBtn.addActionListener(this);

		controls.add(powerSlider);
		controls.add(directionSlider);
		controls.add(playBtn);
		
		controls.setOpaque(false);
		locator.setOpaque(false);
		
		locator.add("South", controls);
		add("East", locator);
		
		setData(displayThis);
	}
	
	/*
	  Method to set all the variables from the data in the object
	*/
	public void setData(CourseObject displayThis) {
		resetGame();
		
		courseName = displayThis.getName();
		courseAddy = displayThis.getAddress();
		courseCity = displayThis.getCity();
		courseState = displayThis.getState();
		courseZip = displayThis.getZipCode();
		coursePhoneNum = displayThis.getPhoneNum();
		for(int i = 0; i < 5; i++) {
			courseDirections[i] = displayThis.getDirections(i);
		}
		courseNumHoles = displayThis.getNumHoles();
		courseTotalYards = displayThis.getTotalYards();
		courseTotalPar = displayThis.getTotalPar();
		
		holeNum = displayThis.getSignatureHoleNum();
		yardage = displayThis.getYardLength();
		par = displayThis.getHolePar();
		
		courseImage = Toolkit.getDefaultToolkit().getImage("img/"+displayThis.getImage());
		
		northBound = (237 - (courseImage.getHeight(this)/2));
		southBound = (237 + courseImage.getHeight(this));
		westBound = (447 - (courseImage.getWidth(this)/2));
		eastBound = (447 + courseImage.getWidth(this));
		teeX = westBound + displayThis.getTeeX();
		teeY = northBound + displayThis.getTeeY();
		ballX = teeX;
		ballY = teeY;
		holeX = westBound + displayThis.getHoleX();
		holeY = northBound + displayThis.getHoleY();
		
		resetGame();
		
		repaint();
	}
	
	/*
	  Starts a new game
	*/
	private void resetGame() {
		stroke = 0;
		ballInHole = false;
		powerSlider.setValue(0);
		directionSlider.setValue(0);
		ballX = teeX;
		ballY = teeY;
		repaint();
		playBtn.setLabel("Hit Ball");
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(3, 0, 650, 500);
		g.setColor(Color.black);
		
		// Course display
		g.drawString("Name:", 5, 15);
		g.drawString("Number of Holes:", 5, 30);
		g.drawString("Total Yards:", 5, 45);
		g.drawString("Par:", 5, 60);
		g.drawString("Address:", 5, 75);
		g.drawString("City:", 5, 90);
		g.drawString("State:", 5, 105);
		g.drawString("Zip Code:", 5, 120);
		g.drawString("Phone Number:", 5, 135);
		g.drawString("Directions:", 5, 165);
		
		g.drawString(courseName, 110, 15);
		g.drawString(""+courseNumHoles+"", 110, 30);
		g.drawString(""+courseTotalYards+"", 110, 45);
		g.drawString(""+courseTotalPar+"", 110, 60);
		g.drawString(courseAddy, 110, 75);
		g.drawString(courseCity, 110, 90);
		g.drawString(courseState, 110, 105);
		g.drawString(courseZip, 110, 120);
		
		g.drawString(coursePhoneNum, 110, 135);
		for(int i = 0; i < 5; i++) {
			if(courseDirections[i].compareTo("!") > 0) {
				g.drawString(courseDirections[i], 5, 180 + (i * 15));
			}
		}
		
		// Signature Hole display
		g.drawString("Signature Hole", 5, 280);
		g.drawString("Hole number:", 5, 310);
		g.drawString("Yardage:", 5, 325);
		g.drawString("Par:", 5, 340);
		
		g.drawString(holeNum, 110, 310);
		g.drawString(yardage, 110, 325);
		g.drawString(par, 110, 340);
		
		g.drawLine(325, 0, 325, 500);
		g.drawLine(3, 255, 325, 255);
		
		// Game drawing
		g.drawString("Stroke:  "+stroke+"", 435, 492);
		
		g.drawImage(courseImage, (447-(courseImage.getWidth(this)/2)), (237-(courseImage.getHeight(this)/2)), this);
		
		g.fillOval(ballX, ballY, 6, 6);
		
		if(ballInHole == true) {
			playBtn.setLabel("Play Again");
			if(stroke == 1)
				g.drawString("HOLE IN ONE!", 415, 12);
			else
				g.drawString("Ball in Hole", 415, 12);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		// if the user hits the play button, reposition the ball
		if(e.getSource() == playBtn) {
			if(ballInHole == true) {
				resetGame();
			}
			
			// move the ball according to the location of the hole
			// and the power/direction that the ball was hit
			++stroke;
			ballX = (ballX + directionSlider.getValue());
			if(ballY < holeY)
				ballY = (ballY + powerSlider.getValue());
			else
				ballY = (ballY - powerSlider.getValue());

			// make sure the ball didn't go too far off course
			if(ballX < westBound)
				ballX = westBound;
			if(ballX > eastBound)
				ballX = eastBound;
			if(ballY < northBound)
				ballY = northBound;
			if(ballY > southBound)
				ballY = southBound;
			
			// check to see if the ball went in the hole
			if((ballX > holeX - 5)&&(ballX < holeX + 5))
				if((ballY > holeY - 5)&&(ballY < holeY + 5))
					ballInHole = true;
			
			// reset the power and direction sliders
			powerSlider.setValue(0);
			directionSlider.setValue(0);
		}
		repaint();
	}
}
