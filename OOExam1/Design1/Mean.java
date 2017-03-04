public class Mean implements IGrader
{
    protected int[] m_grades;
    
    public Mean(int[] grades)
    {
        m_grades = grades;
    }
    
    @Override
    public double grade()
    {
        return average();
    }
    
    protected double average()
    {
        double sum = 0.0;
        for (int i : m_grades)
            sum += i;
        return sum/m_grades.length;
    }
}