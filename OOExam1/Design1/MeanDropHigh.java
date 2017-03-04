import java.util.*;
public class MeanDropHigh extends Mean
{
    public MeanDropHigh(int[] grades)
    {
        super(grades);
    }
    
    @Override
    public double grade()
    {
        int[] copy = new int[m_grades.length-1];
        Arrays.sort(m_grades);
        for (int i = 0; i < m_grades.length-1; i++)
            copy[i] = m_grades[i];
        m_grades = copy;
        return average();
    }
}