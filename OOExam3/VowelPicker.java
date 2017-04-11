public class VowelPicker implements IWordPicker
{
    @Override
    public boolean approveWord(String word)
    {
        int vowelCount = 0;
        int consCount = 0;
        char[] checkAry = word.toUpperCase().toCharArray();
        for(char c : checkAry)
        {
            if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            {
                vowelCount++;
            }else{
                consCount++;
            }
        }
        if(consCount*3 < vowelCount){
            return false;
        }else{
            return true;
        }
    }
}