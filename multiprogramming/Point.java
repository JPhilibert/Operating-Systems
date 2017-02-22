import java.util.Random;

public class Point
{
    private int m_x;
    private int m_y;
    private Random rand = new Random();
    
    public Point(int max)
    {
        m_x = rand.nextInt(max);
        m_y = rand.nextInt(max);
    }

    public Point(int x, int y)
    {
        m_x = x;
        m_y = y;
    }
    //i regret not making a constructor that took a string and split it into the values it needed
    
    public double getDistance(Point p)
    {
        //sqrt( (x1 - x2 )^2 + (y1 - y2)^2 )
        return Math.sqrt(Math.pow(p.getX() - m_x, 2) + Math.pow(p.getY() - m_y ,2));
    }
    
    @Override
    public String toString()
    {
        return m_x + "," + m_y;
    }
    
    public int getX(){return m_x;}
    public int getY(){return m_y;}
    
}