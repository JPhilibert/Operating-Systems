public class WeightedOrderAlg implements IDiffAlg extends AbstractOrderAlg
{
    private static WeightedOrderAlg instance;
    
    public static WeightedOrderAlg getInstance()
    {
        if(instance == null)
        {
            instance = new WeightedOrderAlg();
        }
        return instance;
    }
    private WeightedOrderAlg(){};
    
    protected int getPenalty(char ch1, char ch2)
    {
        if(ch1 != ch2)
        {
            if(ch1 == "A"){
                return 1;
            }
            if(ch1 == "C"){
                return 2;
            }
            if(ch1 == "G"){
                return 3;
            }
            if(ch1 == "T"){
                return 4;
            }
            
        }else{
            return 0;
        }
    }
}