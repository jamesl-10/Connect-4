/****************************************************************************
 * Created by: Shuvaethy Neill
 * Created on: June 2019
 * Created for: ICS4U
 * This program is the splash screen
 ****************************************************************************/

import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SplashScreen extends JPanel
{
	// Constructor
	public SplashScreen(ActionListener mainMenu)
	{
		// Creates timer
		Timer timer = new Timer();
		
		// Background
		JLabel picLabel = new JLabel();
		picLabel.setIcon(new ImageIcon(this.getClass().getResource("resources/MT_Game_Studio_Logo.JPG")));
		picLabel.setBounds(0, 0, 2000, 1000);
		this.add(picLabel);
		
		// Creates invisible button to trigger an action event
		JButton nextButton = new JButton();
		nextButton.setVisible(false);
		nextButton.addActionListener(mainMenu);
		
		// Runs event (next scene)
		timer.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				nextButton.doClick();
			}
			
		}, 3000);
	}
}
