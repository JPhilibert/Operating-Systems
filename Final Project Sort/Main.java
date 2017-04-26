import java.util.*;
import java.util.concurrent.*;

public class Main
{
    private ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
    private final int n = 8;
    
    public static void main(String[] args) throws Exception
    {
        (new Main()).go();
    }
    
    private void go() throws Exception
    {
        for(int i = 0; i < n; i++)
        {
            ArrayList<Integer> random = new ArrayList<Integer>();
            random.add((int)(Math.random() * 50));
            
            nodes.add(random);
        }
        
        while(nodes.size()!=1)
        {
            List<Callable<ArrayList>> sorters = new ArrayList<Callable<ArrayList>>();
            ArrayList<ArrayList<Integer>> tempNodes = new ArrayList<ArrayList<Integer>>();
            
            
            for(int i = 0; i < nodes.size(); i+=2)
            {
                Callable<ArrayList> temp = new NumberSorter(nodes.get(i), nodes.get(i+1));
                sorters.add(temp);
            }
            
            ExecutorService executor = Executors.newFixedThreadPool(sorters.size());
            List<Future<ArrayList>> futures = executor.invokeAll(sorters);
            
            for (Future<ArrayList> f : futures)
            {
                tempNodes.add(f.get());
            }
            
            executor.shutdown();
            
            nodes = tempNodes;
            
            sorters.clear();
        }
        
        printArrayList(nodes.get(0));
        
        /*List<Integer> in1 = new ArrayList<Integer>();
        List<Integer> in2 = new ArrayList<Integer>();
        in1.add(1);
        in1.add(3);
        in1.add(5);

        in2.add(2);
        in2.add(4);
        in2.add(6);

        List<Integer> out = new NumberSorter(in1, in2).sort();
        for(int i = 0; i < out.size(); i++)
        {
            System.out.println(out.get(i));
        }*/
    }
    
    private void printArrayList(ArrayList n)
    {
        for(int i = 0; i < n.size(); i++)
        {
            System.out.println(n.get(i));
        }
    }
    
}