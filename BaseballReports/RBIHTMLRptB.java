import java.util.*;
import java.io.*;

public class RBIHTMLRptB extends HomeRunHTMLRpt
{
    public RBIHTMLRptB(String players, String output)
    {
        super(players, output);
    }
    
    @Override
    public List<DataPair> loadData()
    {
        try
          {
            BufferedReader reader = new BufferedReader(new FileReader(m_dataFile));
            String line;
            while ((line = reader.readLine()) != null)
            {
                //string format: name,homeruns,rbis
                String[] lineValue = line.split(",",-1);
                String nameIn = lineValue[0];
                int statIn;
                try{
                  statIn = Integer.parseInt(lineValue[2]);
                }
                catch(NumberFormatException e)
                {
                  statIn = 0;
                }
                DataPair input = new DataPair(nameIn, statIn);
                reports.add(input);
            }
            reader.close();
            return reports;
          }
          catch (Exception e)
          {
            e.printStackTrace();
            return null;
          }
    }    
}

