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
import java.io.IOException;

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
	    
	    Player p1 = new Player("James", "Blue");
	    Player p2 = new Player("Shu", "White");
	    
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
											
											System.out.print("The winner is " + winner);
										}
									}
								}
								
								turnNumber += 1;
							}
						}

						@Override
						public void mouseReleased(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
	    		    });
	    		}
	    		
	    		catch (Exception e) {}
	    		
	    		spots[j][i] = spot;
	    	}
	    }
	    
	    add(board);
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

class Spot extends JButton
{
	private Coin coin;
	private int xPos;
	private int yPos;
	
	// Constructor
	public Spot(int xPos, int yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void addCoin(Coin c)
	{
		this.coin = c;
	}
	
	public Coin getCoin()
	{
		return this.coin;
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
}

class Coin
{
	private String color;
	
	public Coin(String color)
	{
		this.color = color;
	}
	
	public String getColor()
	{
		return color;
	}
}

class Board extends JPanel
{
	
}

class Player
{
	private String name;
	private String color;
	
	public Player(String name, String color)
	{
		this.name = name;
		this.color = color;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getColor()
	{
		return color;
	}
}
