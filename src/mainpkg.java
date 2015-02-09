import java.awt.Frame;
import java.lang.Math;

public class mainpkg {

 public static void main(String[] args)
    {
        System.out.println("Hello there");
       
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
        
        //testing
       /* x[0] = x[2] = 0;
        x[1] = x[3] = (int)Math.sqrt( (height/4.0) * (width/4.0) + (height/4.0) * (width/4.0));
        x[3] = -x[1];
        y[0] = (int)Math.sqrt( (height/4.0) * (width/4.0) + (height/4.0) * (width/4.0));
        y[2] = -y[0];
        y[1] = y[3] = 0;
        
        r2.setCoords(x,y);*/
        
        double i = 0;
        
        while(true) {
            double angle = i* 2.0*Math.PI;
            rotate(x,y,angle);
            
        }
        
       
        
        
    }
 
    public static void rotate(double[] x, double[] y, double angle) {
        double[] newx = new double[4];
        double[] newy = new double[4];
        
        
      
    }
}