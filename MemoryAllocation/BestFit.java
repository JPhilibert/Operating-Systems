public class BestFit extends Swapper
{
    public boolean load(IProcess p, IMemory mem) throws BlueScreenException
    {
        int bestFit = 0;//best fit to insert node
        int position = 0;
        int space = Integer.MAX_VALUE;//wasted space
        
        for(int i = 0; i < memory.size(); i++)//find best position to insert
        {
            if(memory.get(i).checkSize() - p.getSize() < space && memory.get(i).checkSize() - p.getSize() >= 0)
            {
                space = memory.get(i).checkSize() - p.getSize();
                bestFit = position;
            }
            position += memory.get(i).checkSize();
        }
        
        if(space != Integer.MAX_VALUE)//if anything has been found, insert it
        {
            mem.load(p, position, position+p.getSize());//call load method on the IMemory class
            memory.add(i, new Node(p.getSize(), false)); //insert new node for process
            memory.get(i+1).sub(p.getSize());//set the remaining open space 
            return true;
        }else{
            return false;
        }
    }
}