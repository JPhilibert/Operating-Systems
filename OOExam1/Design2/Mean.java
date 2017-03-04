public class Mean implements IGrader
{
    protected IFilter m_filter;
    protected int[] m_grades;
    
    public Mean(int[] grades, IFilter filter)
    {
        m_filter = filter;
        m_grades = grades;
        if(filter!=null){
            m_grades = m_filter.filter(grades);
        }
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