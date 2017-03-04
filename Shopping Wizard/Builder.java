public class Builder
{
    private static Builder instance;
    
    public static Builder getInstance()
    {
        if(instance == null)
        {
            instance = new Builder();
        }
        return instance;
    }
    private Builder(){};
    
    public IDecision buildWizard()
    {//returns the starting question
        
        //snowboard branch
        Decision D1 = new Decision("Do you like to go fast?", null, null, "Buy the XG300 model", "Buy the XG200 model");
        Decision D2 = new Decision("Are you an expert?", D1, null, null, "Buy the XG200 model");
        Decision D3 = new Decision("Have you snowboarded before?", D2, null, null, "Buy the XG100 model");
        //ski branch
        Decision D4 = new Decision("Do you like to jump?", null, null, "Buy the ZR300 model", "Buy the ZR200 model");
        Decision D5 = new Decision("Are you an expert?", D4, null, null, "Buy the ZR200 model");
        Decision D6 = new Decision("Have you gone skiing before?", D5, null, null, "Buy the ZR100 model");
        Decision D7 = new Decision("Do you want to buy downhill skis?", D6, null, null, "Why are you here then?");
        //starting question
        Decision D8 = new Decision("Do you want to buy a snowboard?", D3, D7, null, null);
        
        return D8;
    }
}