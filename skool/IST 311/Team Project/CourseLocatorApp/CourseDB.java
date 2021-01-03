/*
  CourseDB.java
*/

import java.util.*;

public class CourseDB {
	private static LinkedList CourseDBList;
	
	private int listSize;
	private int listLoc;
	
	public CourseDB() {
		CourseDBList = new LinkedList();
		
		// load the list from the XML file
		
		/*********************************************/
		// test code
		addCourse("yay1", "addy1", "phn1", "dir1", 18, 200, 5);
		addCourse("yay2", "addy2", "phn2", "dir2", 18, 250, 10);
		addCourse("yay3", "addy3", "phn3", "dir3", 9, 100, 3);
		addCourse("yay4", "addy4", "phn4", "dir4", 18, 1100, 20);
		/*********************************************/
		
		//Collections.sort(CourseDBList);
		listSize = CourseDBList.size();
		listLoc = CourseDBList.indexOf(CourseDBList.getFirst());
	}
	
	public void addCourse(String name,
						  String address,
						  String phoneNum,
						  String directions,
						  int numHoles,
						  int totalYards,
						  int totalPar) {
		CourseObject addThis = new CourseObject(name,
						  						address,
						  						phoneNum,
						  						directions,
						  						numHoles,
						  						totalYards,
						 						totalPar);
		CourseDBList.add(addThis);
	}
	
	/**********************************************/
	// sorters
	public void sortABC() {
		//
	}
	
	public void sortYard() {
		//
	}
	/**********************************************/
	
	/**********************************************/
	// next and previous
	public void nextCourse() {
		if(listLoc != listSize) ++listLoc;
	}
	
	public void previousCourse() {
		if(listLoc != CourseDBList.indexOf(CourseDBList.getFirst())) --listLoc;
	}
	/**********************************************/

	/**********************************************/
	// gets
	public String getName() {
		CourseObject getThis = (CourseObject) CourseDBList.get(listLoc);
		return getThis.getName();
	}
	
	public String getAddress() {
		CourseObject getThis = (CourseObject) CourseDBList.get(listLoc);
		return getThis.getAddress();
	}
	
	public String getPhoneNum() {
		CourseObject getThis = (CourseObject) CourseDBList.get(listLoc);
		return getThis.getPhoneNum();
	}
	
	public String getDirections() {
		CourseObject getThis = (CourseObject) CourseDBList.get(listLoc);
		return getThis.getDirections();
	}
	
	public int getNumHoles() {
		CourseObject getThis = (CourseObject) CourseDBList.get(listLoc);
		return getThis.getNumHoles();
	}
	
	public int getTotalYards() {
		CourseObject getThis = (CourseObject) CourseDBList.get(listLoc);
		return getThis.getTotalYards();
	}
	
	public int getTotalPar() {
		CourseObject getThis = (CourseObject) CourseDBList.get(listLoc);
		return getThis.getTotalPar();
	}
	/**********************************************/
	
	/**********************************************/
	// sets
	public void setName(String name) {
		CourseObject setThis = (CourseObject) CourseDBList.get(listLoc);
		setThis.setName(name);
	}
	
	public void setAddress(String address) {
		CourseObject setThis = (CourseObject) CourseDBList.get(listLoc);
		setThis.setAddress(address);
	}
	
	public void setPhoneNum(String phoneNum) {
		CourseObject setThis = (CourseObject) CourseDBList.get(listLoc);
		setThis.setPhoneNum(phoneNum);
	}
	
	public void setDirections(String directions) {
		CourseObject setThis = (CourseObject) CourseDBList.get(listLoc);
		setThis.setDirections(directions);
	}
	
	public void setNumHoles(int numHoles) {
		CourseObject setThis = (CourseObject) CourseDBList.get(listLoc);
		setThis.setNumHoles(numHoles);
	}
	
	public void setTotalYards(int totalYards) {
		CourseObject setThis = (CourseObject) CourseDBList.get(listLoc);
		setThis.setTotalYards(totalYards);
	}
	
	public void setTotalPar(int totalPar) {
		CourseObject setThis = (CourseObject) CourseDBList.get(listLoc);
		setThis.setTotalPar(totalPar);
	}
	/**********************************************/
}
