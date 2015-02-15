import java.awt.Frame;
import java.lang.Math;
import java.awt.Graphics;

public class mainpkg {
    
    private static double[] newx = new double[4];
    private static double[] newy = new double[4];
    private static double[] newx3 = new double[8];
    private static double[] newy3 = new double[8];
    private static double[] newx4 = new double[16];
    private static double[] newy4 = new double[16];
    

 public static void main(String[] args)
    {
	 
	 System.out.println("args length is " + args.length);
	 for(String arg:args) {
		 System.out.println(arg);
	 }
	 
	 if(args[0].equals("2")) {
		 
		 rot2d();
	 }
	 else if(args[0].equals("3")) {
		 rot3d();
	 }
	 else if(args[0].equals("4")) {
	     rot4d();
	 }
	 else System.out.println("args[0] is " + args[0]);
        
        
    }
 
    public static void rotate2d(double[] x, double[] y, double angle) {
        for(int i =0; i<4; i++) {
            newx[i] = x[i]*Math.cos(angle) - y[i]*Math.sin(angle);
            newy[i] = x[i]*Math.sin(angle) + y[i] *Math.cos(angle);
        }
    }
    
    public static void rotate3d(double[] x, double[] y, double angle) {
        for(int i=0; i<8; i++) {
            newx3[i] = x[i]*Math.cos(angle) - y[i]*Math.sin(angle);
            newy3[i] = x[i]*Math.sin(angle) + y[i] *Math.cos(angle);
        }
    }
    
    public static void rotate4d(double[] x, double[] y, double angle) {
        for(int i=0; i<16; i++) {
            newx4[i] = x[i]*Math.cos(angle) - y[i]*Math.sin(angle);
            newy4[i] = x[i]*Math.sin(angle) + y[i] *Math.cos(angle);           
        }
    }
    
    public static void rot2d() {
    	
    	int height = 822;
        int width = 800;
        double[] x = new double[4];
        double[] y = new double[4];
        
        Square r2 = new Square(width, height);
        Frame aFrame = new Frame(); 
        aFrame.setSize(height, width); //5 pixels either side for frame, 5 below for frame + 25 above foe window bar
        aFrame.add(r2); 
        aFrame.setVisible(true);
        
        x[0] = x[3] = -width/4.0;
        x[1] = x[2] = width/4.0;
        y[0] = y[1] = height/4.0;
        y[2] = y[3] = -height/4.0;
        
        r2.setCoords(x,y);
        
        double i = 0;
        
        while(true) {
            double angle = i* 2.0*Math.PI;
            rotate2d(x,y,angle);
            r2.setCoords(newx,newy);
            try {
                Thread.sleep(100);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Graphics f = r2.getGraphics();
            r2.update(f);
            i+=0.01;
            
        } 
    }
    
    public static void rot3d() {
        int height = 822;
        int width = 800;
        int depth = 800;
        double[] x = new double[8];
        double[] y = new double[8];
        double[] z = new double[8];
        
        Cube r3 = new Cube(width, height, depth);
        Frame aFrame = new Frame(); 
        aFrame.setSize(height, width); //5 pixels either side for frame, 5 below for frame + 25 above foe window bar
        aFrame.add(r3); 
        aFrame.setVisible(true);
        
        x[0] = x[3] = x[4] = x[7] = -width/4.0;
        x[1] = x[2] = x[5] = x[6] = width/4.0;
        y[0] = y[1] = y[4] = y[5] = height/4.0;
        y[2] = y[3] = y[6] = y[7] = -height/4.0;
        
        r3.setCoords(x,y);
        
        double i = 0;
        
        while(true) {
            double angle = i* 2.0*Math.PI;
            rotate3d(x,y,angle);
            r3.setCoords(newx3,newy3);
            try {
                Thread.sleep(100);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Graphics f = r3.getGraphics();
            r3.update(f);
            i+=0.01;
            
        } 
    	
    }
    
    public static void rot4d() {
        int height = 822;
        int width = 800;
        int depth = 800;
        int fourth = 800;
        double[] x = new double[16];
        double[] y = new double[16];
        double[] z = new double[16];
        double[] w = new double[16];
        
        Tesseract r4 = new Tesseract(width, height, depth, fourth);
        Frame aFrame = new Frame(); 
        aFrame.setSize(height, width); 
        aFrame.add(r4); 
        aFrame.setVisible(true);
        
        x[0] = x[3] = x[4] = x[7] = x[8] = x[11] = x[12] = x[15] = -width/6.0;
        x[1] = x[2] = x[5] = x[6] = x[9] = x[10] = x[13] = x[14] = width/6.0;
        y[0] = y[1] = y[4] = y[5] = y[8] = y[9] = y[12] = y[13] = height/6.0;
        y[2] = y[3] = y[6] = y[7] =y[10] = y[11] = y[14] = y[15] = -height/6.0;
        
        r4.setCoords(x,y);
        
        double i = 0;
        
        while(true) {
            double angle = i* 2.0*Math.PI;
            rotate4d(x,y,angle);
            r4.setCoords(newx4,newy4);
            try {
                Thread.sleep(100);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Graphics f = r4.getGraphics();
            r4.update(f);
            i+=0.01;
            
        } 
        
    }
}