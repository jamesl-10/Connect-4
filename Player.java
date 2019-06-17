/****************************************************************************
 *
 * Created by: James Lee
 * Created on: June 2019
 * Created for: ICS4U
 * Connect 4 code, player class
 * 
 * Player class for main game
 * 
 ****************************************************************************/

class Player
{
	// Properties
	private String name;
	private COLORS color;
	
	// Constructor
	public Player(String name, COLORS color)
	{
		this.name = name;
		this.color = color;
	}
	
	// Return name
	public String getName()
	{
		return name;
	}
	
	// Return color
	public COLORS getColor()
	{
		return color;
	}
}
