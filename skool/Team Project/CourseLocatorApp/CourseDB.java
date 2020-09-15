/*
  IST 311 Final Project
 
  CourseDB.java
  
  Contains the linked list and performs database operations
*/

import java.util.*;
import java.io.*;
import java.lang.Integer;
import java.io.FilePermission;

public class CourseDB {
	// Linked list for storing the course objects
	private static LinkedList CourseDBList;
	
	private int listSize;
	private int listLoc;
	
	/*
	  CourseDB constructor
	  creates the new linked list and adds data from a file
	*/
	public CourseDB() {
		FilePermission perm = new FilePermission("/data/course.txt", "read,write");
		
		CourseDBList = new LinkedList();
		
		try {
			BufferedReader inStream = new BufferedReader (new FileReader("data/course.txt"));
		
			// read in the data
			while(inStream.readLine() != null) {
				addCourse(inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  Integer.parseInt(inStream.readLine()),
						  Integer.parseInt(inStream.readLine()),
						  Integer.parseInt(inStream.readLine()),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  inStream.readLine(),
						  Integer.parseInt(inStream.readLine()),
						  Integer.parseInt(inStream.readLine()),
						  Integer.parseInt(inStream.readLine()),
						  Integer.parseInt(inStream.readLine()));
			}
			inStream.close();
		} catch (FileNotFoundException e) {
            listSize = 0;
            listLoc = 0;
            return;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
		
		//Collections.sort(CourseDBList);
		listSize = CourseDBList.size();
		listLoc = CourseDBList.indexOf(CourseDBList.getFirst());
	}
	
	/*
	  File IO Methods
	  note:  loading is handeled in the constructor
	
	  Save the data from the linked list to a file
	*/
	public void saveCourseDB() {
		int i, c;
		FilePermission perm = new FilePermission("/data/course.txt", "read,write");
		
		if(listSize == 0)
			return;

        try {
            BufferedWriter outStream = new BufferedWriter (new FileWriter("data/course.txt"));
            
            for(i = 0; i < listSize; i++) {
            	CourseObject getThis = (CourseObject) CourseDBList.get(i);
            	outStream.write(String.valueOf(i));
            	outStream.newLine();
            	outStream.write(getThis.getName());
            	outStream.newLine();
            	outStream.write(getThis.getAddress());
            	outStream.newLine();
            	outStream.write(getThis.getCity());
            	outStream.newLine();
            	outStream.write(getThis.getState());
            	outStream.newLine();
            	outStream.write(getThis.getZipCode());
            	outStream.newLine();
            	outStream.write(getThis.getPhoneNum());
            	outStream.newLine();
            	for(c = 0; c < 5; c++) {
	            	outStream.write(getThis.getDirections(c));
	            	outStream.newLine();
	            }
            	outStream.write(String.valueOf(getThis.getNumHoles()));
            	outStream.newLine();
            	outStream.write(String.valueOf(getThis.getTotalYards()));
            	outStream.newLine();
            	outStream.write(String.valueOf(getThis.getTotalPar()));
            	outStream.newLine();
            	outStream.write(getThis.getImage());
            	outStream.newLine();
            	outStream.write(getThis.getSignatureHoleNum());
            	outStream.newLine();
            	outStream.write(getThis.getYardLength());
            	outStream.newLine();
            	outStream.write(getThis.getHolePar());
            	outStream.newLine();
            	outStream.write(String.valueOf(getThis.getTeeX()));
            	outStream.newLine();
            	outStream.write(String.valueOf(getThis.getTeeY()));
            	outStream.newLine();
            	outStream.write(String.valueOf(getThis.getHoleX()));
            	outStream.newLine();
            	outStream.write(String.valueOf(getThis.getHoleY()));
            	outStream.newLine();
            }
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
	
	/*
	  This method will add an entire new course to the linked list
	  Call this method once instead of using all the set methods
	*/
	public void addCourse(String name, String address, String city,
						  String state, String zip, String phoneNum,
						  String directions1, String directions2,
						  String directions3, String directions4,
						  String directions5,
						  int numHoles, int totalYards, int totalPar,
						  String num, String image, String yardage,
						  String par, int teeX, int teeY, int holeX, int holeY) {
		CourseObject addThis = new CourseObject(name, address, city,
												state, zip, phoneNum,
						  						directions1, directions2,
						  						directions3, directions4,
						  						directions5,
						  						numHoles, totalYards,
						 						totalPar, num, image,
						 						yardage, par, teeX, teeY, holeX, holeY);
		CourseDBList.add(addThis);
		listSize = CourseDBList.size();
		sortABC();
	}
	
	public void removeCourse() {
		CourseDBList.remove(listLoc);
		listSize = CourseDBList.size();
		if(listLoc > listSize) listLoc = listSize;
		sortABC();
	}
	
	/*
	  Search by name method
	*/
	public boolean searchByName(String name) {
		CourseObject getThis;
		for(int i = 0; i < listSize; i++) {
			getThis = (CourseObject) CourseDBList.get(i);
			if(name.toUpperCase().compareTo(getThis.getName().toUpperCase()) == 0) {
				// course found, set listLoc to i and return success
				listLoc = i;
				return true;
			}
		}
		// course not found, return error
		return false;
	}

	/**********************************************/
	/*
	  Sort Methods
	  These methods will restructure the linked list
	*/
	public void sortABC() {
		int i, c;
		CourseObject temp;
		CourseObject temp2;
		
		for(i = 0; i < listSize; i++) {
			for(c = 0; c < i; c++) {
				temp = (CourseObject) CourseDBList.get(c);
				temp2 = (CourseObject) CourseDBList.get(c+1);
				
				if(temp.getName().toUpperCase().compareTo(temp2.getName().toUpperCase()) > 0) {
					CourseDBList.set(c+1, CourseDBList.get(c));
					CourseDBList.set(c, temp2);
				}
			}
		}
		listLoc = 0;
	}	
	
	public void sortYard() {
		int i, c;
		CourseObject temp;
		CourseObject temp2;
		
		for(i = 0; i < listSize; i++) {
			for(c = 0; c < i; c++) {
				temp = (CourseObject) CourseDBList.get(c);
				temp2 = (CourseObject) CourseDBList.get(c+1);
				
				if(temp.getTotalYards() > temp2.getTotalYards()) {
					CourseDBList.set(c+1, CourseDBList.get(c));
					CourseDBList.set(c, temp2);
				}
			}
		}
		listLoc = 0;
	}
	/**********************************************/
	
	// next and previous
	public void nextCourse() {
		if(listLoc < listSize-1) ++listLoc;
	}
	
	public void previousCourse() {
		if(listLoc != CourseDBList.indexOf(CourseDBList.getFirst())) --listLoc;
	}

	// returns the current object
	public CourseObject getObject() {
		return (CourseObject)CourseDBList.get(listLoc);
	}
}
