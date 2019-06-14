/****************************************************************************
 *
 * Created by: James Lee
 * Created on: June 2019
 * Created for: ICS4U
 * Connect 4 code, main game
 *
 *
 * Still needs : 
 * 
 * - Literally everything
 * 
 ****************************************************************************/

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class gameScene extends JFrame
{	
	private static int turnNumber = 0;
	
	public static void main(String[] args) 
	{	
	    gameScene frame = new gameScene();
	    
	    frame.setTitle("Connect 4");
	    frame.setSize(900,900);
	    frame.setLocationRelativeTo(null);
	    frame.getContentPane().setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    
	    JButton backButton = new JButton();
	    backButton.setSize(120,100);
	    backButton.setLocation(80, 700);
	    backButton.setText("Back");
	    frame.add(backButton);
	    
	    backButton.addMouseListener(new MouseListener()
	    {
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
				System.out.print("Hello, World!");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    });
	}
	
	public gameScene()
	{
		// Creates a panel for the board
	    JPanel board = new JPanel();
	    
	    // Makes an 8 x 8 grid
	    board.setLayout(new GridLayout(6, 8));
	    board.setSize(720,540);
	    board.setLocation(80,50);
	    
	    Spot spots[][] = new Spot[6][8];
	    
	    for (int i = 0; i < 6; i++)
	    {
	    	for (int j = 0; j < 8; j++)
	    	{
	    		Spot spot = new Spot();
	    		spot.setSize(90,90);
	    		spots[i][j] = spot;
	    		board.add(spot);
	    		
	    		try
	    		{
	    		    Image img = ImageIO.read(getClass().getResource("resources/spot.jpg"));
	    		    spot.setIcon(new ImageIcon(img));
	    		    
	    		    spot.addMouseListener(new MouseListener()
	    		    {
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
							System.out.print("Hello, World!");
						}

						@Override
						public void mouseReleased(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
	    		    });
	    		}
	    		
	    		catch (Exception e) {}
	    		
	    		spots[i][j] = spot;
	    	}
	    }
	    
	    add(board);
	}
}

class Spot extends JButton
{
	
	
	// Constructor
	public Spot()
	{
		
	}
	
	public void addCoin(int x)
	{
		
	}
}

class Board extends JPanel
{
	
}
