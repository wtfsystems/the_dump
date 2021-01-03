/*
  IST 311 Final Project
 
  SignatureHole.java
  
  Class containing signature hole information
  The CourseObject class extends off of this
*/

import java.awt.Image;

public class SignatureHole {
	public String courseImage;
	
	public String signatureHoleNum;
	public String yardLength;
	public String holePar;
	
	public int teePosX;
	public int teePosY;
	
	public int holePosX;
	public int holePosY;
	
	public SignatureHole() {
		//
	}
	
	/***********************************************/
	// gets
	public String getImage() {
		return courseImage;
	}
	
	public String getHolePar() {
		return holePar;
	}
	
	public String getSignatureHoleNum() {
		return signatureHoleNum;
	}
	
	public int getHolePosX() {
		return holePosX;
	}
	
	public int getHolePosY() {
		return holePosY;
	}
	
	public int getTeePosX() {
		return teePosX;
	}
	
	public int getTeePosY() {
		return teePosY;
	}
	
	public String getYardLength() {
		return yardLength;
	}
	/***********************************************/
	
	/***********************************************/
	// sets
	public void setImage(String image) {
		courseImage = image;
	}
	
	public void setHolePar(String par) {
		holePar = par;
	}
	
	public void setSignatureHoleNum(String holeNum) {
		signatureHoleNum = holeNum;
	}
	
	public void setHolePosX(int x) {
		holePosX = x;
	}
	
	public void setHolePosY(int y) {
		holePosY = y;
	}
	
	public void setTeePosX(int x) {
		teePosX = x;
	}
	
	public void setTeePosY(int y) {
		teePosY = y;
	}
	
	public void setYardLength(String yard) {
		yardLength = yard;
	}
	/***********************************************/
}
