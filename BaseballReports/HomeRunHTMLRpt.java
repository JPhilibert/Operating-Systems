import java.util.*;
import java.io.*;

public class HomeRunHTMLRpt extends HomeRunTextRpt
{
    public HomeRunHTMLRpt(String players, String output)
    {
        super(players, output);
    }
    
    @Override
    public void generateReport(List<DataPair> data) throws IOException
    {
        m_reportFile.write("<html>\n<body>\n<table>\n");
        for(DataPair pair: reports)
        {
            m_reportFile.write("<tr><td>" + pair.getName() + "</td><td>" + pair.getStat() + "</td></tr>");
            m_reportFile.newLine();
        }
        m_reportFile.write("</table>\n</body>\n</html>");
    }
}

