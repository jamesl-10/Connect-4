/****************************************************************************
 *
 * Created by: James Lee
 * Created on: June 2019
 * Created for: ICS4U
 * Connect 4 code, main game
 * 
 * Plays connect 4 with another player locally
 * 
 ****************************************************************************/

import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*; 

// Game Scene
public class gameScene extends JPanel
{
	// Variables
	// Declared here in order to be usable in mouse events
	private static int turnNumber = 0;
    private static boolean gameOver = false;

    // Constructor
	public gameScene(ActionListener backToMain)
	{		
		// Sets layout to null
		this.setLayout(null);
		
		// Sets variables to default
		turnNumber = 0;
		gameOver = false;
		
		// Makes game panel
		JPanel board = new JPanel();  
		
		// Makes an 6 x 8 grid for game panel
	    board.setLayout(new GridLayout(6, 8));
	    board.setBounds(200, 75, 600, 450);
	    
	    // Makes button that returns user to main menu
		JButton backButton = new JButton();
		backButton.addActionListener(backToMain);
		backButton.setBounds(300, 550, 100, 50);
		backButton.setText("Back");
	    
		// Label that shows winner
		JLabel winnerLabel = new JLabel();
		winnerLabel.setBounds(500, 550, 250, 50);
		winnerLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		
		// Label that shows which player's turn it is
		JLabel turnLabel = new JLabel();
		turnLabel.setBounds(500, 550, 250, 50);
		turnLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		
		// Background
		JLabel picLabel = new JLabel();
		picLabel.setIcon(new ImageIcon(this.getClass().getResource("resources/mainMenu.jpg")));
		picLabel.setBounds(0, 0, 1000, 900);
		
		// Creates players
	    Player p1 = new Player("Player 1", COLORS.BLUE);
	    Player p2 = new Player("Player 2", COLORS.WHITE);
	
	    // Initially player 1's turn
	    turnLabel.setText(p1.getName() + "'s turn");
	    
	    // Array for spots
	    // Game board (empty)
	    Spot spots[][] = new Spot[8][6];
	    
	    // Creates game board
	    for (int i = 0; i < 6; i++)
	    {
	    	for (int j = 0; j < 8; j++)
	    	{
	    		// Creates new spot
	    		Spot spot = new Spot(j,i);
	    		spot.setSize(75,75);
	    		spots[j][i] = spot;
	    		board.add(spot);
	    		
	    		try
	    		{
	    			// sets image
	    		    Image img = ImageIO.read(getClass().getResource("resources/emptySpot.jpg"));
	    		    spot.setIcon(new ImageIcon(img));
	    		     
	    		    // When spot is clicked
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
									COLORS coinColor = null;
									Image img = null;
									
									// Decides which player's coin to add
									
									// Player 1
									if (turnNumber%2 == 0)
									{
										coinColor = p1.getColor();
										turnLabel.setText(p2.getName() + "'s turn");
										
										try
										{
											img = ImageIO.read(getClass().getResource("resources/blueSpot.jpg"));
										}
										catch (IOException e1)
										{
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
									
									// Player 2
									else
									{
										coinColor = p2.getColor();
										turnLabel.setText(p1.getName() + "'s turn");
										
										try
										{
											img = ImageIO.read(getClass().getResource("resources/whiteSpot.jpg"));
										}
										catch (IOException e1)
										{
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
									
									// Puts coin on bottom-most row, just like real connect 4!
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
									
									// Verifies if there is a winner
									// Checks each spot, and if there are 4 spots filled with the same color coin
									// vertically, horizontally, diagonally left or right from the spot
									for(int i = 0; i < spots[0].length; i++)
									{
										for (int j = 0;  j < spots.length; j++)
										{
											// If there is a winner
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
												
												// Shows winner
												turnLabel.setText("");
												winnerLabel.setText("The winner is " + winner + "!");
												gameOver = true;
											}
										}
									}
									
									// Next turn
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
		    }
	    }
	    
	    // Adds components to panel
	    this.add(board);
	    this.add(backButton);
	    this.add(winnerLabel);
	    this.add(turnLabel);
		this.add(picLabel);
	} 
	
	// Checks if there is a winner or not
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
