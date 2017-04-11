public class FirstFit extends Swapper
{
    public boolean load(IProcess p, IMemory mem) throws BlueScreenException
    {
        int position = 0;
        
        for(int i = 0; i < memory.size(); i++)
        {
            if(memory.get(i).checkOpen() && memory.get(i).checkSize() > p.getSize())//if node is unoccupied and is large enough
            {
                mem.load(p, position, position+p.getSize());//call load method on the IMemory class
                memory.add(i, new Node(p.getSize(), false)); //insert new node for process
                memory.get(i+1).sub(p.getSize());//set the remaining open space 
                return true;
            }else{
                position += memory.get(i).checkSize();
            }
        }
        return false;
        
        
    }
}