import java.awt.Frame;
import java.lang.Math;
import java.awt.Graphics;

public class mainpkg {
    
    private static double[] newx = new double[4];
    private static double[] newy = new double[4];
    private static double[] newx3 = new double[8];
    private static double[] newy3 = new double[8];
    

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
	 else System.out.println("args[0] is " + args[0]);
        
        
    }
 
    public static void rotate2d(double[] x, double[] y, double angle) {
        for(int i =0; i<4; i++) {
            newx[i] = x[i]*Math.cos(angle) - y[i]*Math.sin(angle);
            newy[i] = x[i]*Math.sin(angle) + y[i] *Math.cos(angle);
        }
    }
    
    public static void rot2d() {
    	
    	int height = 822;
        int width = 800;
        double[] x = new double[4];
        double[] y = new double[4];
        
        rotate2d r2 = new rotate2d(width, height);
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
        
        rotate3d r3 = new rotate3d(width, height, depth);
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
    
    public static void rotate3d(double[] x, double[] y, double angle) {
        for(int i =0; i<8; i++) {
            newx3[i] = x[i]*Math.cos(angle) - y[i]*Math.sin(angle);
            newy3[i] = x[i]*Math.sin(angle) + y[i] *Math.cos(angle);
        }
    }
}