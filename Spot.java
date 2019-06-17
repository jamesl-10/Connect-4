/****************************************************************************
 *
 * Created by: James Lee
 * Created on: June 2019
 * Created for: ICS4U
 * Connect 4 code, spot class
 * 
 * Every spot on the game board
 * 
 ****************************************************************************/

import javax.swing.JButton;

class Spot extends JButton
{
	// Properties
	private Coin coin;
	private int xPos;
	private int yPos;
	
	// Constructor
	public Spot(int xPos, int yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	// Adds coin
	public void addCoin(Coin c)
	{
		this.coin = c;
	}
	
	// Returns coin
	public Coin getCoin()
	{
		return this.coin;
	}
	
	// Returns x-position
	public int getXPos()
	{
		return xPos;
	}
	
	// Returns y-position
	public int getYPos()
	{
		return yPos;
	}
}
