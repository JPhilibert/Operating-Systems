import java.util.*;

public class DropLow implements IFilter
{
    @Override
    public int[] filter(int[] ary)
    {
        int[] copy = new int[ary.length-1];
        Arrays.sort(ary);
        for (int i = 1; i < ary.length; i++)
            copy[i-1] = ary[i];
        return copy;
    }
}