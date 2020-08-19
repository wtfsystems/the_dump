/*
  IST 311 Final Project
 
  DisplayPanel.java
  This panel is used to display either the admin or user panel
*/

import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class DisplayPanel
extends JPanel
implements ActionListener {
	
	// user and admin display methods/panels
	private static CourseDisplay courseDisplay;
	private static CourseAdmin courseAdmin;
	
	private static CourseDB courseList;
	private CourseObject tempObject;
	
	private Button addBtn;
	private Button modifyBtn;
	private Button deleteBtn;
	private Button clearBtn;
	private Button saveBtn;
	private Button loadBtn;
	
	private Label spacer;
	
	private static JPanel admin = new JPanel();
	
	/*
	  DisplayPanel constructor
	  Creates a new database, user and admin panel, and shows the user panel
	*/
	public DisplayPanel() {
		courseList = new CourseDB();
		getItAll();
		
		courseDisplay = new CourseDisplay(tempObject);
		courseAdmin = new CourseAdmin(tempObject);
		
		courseDisplay.setOpaque(false);
		courseAdmin.setOpaque(false);

		setLayout(new GridLayout(1, 1, 0, 0));
		add(courseDisplay);

		addBtn = new Button("  Add  ");
		addBtn.addActionListener(this);
		modifyBtn = new Button("  Modify  ");
		modifyBtn.addActionListener(this);
		deleteBtn = new Button("  Delete  ");
		deleteBtn.addActionListener(this);
		clearBtn = new Button("Clear Fields");
		clearBtn.addActionListener(this);
		saveBtn = new Button("Save Data");
		saveBtn.addActionListener(this);
		loadBtn = new Button("Load Data");
		loadBtn.addActionListener(this);
		spacer = new Label("     ");
		
		admin.add(addBtn);
		admin.add(modifyBtn);
		admin.add(deleteBtn);
		//admin.add(clearBtn);
		admin.add(spacer);
		admin.add(saveBtn);
		admin.add(loadBtn);
		
		courseAdmin.add(admin,BorderLayout.NORTH);
	}
	
	// show the admin panel
	public void showAdmin() {
		remove(courseDisplay);
		add(courseAdmin);
	}
	
	// show the user panel
	public void showUser() {
		remove(courseAdmin);
		add(courseDisplay);
	}
	
	// go to the next course
	public void nextCourse() {
		courseList.nextCourse();
		getItAll();
		courseDisplay.setData(tempObject);
		courseAdmin.setData(tempObject);
	}
	
	// go to the previous course
	public void previousCourse() {
		courseList.previousCourse();
		getItAll();
		courseDisplay.setData(tempObject);
		courseAdmin.setData(tempObject);
	}
	
	// search for a course
	public String search(String name) {
		if(!courseList.searchByName(name))
			return "Course not found";
		getItAll();
		courseDisplay.setData(tempObject);
		courseAdmin.setData(tempObject);
		return "";
	}
	
	/**********************************************/
	/*
	  Sort Methods
	  These methods will restructure the linked list
	*/
	public void sortABC() {
		courseList.sortABC();
		getItAll();
		courseDisplay.setData(tempObject);
		courseAdmin.setData(tempObject);
	}
	
	public void sortYard() {
		courseList.sortYard();
		getItAll();
		courseDisplay.setData(tempObject);
		courseAdmin.setData(tempObject);
	}
	/**********************************************/
	
	private void getItAll() {
		tempObject = courseList.getObject();
	}
	
	public void actionPerformed(ActionEvent e) {
		// add a course
		if(e.getSource() == addBtn) {
			courseList.addCourse(courseAdmin.getNameTxt(), courseAdmin.getAddressTxt(), courseAdmin.getCityTxt(),
				courseAdmin.getStateTxt(), courseAdmin.getZipCodeTxt(), courseAdmin.getPhoneTxt(),
				courseAdmin.getDirectionsTxt(0), courseAdmin.getDirectionsTxt(1), courseAdmin.getDirectionsTxt(2),
				courseAdmin.getDirectionsTxt(3), courseAdmin.getDirectionsTxt(4),
				Integer.parseInt(courseAdmin.getNumOfHolesTxt()), Integer.parseInt(courseAdmin.getTotalYardageTxt()),
				Integer.parseInt(courseAdmin.getTotalParTxt()), courseAdmin.getImageTxt(), courseAdmin.getHoleNumTxt(),
				courseAdmin.getYardageTxt(), courseAdmin.getParTxt(),
				Integer.parseInt(courseAdmin.getTeeXTxt()), Integer.parseInt(courseAdmin.getTeeYTxt()),
				Integer.parseInt(courseAdmin.getHoleXTxt()), Integer.parseInt(courseAdmin.getHoleYTxt()));
		}
		// modify a course
		if(e.getSource() == modifyBtn) {
			courseList.removeCourse();
			courseList.addCourse(courseAdmin.getNameTxt(), courseAdmin.getAddressTxt(), courseAdmin.getCityTxt(),
				courseAdmin.getStateTxt(), courseAdmin.getZipCodeTxt(), courseAdmin.getPhoneTxt(),
				courseAdmin.getDirectionsTxt(0), courseAdmin.getDirectionsTxt(1), courseAdmin.getDirectionsTxt(2),
				courseAdmin.getDirectionsTxt(3), courseAdmin.getDirectionsTxt(4),
				Integer.parseInt(courseAdmin.getNumOfHolesTxt()), Integer.parseInt(courseAdmin.getTotalYardageTxt()),
				Integer.parseInt(courseAdmin.getTotalParTxt()), courseAdmin.getImageTxt(), courseAdmin.getHoleNumTxt(),
				courseAdmin.getYardageTxt(), courseAdmin.getParTxt(),
				Integer.parseInt(courseAdmin.getTeeXTxt()), Integer.parseInt(courseAdmin.getTeeYTxt()),
				Integer.parseInt(courseAdmin.getHoleXTxt()), Integer.parseInt(courseAdmin.getHoleYTxt()));
		}
		// delete a course
		if(e.getSource() == deleteBtn) {
			courseList.removeCourse();
		}
		// clear the text fields
		if(e.getSource() == clearBtn) {
			courseAdmin.setNameTxt("");
			courseAdmin.setAddressTxt("");
			courseAdmin.setCityTxt("");
			courseAdmin.setStateTxt("");
			courseAdmin.setZipCodeTxt("");
			courseAdmin.setPhoneTxt("");
			courseAdmin.setNumOfHolesTxt("");
			courseAdmin.setTotalYardageTxt("");
			courseAdmin.setTotalParTxt("");
			courseAdmin.setImageTxt("");
			courseAdmin.setHoleNumTxt("");
			courseAdmin.setYardageTxt("");
			courseAdmin.setParTxt("");
			courseAdmin.setTeeXTxt("");
			courseAdmin.setTeeYTxt("");
			courseAdmin.setHoleXTxt("");
			courseAdmin.setHoleYTxt("");
			
			for (int i = 0; i < 5; i++) {
				courseAdmin.setDirectionsTxt("", i);
			}
		}
		// save the course DB to file
		if(e.getSource() == saveBtn) {
			courseList.saveCourseDB();
		}
		// load the course DB from file
		if(e.getSource() == loadBtn) {
			courseList = new CourseDB();
		}
		sortABC();
	}
}
