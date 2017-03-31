import java.util.*;

public class WordReverse implements ICrypto
{
    private static WordReverse instance;
    
    public static WordReverse getInstance()
    {
        if(instance == null)
        {
            instance = new WordReverse();
        }
        return instance;
    }
    
    private WordReverse(){};
    
    public String encrypt(String message)
    {
        IMessageParser parser = Factory.getInstance().createParser(message);
        String rPhrase = "";
        
        for(int i = 0; i < parser.getWordCount(); i++)
        {
            String rWord = "";
            for (int j = parser.getWord(i).length() - 1; j >= 0; j--)
            {
                rWord += parser.getWord(i).charAt(j);
            }
            rPhrase += rWord+" ";
        }
        return rPhrase;
    }
    
    public String decrypt(String message)
    {
        IMessageParser parser = Factory.getInstance().createParser(message);
        String rPhrase = "";
        
        for(int i = 0; i < parser.getWordCount(); i++)
        {
            String rWord = "";
            for (int j = parser.getWord(i).length() - 1; j >= 0; j--)
            {
                rWord += parser.getWord(i).charAt(j);
            }
            rPhrase += rWord+" ";
        }
        return rPhrase;
    }
}