import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class mainMenuScene extends JFrame{
	public static void main(String[] args){	
	    mainMenuScene frame = new mainMenuScene();
	    
	    frame.setTitle("Connect 4");
	    frame.setSize(1300,850);
	    frame.setLocationRelativeTo(null);
	    frame.getContentPane().setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    frame.setContentPane(new JLabel(new ImageIcon("resources/goodMainMenu.jpg")));
	    
	    
	    JButton playButton = new JButton();
	    playButton.setSize(200,50);
	    playButton.setLocation(590, 580);
	    playButton.setText("Play");
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
				System.out.print("connect 4 yay");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    });
	    
	    JButton creditsButton = new JButton();
	    creditsButton.setSize(150,50);
	    creditsButton.setLocation(1100, 750);
	    creditsButton.setText("Credits");
	    frame.add(creditsButton);
	    
	    creditsButton.addMouseListener(new MouseListener(){
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
				System.out.print("credits yay");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    });
	    
	    frame.setVisible(true);
   }
}
