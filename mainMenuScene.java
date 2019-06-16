import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class mainMenuScene extends JPanel
{
	public mainMenuScene(ActionListener credits, ActionListener game)
	{    
		this.setLayout(null);
	    
	    JButton playButton = new JButton();
	    playButton.setBounds(900, 600, 200, 50);
	    playButton.setText("Play");
	    this.add(playButton);
	    
	    playButton.addActionListener(game);
	    
	    JButton creditsButton = new JButton();
	    creditsButton.setBounds(1500, 750, 150, 50);
	    creditsButton.setText("Credits");
	    this.add(creditsButton);
	    
	    creditsButton.addActionListener(credits);
	    
		JLabel picLabel = new JLabel();
		picLabel.setIcon(new ImageIcon(this.getClass().getResource("resources/goodMainMenu.jpg")));
		picLabel.setBounds(0, 0, 2000, 1000);
		this.add(picLabel);
		
	    this.setVisible(true);
   }
}
