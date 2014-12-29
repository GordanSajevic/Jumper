
public class Point {

	private int x;
	private int y;
	
	/**
	 * Konstruktor sa dva parametra
	 * @param x
	 * @param y
	 */
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Getter za x
	 * @return x
	 */
	
	public int getX()
	{
		return x;
	}

	/**
	 * Getter za y
	 * @return y
	 */
	
	public int getY()
	{
		return y;
	}
	
	/**
	 * Metoda koja pomjera tačku za odgovarajuće brzine po x i y osama
	 * @param speedX
	 * @param speedY
	 */
	
	public void move(int speedX, int speedY)
	{
		this.x += speedX;
		this.y += speedY;
	}
	
	/**
	 * Setter za x
	 */
	
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Setter za y
	 */
	
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Metoda računa udaljenost jedne tačke od druge
	 * @param other
	 * @return distance
	 */
	
	public int distance(Point other)
	{
		return (int) Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}
	
}
