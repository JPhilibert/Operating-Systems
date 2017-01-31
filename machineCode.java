import java.util.Scanner;


public class MachineCode 
{
	public static void main(String[] args)
	{
		String[][] display = 
		{
			{"0H","0","0","0","0","","","","","","","",""},
			{"1H","0","0","0","1","","","","","","","",""},
			{"2H","0","0","1","0","","","","","","","",""},
			{"3H","0","0","1","1","","","","","","","",""},
			{"4H","0","1","0","0","","","","","","","",""},
			{"5H","0","1","0","1","","","","","","","",""},
			{"6H","0","1","1","0","","","","","","","",""},
			{"7H","0","1","1","1","","","","","","","",""},
			{"8H","1","0","0","0","","","","","","","",""},
			{"9H","1","0","0","1","","","","","","","",""},
			{"AH","1","0","1","0","","","","","","","",""},
			{"BH","1","0","1","1","","","","","","","",""},
			{"CH","1","1","0","0","","","","","","","",""},
			{"DH","1","1","0","1","","","","","","","",""},
			{"EH","1","1","1","0","","","","","","","",""},
			{"FH","1","1","1","1","","","","","","","",""}
		};
		Scanner file = new Scanner("file.txt");
		String input = "";
		int itTop = 0;
		int itBot = 15;
		boolean end = false;
		boolean error = false;

		while(!end && itBot+itTop < 16)
		{
			input = file.nextln();
			String[] parts = input.split("\\s");
			if(parts[0] == "LDA") //0000
			{
				display[itTop][5]= "0";
				display[itTop][6]= "0";
				display[itTop][7]= "0";
				display[itTop][8]= "0";
				itBot++;
				itTop++;
			}else if(parts[0] == "ADD") //0001
			{
				display[itTop][5]= "0";
				display[itTop][6]= "0";
				display[itTop][7]= "0";
				display[itTop][8]= "1";
				itBot++;
				itTop++;
			}else if(parts[0] == "SUB") //0010
			{
				display[itTop][5]= "0";
				display[itTop][6]= "0";
				display[itTop][7]= "1";
				display[itTop][8]= "0";
				itBot++;
				itTop++;
			}else if(parts[0] == "OUT") //1110
			{
				display[itTop][5]= "1";
				display[itTop][6]= "1";
				display[itTop][7]= "1";
				display[itTop][8]= "0";
				itTop++;
			}else if(parts[0] == "HLT") //1111
			{
				display[itTop][5]= "1";
				display[itTop][6]= "1";
				display[itTop][7]= "1";
				display[itTop][8]= "1";
				itTop++;
				end = true;
			}
			else if(parts[0] == "//")
			{

			}else{
				error = true;
				System.out.println("unknown input on line" + (itTop+1));
			}

			if(parts[1] != null){
				String binary = Integer.toString(parts[1], 2);
				char[] array = binary.toCharArray();
				if(array.length > 4)
				{
					System.out.println("number too large")
				}else{
					for(int i=0; i < 8; i++) {
						disply[itTop][i+9] = (String)array[i];
					}
				}
			}else{
				display[itTop][9]= "x";
				display[itTop][10]= "x";
				display[itTop][11]= "x";
				display[itTop][12]= "x";
			}
		}

		if(!end){
			System.out.println("memory full");
		}else{
			for(int i=1; i < itBot; i++){
				display[16-i][5] = 0;
				display[16-i][6] = 0;
				display[16-i][7] = 0;
				display[16-i][8] = 0;
				display[16-i][9] = 0;
			}
			if(itBot > 0) {
				display[15][10] = 0;
				display[15][11] = 0;
				display[15][12] = 1;
			}
			if(itBot > 1) {
				display[15][10] = 0;
				display[15][11] = 1;
				display[15][12] = 0;
				
			}
			if(itBot > 2) {
				display[15][10] = 0;
				display[15][11] = 1;
				display[15][12] = 1;
				
			}
			if(itBot > 3) {
				display[15][10] = 1;
				display[15][11] = 0;
				display[15][12] = 0;
				
			}
			if(itBot > 4) {
				display[15][10] = 1;
				display[15][11] = 0;
				display[15][12] = 1;
			}
			if(itBot > 5) {
				display[15][10] = 1;
				display[15][11] = 1;
				display[15][12] = 0;
			}
			if(itBot > 6) {
				display[15][10] = 1;
				display[15][11] = 1;
				display[15][12] = 1;
			}

			for(int i = 0;i< 15;i++){
				for(int k=0;k<13;k++){
					System.out.print(display[i][k]);
				}
				System.out.println("");
			}
		}
	}
}