import java.util.*;
import java.io.*;

public class HomeRunTextRpt
{
    protected List<DataPair> reports = new ArrayList<DataPair>();
    protected File m_dataFile;
    protected BufferedWriter m_reportFile;
    
    public HomeRunTextRpt(String players, String output)
    {
        m_dataFile = new File(players);
        try
        {
          m_reportFile = new BufferedWriter(new FileWriter(output));
        }
        catch(IOException ioe)
        {
          ioe.printStackTrace();
        }
    }
    
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
                  statIn = Integer.parseInt(lineValue[1]);
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
    
    public void generateReport(List<DataPair> data) throws IOException
    {
      for(DataPair pair: reports)
      {
        m_reportFile.write(pair.getName() + "," + pair.getStat());
        m_reportFile.newLine();
      }
    }
}