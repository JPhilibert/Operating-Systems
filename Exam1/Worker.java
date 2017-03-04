import java.util.*;
import java.lang.*;

public class Worker
{
  // can easily be run 'stand alone'...  
  public static void main(String args[]) throws Exception
  {
    new Worker().go();
  }

  private void go() throws Exception
  {
    Scanner scan = new Scanner(System.in);
    int start = scan.nextInt();
    int end = scan.nextInt();
    double x_max = 0.0;
    double y_max = Double.NEGATIVE_INFINITY;
    
    for (int i = 0; i < (end-start)*10; i++)
    {//y = ( (-x^4 + 20x^3) / 500 ) + 24
      double x = start + i*.1;
      double y = ( ( (-1*Math.pow(x,4)) + (20 * Math.pow(x,3)) ) / 500 ) + 24;
      if(y > y_max){
        y_max = y;
        x_max = x;
      }
    }
    System.out.printf("%.2f, %.2f", x_max, y_max);
  }
}
