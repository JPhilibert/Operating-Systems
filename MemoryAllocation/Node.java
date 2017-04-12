public class Node
{
    private int m_size;
    private boolean m_isOpen;
    
    public Node(int size, boolean isOpen)
    {
        m_size = size;
        m_isOpen = isOpen;
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
    
}