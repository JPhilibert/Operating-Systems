public class MessageParser implements IMessageParser
{
    private List<String> m_words = new ArrayList<String>();
    private String m_msg;
    
    MessageParser(String msg)
    {
        m_msg = msg;
        String[] words = m_msg.split("\\s");
        for(String s : words)
        {
            m_words.add(s);
        }
    }
    public int getCharCount()
    {
        return m_msg.length;
    }
    public int getWordCount()
    {
        
    }
    public char getChar(int i);
    public String getWord(int i);
}