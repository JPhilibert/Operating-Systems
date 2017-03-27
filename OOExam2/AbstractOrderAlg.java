public class AbstractOrderAlg implements IDiffAlg
{
    public int difference(String seq1, String seq2)
    {
        int penalty = 0;
        char[] seq1Ary = seq1.toCharArray();
        char[] seq2Ary = seq2.toCharArray();
        for(int i = 0; i < seq1Ary.length; i++)
        {
            penalty += getPenalty(seq1Ary[i], seq2Ary[i]);
        }
        return penalty;
        
    }
    
    abstract protected int getPenalty(char ch1, char ch2);
}