import java.util.*;

public class Point
{
    private int min = 0;
    private int max = 100; //pass this?
    private int x;
    private int y;
    
    
    public Point()
    {
        Random rand = new Random();
        x = rand.nextInt((max - min) + 1) + min;
        y = rand.nextInt((max - min) + 1) + min;
        System.out.println("made point " + x + y);
    }
    public Point(int ax, int ay)
    {
        x = ax;
        y = ay;
        System.out.println("made point " + x + y);
    }
    
}