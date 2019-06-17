/****************************************************************************
 * Created by: Shuvaethy Neill
 * Created on: June 2019
 * Created for: ICS4U
 * This program is the credits scene
 ****************************************************************************/

import java.awt.event.*;
import javax.swing.*;

public class creditsScene extends JPanel
{
	// Constructor
	public creditsScene(ActionListener mainMenu)
	{	
		this.setLayout(null);
		
		// Creates a play button
	    JButton playButton = new JButton();
	    playButton.setBounds(900, 700, 200, 50);
	    playButton.setText("Main Menu");
	    this.add(playButton);
	    
	    // adds action to go back to main menu
	    playButton.addActionListener(mainMenu);
	    
	    // Background image
	    JLabel picLabel = new JLabel();
		picLabel.setIcon(new ImageIcon(this.getClass().getResource("resources/credits.jpg")));
		picLabel.setBounds(0, 0, 1900, 1000);
		this.add(picLabel);
	    
	    this.setVisible(true);
	}
}
