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
    
    public String decrypt(String message)
    {
        char[] messageCharAry = message.toCharArray();
        for(char c : messageCharAry){
            if(c == 'A'){
                c = 'E';
                continue;
            }
            if (c == 'E'){
                c = 'I';
                continue;
            }
            if (c == 'I'){
                c = 'O';
                continue;
            }
            if (c == 'O'){
                c = 'U';
                continue;
            }
            if(c == 'U'){
                c = 'A';
                continue;
            }
        }
        System.out.println(String.valueOf(messageCharAry));
        return String.valueOf(messageCharAry);
    }
    
    public String encrypt(String message)
    {
        return message;
    }
}    
