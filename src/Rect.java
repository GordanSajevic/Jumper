import java.awt.Color;
import java.awt.Graphics;


public class Rect extends Body{

	public Rect(int x, int y, int width, int height, Color color, int speedX, int speedY, int maxX, int maxY, int minX, int minY) {
		super(x, y, width, height, color, speedX, speedY, maxX,  maxY, minX, minY);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g)
	{
		super.draw(g);
		g.fillRect(super.getStart().getX(), super.getStart().getY(), super.getWidth(), super.getHeight());
	}

}
