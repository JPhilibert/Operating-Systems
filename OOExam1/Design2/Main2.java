public class Main2
{
    public static void main(String args[])
    {
        new Main2().go();
    }
    
    public void go()
    {
        int[] grades = new int[] {98, 67, 88, 88, 88, 82, 72, 96, 75, 89, 74, 81};
        
        IGrader grader = new Mean(grades, null);
        System.out.printf("Mean Grader: %.2f%n", grader.grade());
        grader = new Mean(grades, new DropLow());
        System.out.printf("Mean Drop Low Grader: %.2f%n", grader.grade());
        grader = new Mean(grades, new DropHigh());
        System.out.printf("Mean Drop High Grader: %.2f%n", grader.grade());
        grader = new Mean(grades, new DropBoth());
        System.out.printf("Mean Drop Both Grader: %.2f%n", grader.grade());

        grader = new Median(grades, null);
        System.out.printf("Median Grader: %.2f%n", grader.grade());
        grader = new Median(grades, new DropLow());
        System.out.printf("Median Drop Low Grader: %.2f%n", grader.grade());
        grader = new Median(grades, new DropHigh());
        System.out.printf("Median Drop High Grader: %.2f%n", grader.grade());
        grader = new Median(grades, new DropBoth());
        System.out.printf("Median Drop Both Grader: %.2f%n", grader.grade());
    }
    
}