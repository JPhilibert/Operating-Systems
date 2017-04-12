import java.util.LinkedList;

public abstract class Swapper implements ISwapper
{
    protected LinkedList memory = new LinkedList();
    
    public void init(int memSize)
    {
        memory.add(new Node(memSize));
    }
    
    public void unload(IProcess p, IMemory mem) throws BlueScreenException
    {
        for(int i = 0; i < memory.size(); i++)
        {
            if(p.getID() == memory.get(i).getID())
            {
                memory.get(i).clear();
            }
        }
        
        cleanMemory();
        mem.unload(p);
    }
    
    private void cleanMemory()
    {
        //iterate through memory, combine holes, restart until complete
        boolean allClean = false;
        
        while(!allClean)
        {  
            allClean = true;
            for(int i = 0; i < memory.size(); i++)
            {
                if(memory.get(i).checkOpen() && memory.get(i+1).checkOpen())
                {
                    memory.get(i).add(memory.get(i+1).checkSize());
                    memory.remove(i+1);//i feel terrible about this. when something goes wrong, its this.
                    allClean = false;
                }
            }
        }
    }
}