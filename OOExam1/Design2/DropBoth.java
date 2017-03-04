import java.util.*;

public class DropBoth implements IFilter
{
    @Override
    public int[] filter(int[] ary)
    {
        int[] copy = new int[ary.length-2];
        Arrays.sort(ary);
        for (int i = 1; i < ary.length-1; i++)
            copy[i-1] = ary[i];
        return copy;
    }
}