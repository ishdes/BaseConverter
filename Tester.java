
/**
 * Will run BaseConverter program.
 */
import java.util.Scanner;
public class Tester
{
    public static void main(String args[])
    {
        boolean repeat = true; 
        Scanner s = new Scanner(System.in); 
        String ans="";
        while(repeat)
        {
            BaseConverter test = new BaseConverter();
            if(tooHighBase(test.getBase()))
            {
                System.out.println("Current base does not fall in the 2-36 range.\nPlease compile again and fit conditions.");
                break;
            }
            if(tooHighBase(test.getToBase()))
            {
                System.out.println("Base to be converted to does not fall in the 2-36 range.\nPlease compile again and fit conditions.");
                break;
            }
            if(!(numOverBase(test.getUserInput(),test.getBase())))
            {
                System.out.println("Bad input: Number can not occur with current Base\nCompile again with new input");
                break;
            }
            System.out.println("Base ten: "+test.toDecimal());
            System.out.println("Base "+test.getToBase()+": "+test.toDesiredBase());
            System.out.print("Would you like to keep converting? Yes or No?    :");
            ans = (s.next()).toUpperCase();
            if(ans.equals("YES"))
                repeat = true;
            else
                repeat = false;
        }
    }
    //To catch an error in user input and alert the user to re-enter numbers. 
    public static boolean numOverBase(String input, int base)
    {
        String charac="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0;i<input.length();i++)
        {
            if((input.substring(i,i+1).compareTo(charac.substring(base,base+1)))>=0)
                return false;
        }
        return true; 
    }
    //To check if either current base or to be converted to base are in 2-36 range.
    public static boolean tooHighBase(int num)
    {
        if(num>36||num<2)
            return true;
        return false;
    }
}

