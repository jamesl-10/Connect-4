import javax.swing.JButton;

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
