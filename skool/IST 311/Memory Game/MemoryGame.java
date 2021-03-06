/*
 *  File: MemoryGame.java
 *  Author: Java, Java, Java
 *  Description: This class creates a user interface for a memory game.
 *  It displays an NCELLS x NCELLS grid of buttons, each labeled 
 *  initially by "?". Under the buttons are pairs of letters 'A',
 *  'B', and so on. The object of the game is to find all the pairs
 *  in the fewest guesses. The user clicks on one button and then 
 *  another to show their hidden letters. If they match, the letters
 *  remain showing, otherwise, they are covered up again when the user
 *  clicks on another button.
 */

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.applet.Applet;

public class MemoryGame extends JApplet implements ActionListener{
    
    private final static int NCELLS = 16;   // Number of hidden letters
    private final static int NROWS= 4;      // Should be sqrt of cells

    private JPanel gamePanel = new JPanel();          // Panel to hold game board
    private JPanel controls = new JPanel();		  
    private JButton reset = new JButton("New Game");  // New game button	
	
    private JButton cells[];                          // Game memory cells				
   	private String alphabet = "1234567812345678"; 
	  
    private JButton firstGuess, secondGuess;    
    private String firstGuessName, secondGuessName;

    /**
     * MemoryGame() constructor sets up the user interface, which consists of
     *  two panels, a NROWS x NROWS grid of buttons, hiding the secret letters,
     *  and a control panel containing a reset button.
     */
    public void init() {
        
        
                                // Set up the keypad grid layout
        gamePanel.setLayout(new GridLayout (NROWS,NROWS,1,1));
        controls.add(reset);
        reset.addActionListener(this);
                                // Create an array of buttons																	
        cells = new JButton [NCELLS];             // Create the array of cells
        for (int k = 0; k < cells.length; k++) {  // For each array slot
            cells[k] = new JButton("?");          //  Create a button
            cells[k].setName(alphabet.substring(k,k+1));  //  Give the button a name
            cells[k].addActionListener(this);     //  And a listener for it
            gamePanel.add(cells[k]);              //  And add it to the panel
        } // for
                               // Add components to the frame
        getContentPane().setLayout (new BorderLayout(10, 10)); // Border layout
        getContentPane().add("North", controls);
        getContentPane().add("Center", gamePanel);
        initBoard();
    } // MemoryGame()
	
    /**
     * initBoard() is called each time the Reset button is pressed and at the
     *   beginning of the game. It scrambles the secret letters and hides them
     *   beneath the buttons. The secret string is constructed by
     *   concatenating a substring of the alphabet and then shuffling the letters.
     *   The secret string should consist of NCELLS/2 pairs of letters.
     */
    private void initBoard() {
        String secret = alphabet.substring(0, NCELLS/2) + alphabet.substring(0, NCELLS/2);
        secret = shuffle(secret);
        firstGuess = null;
        firstGuessName = "?";
        //firstGuess.setIcon(null);
        secondGuess = null;
        secondGuessName = "?";
        //secondGuess.setIcon(null);
        for (int k = 0; k < cells.length; k++) {   // For each array slot
            cells[k].setText("?");
            cells[k].setName(secret.substring(k,k+1));
            cells[k].setIcon(null);
        }
    } // initBoard()
	
    /**
     * shuffle() rearranges the letters in its parameter by randomly swapping
     *  10 pairs of letters.
     * @param s -- a String to be shuffled
     * @return the shuffled string 
     */
    private String shuffle(String s) {
        StringBuffer tempStr = new StringBuffer(s);
        for (int k = 0; k < 10; k++) {
            int m = (int) (Math.random() * NCELLS);
            int n = (int) (Math.random() * NCELLS);
            char ch = tempStr.charAt(m);            // Swap two random chars
            tempStr.setCharAt(m, tempStr.charAt(n)); 
            tempStr.setCharAt(n, ch);	        
        }
        return tempStr.toString();
    } // shuffle()
	
    /**
     * actionPerformed() handles all the game's action. Each time the user
     *  clicks on a button on the memory board, the button's secret letter
     *  is displayed. If two successive clicks turn over equal letters, they
     *  remain showing. Otherwise they are hidden again. 
     */
	public void actionPerformed (ActionEvent e) {
        JButton b = (JButton) e.getSource();    // Get the button that was clicked	
        if (b == reset) {
            initBoard();                            // Start a new game
            return;
        }
        if ( !b.getText().equals("?"))  
            return;                             // Ignore illegal moves

        b.setText(b.getName()); // Reveal the button's name    

        b.setIcon(new ImageIcon(b.getName()+".gif") );

        if (firstGuess == null) {               // If first guess, store it
            firstGuess = b;
            firstGuessName =  b.getName(); 
        } else if (secondGuess == null) {       // If second guess, store it
            secondGuess = b;
            secondGuessName =  b.getName(); 
        } else {                                // If third guess, restart
            if (!firstGuessName.equals(secondGuessName)) { // If guesses wrong
                firstGuess.setText("?");                   // Cover up the names
                firstGuess.setIcon(null);
                secondGuess.setText("?");
                secondGuess.setIcon(null);
            }
            firstGuess = b;                     // Reset the guesses
            firstGuessName = b.getName();
            secondGuess = null;       
            secondGuessName = "?";
        }
    } //  actionPerformed()
} // MemoryGame
