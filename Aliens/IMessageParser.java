public interface IMessageParser
{
    private List<String> m_words;
    private String m_msg;
    
    MessageParser(String msg);
    public int getCharCount();
    public int getWordCount();
    public char getChar(int i);
    public String getWord(int i);
}