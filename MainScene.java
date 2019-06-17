/****************************************************************************
 *
 * Created by: James Lee
 * Created on: June 2019
 * Created for: ICS4U
 * The main scene, where all the other scenes are handled
 * 
 * Scenes : 
 * 
 * Splash Scene
 * MainMenuScene
 * GameScene
 * CreditsScene
 * 
 ****************************************************************************/
 
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 

// Class extends JFrame and implements actionlistener 
public class MainScene extends JFrame implements ActionListener
{ 
	 // Main 
	public static void main(String[] args) 
	{ 
		// Creating Object of CardLayout class. 
		MainScene cl = new MainScene(); 
		
		cl.setTitle("Connect 4");
		cl.setSize(1900,1000);
		cl.setLocationRelativeTo(null);
		cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cl.setVisible(true);
		cl.setResizable(false);
	}

	CardLayout card;
	Container c;
	
	public MainScene() 
	{ 
		// To get the content 
		c = getContentPane(); 
	    
	    // Make new card layout
	    card = new CardLayout(); 
	
	    // Set the layout 
	    c.setLayout(card); 
	    
	    // Create scenes
	    
	    // Splash scene
	    SplashScreen splashScreen = new SplashScreen(this);
		
	    // Main Menu
	    mainMenuScene mainMenu = new mainMenuScene(this, new AbstractAction("Game")
	    {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				// Creates new game everytime play button is clicked
				gameScene game = new gameScene(new AbstractAction("Main Menu")
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						// TODO Auto-generated method stub
						card.show(c, "mainMenuScene");
					}
					
				});
				
			    c.add("gameScene", game);
				card.show(c, "gameScene");
			}   	
	    });
	    
	    // Credits scene
		creditsScene credits = new creditsScene(new AbstractAction("Back")
	    {
	
	    	@Override
			public void actionPerformed(ActionEvent arg0)
	    	{
	    		// TODO Auto-generated method stub
	    		card.previous(c);
						
			}  	 
	    });
		
		// Adds scenes to container
	    c.add("SplashScreen", splashScreen); 
	    c.add("mainMenuScene", mainMenu); 
	    c.add("creditsScene", credits);     
	} 

	// Default action
 	public void actionPerformed(ActionEvent e) 
	{ 	       
	    // call the next card 
	    card.next(c); 
	}
}

// Enum for colors in game scene
// Chip colors
enum COLORS
{
	BLUE("Blue"),
	WHITE("White");
	
	private final String color;
	
	// Constructor
	private COLORS(String color)
	{
		this.color = color;
	}
	
	// Returns color
	public String getColor()
	{
		return color;
	}
}
