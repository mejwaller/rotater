import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class rotate4d extends Canvas{
    
    //y is vertical (against convention..)
    //z come out of screen
    //x is horizontal
    private int height;
    private int width;
    private int depth;
    private int fourth;
    private int[] X = new int[16];
    private int[] Y = new int[16];
    private int[] Z = new int[16]; 
    private int[] W = new int[16];
    private int xztrans;//hack to translate points along diagonal z axis
    private int yztrans;
    private int xwtrans;
    private int ywtrans;
    
    rotate4d(int width, int height, int depth, int fourth) {
        this.width=width;
        this.height=height;
        this.depth=depth;
        this.fourth=fourth;
        setBackground(Color.white);
        X[0] = X[3] = X[4] = X[7] = X[8] = X[11] = X[12] = X[15]= -width/6;
        X[1] = X[2] = X[5] = X[6] = X[9] = X[10] = X[13] = X[14] = width/6;
        Y[0] = Y[1] = Y[4] = Y[5] = Y[8] = Y[9] = Y[12] = Y[13] = height/6;
        Y[2] = Y[3] = Y[6] = Y[7] = Y[10] = Y[11] = Y[1] = Y[15] =-height/6;
        Z[0] = Z[1] = Z[2] = Z[3] = depth/6;
        Z[5] = Z[5] = Z[6] = Z[7] = -depth/6;
        xztrans=width/12;
        yztrans=height/12;
        xwtrans=width/12;
        ywtrans=height/12; 
                         
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.black);
        drawLine(g,0,-(height/2),0,(height/2));
        drawLine(g,-(width/2),0,width/2,0);
        drawLine(g,height/2, height/2, -height/2, -height/2);
        drawLine(g,height/2, -height/2, -height/2, height/2);
        g.setColor(Color.red);
        drawTesseract(g);               
    }
    
    public void update(Graphics g) {
        super.update(g);
       paint(g);        
    }
    
    void setCoords(double[] xs, double[] ys/*, double[] zs*/) {
        
        for(int i=0; i < 16; i++)
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
    
    public void drawTesseract(Graphics g) {
        
        //cube at 'front' w-axis
        drawLine(g, X[0]+xztrans-xwtrans, Y[0]+yztrans+ywtrans, X[1]+xztrans-xwtrans, Y[1]+yztrans+ywtrans);
        drawLine(g, X[1]+xztrans-xwtrans, Y[1]+yztrans+ywtrans, X[2]+xztrans-xwtrans, Y[2]+yztrans+ywtrans);
        drawLine(g, X[2]+xztrans-xwtrans, Y[2]+yztrans+ywtrans, X[3]+xztrans-xwtrans, Y[3]+yztrans+ywtrans);
        drawLine(g, X[3]+xztrans-xwtrans, Y[3]+yztrans+ywtrans, X[0]+xztrans-xwtrans, Y[0]+yztrans+ywtrans);
        /*drawLine(g, X[0]+xztrans, Y[0]+yztrans, X[1]+xztrans, Y[1]+yztrans);
        drawLine(g, X[1]+xztrans, Y[1]+yztrans, X[2]+xztrans, Y[2]+yztrans);
        drawLine(g, X[2]+xztrans, Y[2]+yztrans, X[3]+xztrans, Y[3]+yztrans);
        drawLine(g, X[3]+xztrans, Y[3]+yztrans, X[0]+xztrans, Y[0]+yztrans);*/
        
        drawLine(g,X[4]-xztrans-xwtrans, Y[4]-yztrans+ywtrans, X[5]-xztrans-xwtrans, Y[5]-yztrans+ywtrans);
        drawLine(g,X[5]-xztrans-xwtrans,Y[5]-yztrans+ywtrans, X[6]-xztrans-xwtrans,Y[6]-yztrans+ywtrans);
        drawLine(g,X[6]-xztrans-xwtrans, Y[6]-xztrans+ywtrans, X[7]-xztrans-xwtrans, Y[7]-yztrans+ywtrans);
        drawLine(g, X[7]-xztrans-xwtrans, Y[7]-yztrans+ywtrans,X[4]-yztrans-xwtrans, Y[4]-yztrans+ywtrans);
        /*drawLine(g,X[4]-xztrans, Y[4]-yztrans, X[5]-xztrans, Y[5]-yztrans);
        drawLine(g,X[5]-xztrans,Y[5]-yztrans, X[6]-xztrans,Y[6]-yztrans);
        drawLine(g,X[6]-xztrans, Y[6]-xztrans, X[7]-xztrans, Y[7]-yztrans);
        drawLine(g, X[7]-xztrans, Y[7]-yztrans,X[4]-yztrans, Y[4]-yztrans);*/
        
        drawLine(g,X[0]+xztrans-xwtrans, Y[0]+yztrans+ywtrans, X[4]-xztrans-xwtrans, Y[4]-yztrans+ywtrans);
        drawLine(g,X[1]+xztrans-xwtrans, Y[1]+yztrans+ywtrans, X[5]-xztrans-xwtrans, Y[5]-yztrans+ywtrans);
        drawLine(g,X[2]+xztrans-xwtrans,Y[2]+yztrans+ywtrans,X[6]-xztrans-xwtrans, Y[6]-yztrans+ywtrans);
        drawLine(g,X[3]+xztrans-xwtrans,Y[3]+yztrans+ywtrans,X[7]-yztrans-xwtrans, Y[7]-yztrans+ywtrans);
        /*drawLine(g,X[0]+xztrans, Y[0]+yztrans, X[4]-xztrans, Y[4]-yztrans);
        drawLine(g,X[1]+xztrans, Y[1]+yztrans, X[5]-xztrans, Y[5]-yztrans);
        drawLine(g,X[2]+xztrans,Y[2]+yztrans,X[6]-xztrans, Y[6]-yztrans);
        drawLine(g,X[3]+xztrans,Y[3]+yztrans,X[7]-yztrans, Y[7]-yztrans);*/
        
        
        
        
        //cube at 'back' w axis
        drawLine(g, X[8]+xztrans+xwtrans, Y[8]+yztrans-ywtrans, X[9]+xztrans+xwtrans, Y[9]+yztrans-ywtrans);
        drawLine(g, X[9]+xztrans+xwtrans, Y[9]+yztrans-ywtrans, X[10]+xztrans+xwtrans, Y[10]+yztrans-ywtrans);
        drawLine(g, X[10]+xztrans+xwtrans, Y[10]+yztrans-ywtrans, X[11]+xztrans+xwtrans, Y[11]+yztrans-ywtrans);
        drawLine(g, X[11]+xztrans+xwtrans, Y[11]+yztrans-ywtrans, X[8]+xztrans+xwtrans, Y[8]+yztrans-ywtrans);
        /*drawLine(g, X[0]+xztrans+xwtrans, Y[0]+yztrans+ywtrans, X[1]+xztrans+xwtrans, Y[1]+yztrans+ywtrans);
        drawLine(g, X[1]+xztrans+xwtrans, Y[1]+yztrans+ywtrans, X[2]+xztrans+xwtrans, Y[2]+yztrans+ywtrans);
        drawLine(g, X[2]+xztrans+xwtrans, Y[2]+yztrans+ywtrans, X[3]+xztrans+xwtrans, Y[3]+yztrans+ywtrans);
        drawLine(g, X[3]+xztrans+xwtrans, Y[3]+yztrans+ywtrans, X[0]+xztrans+xwtrans, Y[0]+yztrans+ywtrans);*/
  
        drawLine(g,X[12]-xztrans+xwtrans, Y[12]-yztrans-ywtrans, X[13]-xztrans+xwtrans, Y[13]-yztrans-ywtrans);
        drawLine(g,X[13]-xztrans+xwtrans,Y[13]-yztrans-ywtrans, X[14]-xztrans+xwtrans,Y[14]-yztrans-ywtrans);
        drawLine(g,X[14]-xztrans+xwtrans, Y[14]-xztrans-xwtrans, X[15]-xztrans+xwtrans, Y[15]-yztrans-ywtrans);
        drawLine(g,X[15]-xztrans+xwtrans, Y[15]-yztrans-ywtrans,X[12]-yztrans+ywtrans, Y[12]-yztrans-ywtrans);
        /*drawLine(g,X[4]-xztrans+xwtrans, Y[4]-yztrans+ywtrans, X[5]-xztrans+xwtrans, Y[5]-yztrans+ywtrans);
        drawLine(g,X[5]-xztrans+xwtrans,Y[5]-yztrans+ywtrans, X[6]-xztrans+xwtrans,Y[6]-yztrans+ywtrans);
        drawLine(g,X[6]-xztrans+xwtrans, Y[6]-xztrans+xwtrans, X[7]-xztrans+xwtrans, Y[7]-yztrans+ywtrans);
        drawLine(g,X[7]-xztrans+xwtrans, Y[7]-yztrans+ywtrans,X[4]-yztrans+ywtrans, Y[4]-yztrans+ywtrans);*/
        
        drawLine(g,X[8]+xztrans+xwtrans, Y[8]+yztrans-ywtrans, X[12]-xztrans+xwtrans, Y[12]-yztrans-ywtrans);
        drawLine(g,X[9]+xztrans+xwtrans, Y[9]+yztrans-ywtrans, X[13]-xztrans+xwtrans, Y[13]-yztrans-ywtrans);
        drawLine(g,X[10]+xztrans+xwtrans,Y[10]+yztrans-ywtrans,X[14]-xztrans+xwtrans, Y[14]-yztrans-ywtrans);
        drawLine(g,X[11]+xztrans+xwtrans,Y[11]+yztrans-ywtrans,X[15]-yztrans+ywtrans, Y[15]-yztrans-ywtrans);
        /*drawLine(g,X[0]+xztrans+xwtrans, Y[0]+yztrans+ywtrans, X[4]-xztrans+xwtrans, Y[4]-yztrans+ywtrans);
        drawLine(g,X[1]+xztrans+xwtrans, Y[1]+yztrans+ywtrans, X[5]-xztrans+xwtrans, Y[5]-yztrans+ywtrans);
        drawLine(g,X[2]+xztrans+xwtrans,Y[2]+yztrans+ywtrans,X[6]-xztrans+xwtrans, Y[6]-yztrans+ywtrans);
        drawLine(g,X[3]+xztrans+xwtrans,Y[3]+yztrans+ywtrans,X[7]-yztrans+ywtrans, Y[7]-yztrans+ywtrans);*/
        
        //conect teh 'front' an 'back' cubes
        
        drawLine(g,X[0]+xztrans-xwtrans, Y[0]+yztrans+ywtrans,X[8]+xztrans+xwtrans, Y[8]+yztrans-ywtrans);
        drawLine(g,X[1]+xztrans-xwtrans, Y[1]+yztrans+ywtrans,X[9]+xztrans+xwtrans, Y[9]+yztrans-ywtrans);
        drawLine(g,X[2]+xztrans-xwtrans, Y[2]+yztrans+ywtrans,X[10]+xztrans+xwtrans, Y[10]+yztrans-ywtrans);
        drawLine(g,X[3]+xztrans-xwtrans, Y[3]+yztrans+ywtrans,X[11]+xztrans+xwtrans, Y[11]+yztrans-ywtrans);
        
        
        drawLine(g,X[4]-xztrans-xwtrans, Y[4]-yztrans+ywtrans,X[12]-xztrans+xwtrans, Y[12]-yztrans-ywtrans);
        drawLine(g,X[5]-xztrans-xwtrans, Y[5]-yztrans+ywtrans,X[13]-xztrans+xwtrans, Y[13]-yztrans-ywtrans);
        drawLine(g,X[6]-xztrans-xwtrans, Y[6]-yztrans+ywtrans,X[14]-xztrans+xwtrans, Y[14]-yztrans-ywtrans);
        drawLine(g,X[7]-xztrans-xwtrans, Y[7]-yztrans+ywtrans,X[15]-xztrans+xwtrans, Y[15]-yztrans-ywtrans);
        
        
        
        
        
    }

}