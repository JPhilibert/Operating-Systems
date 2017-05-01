public class Chair extends GameObject
{
  public Chair(int x, int y, int w, int h, int dX, int dY)
  {
    super("./chair.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_x = m_x + m_dX;
    m_y = m_y + m_dY;
    
    if (m_x > maxw)
      m_x = maxw/2;
    else if (m_x < 0)
      m_x = maxw/2;

    if (m_y > maxh)
      m_y = maxh/2;
    else if (m_y < 0)
      m_y = maxh/2;

  }
  @Override
  public boolean isEnemy()
  {
    return true;
  }

}
