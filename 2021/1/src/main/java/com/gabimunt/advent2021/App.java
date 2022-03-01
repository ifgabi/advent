package com.gabimunt.advent2021;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        first();
        second();
    }

    private static void first()
    {
        File file = new File(App.class.getResource("/input.txt").getFile());
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            int previous = 0;
            int count = 0;
            String line;
            while((line = reader.readLine()) != null)
            {
                int value = Integer.parseInt(line);
                if(previous != 0)
                {
                    if(value > previous)
                        count++;
                }
                previous = value;

            }
            
            System.out.println("COUNT: " + count);

            reader.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void second()
    {
        File file = new File(App.class.getResource("/input.txt").getFile());
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            int buffer[] = new int[3];
            int bufferIndex = 0;
            int bufferValuesCount = 0;
            
            int windowIndex = 0;
            int sum = 0;
            int prevSum = 0;
            int increasedSumCount = 0;

            String line;
            while(true)
            {
                line = reader.readLine();
                int value = 0;
                if(line != null)
                    value = Integer.parseInt(line);
                else
                    value = 0;//I needed a blank iteration at the end :)
                
                
                if(bufferValuesCount > 2)
                {
                    sum = buffer[(bufferIndex + 0) % 3] + buffer[ (bufferIndex + 1) % 3] + buffer[(bufferIndex + 2) % 3];
                    System.out.println(windowIndex + ": " + sum);

                    if(prevSum > 0)
                    {
                        if(sum > prevSum)
                        {
                            increasedSumCount++;
                        }
                    }

                    windowIndex++;
                    prevSum = sum;
                }
                
                buffer[bufferIndex] = value;
                bufferValuesCount++;
                bufferIndex++;
                bufferIndex = bufferIndex % 3;

                if(line == null)
                    break;
            }


            System.out.println(increasedSumCount);

            reader.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
