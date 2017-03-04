import java.util.*;
public class MedianDropLow extends Median
{
    public MedianDropLow(int[] grades)
    {
        super(grades);
    }
    
    @Override
    public double grade()
    {
        int[] copy = new int[m_grades.length-1];
        Arrays.sort(m_grades);
        for (int i = 1; i < m_grades.length; i++)
            copy[i-1] = m_grades[i];
        m_grades = copy;
        return median();
    }
}