/*
  TrafficLightApplet.java
  By:  Matthew Evans
  Boku wa riyu no heya desu!
  Soshite, nijyusai desu.
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLightApplet extends Applet implements ActionListener {
	private Button redBtn, yellowBtn, greenBtn;
	private int activeLight = 1;
	
	public void init() {
		setSize(500, 400);
		
		redBtn = new Button("Red");
		redBtn.addActionListener(this);
		yellowBtn = new Button("Yellow");
		yellowBtn.addActionListener(this);
		greenBtn = new Button("Green");
		greenBtn.addActionListener(this);
		
		add(redBtn);
		add(yellowBtn);
		add(greenBtn);
		
		redBtn.setEnabled(false);
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 155, 500, 95);
		g.fillRect(200, 0, 95, 400);
		
		g.setColor(Color.yellow);
		g.fillRect(0, 200, 500, 5);
		g.fillRect(245, 0, 5, 400);
		
		g.setColor(Color.orange);
		
		g.fillRect(210, 125, 75, 150);
		
		g.setColor(Color.black);
		
		// Sets the light to red
		if(activeLight == 1)
			g.setColor(Color.red);		
		
		g.fillOval(227, 130, 40, 40);
		
		g.setColor(Color.black);
		
		// Sets the light to yellow
		if(activeLight == 2)
			g.setColor(Color.yellow);
		
		g.fillOval(227, 180, 40, 40);
		
		g.setColor(Color.black);
		
		// Sets the light to green
		if(activeLight == 3)
			g.setColor(Color.green);
		
		g.fillOval(227, 230, 40, 40);		
	}
	
	public void actionPerformed(ActionEvent e) {
		// User hit the red button
		if(e.getSource() == redBtn) {
			redBtn.setEnabled(false);
			greenBtn.setEnabled(true);
			yellowBtn.setEnabled(true);
			
			activeLight = 1;
		}
		
		// User hit the yellow button
		if(e.getSource() == yellowBtn) {
			yellowBtn.setEnabled(false);
			redBtn.setEnabled(true);
			greenBtn.setEnabled(true);
			
			activeLight = 2;
		}
		
		// User hit the green button
		if(e.getSource() == greenBtn) {
			greenBtn.setEnabled(false);
			redBtn.setEnabled(true);
			yellowBtn.setEnabled(true);
			
			activeLight = 3;
		}
		
		repaint();
	}
}
