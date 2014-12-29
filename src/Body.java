import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Body {

	/**
	 * Sve klasne varijable. Tačke start i center su objekti tipa Point
	 */
	
	private int width;
	private int height;
	private Color color;
	protected Point start;
	private Point center;
	private int speedX;
	private int speedY;
	private int maxX;
	private int maxY;
	private int minX;
	private int minY;
	
	
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
	
	public Body(int x, int y, int width, int height, Color color, int speedX, int speedY, int maxX, int maxY, int minX, int minY) 
	{
		this.start = new Point(x, y);
		this.width = width;
		this.height = height;
		this.color = color;
		this.center = new Point(x + width/2, y + height/2);
		this.speedX = speedX;
		this.speedY = speedY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.minX = minX;
		this.minY = minY;
		
	}
	
	/**
	 * Konstruktor koji ne prima parametre za brzinu
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 * @param maxX
	 * @param maxY
	 * @param minX
	 * @param minY
	 */
	
	public Body(int x, int y, int width, int height, Color color, int maxX, int maxY, int minX, int minY)
	{
		this.start = new Point(x, y);
		this.width = width;
		this.height = height;
		this.color = color;
		this.center = new Point(x + width/2, y + height/2);
		this.speedX = 0;
		this.speedY = 0;
		this.maxX = maxX;
		this.maxY = maxY;
		this.minX = minX;
		this.minY = minY;
		
	}
	
	/**
	 * Konstruktor koji ne prima parametar za boju
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param speedX
	 * @param speedY
	 * @param maxX
	 * @param maxY
	 * @param minX
	 * @param minY
	 */
	
	public Body(int x, int y, int width, int height, int speedX, int speedY, int maxX, int maxY, int minX, int minY)
	{
		this.start = new Point(x, y);
		this.width = width;
		this.height = height;
		this.color = Color.BLACK;
		this.center = new Point(x + width/2, y + height/2);
		this.speedX = speedX;
		this.speedY = speedY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.minX = minX;
		this.minY = minY;
		;
	}
	
	/**
	 * Getter za širinu figure
	 * @return width
	 */
	
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Getter za visinufigure
	 * @return height
	 */
	
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * Getter za boju figure
	 * @return color
	 */
	
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * Getter za početnu tačku figure
	 * @return start
	 */
	
	public Point getStart()
	{
		return start;
	}
	
	/**
	 * Getter za centralnu tačku figure
	 * @return
	 */
	
	public Point getCenter()
	{
		return center;
	}
	
	/**
	 * Getter za brzinu po x osi
	 * @return speedX
	 */
	
	public int getSpeedX(){
		return speedX;
	}

	/**
	 * Getter za brzinu po y osi
	 * @return speedY
	 */
	
	public int getSpeedY(){
		return speedY;
	}
	
	/**
	 * Metoda za crtanje (koristimo return jer u ovoj klasi ne znamo koju figuru treba crtati)
	 * @param g
	 */
	
	public void draw(Graphics g)
	{
		move();
		g.setColor(this.color);
		return;
	}
	
	/**
	 * Metoda koja provjerava da li se dvije figure dodiruju
	 * @param other
	 * @return boolean
	 */
	
	public boolean chekcCollision(Body other)
	{
		int distance = this.start.distance(other.start) ;
		if (distance > this.height/2 + other.height/2 && distance > this.width/2 + other.width/2)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Metoda koja pomjera figuru za određene brzine po x i y osama.
	 * Ukoliko figura dođe do kranje tačke prozora, figura ne ide dalje, tj. brzina je 0
	 */
	
	private void move()
	{
		if(this.start.getX() + this.width >= maxX && speedX > 0)
		{
			this.speedX = 0;
			this.setX(maxX - width);
		}
		if(this.start.getY() + this.height >= maxY && speedY > 0)
		{
			this.speedY = 0;
			this.setY(maxY - height);
		}
		if(this.start.getX() <= minX && speedX < 0)
		{
			this.speedX = 0;
			this.setX(minX);
		}
		if(this.start.getY() <= minY && speedY < 0)
		{
			this.speedY = 0;
			this.setY(minY);
		}
		this.start.move(speedX, speedY);
		this.center.move(speedX, speedY);
	}

	/**
	 * Setter za koordinatu x početne tačke
	 * @param x
	 */
	
	public void setX(int x) {
		this.start.setX(x);
	}
	
	/**
	 * Setter za koordinatu y početne tačke
	 * @param y
	 */
	
	public void setY(int y) {
		this.start.setY(y);
	}
	
	/**
	 * Metoda koja omogućava "skok" figure
	 */
	
	public void jump()
	{
		if (this.start.getY() == maxY - height)
		{
			this.speedY = -4;
			Timer timer = new Timer(1000, new JumpHandler());
			timer.start();
		}
	}
	
	/**
	 * Metoda koja figuru ponovo vraća na početak prozora, ako figura dođe do kraja
	 */
	
	public void reset()
	{
		if(this.start.getX() <= minX)
		{
			this.start.setX(maxX);
			this.center.setX(maxX+width/2);
		}
	}
	
	/**
	 * Handler za skok 
	 * @author Gordan
	 *
	 */
	
	private class JumpHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			speedY = 3; 
			Timer t = (Timer) e.getSource();
			t.stop();
		}
		
	}
	
}
