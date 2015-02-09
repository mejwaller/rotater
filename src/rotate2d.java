import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class rotate2d extends Canvas{
    
    private int height;
    private int width;
    private int[] X = new int[4];
    private int[] Y = new int[4];
    
    rotate2d(int width, int height) {
        this.width=width;
        this.height=height;
        setBackground(Color.white);
        X[0] = X[3] = -width/4;
        X[1] = X[2] = width/4;
        Y[0] = Y[1] = height/4;
        Y[2] = Y[3] = -height/4;
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.black);
        drawLine(g,0,-(height/2),0,(height/2));
        drawLine(g,-(width/2),0,width/2,0);
        g.setColor(Color.red);
        drawSquare(g);
        //drawLine(g, 10, 10, 800, 10);
        //drawLine(g, 10, 10, 10, 800);
        //g.setColor(Color.red);
        //drawLine(g, 10, 10, 800, 800);
        
    }
    
    public void update(Graphics g) {
       paint(g);        
    }
    
    void setCoords(double[] xs, double[] ys) {
        
        for(int i=0; i < 4; i++)
        {
            X[i] = (int)xs[i];
            Y[i] = (int)ys[i];
        }
        
    }
    
    public void drawLine(Graphics g, int xstart, int ystart, int xend, int yend) {
        System.out.println("getHeight is " + getHeight());
        System.out.println("xstart + 400 is " + (xstart + 400));
        System.out.println("getheight - 400 + ystart is " + (getHeight() - 400 + ystart));
        
        System.out.println("xend + 400 is " + (xstart+400));
        System.out.println("getheight - 400 + yend is " + (getHeight() - 400 + yend));
        g.drawLine(xstart + 400, getHeight()-400+ystart, 
                        xend + 400, getHeight()-400+yend);
        //g.drawLine(xstart, getHeight()-ystart, xend, getHeight()-yend);
        
    }
    
    public void drawSquare(Graphics g) {
        drawLine(g, X[0], Y[0], X[1], Y[1]);
        drawLine(g, X[1], Y[1], X[2], Y[2]);
        drawLine(g, X[2], Y[2], X[3], Y[3]);
        drawLine(g, X[3], Y[3], X[0], Y[0]);
        
    }

}