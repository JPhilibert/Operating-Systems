public class OrderAlg implements IDiffAlg extends AbstractOrderAlg
{
    private static OrderAlg instance;
    
    public static OrderAlg getInstance()
    {
        if(instance == null)
        {
            instance = new OrderAlg();
        }
        return instance;
    }
    private OrderAlg(){};
    
    protected int getPenalty(char ch1, char ch2)
    {
        if(ch1 == ch2){
            return 0;
        }else{
            return 1;
        }
        
    }
}