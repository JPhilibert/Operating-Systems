import java.util.LinkedList;

public abstract class Swapper implements ISwapper
{
    private LinkedList memory = new LinkedList();
    
    public void init(int memSize)
    {
        memory.add(new Node(memSize, true));
    }
    
    public void unload(IProcess p, IMemory mem) throws BlueScreenException
    {
        mem.unload(p);
    }
}