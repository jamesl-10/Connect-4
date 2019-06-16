import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class SplashScreen {

  public static void main(String[] args) {
	  JWindow window = new JWindow();
	  window.getContentPane().add(
	      new JLabel("", new ImageIcon(("resources/MT_Game_Studio.png")), SwingConstants.CENTER));
	  window.setBounds(65, 10, 1300, 1000);
	  window.setVisible(true);
	  try {
	      Thread.sleep(4000);
	  } catch (InterruptedException e) {
	      e.printStackTrace();
	  }
	  window.setVisible(false);
	  JFrame frame = new JFrame();
	  frame.add(new JLabel("Main Menu"));
	  frame.setVisible(true);
	  frame.setSize(900,900);
	  window.dispose();
  }
}
