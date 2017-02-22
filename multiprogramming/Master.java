import java.io.*;
import java.util.*;

public class Master
{
  private int max;
  private Point origin;
  private int segments;
  private int quantity;
  
  private List<Point> points = new ArrayList<Point>();
  private List<Point> reducedPoints = new ArrayList<Point>();
  public static void main(String args[]) throws Exception
  {
    new Master().go();
  }

  private void go() throws Exception
  {
    initializeValues();
    generatePoints();
    int size = quantity/segments;
    int extra = quantity%segments;
    
    List<Process> list = new ArrayList<Process>();
    
    for (int i = 0; i < segments; i++)
    {
      System.out.printf("Starting process %d ...%n",i);
      Process p = new ProcessBuilder("java", "Worker").start();
      PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream(), "UTF-8"));
      pw.println(origin.getX());
      pw.println(origin.getY());
      
      if(i == segments-1)//pass remainders to last worker
      {
        pw.println(size + extra);
        for(int j = quantity-extra; j < quantity; j++)
        {
          pw.println(points.get(j).getX());
          pw.println(points.get(j).getY());
        }
      }else{
        pw.println(size);
      }
      
      for(int j = size*i; j < size*(i+1) ; j++)
      {
        pw.println(points.get(j).getX());
        pw.println(points.get(j).getY());
      }
      
      list.add(p);
    }

    for (Process p : list)
    {
      reducedPoints.add(readClosest(p));
      //System.out.println("reading data...");
    }
    
    masterFindClosest();
    
  }
  
  private void masterFindClosest()
  {//uses reduced points from workers
      double distance = Double.MAX_VALUE;
      Point closest = null;
      for(Point p : reducedPoints)
      {
          if(p.getDistance(origin) < distance)
          {
              distance = p.getDistance(origin);
              closest = p;
          }
      }
      System.out.println(closest);
  }

  private Point readClosest(Process p) throws Exception
  {
    p.waitFor();
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
    String line = br.readLine();
    String[] coordinates = line.split(",");
    Point closest = new Point(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]));
    return closest;
  }
    
  private void initializeValues()
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("\nInput maximum x/y values:");
    max = keyboard.nextInt();
    System.out.print("\nInput origin x:");
    int x = keyboard.nextInt();
    System.out.print("\nInput origin y:");
    int y = keyboard.nextInt();
    origin = new Point(x,y);
    System.out.print("\nInput number of points:");
    quantity = keyboard.nextInt();
    System.out.print("\nInput number of segments:");
    segments = keyboard.nextInt();
  }
    
  private void generatePoints()
  {
    for(int i =0; i < quantity; i++)
    {
      points.add(new Point(max));
    }
  }
}
