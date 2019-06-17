/****************************************************************************
 *
 * Created by: James Lee
 * Created on: June 2019
 * Created for: ICS4U
 * Connect 4 code, coin class
 * 
 * Coins used in the game
 * 
 ****************************************************************************/

class Coin
{
	// Properties
	private COLORS color;
	
	// Constructor
	public Coin(COLORS color)
	{
		this.color = color;
	}
	
	// Returns color
	public COLORS getColor()
	{
		return color;
	}
}
