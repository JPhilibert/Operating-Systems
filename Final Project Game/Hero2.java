import java.awt.*;

public class Hero2 extends GameObject implements KeyListener
{
  private int m_ticks = 0;
  private int m_lives = 5;
  private int m_velocity = 10;
  private int score = 0;


  public Hero(int x, int y, int w, int h, int dX, int dY)
  {
    super("./monkey.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_x = m_x + m_dX;
    m_y = m_y + m_dY;
    
    if(m_y < maxh/2)
      score++;
    
    if (m_x > maxw)
      m_x = maxw;
    else if (m_x < 0)
      m_x = 0;

    if (m_y > maxh)
      m_y = maxh;
    else if (m_y < 0)
      m_y = 0;
  }
  
  public void death()
  {
    m_lives--;
    m_x = m_rand.nextInt(maxw);
    m_y = m_rand.nextInt(maxh);
  }
  
  public int getLives()
  {
    return m_lives;
  }
  
  @Override
  public boolean isEnemy()
  {
    return false;
  }
  
  public int getScore()
  {
    return score;
  }
  
  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
    {
      m_dX = m_velocity;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) 
    {
      m_dX = -m_velocity;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) 
    {
      m_dY = m_velocity;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) 
    {
      m_dY = -m_velocity;
    }    
  }

  @Override
  public void keyReleased(KeyEvent e) {}
}
