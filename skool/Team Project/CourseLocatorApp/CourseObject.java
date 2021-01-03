/*
  IST 311 Final Project
 
  CourseObject.java
  
  CourseObject element that makes up the linked list
  Stores information on each course in the database
  Extends SignatureHole for aditional course information
*/

public class CourseObject
extends SignatureHole {
	private String courseName;
	private String courseAddress;
	private String courseCity;
	private String courseState;
	private String courseZipCode;
	private String coursePhoneNum;
	private String courseDirections[] = new String[5];
	private int courseNumHoles;
	private int courseTotalYards;
	private int courseTotalPar;
	
	/*
	  CourseObject constructor
	  simply gets passed all the data and stores it in the object
	*/
	public CourseObject(String name,
						String address,
						String city,
						String state,
						String zipcode,
						String phoneNum,
						String directions1,
						String directions2,
						String directions3,
						String directions4,
						String directions5,
						int numHoles,
						int totalYards,
						int totalPar,
						String image,
						String num,
						String yardage,
						String par,
						int teeX, int teeY,
						int holeX, int holeY) {
		courseName = name;
		courseAddress = address;
		courseCity = city;
		courseState = state;
		courseZipCode = zipcode;
		coursePhoneNum = phoneNum;
		courseDirections[0] = directions1;
		courseDirections[1] = directions2;
		courseDirections[2] = directions3;
		courseDirections[3] = directions4;
		courseDirections[4] = directions5;
		courseNumHoles = numHoles;
		courseTotalYards = totalYards;
		courseTotalPar = totalPar;
		courseImage = image;
		signatureHoleNum = num;
		yardLength = yardage;
		holePar = par;
		teePosX = teeX;
		teePosY = teeY;
		holePosX = holeX;
		holePosY = holeY;
	}
	
	/**********************************************/
	// gets
	public String getName() {
		return courseName;
	}
	
	public String getAddress() {
		return courseAddress;
	}
	
	public String getCity() {
		return courseCity;
	}
	
	public String getState() {
		return courseState;
	}
	
	public String getZipCode() {
		return courseZipCode;
	}
	
	public String getPhoneNum() {
		return coursePhoneNum;
	}
	
	public String getDirections(int line) {
		return courseDirections[line];
	}
	
	public int getNumHoles() {
		return courseNumHoles;
	}
	
	public int getTotalYards() {
		return courseTotalYards;
	}
	
	public int getTotalPar() {
		return courseTotalPar;
	}
	
	public int getTeeX() {
		return teePosX;
	}
	
	public int getTeeY() {
		return teePosY;
	}
	
	public int getHoleX() {
		return holePosX;
	}
	
	public int getHoleY() {
		return holePosY;
	}
	/**********************************************/
	
	/**********************************************/
	// sets
	public void setName(String name) {
		courseName = name;
	}
	
	public void setAddress(String address) {
		courseAddress = address;
	}
	
	public void setPhoneNum(String phoneNum) {
		coursePhoneNum = phoneNum;
	}
	
	public void setDirections(String directions, int line) {
		courseDirections[line] = directions;
	}
	
	public void setNumHoles(int numHoles) {
		courseNumHoles = numHoles;
	}
	
	public void setTotalYards(int totalYards) {
		courseTotalYards = totalYards;
	}
	
	public void setTotalPar(int totalPar) {
		courseTotalPar = totalPar;
	}
	/**********************************************/
}
