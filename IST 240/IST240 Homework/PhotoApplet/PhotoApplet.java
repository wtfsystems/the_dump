/*
  Filename:  PhotoApplet.java
  By:  Matthew Evans
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class PhotoApplet extends Applet implements ActionListener {
	private Button nextBtn, prevBtn;
	private Image[] ImageArray = new Image[5];
	private int currentImage;
	private AudioClip nextAudio;
	private AudioClip prevAudio;
	
	public void init() {
		setSize(700, 500);
		
		// Add the buttons
		nextBtn = new Button("Next");
		nextBtn.addActionListener(this);
		prevBtn = new Button("Previous");
		prevBtn.addActionListener(this);
		
		add(prevBtn);
		add(nextBtn);
		
		prevBtn.setEnabled(false);
		nextBtn.setEnabled(true);
		
		currentImage = 0;
		
		// Load the images
		String thisImage = "";
		for(int i = 0; i < 5; i++) {
			if(i == 0)
				thisImage = "one";
			if(i == 1)
				thisImage = "two";
			if(i == 2)
				thisImage = "three";
			if(i == 3)
				thisImage = "four";
			if(i == 4)
				thisImage = "five";
				
			Image newImage = getImage(getCodeBase(), thisImage + ".jpg");
			ImageArray[i] = newImage;
		}
		
		// Load the audio clip
		nextAudio = getAudioClip(getCodeBase(), "trash_sb.wav");
		prevAudio = getAudioClip(getCodeBase(), "error_hs.wav");
	}
	
	public void actionPerformed(ActionEvent e) {
		// Advance to the next image
		if(e.getSource() == nextBtn) {
			nextAudio.stop();
			nextAudio.play();
			++currentImage;
		}
		
		// Return to the previous image
		if(e.getSource() == prevBtn) {
			prevAudio.stop();
			prevAudio.play();
			--currentImage;
		}
		
		// If the first image is displayed, disable the back button
		if(currentImage == 0)
			prevBtn.setEnabled(false);
		else
			prevBtn.setEnabled(true);
		
		// If the last image is displayed, disable the next button
		if(currentImage == 4)
			nextBtn.setEnabled(false);
		else
			nextBtn.setEnabled(true);
			
		// Redraw the applet to update the image
		repaint();
	}

	public void paint(Graphics g) {
		g.drawImage(ImageArray[currentImage], 0, 0, this);
	}
}
