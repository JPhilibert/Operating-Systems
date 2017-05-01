import java.util.*;
import java.io.*;
//factory is the one that reads in from a text file to determine object types
//Enemy options: Ball, Fish, Chair, Coke
//Hero options: Hero, Hero2
//StatusView options: StatusView, StatusView2
public class Factory implements IFactory
{
  private static IFactory m_instance;
  private static String[] classes;
  public static IFactory getInstance()
  {
    if (m_instance == null)
    {
      m_instance = new Factory();
      Scanner f = new Scanner(new File("Classes.txt"));
      String line = f.nextLine();
      classes = line.split(",");
    }

    return m_instance;
  }
  private Factory() {}

  @Override
  public IGameObject createEnemy1(int x, int y, int w, int h, int dX, int dY)
  {
    IGameObject o = null;
    try{
      //not sure if this is the best way to use a non-null constructor, but its what i got
      Class c = Class.forName(classes[0]);
      IGameObject o = (IGameObject) c.getDeclaredConstructor(Integer.class, Integer.class, Integer.class, 
        Integer.class, Integer.class, Integer.class).newInstance(x, y, w, h, dX, dY);
    }
    catch(Exception e){
      throw new Error("Unable to create Enemy1");
    }
    return o;
  }
  
  @Override
  public IGameObject createEnemy2(int x, int y, int w, int h, int dX, int dY)
  {
    IGameObject o = null;
    try{
      Class c = Class.forName(classes[1]);
      IGameObject o = (IGameObject) c.getDeclaredConstructor(Integer.class, Integer.class, Integer.class, 
        Integer.class, Integer.class, Integer.class).newInstance(x, y, w, h, dX, dY);
    }
    catch(Exception e){
      throw new Error("Unable to create Enemy2");
    }
    return o;
  }

  @Override
  public IGameObject createHero(int x, int y, int w, int h, int dX, int dY)
  {
    IGameObject o = null;
    try{
      Class c = Class.forName(classes[3]);
      IGameObject o = (IGameObject) c.getDeclaredConstructor(Integer.class, Integer.class, Integer.class, 
        Integer.class, Integer.class, Integer.class).newInstance(x, y, w, h, dX, dY);
    }
    catch(Exception e){
      throw new Error("Unable to create Hero");
    }
    return o;
  }

  @Override
  public IGameView createMainView(List<IGameObject> objects)
  {
    return new GameView(objects);
  }

  @Override
  public IGameView createStatusView(List<IGameObject> objects)
  {
    IGameObject o = null;
    try{
      Class c = Class.forName(classes[3]);
      //valid?
      //http://stackoverflow.com/questions/7502243/java-casting-class-operator-used-on-a-generic-type-e-g-list-to-classlist
      IGameObject o = (IGameObject) c.getDeclaredConstructor((Class<List<IGameObject>>)((Class)List.class)).newInstance(objects);
    }
    catch(Exception e){
      throw new Error("Unable to create StatusView");
    }
    return o;
  }

  @Override
  public IGameController createController(int interval, List<IGameObject> objects, List<IGameView> views)
  {
    return new GameController(interval, objects, views);
  }
}
