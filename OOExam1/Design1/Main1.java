public class Main1
{
    public static void main(String args[])
    {
        new Main1().go();
    }
    
    public void go()
    {
        int[] grades = new int[] {98, 67, 88, 88, 88, 82, 72, 96, 75, 89, 74, 81};
        
        IGrader grader = new Mean(grades);
        System.out.printf("Mean Grader: %.2f%n", grader.grade());
        grader = new MeanDropLow(grades);
        System.out.printf("Mean Drop Low Grader: %.2f%n", grader.grade());
        grader = new MeanDropHigh(grades);
        System.out.printf("Mean Drop High Grader: %.2f%n", grader.grade());
        grader = new MeanDropBoth(grades);
        System.out.printf("Mean Drop Both Grader: %.2f%n", grader.grade());

        grader = new Median(grades);
        System.out.printf("Median Grader: %.2f%n", grader.grade());
        grader = new MedianDropLow(grades);
        System.out.printf("Median Drop Low Grader: %.2f%n", grader.grade());
        grader = new MedianDropHigh(grades);
        System.out.printf("Median Drop High Grader: %.2f%n", grader.grade());
        grader = new MedianDropBoth(grades);
        System.out.printf("Median Drop Both Grader: %.2f%n", grader.grade());        
    }
    
}