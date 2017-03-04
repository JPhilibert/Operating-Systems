import java.util.*;

public class Decision implements IDecision
{
    private String m_question;
    private IDecision m_yes;
    private IDecision m_no;
    private String m_yesTerminal;
    private String m_noTerminal;
    private Scanner input = new Scanner(System.in);
    
    public Decision(String question, IDecision yes, IDecision no, String yesTerminal, String noTerminal)
    {
        m_question = question;
        m_yes = yes;
        m_no = no;
        m_yesTerminal = yesTerminal;
        m_noTerminal = noTerminal;
    }
    
    public void setYes(IDecision yes)
    {
        m_yes = yes;
    }
    public void setNo(IDecision no)
    {
        m_no = no;
    }
    public void setYesTerminal(String terminal)
    {
        m_yesTerminal = terminal;
    }
    public void setNoTerminal(String terminal)
    {
        m_noTerminal = terminal;
    }
    public IDecision ask()
    {
        System.out.println(m_question + "(y/n)");
        String answer = input.nextLine();
        if(answer.equals("y")){
            if(m_yes == null){
                System.out.println(m_yesTerminal);
            }
            return m_yes;
            
        }else if(answer.equals("n")){
            if(m_no == null){
                System.out.println(m_noTerminal);
            }
            return m_no;
        }else{
            System.out.println("unknown input");
            return null;
        }
    }
}