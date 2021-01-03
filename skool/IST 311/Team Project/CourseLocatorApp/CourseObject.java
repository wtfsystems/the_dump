/*
  CourseObject.java
*/

public class CourseObject
extends SignatureHole {
	private String courseName;
	private String courseAddress;
	private String coursePhoneNum;
	private String courseDirections;
	private int courseNumHoles;
	private int courseTotalYards;
	private int courseTotalPar;
	
	public CourseObject(String name,
						String address,
						String phoneNum,
						String directions,
						int numHoles,
						int totalYards,
						int totalPar) {
		courseName = name;
		courseAddress = address;
		coursePhoneNum = phoneNum;
		courseDirections = directions;
		courseNumHoles = numHoles;
		courseTotalYards = totalYards;
		courseTotalPar = totalPar;
	}
	
	/**********************************************/
	// gets
	public String getName() {
		return courseName;
	}
	
	public String getAddress() {
		return courseAddress;
	}
	
	public String getPhoneNum() {
		return coursePhoneNum;
	}
	
	public String getDirections() {
		return courseDirections;
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
	
	public void setDirections(String directions) {
		courseDirections = directions;
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
