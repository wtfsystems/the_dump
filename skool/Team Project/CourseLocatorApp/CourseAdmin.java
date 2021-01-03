/*
  IST 311 Final Project
 
  CourseAdmin.java
*/

import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class CourseAdmin
extends JPanel {
	
	private static CourseDB courseList;
		
	private Image courseImage;
	
	// variables to store data
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
	private int teeX;
	private int teeY;
	private int holeX;
	private int holeY;
	
	// labels
	private Label searchLabel;
	private Label blankLabel;
	private Label nameLabel;
	private Label addressLabel;
	private Label cityLabel;
	private Label stateLabel;
	private Label zipcodeLabel;
	private Label phoneLabel;
	private Label directionsLabel;
	private Label numOfHolesLabel;
	private Label totalYardageLabel;
	private Label totalParLabel;
	private Label parLabel;
	private Label holeNumLabel;
	private Label signatureHoleLabel;
	private Label imageLabel;
	private Label yardageLabel;
	private Label gameDataLabel;
	private Label teeXLabel;
	private Label teeYLabel;
	private Label holeXLabel;
	private Label holeYLabel;
	
	// text fields to enter data
	private TextField nameTxt;
	private TextField addressTxt;
	private TextField cityTxt;
	private TextField stateTxt;
	private TextField zipcodeTxt;
	private TextField phoneTxt;
	private TextField directionsTxt[] = new TextField[5];
	private TextField numOfHolesTxt;
	private TextField totalYardageTxt;
	private TextField totalParTxt;
	private TextField parTxt;
	private TextField holeNumTxt;
	private TextField imageTxt;
	private TextField yardageTxt;
	private TextField teeXTxt;
	private TextField teeYTxt;
	private TextField holeXTxt;
	private TextField holeYTxt;
	
	private String holeNum;
	private String yardage;
	private String par;
	private String imageFile;
	
	// panels for layout control
	private static JPanel adminControls = new JPanel();
	private static JPanel info = new JPanel();
	private static JPanel infoSH = new JPanel();
	
	/*
	  CourseAdmin constructor
	  gets passed an object from the DB that will be displayed
	  and can be edited
	*/
	public CourseAdmin(CourseObject displayThis) {
		setLayout(new BorderLayout());
		adminControls.setLayout(new BorderLayout());
		
		nameLabel = new Label("Name");
		nameTxt = new TextField(courseName,20);
		addressLabel = new Label("Address");
		addressTxt = new TextField(courseAddy,30);
		phoneLabel = new Label("                          Phone");
		phoneTxt = new TextField(coursePhoneNum,20);
		totalYardageLabel = new Label("       Total Yardage");
		totalYardageTxt = new TextField(String.valueOf(courseTotalYards),5);
		totalParLabel = new Label("     Total Par");
		totalParTxt = new TextField(String.valueOf(courseTotalPar),5);
		numOfHolesLabel = new Label("     Number of Holes");
		numOfHolesTxt = new TextField(String.valueOf(courseNumHoles),5);
		blankLabel = new Label("                                                                            ");
				
		directionsLabel = new Label("Directions:                                                                                                                                                      ");
		for (int i=0;i<5;i++){
		directionsTxt[i] = new TextField(courseDirections[i],60);
		}
		cityLabel = new Label("        City");
		cityTxt = new TextField(20);
		stateLabel = new Label("           State");
		stateTxt = new TextField(2);
		zipcodeLabel = new Label("            Zipcode");
		zipcodeTxt = new TextField(9);
		holeNumLabel = new Label("           Hole #");
		holeNumTxt = new TextField(String.valueOf(holeNum),4);
		parLabel = new Label("                    Par");
		parTxt = new TextField(String.valueOf(par),5);
		yardageLabel = new Label("                    Yardage");
		yardageTxt = new TextField(String.valueOf(yardage),5);
		imageLabel = new Label("        Image");
		imageTxt = new TextField(String.valueOf(imageFile),20);
		signatureHoleLabel = new Label("Signature Hole Information ________________________________________________________");
		gameDataLabel = new Label("Game Data ____________________________________________________________________");
		teeXLabel = new Label("TeeX");
		teeXTxt = new TextField(3);
		teeYLabel = new Label("TeeY");
		teeYTxt = new TextField(3);
		holeXLabel = new Label("HoleX");
		holeXTxt = new TextField(3);
		holeYLabel = new Label("HoleY");
		holeYTxt = new TextField(3);
		
		// Course Information Panel
		info.setBorder(BorderFactory.createTitledBorder("Golf Course Information"));
		info.add(nameLabel);
		info.add(nameTxt);
		info.add(phoneLabel);
		info.add(phoneTxt);
		info.add(addressLabel);
		info.add(addressTxt);
		info.add(blankLabel);
		info.add(cityLabel);
		info.add(cityTxt);
		info.add(stateLabel);
		info.add(stateTxt);
		info.add(zipcodeLabel);
		info.add(zipcodeTxt);
		info.add(directionsLabel);
		for (int i=0;i<5;i++) {
			info.add(directionsTxt[i]);
		}
		info.add(totalYardageLabel);
		info.add(totalYardageTxt);
		info.add(totalParLabel);
		info.add(totalParTxt);
		info.add(numOfHolesLabel);
		info.add(numOfHolesTxt);
		
		// Signature Hole Information Panel
		info.add(signatureHoleLabel);
		info.add(holeNumLabel);
		info.add(holeNumTxt);
		info.add(parLabel);
		info.add(parTxt);
		info.add(yardageLabel);
		info.add(yardageTxt);
		info.add(imageLabel);
		info.add(imageTxt);
		
		// Game Data Information Panel
		info.add(gameDataLabel);
		info.add(teeXLabel);
		info.add(teeXTxt);
		info.add(teeYLabel);
		info.add(teeYTxt);
		info.add(holeXLabel);
		info.add(holeXTxt);
		info.add(holeYLabel);
		info.add(holeYTxt);

		adminControls.add(info,BorderLayout.CENTER);
		
		add(adminControls);
	
		setData(displayThis);
	}
	
	/*
	  Sets all the text fields on the display
	*/
	public void setData(CourseObject displayThis) {
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
		imageFile = displayThis.getImage();
		
		teeX = displayThis.getTeeX();
		teeY = displayThis.getTeeY();
		holeX = displayThis.getHoleX();
		holeY = displayThis.getHoleY();

		nameTxt.setText(courseName);
		addressTxt.setText(courseAddy);
		cityTxt.setText(courseCity);
		stateTxt.setText(courseState);
		zipcodeTxt.setText(courseZip);
		phoneTxt.setText(coursePhoneNum);
		totalParTxt.setText(String.valueOf(courseTotalPar));
		totalYardageTxt.setText(String.valueOf(courseTotalYards));
		numOfHolesTxt.setText(String.valueOf(courseNumHoles));
		holeNumTxt.setText(String.valueOf(holeNum));
		parTxt.setText(String.valueOf(par));
		yardageTxt.setText(String.valueOf(yardage));
		imageTxt.setText(imageFile);
		teeXTxt.setText(String.valueOf(teeX));
		teeYTxt.setText(String.valueOf(teeY));
		holeXTxt.setText(String.valueOf(holeX));
		holeYTxt.setText(String.valueOf(holeY));
		
		for (int i = 0; i < 5; i++){
		directionsTxt[i].setText(courseDirections[i]); }
	}
	
	// Gets
	public String getNameTxt() {
		return nameTxt.getText();
	}
	
	public String getAddressTxt() {
		return addressTxt.getText();
	}
	
	public String getCityTxt() {
		return cityTxt.getText();
	}
	
	public String getStateTxt() {
		return stateTxt.getText();
	}
	
	public String getZipCodeTxt() {
		return zipcodeTxt.getText();
	}
	
	public String getPhoneTxt() {
		return phoneTxt.getText();
	}
	
	public String getDirectionsTxt(int i) {
		return directionsTxt[i].getText();
	}
	
	public String getNumOfHolesTxt() {
		return numOfHolesTxt.getText();
	}
	
	public String getTotalYardageTxt() {
		return totalYardageTxt.getText();
	}
	
	public String getTotalParTxt() {
		return totalParTxt.getText();
	}
	
	public String getParTxt() {
		return parTxt.getText();
	}
	
	public String getHoleNumTxt() {
		return holeNumTxt.getText();
	}
	
	public String getImageTxt() {
		return imageTxt.getText();
	}
	
	public String getYardageTxt() {
		return yardageTxt.getText();
	}
	
	public String getTeeXTxt() {
		return teeXTxt.getText();
	}
	
	public String getTeeYTxt() {
		return teeXTxt.getText();
	}
	
	public String getHoleXTxt() {
		return holeXTxt.getText();
	}
	
	public String getHoleYTxt() {
		return holeYTxt.getText();
	}
	
	// Sets
	public void setNameTxt(String temp) {
		nameTxt.setText(temp);
	}
	
	public void setAddressTxt(String temp) {
		addressTxt.setText(temp);
	}
	
	public void setCityTxt(String temp) {
		cityTxt.setText(temp);
	}
	
	public void setStateTxt(String temp) {
		stateTxt.setText(temp);
	}
	
	public void setZipCodeTxt(String temp) {
		zipcodeTxt.setText(temp);
	}
	
	public void setPhoneTxt(String temp) {
		phoneTxt.setText(temp);
	}
	
	public void setDirectionsTxt(String temp, int i) {
		directionsTxt[i].setText(temp);
	}
	
	public void setNumOfHolesTxt(String temp) {
		numOfHolesTxt.setText(temp);
	}
	
	public void setTotalYardageTxt(String temp) {
		totalYardageTxt.setText(temp);
	}
	
	public void setTotalParTxt(String temp) {
		totalParTxt.setText(temp);
	}
	
	public void setParTxt(String temp) {
		parTxt.setText(temp);
	}
	
	public void setHoleNumTxt(String temp) {
		holeNumTxt.setText(temp);
	}
	
	public void setImageTxt(String temp) {
		imageTxt.setText(temp);
	}
	
	public void setYardageTxt(String temp) {
		yardageTxt.setText(temp);
	}
	
	public void setTeeXTxt(String temp) {
		teeXTxt.setText(temp);
	}
	
	public void setTeeYTxt(String temp) {
		teeXTxt.setText(temp);
	}
	
	public void setHoleXTxt(String temp) {
		holeXTxt.setText(temp);
	}
	
	public void setHoleYTxt(String temp) {
		holeYTxt.setText(temp);
	}
}
