import java.util.*;
public class MeanDropBoth extends Mean
{
    public MeanDropBoth(int[] grades)
    {
        super(grades);
    }
    
    @Override
    public double grade()
    {
        int[] copy = new int[m_grades.length-2];
        Arrays.sort(m_grades);
        for (int i = 1; i < m_grades.length-1; i++)
            copy[i-1] = m_grades[i];
        m_grades = copy;
        return average();
    }
}