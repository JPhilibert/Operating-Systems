import javax.swing.*;
import java.awt.BorderLayout;
import java.util.*;

class StatusView extends JPanel implements IGameView
{
  private JLabel m_status = new JLabel();
  private JLabel m_encouragement = new JLabel();
  List<IGameObject> m_objects;
  public StatusView(List<IGameObject> objects)
  {
    m_objects = objects;
    setLayout(new BorderLayout());
    m_status.setText("");
    m_encouragement.setText("You can do it!");
    add(m_encouragement, BorderLayout.EAST);
    add(m_status, BorderLayout.CENTER);
  }

  @Override
  public void tick()
  {
    if (m_objects.size()> 1)
    {
        m_status.setText(String.format("X: %s Y:%s <3:%s Score:%s",
          m_objects.get(0).getX(), m_objects.get(0).getX(),
            m_objects.get(0).getLives(), m_objects.get(0).getScore()));
    }
  }

  @Override
  public JPanel getJPanel()
  {
    return this;
  }
}
