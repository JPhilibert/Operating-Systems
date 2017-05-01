public class Fish extends GameObject
{
  public Fish(int x, int y, int w, int h, int dX, int dY)
  {
    super("./fish.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_x = m_x + m_dX;
    m_y = m_y + m_dY;
    
    if (m_x > maxw)
      m_x = maxw;
    else if (m_x < 0)
      m_x = 0;
    m_dX = -m_dX;

    if (m_y > maxh)
      m_y = maxh;
    else if (m_y < 0)
      m_y = 0;
    m_dY = -m_dY;
  }
  @Override
  public boolean isEnemy()
  {
    return true;
  }

}
