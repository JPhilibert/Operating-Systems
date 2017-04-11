import java.util.*;
import java.io.*;

public class CrosswordMaker
{
    private static CrosswordMaker m_instance;
    public static CrosswordMaker getInstance()
    {
        if (m_instance == null)
            m_instance = new CrosswordMaker();
        return m_instance;
    }
    private CrosswordMaker() {}
    
    public List<String> selectWords(IWordPicker picker, int wordCount, 
        String wordFile)
    {
        List<String> words = new ArrayList<String>();
        List<String> choices = new ArrayList<String>();
        try (BufferedReader in = new BufferedReader(new FileReader(wordFile))) 
        {
            String line = in.readLine();
            while (line != null)
            {
                choices.add(line);
                line = in.readLine();
            }
        }
        catch (IOException e)
        {
            throw new Error(e);
        }
        
        Collections.shuffle(choices);
        int count = 0;
        for (String choice : choices)
        {
            if (picker.approveWord(choice))
            {
                count++;
                words.add(choice);
            }
            if (count == wordCount)
                break;
        }

        return words;
    }
}