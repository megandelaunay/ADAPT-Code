
/**
 * ADAPT Model Code
 * 
 * @author Megan DeLaunay
 * @version 1/28/13
 */
public class Model
{
    private int WMS; 
    private int position = 0;
    private String number;
    private Frame frame = new Frame();
    

    public Model(String n)
    {
        number = n;
    }

    public String transcode()
    {
        String[] array = number.split(" ");

        for(int i = 0; i < array.length; i++)
        {
            String word = array[i];
            //System.out.println(word);

            if(word.equals("hundred") || word.equals("thousand") || word.equals("million") || word.equals("billion"))
            {

                transcodeScale(word);

            }
            else if(word.endsWith("ty") || word.equals("ten")) //will be a number decade
            {
                if((i < array.length-1 && array[i+1].equals("million")) || (i < array.length - 2 && array[i+2].equals("million")))
                {
                    transcodeDecadeMillion(word);
                }
                else if((i < array.length-1 && array[i+1].equals("thousand")) || (i < array.length - 2 && array[i+2].equals("thousand")))
                {
                    transcodeDecadeThousand(word);
                }
                else
                {
                    transcodeDecade(word);
                }
            }
            else if(word.equals("eleven") || word.equals("twelve") || word.endsWith("teen"))
            {

                transcodeTeen(word);

            }
            else //will be a digit
            {

                transcodeDigit(word);

            }

        }

        if(WMS != 0)
        {
            //System.out.println(j);
            if(frame.size != null)
            {
                frame.setNumber(frame.length - 1, WMS);
            }
            else
            {
                System.out.println(Integer.toString(WMS));
                return Integer.toString(WMS);
            }
            //frame.print();
        }

        WMS = 0;
        return frame.print();
    }

    private void transcodeScale(String word)
    {

        if(frame.size != null)
        {
            //need to deal with overlap here.

            Frame frame2 = new Frame(word, WMS);

            if(frame.length > frame2.length) //overlap
            {
                Frame.overlap(frame, frame2);
            }
            else if (frame2.length > frame.length) //concat
            {
                Frame.merge(frame, frame2);
            }

            //to make hundred thousand work, need to say that like if
            
            WMS = 0;

        }

        else if(WMS != 0)
        {
            frame = new Frame(word, WMS);
            WMS = 0;

        }
        else
        {
            frame = new Frame(word);

        }

        //frame.print();
        position++;
    }

    int i = 0;
    
    private void transcodeDecade(String word)
    {
        
        
        if(word.equals("ten"))
        {
            WMS = 1;
        }
        else if(word.equals("twenty"))
        {
            WMS = 2;
        }
        else if(word.equals("thirty"))
        {
            WMS = 3;
        }
        else if(word.equals("forty"))
        {
            WMS = 4;
        }
        else if(word.equals("fifty"))
        {
            WMS = 5;
        }
        else if(word.equals("sixty"))
        {
            WMS = 6;
        }
        else if(word.equals("seventy"))
        {
            WMS = 7;
        }
        else if(word.equals("eighty"))
        {
            WMS = 8;
        }
        else if(word.equals("ninety"))
        {
            WMS = 9;
        }
        else
        {
            System.out.println("wrong");
        }

        if(frame.size == null)
        {
            frame = new Frame("decade", WMS);
            WMS = 0;
        }
        else
        {
            
            frame.setNumber(frame.length - 2, WMS); //THIS IS WHERE ERROR STARTS. 
            position++;
            WMS = 0;
           
        }

    }
    
    private void transcodeDecadeMillion(String word)
    {
        if(word.equals("ten"))
        {
            WMS = 1;
        }
        else if(word.equals("twenty"))
        {
            WMS = 2;
        }
        else if(word.equals("thirty"))
        {
            WMS = 3;
        }
        else if(word.equals("forty"))
        {
            WMS = 4;
        }
        else if(word.equals("fifty"))
        {
            WMS = 5;
        }
        else if(word.equals("sixty"))
        {
            WMS = 6;
        }
        else if(word.equals("seventy"))
        {
            WMS = 7;
        }
        else if(word.equals("eighty"))
        {
            WMS = 8;
        }
        else if(word.equals("ninety"))
        {
            WMS = 9;
        }
        else
        {
            System.out.println("wrong");
        }

        
            
            frame.setNumber(frame.length-8, WMS); //THIS IS WHERE ERROR STARTS. 
            position++;
            WMS = 0;
           
        
    }
    
    private void transcodeDecadeThousand(String word)
    {
        if(word.equals("ten"))
        {
            WMS = 1;
        }
        else if(word.equals("twenty"))
        {
            WMS = 2;
        }
        else if(word.equals("thirty"))
        {
            WMS = 3;
        }
        else if(word.equals("forty"))
        {
            WMS = 4;
        }
        else if(word.equals("fifty"))
        {
            WMS = 5;
        }
        else if(word.equals("sixty"))
        {
            WMS = 6;
        }
        else if(word.equals("seventy"))
        {
            WMS = 7;
        }
        else if(word.equals("eighty"))
        {
            WMS = 8;
        }
        else if(word.equals("ninety"))
        {
            WMS = 9;
        }
        else
        {
            System.out.println("wrong");
        }

        
            
            frame.setNumber(frame.length - 5, WMS); //THIS IS WHERE ERROR STARTS. 
            position++;
            WMS = 0;
           
        
    }

    private void transcodeTeen(String word)
    {
        String fakeWord = "ten";
        transcodeDecade(fakeWord);

        if(word.equals("eleven"))
        {
            WMS = 1;
            word = "one";
        }
        else if(word.equals("twelve"))
        {
            WMS = 2;
            word = "two";
        }
        else if(word.equals("thirteen"))
        {
            WMS = 3;
            word = "three";
        }
        else if(word.equals("fourteen"))
        {
            WMS = 4;
            word = "four";
        }
        else if(word.equals("fifteen"))
        {
            WMS = 5;
            word = "five";
        }
        else if(word.equals("sixteen"))
        {
            WMS = 6;
            word = "six";
        }
        else if(word.equals("seventeen"))
        {
            WMS = 7;
            word = "seven";
        }
        else if(word.equals("eighteen"))
        {
            WMS = 8;
            word = "eight";
        }
        else if(word.equals("nineteen"))
        {
            WMS = 9;
            word = "nine";
        }
        else
        {
            System.out.println("wrong");
        }

        transcodeDigit(word);
    }

    private void transcodeDigit(String word)
    {
        if(word.equals("one"))
        {
            WMS = 1;
        }
        else if(word.equals("two"))
        {
            WMS = 2;
        }
        else if(word.equals("three"))
        {
            WMS = 3;
        }
        else if(word.equals("four"))
        {
            WMS = 4;
        }
        else if(word.equals("five"))
        {
            WMS = 5;
        }
        else if(word.equals("six"))
        {
            WMS = 6;
        }
        else if(word.equals("seven"))
        {
            WMS = 7;
        }
        else if(word.equals("eight"))
        {
            WMS = 8;
        }
        else if(word.equals("nine"))
        {
            WMS = 9;
        }
        else
        {
            System.out.println("wrong");
        }
    }

    public String toString(Frame frame)
    {
        String num = frame.print();
        System.out.println(num);
        return num;
    }
}
