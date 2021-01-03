/*
  BirthdayApplet.java
  By:  Matthew Evans
*/

import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;

public class BirthdayApplet extends JApplet implements ActionListener {
	private String months[] = {"January",
							   "Febuary",
							   "March",
							   "April",
							   "May",
							   "June",
							   "July",
							   "August",
							   "September",
							   "October",
							   "November",
							   "December"};
	private JComboBox monthList = new JComboBox(months);

	private TextField dayField;
	private Button findButton;

	private JPanel controls = new JPanel();
	private Calendar calendar = new Calendar();
	
	public void init() {
		setSize(450, 350);
		
		// Yay! Drop-downs rule!
		controls.add(monthList);
		
		dayField = new TextField(2);
		controls.add(dayField);
		
		findButton = new Button("Go!");
		findButton.addActionListener(this);
		controls.add(findButton);
		
		getContentPane().add(controls, "North");
		getContentPane().add(calendar, "Center");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == findButton) {
			if(Integer.parseInt(dayField.getText()) < 1)
				return;
			if(Integer.parseInt(dayField.getText()) > 31)
				return;
			calendar.setMonthSelected(monthList.getSelectedIndex());
			calendar.setDayEntered(Integer.parseInt(dayField.getText()));
		}
		repaint();
	}
}
