/*
  Calendar.java
  By:  Matthew Evans
  muzukashi desu ne!!!
*/

import javax.swing.*;
import java.awt.*;

public class Calendar extends JPanel {
	private int daysInEachMonth[] = { 31, 28, 31, 30, 31, 30,
									  31, 31, 30, 31, 30, 31 };
	private int monthSelected = 0;
	private int dayEntered = 0;
	private int dayOfWeek = 0;
	
	public Calendar() {
		setSize(450, 250);
	}
	
	public void setMonthSelected(int month) {
		monthSelected = month;
	}	
	
	public void setDayEntered(int day) {
		dayEntered = day;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.drawRect(0, 0, 450, 250);
		g.setColor(getForeground());
		
		/****************************/
		// Draw the calendar outline
		g.drawRect(50, 50, 350, 200);
		g.drawLine(50, 75, 400, 75);
		g.drawLine(50, 100, 400, 100);
		g.drawLine(50, 125, 400, 125);
		g.drawLine(50, 150, 400, 150);
		g.drawLine(50, 175, 400, 175);
		g.drawLine(50, 200, 400, 200);
		g.drawLine(50, 225, 400, 225);
		g.drawLine(100, 75, 100, 250);
		g.drawLine(150, 75, 150, 250);
		g.drawLine(200, 75, 200, 250);
		g.drawLine(250, 75, 250, 250);
		g.drawLine(300, 75, 300, 250);
		g.drawLine(350, 75, 350, 250);
		g.setColor(Color.blue);
		g.drawString("S", 70, 95);
		g.drawString("M", 120, 95);
		g.drawString("T", 170, 95);
		g.drawString("W", 220, 95);
		g.drawString("T", 270, 95);
		g.drawString("F", 320, 95);
		g.drawString("S", 370, 95);
		/****************************/
		
		// Set the calendar month
		g.drawString(getMonthName(), 200, 65);
		
		// Draw in the days
		int d = 0;
		for(int i = 0; i < 6; i++) {
			for(int n = 0; (n < 7)&&(d < daysInEachMonth[monthSelected]); n++) {
				++d;
				if((i == 0)&&(n == 0)) {
					n = getFirstOfMonth(monthSelected);
				}
				if(d == dayEntered) {
					g.setColor(Color.red);
					g.drawString(""+d+"", 70 + (50 * n), 115 + (25 * i));
					g.setColor(Color.blue);
				}
				else {
					g.drawString(""+d+"", 70 + (50 * n), 115 + (25 * i));
				}
			}
		}
		g.setColor(Color.black);
		
		if((monthSelected == 9)&&(dayEntered == 30))
			g.drawString("Hey! That's my birthday!", 25, 300);
	}
	
	public int getDay(int month, int day) {
		int calcDay = 0;
		
		for(int i = 0; i < month; i++)
			calcDay += daysInEachMonth[i];
		calcDay += day;
		
		return calcDay;
	}
	
	public int getDayOfWeek(int day) {
		switch(day % 7) {
			case 0: return 2;
			case 1: return 3;
			case 2: return 4;
			case 3: return 5;
			case 4: return 6;
			case 5: return 0;
			case 6: return 1;
		}
		return 0;
	}
	
	private String getMonthName() {
		switch (monthSelected) {
			case 0:  return "January";
			case 1:  return "Febuary";
			case 2:  return "March";
			case 3:  return "April";
			case 4:  return "May";
			case 5:  return "June";
			case 6:  return "Juy";
			case 7:  return "August";
			case 8:  return "September";
			case 9:  return "October";
			case 10: return "November";
			case 11: return "December";
		}
		return "";
	}
	
	private int getFirstOfMonth(int month) {
		int calcFirst = 0;
		
		for(int i = 0; i < month; i++)
			calcFirst += daysInEachMonth[i];
		++calcFirst;
		
		return getDayOfWeek(calcFirst);
	}
}
