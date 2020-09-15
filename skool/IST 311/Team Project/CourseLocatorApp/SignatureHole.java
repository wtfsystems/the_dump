/*
  SignatureHole.java
*/

import java.awt.Image;

public class SignatureHole {
	Image signatureHoleImage;
	
	int signatureHoleNum;
	
	int holePosX;
	int holePosY;
	
	int teePosX;
	int teePosY;
	
	int yardLength;
	
	int bunkerX[];
	int bunkerY[];
	
	public SignatureHole() {
		//
	}
	
	/***********************************************/
	// gets
	public Image getSignatureHoleImage() {
		return signatureHoleImage;
	}
	
	public int getSignatureHoleNum() {
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
	
	public int getYardLength() {
		return yardLength;
	}
	/***********************************************/
	
	/***********************************************/
	// sets
	public void setSignatureHoleImage(Image theImg) {
		signatureHoleImage = theImg;
	}
	
	public void setSignatureHoleNum(int holeNum) {
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
	
	public void setYardLength(int yard) {
		yardLength = yard;
	}
	/***********************************************/
}
