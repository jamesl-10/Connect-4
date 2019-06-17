/****************************************************************************
 * Created by: Shuvaethy Neill
 * Created on: June 2019
 * Created for: ICS4U
 * This program is the main menu scene
 ****************************************************************************/

import java.awt.event.*;
import javax.swing.*;

public class mainMenuScene extends JPanel
{
	// Constructor
	// Actions go to credits scene and game scene
	public mainMenuScene(ActionListener credits, ActionListener game)
	{    
		this.setLayout(null);
	    
		// Adds new play button that goes to game scene
	    JButton playButton = new JButton();
	    playButton.setBounds(900, 700, 200, 50);
	    playButton.setText("Play");
	    this.add(playButton);
	    playButton.addActionListener(game);
	    
	    // Adds new credits button that goes to credits scene
	    JButton creditsButton = new JButton();
	    creditsButton.setBounds(925, 800, 150, 50);
	    creditsButton.setText("Credits");
	    this.add(creditsButton);
	    creditsButton.addActionListener(credits);
	    
	    // Background image
		JLabel picLabel = new JLabel();
		picLabel.setIcon(new ImageIcon(this.getClass().getResource("resources/goodMainMenu.jpg")));
		picLabel.setBounds(0, 0, 1900, 1000);
		this.add(picLabel);
		
	    this.setVisible(true);
   }
}
