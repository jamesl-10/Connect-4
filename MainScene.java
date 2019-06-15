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

import javax.imageio.ImageIO;
import javax.swing.*; 

//class extends JFrame and implements actionlistener 
public class MainScene extends JFrame implements ActionListener
{ 
	 // Main Method 
	 public static void main(String[] args) 
	 { 
	     // Creating Object of CardLayout class. 
	     MainScene cl = new MainScene(); 
	
	     cl.setTitle("Connect 4");
	     cl.setSize(1000,1000);
		 cl.setLocationRelativeTo(null);
		 cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 cl.setVisible(true);
		 cl.setResizable(false);

	}
			
	// Declaration of objects of CardLayout class. 
	CardLayout card; 

	// Declaration of objects of JButton class. 
	JButton b1, b2, b3;

	// Declaration of objects 
	// of Container class. 
	Container c; 

 public MainScene() 
 { 
	 // to get the content 
     c = getContentPane(); 

     // Initialization of object "card" 
     // of CardLayout class with 40  
     // horizontal space and 30 vertical space . 
     card = new CardLayout(40, 30); 

     // set the layout 
     c.setLayout(card); 

     // Initialization of object "b1" of JButton class. 
     b1 = new JButton("Page 1"); 

     // Initialization of object "b2" of JButton class. 
     b2 = new JButton("Page 2"); 

     // Initialization of object "b3" of JButton class. 
     b3 = new JButton("Page 3"); 
     
     gameScene game = new gameScene(this);
     
     // this Keyword refers to current object. 
     // Adding Jbutton "b1" on JFrame using ActionListener. 
     b1.addActionListener(this); 

     // Adding Jbutton "b2" on JFrame using ActionListener. 
     b2.addActionListener(this); 

     // Adding Jbutton "b3" on JFrame using ActionListener. 
     b3.addActionListener(this); 
     
     // Adding the JButton "b1" 
     c.add("a", b1); 

     // Adding the JButton "b2" 
     c.add("b", b2); 

     // Adding the JButton "b1" 
     c.add("c", b3);
     
     c.add("d", game);
 } 
 
	 public void actionPerformed(ActionEvent e) 
	 { 	       
	     // call the next card 
	     card.next(c); 
	 } 
}
