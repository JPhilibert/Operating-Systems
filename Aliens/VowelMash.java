public class VowelMash implements ICrypto
{
    private static VowelMash instance;
    
    public static VowelMash getInstance()
    {
        if(instance == null)
        {
            instance = new VowelMash();
        }
        return instance;
    }
    
    private VowelMash(){};
    
    public String encrypt(String message)
    {
        IMessageParser parser = Factory.getInstance().createParser(message);
        String rPhrase = "";
        
        for(int i = 0; i < parser.getCharCount(); i++)
        {
            if(parser.getChar(i) == 'A'){
                rPhrase += 'E';
            }else if(parser.getChar(i) == 'E'){
                rPhrase += 'I';
            }else if(parser.getChar(i) == 'I'){
                rPhrase += 'O';
            }else if(parser.getChar(i) == 'O'){
                rPhrase += 'U';
            }else if(parser.getChar(i) == 'U'){
                rPhrase += 'A';
            }else{
                rPhrase += parser.getChar(i);
            }
        }
        return rPhrase;
    }
    
    public String decrypt(String message)
    {
        IMessageParser parser = Factory.getInstance().createParser(message);
        String rPhrase = "";
        
        for(int i = 0; i < parser.getCharCount(); i++)
        {
            if(parser.getChar(i) == 'A'){
                rPhrase += 'U';
            }else if(parser.getChar(i) == 'E'){
                rPhrase += 'A';
            }else if(parser.getChar(i) == 'I'){
                rPhrase += 'E';
            }else if(parser.getChar(i) == 'O'){
                rPhrase += 'I';
            }else if(parser.getChar(i) == 'U'){
                rPhrase += 'O';
            }else{
                rPhrase += parser.getChar(i);
            }
        }
        return rPhrase;
    }
}    
