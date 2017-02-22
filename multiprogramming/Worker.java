import java.util.*;

public class Worker
{
  
  private Point origin;
  private List<Point> points = new ArrayList<Point>();
  
  public static void main(String args[]) throws Exception
  {
    new Worker().go();
  }

  private void go() throws Exception
  {
    //System.out.println("made worker");
    readData();
    findClosest();
  }
  
  private void readData()
  {//reads in originx/y, size, loop x/y point
    Scanner scan = new Scanner(System.in);
    int ox = scan.nextInt();
    int oy = scan.nextInt();
    origin = new Point(ox,oy);
    int size = scan.nextInt()
    
    for(int i = 0; i < size; i++)
    {
      int _x = scan.nextInt();
      int _y = scan.nextInt();
      Point _p = new Point(_x, _y);
      points.add(_p);
    }
  }
  
  private void findClosest()
  {
      double distance = Double.MAX_VALUE;
      Point closest = null;
      for(Point p : points)
      {
          if(p.getDistance(origin) < distance)
          {
              distance = p.getDistance(origin);
              closest = p;
          }
      }
      System.out.println(closest);
  }
}
