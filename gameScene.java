/****************************************************************************
 *
 * Created by: James Lee
 * Created on: June 2019
 * Created for: ICS4U
 * Connect 4 code, main game
 * 
 ****************************************************************************/

//Java program to illustrate the CardLayout Class 
import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*; 

//class extends JFrame and implements actionlistener 
public class gameScene extends JPanel
{
	private static int turnNumber = 0;
    private static boolean gameOver = false;

public gameScene(ActionListener action)
{		
	this.setLayout(null);
	JPanel board = new JPanel();  
	// Makes an 8 x 8 grid
    board.setLayout(new GridLayout(6, 8));
    board.setBounds(100, 100, 720, 540);
    
	JButton backButton = new JButton();
	backButton.addActionListener(action);
	backButton.setBounds(100, 700, 300, 100);
	backButton.setText("Back");
    
	JLabel winnerLabel = new JLabel();
	winnerLabel.setBounds(500,700,300,100);
	winnerLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 30));
	
    
    Player p1 = new Player("James", "Blue");
    Player p2 = new Player("Chloe", "White");

    Spot spots[][] = new Spot[8][6];
    
    for (int i = 0; i < 6; i++)
    {
    	for (int j = 0; j < 8; j++)
    	{
    		Spot spot = new Spot(j,i);
    		spot.setSize(90,90);
    		spots[j][i] = spot;
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
						if (!gameOver)
						{
							if (spot.getCoin() == null)
							{
								String coinColor = "";
								Image img = null;
								
								if (turnNumber%2 == 1)
								{
									coinColor = p1.getColor();
									try
									{
										img = ImageIO.read(getClass().getResource("resources/blue.jpg"));
									}
									catch (IOException e1)
									{
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								else
								{
									coinColor = p2.getColor();
									
									try
									{
										img = ImageIO.read(getClass().getResource("resources/red.jpg"));
									}
									catch (IOException e1)
									{
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								
								for (int i = 0; i < spots.length; i++)
								{
									if (spots[spot.getXPos()][5 - i].getCoin() == null)
									{
										Coin c = new Coin(coinColor);
										spots[spot.getXPos()][5 - i].addCoin(c);
										spots[spot.getXPos()][5 - i].setIcon(new ImageIcon(img));
										break;
									}
								}
								
								for(int i = 0; i < spots[0].length; i++)
								{
									for (int j = 0;  j < spots.length; j++)
									{
										if (hasWinner(spots,spots[j][i]) == true)
										{
											String winner =  "";
											
											if (turnNumber%2 == 0)
											{
												winner = p1.getName();
											}
											else
											{
												winner = p2.getName();
											}
											
											winnerLabel.setText("The winner is " + winner);
											gameOver = true;
										}
									}
								}
								
								turnNumber += 1;
							}
						}
					}

					@Override
					public void mouseReleased(MouseEvent arg0)
					{
						// TODO Auto-generated method stub
							
					}
				});
	    	}
	    		
	    	catch (Exception e) {}
	    		
	    	spots[j][i] = spot;
	    }
    }
    
    this.add(board);
    this.add(backButton);
    this.add(winnerLabel);
 } 
   
 public boolean hasWinner(Spot[][] spots, Spot s)
	{
		if (s.getCoin() != null)
		{
			// Horizontal check
			try
			{
				for (int i = 0; i < 4; i++)
				{
					if (spots[s.getXPos() - i][s.getYPos()].getCoin().getColor().equals(s.getCoin().getColor()))
					{
						if (i == 3)
						{
							return true;
						}
					}
					
					else
					{
						break;
					}
				}
			}
			catch (Exception e) {}
			
			// Vertical check
			try
			{
				for (int i = 0; i < 4; i++)
				{
					if (spots[s.getXPos()][s.getYPos() - i].getCoin().getColor().equals(s.getCoin().getColor()))
					{
						if (i == 3)
						{
							return true;
						}
					}
					
					else
					{
						break;
					}
				}
			}
			catch (Exception e) {}
			
			// Diagonal check right
			try
			{
				for (int i = 0; i < 4; i++)
				{
					if (spots[s.getXPos() - i][s.getYPos() + i].getCoin().getColor().equals(s.getCoin().getColor()))
					{
						if (i == 3)
						{
							return true;
						}
					}
					
					else
					{
						break;
					}
				}
			}
			catch (Exception e) {}
			
			// Diagonal check left
			try
			{
				for (int i = 0; i < 4; i++)
				{
					if (spots[s.getXPos() + i][s.getYPos() + i].getCoin().getColor().equals(s.getCoin().getColor()))
					{
						if (i == 3)
						{
							return true;
						}
					}
					
					else
					{
						break;
					}
				}
			}
			catch (Exception e) {}
		}
		
		return false;
	} 
}
