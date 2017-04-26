import java.util.*;
import java.util.concurrent.*;

public class NumberSorter implements Callable
{
    private List<Integer> m_block_1;
    private List<Integer> m_block_2;
    
    public NumberSorter(List<Integer> block_1, List<Integer> block_2)
    {
        m_block_1 = block_1;
        m_block_2 = block_2;
    }
    
    @Override
    public List<Integer> call()
    {
        return sortLists();
    }
    
    public List<Integer> sort()
    {
        return sortLists();
    }
    
    private List<Integer> sortLists()
    {
        List<Integer> out = new ArrayList<Integer>();
        
        while(!m_block_1.isEmpty() && !m_block_2.isEmpty())
        {
            if(m_block_1.get(0) < m_block_2.get(0))
            {
                out.add(m_block_1.get(0));
                m_block_1.remove(0);
                
            }else{
                out.add(m_block_2.get(0));
                m_block_2.remove(0);
            }
        }
        if(m_block_1.isEmpty())
        {
            out.addAll(m_block_2);
        }else{
            out.addAll(m_block_1);
        }
        
        return out;
    }
}