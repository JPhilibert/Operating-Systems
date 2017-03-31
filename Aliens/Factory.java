public class Factory
{
    private static Factory instance;
    
    public static Factory getInstance()
    {
        if(instance == null)
        {
            instance = new Factory();
        }
        return instance;
    }
    
    private Factory(){};
    
    public IMessageParser createParser(String text)
    {
        return new MessageParser(text);
    }
}