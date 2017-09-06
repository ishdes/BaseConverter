/*
 * Will do calculations to convert a number of given base to another number of another base. 
 */

import java.util.Scanner;
import java.lang.Math;
public class BaseConverter implements ConverterMethods
{    

    private String userInput;
    private int base;
    private int tobase;
    private String characters;
    Scanner s = new Scanner(System.in);

    public BaseConverter()
    {
        System.out.print("Enter number: ");
        userInput = (s.next()).toUpperCase();
        System.out.print("Enter current base: ");
        base = s.nextInt();
        System.out.print("Enter desired base: ");
        tobase = s.nextInt();
        characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }    
    
    public String getCharacters()
    {
        return characters;
    }
    
    public String getUserInput()
    {
        return userInput; 
    }
    
    public int getBase()
    {
        return base;
    }

    public int getToBase()
    {
        return tobase;
    }

    public int toDecimal()
    {
        String[] nums = new String[userInput.length()]; 
        int summer=0;
        for(int i=0;i<nums.length;i++)
        {
            nums[nums.length-1-i] = (userInput.substring(i,i+1));
        }
        for(int i=0;i<nums.length;i++)
        {
            summer+= ((int)(Math.pow((int)base,(int)i)))*characters.indexOf(nums[i]);
        }
        return summer;
    }

    public String toDesiredBase()
    {
        int deci = toDecimal();
        int counter = 0;
        int ret = 0;
        String retsum="";
        while( ((int) (Math.pow((int)tobase,(int)counter))) <= deci)
            counter++;
        counter=counter-1;
        for(int i=counter;i>=0;i--)
        {
            ret=(deci/ ((int) (Math.pow((int)tobase,(int)i))));
            deci = deci - (((int) (Math.pow((int)tobase,(int)i)))*ret);
            retsum += characters.substring(ret,ret+1);
        }
        return retsum;
    }

}
