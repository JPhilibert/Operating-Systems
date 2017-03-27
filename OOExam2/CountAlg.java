public class CountAlg implements IDiffAlg
{
    private static CountAlg instance;
    
    public static CountAlg getInstance()
    {
        if(instance == null)
        {
            instance = new CountAlg();
        }
        return instance;
    }
    private CountAlg(){};
    
    public int difference(String seq1, String seq2)
    {
        int penalty = 0;
        char[] seq1Ary = seq1.toCharArray();
        char[] seq2Ary = seq2.toCharArray();
        for(int i = 0; i < seq1Ary.length; i++)
        {
            if(!seq1Ary[i] == seq2Ary[i]){
                penalty++;
            }
        }
        return penalty;
        
    }
}