import java.io.*;
import java.util.*;

public class Master
{
  public static void main(String args[]) throws Exception
  {
    new Master().go();
  }
  
  private double y_max = Double.NEGATIVE_INFINITY;
  private double x_max = 0.0;

  private void go() throws Exception
  {
    System.out.println();
    List<Process> list = new ArrayList<Process>();
    

    
    for (int i = 0; i < 6; i++)
    {
      Process p = new ProcessBuilder("java", "Worker").start();
      
      int start = i * 10 - 20;
      int end = start + 10;
      sendParameters(p, start, end);
      list.add(p);
    }

    for (Process p : list)
    {
      getValuePairs(p);
    }
    System.out.printf("Best point is (%.2f, %.2f)", x_max, y_max);
  }

  private void sendParameters(Process p, int start, int end) throws Exception
  {
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream(), "UTF-8"));
    pw.println(start);
    pw.println(end);
    pw.flush();
  }

  private void getValuePairs(Process p) throws Exception
  {//recieves from workers and finds best result
    p.waitFor();
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
    String line = br.readLine();
    System.out.println("Process found (" + line + ")...");
    String[]xy = line.split(", ");
    
    if(Double.parseDouble(xy[1]) > y_max)
    {
      y_max = Double.parseDouble(xy[1]);
      x_max = Double.parseDouble(xy[0]);
    }
    
    
  }
}
