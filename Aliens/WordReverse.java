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
        return message;
    }
    
    public String decrypt(String message)
    {
        return message;
    }
}