import java.awt.Color;
import java.awt.Graphics;


public class Oval extends Body{

	/**
	 * Konstruktor koji prima sve parametre
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 * @param speedX
	 * @param speedY
	 * @param maxX
	 * @param maxY
	 * @param minX
	 * @param minY
	 */
	
	public Oval(int x, int y, int width, int height, Color color, int speedX, int speedY, int maxX, int maxY, int minX, int minY) {
		super(x, y, width, height, color, speedX, speedY, maxX,  maxY, minX, minY);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Override metode draw. Kako je u ovoj klasi jasno koju figuru trebamo crtati, pozivamo fillOval
	 *  i šaljemo odgovarajuće parametre
	 */
	
	@Override
	public void draw(Graphics g)
	{
		super.draw(g);
		g.fillOval(super.getStart().getX(), super.getStart().getY(), super.getWidth(), super.getHeight());
	}

}
