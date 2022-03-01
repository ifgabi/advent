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
        File file = new File(App.class.getResource("/test.txt").getFile());
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line;
            int previous = 0;
            int count = 0;
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
}
