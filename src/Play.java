import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Play extends JPanel{

	/**
	 * U main funkciji kreiramo prozor, a zatim na prozor lijepimo panel tipa GameGraphics.
	 * Neophodno je i postaviti fokus na panel
	 * @param args
	 */
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		GameGraphics panel = new GameGraphics();
		window.setContentPane(panel);
		window.setVisible(true);
		window.setSize(1000, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.requestFocus(false);

	}

}
