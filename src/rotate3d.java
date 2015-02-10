import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class rotate3d extends Canvas{
    
    //y is vertical (against convention..)
    //z come out of screen
    //x is horizontal
    private double axisxrot = Math.PI/8.0;
    private double axisyrot = Math.PI/8.0;
    private double axiszrot = 0.0;
    private int height;
    private int width;
    private int depth;
    private int[] X = new int[8];
    private int[] Y = new int[8];
    private int[] Z = new int[8]; 
    private int xtrans;//hack to translate points along diagional z axis
    private int ytrans;
    
    rotate3d(int width, int height, int depth) {
        this.width=width;
        this.height=height;
        this.depth=depth;
        setBackground(Color.white);
        X[0] = X[3] = X[4] = X[7] = -width/4;
        X[1] = X[2] = X[5] = X[6] = width/4;
        Y[0] = Y[1] = Y[4] = Y[5] = height/4;
        Y[2] = Y[3] = Y[6] = Y[7] = -height/4;
        Z[0] = Z[1] = Z[2] = Z[3] = depth/4;
        Z[5] = Z[5] = Z[6] = Z[7] = -depth/4;
        xtrans=width/8;;
        ytrans=width/8;
        
        
        //to show z axis, foirst rotate pi/8 towards you round xaxis (i.e. -pi/8) (so z and y change)
        //THEN around y axis in a clockwise direction, i.e. also -pi/8, so x and z change
/*        double zaxisendfront = (depth/2.0)*Math.cos(-Math.PI/8.0) - (height/2.0)*Math.sin(-Math.PI/8.0);
        double zaxisendback = (-depth/2.0)*Math.cos(-Math.PI/8.0) - (height/2.0)*Math.sin(-Math.PI/8.0);
        double yaxisendfront = (depth/2.0)*Math.sin(-Math.PI/8.0) + (height/2.0)*Math.cos(-Math.PI/8.0);
        double yaxisendback =  (depth/2.0)*Math.sin(-Math.PI/8.0) + (-height/2.0)*Math.cos(-Math.PI/8.0);
        */
                        
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.black);
        drawLine(g,0,-(height/2),0,(height/2));
        drawLine(g,-(width/2),0,width/2,0);
        drawLine(g,height/2, height/2, -height/2, -height/2);
        g.setColor(Color.red);
        drawCube(g);               
    }
    
    public void update(Graphics g) {
        super.update(g);
       paint(g);        
    }
    
    void setCoords(double[] xs, double[] ys/*, double[] zs*/) {
        
        for(int i=0; i < 8; i++)
        {
            X[i] = (int)xs[i];
            Y[i] = (int)ys[i];
            //Z[i] = (int)zs[i];
        }
        
    }
    
    public void drawLine(Graphics g, int xstart, int ystart, int xend, int yend) {
        g.drawLine(xstart + 400, getHeight()-400+ystart, 
                        xend + 400, getHeight()-400+yend);
        
    }
    
    public void drawCube(Graphics g) {
        drawLine(g, X[0]+xtrans, Y[0]+ytrans, X[1]+xtrans, Y[1]+ytrans);
        drawLine(g, X[1]+xtrans, Y[1]+ytrans, X[2]+xtrans, Y[2]+ytrans);
        drawLine(g, X[2]+xtrans, Y[2]+ytrans, X[3]+xtrans, Y[3]+ytrans);
        drawLine(g, X[3]+xtrans, Y[3]+ytrans, X[0]+xtrans, Y[0]+ytrans);
        
        drawLine(g,X[4]-xtrans, Y[4]-ytrans, X[5]-xtrans, Y[5]-ytrans);
        drawLine(g,X[5]-xtrans,Y[5]-ytrans, X[6]-xtrans,Y[6]-ytrans);
        drawLine(g,X[6]-xtrans, Y[6]-xtrans, X[7]-xtrans, Y[7]-ytrans);
        drawLine(g, X[7]-xtrans, Y[7]-ytrans,X[4]-ytrans, Y[4]-ytrans);
        
        drawLine(g,X[0]+xtrans, Y[0]+ytrans, X[4]-xtrans, Y[4]-ytrans);
        drawLine(g,X[1]+xtrans, Y[1]+ytrans, X[5]-xtrans, Y[5]-ytrans);
        drawLine(g,X[2]+xtrans,Y[2]+ytrans,X[6]-xtrans, Y[6]-ytrans);
        drawLine(g,X[3]+xtrans,Y[3]+ytrans,X[7]-ytrans, Y[7]-ytrans);
        
        
        
        
    }

}