package com.gabimunt.advent2021;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.lang.model.util.ElementScanner14;

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

            String line = reader.readLine();
            int[] gammaOneCount = new int[line.length()];
            int[] epsilonOneCount = new int[line.length()];

            boolean[] gamma = new boolean[line.length()];
            boolean[] epsilon = new boolean[line.length()];

            boolean[] value = new boolean[line.length()];
            do
            {
                for(int i = 0; i < value.length; i++)
                {
                    value[i] = line.charAt(i) == '1';
                    gammaOneCount[i] += (value[i] == true) ? 1 : -1;
                    epsilonOneCount[i] += (value[i] == true) ? 1 : -1;
                }

            }while((line = reader.readLine()) != null);

            reader.close();

            String gammaStr = "";
            String epsilonStr = "";
            for(int i = 0; i < gammaOneCount.length; i++)
            {
                //higher than 0 means 1 is most common
                //one is most common on column i
                if(gammaOneCount[i] > 0)
                    gamma[i] = true;
                else
                    gamma[i] = false;
                //higher than 0 means 1 is most common
                //lower than 0 means 1 is the least common
                if(epsilonOneCount[i] < 0)
                    epsilon[i] = true;
                else
                    epsilon[i] = false;

                gammaStr += gamma[i] == true ? "1" : "0";
                epsilonStr += epsilon[i] == true ? "1" : "0";
            }

            int gammaNumber = toDecimal(gamma);
            int epsilonNumber = toDecimal(epsilon);

            int multiple = gammaNumber * epsilonNumber;

            System.out.println(gammaNumber + ": " + gammaStr);
            System.out.println(epsilonNumber + ": " + epsilonStr);

            System.out.println(multiple);


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

            List<String> initial = reader.lines().collect(Collectors.toList());

            List<String> generatorKept = List.copyOf(initial);
            int generator = -1;
            List<String> scrubberKept = List.copyOf(initial);
            int scrubber = -1;
            int digit = 0;
            int maxDigit = initial.get(0).length();
            while(digit != maxDigit)
            {
                final int fdigit = digit;
                List<String> generatorOneBitValues = 
                generatorKept.stream()
                    .filter(value -> value.charAt(fdigit) == '1')
                    .collect(Collectors.toList());

                List<String> generatorZeroBitValues = 
                generatorKept.stream()
                    .filter(value -> value.charAt(fdigit) == '0')
                    .collect(Collectors.toList());

                if(generatorOneBitValues.size() > generatorZeroBitValues.size())
                {
                    generatorKept = List.copyOf(generatorOneBitValues);
                }
                else if(generatorOneBitValues.size() < generatorZeroBitValues.size())
                {
                    generatorKept = List.copyOf(generatorZeroBitValues);
                }
                else
                {
                    generatorKept = List.copyOf(generatorOneBitValues);
                }

                List<String> scrubberOneBitValues = 
                scrubberKept.stream()
                    .filter(value -> value.charAt(fdigit) == '1')
                    .collect(Collectors.toList());

                List<String> scrubberZeroBitValues = 
                scrubberKept.stream()
                    .filter(value -> value.charAt(fdigit) == '0')
                    .collect(Collectors.toList());

                if(scrubberOneBitValues.size() > scrubberZeroBitValues.size())
                {
                    scrubberKept = List.copyOf(scrubberZeroBitValues);
                }
                else if(scrubberOneBitValues.size() < scrubberZeroBitValues.size())
                {
                    scrubberKept = List.copyOf(scrubberOneBitValues);
                }
                else
                {
                    scrubberKept = List.copyOf(scrubberZeroBitValues);
                }

                if(generatorKept.size() == 1)
                {
                    generator = toDecimal(stringToBinary(generatorKept.get(0)));
                    System.out.println("GENERATOR: " + generator);
                    //break;
                }

                if(scrubberKept.size() == 1)
                {
                    scrubber = toDecimal(stringToBinary(scrubberKept.get(0)));
                    System.out.println("SCRUBBER: " + scrubber);
                    //break;
                }

                digit++;

            }

            int multiple = scrubber * generator;

            System.out.println("MULTIPLE: " + multiple);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean[] stringToBinary(String value)
    {
        boolean[] result = new boolean[value.length()];

        for(int i = 0; i < value.length(); i++)
        {
            result[i] = value.charAt(i) == '1'? true: false;
        }

        return result;
    }

    private static int toDecimal(boolean[] number)
    {
        int resultNumber = 0;
        for(int i = 0; i < number.length; i++)
            resultNumber += Math.pow(2, number.length - i -1) * (number[i] == true ? 1 : 0);

        return resultNumber;
    }

    // private static boolean[][];
}
