import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class creditsScene extends JFrame{
	public static void main(String[] args){	
	    mainMenuScene frame = new mainMenuScene();
	    
	    frame.setTitle("Credits Scene");
	    frame.setSize(1300,850);
	    frame.setLocationRelativeTo(null);
	    frame.getContentPane().setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    frame.setContentPane(new JLabel(new ImageIcon("resources/credits.jpg")));
	    
	    
	    JButton playButton = new JButton();
	    playButton.setSize(200,50);
	    playButton.setLocation(560, 580);
	    playButton.setText("Main Menu");
	    frame.add(playButton);
	    
	    playButton.addMouseListener(new MouseListener(){
	    	@Override
		    public void mouseClicked(MouseEvent e)
		    {
		    	// TODO Auto-generated method stub 
		    }

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				System.out.print("this should take you to the main menu");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    });
	    
	    frame.setVisible(true);
   }
}
