//megan, to make the decades work, create 2 LTM arrays (one words one numbers) and search the LTM
//for the number words of digits, 11-19, and decade words and then its position in the word array
//should correspond to the position in the number array and transcode like that!
//should just be like eighty --> 8 maybe? that'd be cool! then decade 0 works out

//still need to do something weird with 11-19.. thinking on this one! 

import java.util.*;

/**
 * ADAPT Model Code - Frame Class
 * 
 * @author Megan DeLaunay
 * @version 1/28/13
 */
public class Frame
{
    //instance variables
    int[] frame;
    String size;
    int length;

    public Frame()
    {
        frame = null;
    }
    
    public Frame(Frame f)
    {
        frame = f.frame;
        size = f.size;
        length = f.length;
        
    }
    
    public Frame(String s)
    {
        size = s;
        
        if(s.equals("hundred"))
        {
            frame = new int[2];
            size = s;
            length = 2;
        }
        else if(s.equals("thousand"))
        {
            frame = new int[3];
            size = s;
            length = 3;
        }
        else if(s.equals("million"))
        {
            frame = new int[6];
            size = s;
            length = 6;
        }
        else if(s.equals("billion"))
        {
            frame = new int[9];
            size = s;
            length = 9;
        }
    }
    
    public Frame(String s, int n)
    {
        if(s.equals("hundred"))
        {
            frame = new int[3];
            frame[0] = n;
            size = s;
            length = 3;
        }
        else if(s.equals("thousand"))
        {
            frame = new int[4];
            frame[0] = n;
            size = s;
            length = 4;
        }
        else if(s.equals("million"))
        {
            frame = new int[7];
            frame[0] = n;
            size = s;
            length = 7;
        }
        else if(s.equals("billion"))
        {
            frame = new int[10];
            frame[0] = n;
            size = s;
            length = 10;
        }
        else if(s.equals("decade"))
        {
            frame = new int[2];
            frame[0] = n;
            size = s;
            length = 2;
        }
    }
    
    public void setNumber(int position, int number)
    {
        //should position go from left to right or right to left like a number?
        
        if(number > 9)
        {
            System.out.println("Cannot add a number more than one digit to each frame place");
        }
        
        frame[position] = number;
    }
    
    public int getNumber(int position)
    {
        return frame[position];
    }
    
    //will work as long as the algorithm works to fill in all zeros at one time, not just place by place
    //not needed! array is initialized to all zeros.
    public void setZero()
    {
        for(int i = 0; i < frame.length; i++)
        {
            if(frame[i] == 0)//check
            {
                frame[i] = 0;
            }
        }
    }
    
    //will stick a frame to the right of the exisiting frame
    public static void merge(Frame frame1, Frame frame2)
    {
        //need to place two frame next to each other.
        
        int n = frame1.length;
        int m = frame2.length;
        
        int[] f = new int[n+m-1];
        
        for(int i = 0; i < frame1.length-1; i++)
        {
            f[i] = frame1.frame[i];
        }
        
        int k = frame1.length-1;
        
        //for(int j = 0; j < newFrame.length-1; j++)
        //{
            
            
            //for(int k = 2; k < f.length; k++)
            //{
                f[k] = frame2.frame[0];
            //}
            
            
        //}
        
        frame1.frame = f;
        frame1.length = f.length;
        frame1.size = frame1.size + " " + frame2.size;
    }
    
    //will put a frame on top of the exisitng frame (for example, hundred on million frame)
    public static void overlap(Frame bigFrame, Frame littleFrame)
    {
        if((littleFrame.size).equals("hundred") && (bigFrame.size.equals("hundred thousand")))
        {
            int num = littleFrame.getNumber(0);
            //setNumber(3, num);
            bigFrame.frame[3] = num;
        }
        else if((littleFrame.size).equals("hundred") && (bigFrame.size.equals("decade thousand")))
        {
            int num = littleFrame.getNumber(0);
            //setNumber(3, num);
            bigFrame.frame[2] = num;
        }
        else if((littleFrame.size).equals("hundred"))
        {
            int num = littleFrame.getNumber(0);
            //setNumber(1, num);
            bigFrame.frame[1] = num;
        }        
        else //if ((littleFrame.size).equals("thousand"))
        {
            int num = littleFrame.getNumber(0);
            bigFrame.frame[bigFrame.length -4] = num;
            //setNumber((bigFrame.length - 4), num);
        }
        
    }
    
    public String print()
    {
        String s = new String();
        
        for(int i = 0; i < frame.length; i++)
        {
            String num = Integer.toString(frame[i]);
            s = s + num;
        }
        
        System.out.println(s);
        return s;
    }
}
