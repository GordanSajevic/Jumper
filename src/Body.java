import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Body {

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
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public Point getStart()
	{
		return start;
	}
	
	public Point getCenter()
	{
		return center;
	}
	
	public int getSpeedX(){
		return speedX;
	}

	public int getSpeedY(){
		return speedY;
	}
	
	public void draw(Graphics g)
	{
		move();
		g.setColor(this.color);
		return;
	}
	
	public boolean chekcCollision(Body other)
	{
		int distance = this.center.distance(other.center) ;
		if (distance > this.height/2 + other.height/2 && distance > this.width/2 + other.width/2)
		{
			return false;
		}
		return true;
	}
	
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

	public void setX(int x) {
		this.start.setX(x);
	}
	
	public void setY(int y) {
		this.start.setY(y);
	}
	
	public void jump()
	{
		if (this.start.getY() == maxY - height)
		{
			this.speedY = -4;
			Timer timer = new Timer(1000, new JumpHandler());
			timer.start();
		}
	}
	
	public void reset()
	{
		if(this.start.getX() <= minX)
		{
			this.start.setX(maxX);
			this.center.setX(maxX+width/2);
		}
	}
	
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
