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

            String line;

            int forward = 0;
            int depth = 0;

            while((line = reader.readLine()) != null)
            {
                String direction = line.split(" ")[0];
                int value = Integer.parseInt(line.split(" ")[1]);
                switch(direction)
                {
                    case "forward":
                    forward+=value;
                    break;
                    case "up":
                    depth+=value;
                    break;
                    case "down":
                    depth-=value;
                    break;
                }

            }
            int multiple = Math.abs(forward * depth);
            System.out.println("MULTIPLE: " + multiple);

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

            String line;

            int aim = 0;
            int depth = 0;
            int horizontal = 0;

            while((line = reader.readLine()) != null)
            {
                String direction = line.split(" ")[0];
                int value = Integer.parseInt(line.split(" ")[1]);
                switch(direction)
                {
                    case "forward":
                    horizontal+=value;
                    depth+=aim*value;
                    break;
                    case "up":
                    aim+=value;
                    break;
                    case "down":
                    aim-=value;
                    break;
                }

            }
            int multiple = Math.abs(horizontal * depth);
            System.out.println("MULTIPLE: " + multiple);

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
