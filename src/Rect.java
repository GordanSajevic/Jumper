import java.awt.Color;
import java.awt.Graphics;


public class Rect extends Body{

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
	
	public Rect(int x, int y, int width, int height, Color color, int speedX, int speedY, int maxX, int maxY, int minX, int minY) {
		super(x, y, width, height, color, speedX, speedY, maxX,  maxY, minX, minY);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Override metode draw. U ovoj klasi je jasno koju figuru trebamo crtati, pa pozivamo 
	 * fillRect i šaljem odgovarajučće parametre
	 */
	
	@Override
	public void draw(Graphics g)
	{
		super.draw(g);
		g.fillRect(super.getStart().getX(), super.getStart().getY(), super.getWidth(), super.getHeight());
	}

}
