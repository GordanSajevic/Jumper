import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameGraphics extends JPanel implements ActionListener{

	private Timer animation;
	private Body[] elements;
	private int elementCounter;
	protected int width;
	protected int height;
	private Body player;
	private int bodovi=0;
	
	/**
	 * U konstruktoru kreiramo niz elements[] od 10 različitih figura, sa random brzinama
	 *  po x osi i random dimenzijama. Zatim kreiramo figuru za igrača (tipa Oval), i timer za animaciju
	 */
	
	public GameGraphics()
	{
		super();
		elements = new Body[10];
		width = 700;
		height = 700;
		elementCounter = 5;
		for (int i=0; i<10; i++)
		{
			elements[i] = new Rect(1000, 550, 20 + (int)(Math.random() * 50), 20 + (int)(Math.random() * 75), Color.BLUE,  -1 - (int)(Math.random() * 5), 0, 1000 + (int)(Math.random() * 5000), 600, -100,-100);
		}
		player = new Oval(300, 150, 50, 50, Color.RED, 0, 30, 800, 600, 0, 0);
	//	player = new DrawImage(300, 150, 50, 50, 0, 30, 800, 600, 0, 0, "/images/BUGS017.png");
		animation = new Timer(25, this);
		animation.start();
		addKeyListener(new KeyHandler());

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	
	/**
	 * U paintComponent crtamo sve figure iz niza elements, kao i figuru za igrača i zelenu podlogu
	 */
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(new Color(184, 242, 245));
		player.draw(g);
		boolean stop = false;
		for (int i=0; i<elements.length; i++)
		{
			elements[i].draw(g);
			elements[i].reset();
			if(stop == false)
			stop = player.chekcCollision(elements[i]);
			
		}
		g.setColor(Color.GREEN);
		g.fillRect(0, 600, width+1500, height);
		
		if(stop == true){
				animation.stop();
				JOptionPane.showMessageDialog(null, "Izgubio si. Bodovi: " + bodovi--, "Prozor",  JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Pozivamo metodu jump() za bilo koju tipku na tastaturi.
	 * @author Gordan
	 *
	 */
	
	private class KeyHandler extends KeyAdapter{
		
		public void keyTyped(KeyEvent k)
		{
			player.jump();
			bodovi++;
		}
		
		
	}

		

}
