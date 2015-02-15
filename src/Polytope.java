import java.awt.Canvas;
import java.awt.Graphics;

public abstract class Polytope extends Canvas
{
	public abstract void draw(Graphics g); 
	public abstract void drawLine(Graphics g, int xstart, int ystart, int xend, int yend);

}