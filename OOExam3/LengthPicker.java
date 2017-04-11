import java.util.*;

public class LengthPicker implements IWordPicker
{
    @Override
    public boolean approveWord(String word)
    {
        return word.length() > 5;
    }
}