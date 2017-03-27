import java.io.*;

public class DiffCalculator
{
    private List<String> sequence= new ArrayList<String>();
    
    public static void main(String[] args)
    {
        new DiffCalculator().go();
    }
    
    public void go()
    {
        populateSequence();
        for(String s : sequence)
        {
            String[] split = s.split(",");
            IDiffAlg count = new CountAlg(split[0],split[1]);
            IDiffAlg weighted = new WeightedOrderAlg(split[0],split[1]);
            IDiffAlg order = new OrderAlg(split[0],split[1]);
            System.out.println()
            
        }
        
    }
    
    public void populateSequence()
    {
        FileReader reader = new FileReader("Sequences.txt");
        BufferedFileReader bufferedReader = new BufferedFileReader(reader);
        String line = null;
        while((line = bufferedReader.readLine() != null)
        {
            
        }
    }
}