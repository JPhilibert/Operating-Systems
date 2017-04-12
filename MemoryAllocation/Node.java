public class Node
{
    private int m_size;
    private int m_process;
    private int m_id;
    private boolean m_isOpen;
    
    public Node(IProcess p, boolean isOpen)
    {
        m_process = p;
        m_size = m_process.getSize();
        m_id = m_process.getID();
        m_isOpen = isOpen;
    }
    
    public Node(int size)
    {
        m_process = null;
        m_size = size;
        m_id = null;
        m_isOpen = true;
    }
    
    public void clear()
    {
        m_process = null;
        m_id = null;
        m_isOpen = true;
    }
    
    public void add(int i)
    {
        m_size += i;
    }
    
    public void sub(int i)
    {
        m_size -= i;
    }
    
    public boolean checkOpen()
    {
        return m_isOpen;
    }
    
    public int checkSize()
    {
        return m_size;
    }
    
    public int getID()
    {
        return m_processID;
    }
    
}