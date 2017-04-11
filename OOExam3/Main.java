import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        new Main().go();
    }
    
    public void go()
    {
        List<String> words = CrosswordMaker.getInstance().selectWords(
            PickerFactory.getInstance().makePicker(), 10, "words.txt");
            
        System.out.println("Include these words in your crossword:");
        System.out.println(words);
    }
}