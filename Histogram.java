/*
Title: Histogram.java
Abstract: This program receives a user input to create a histogram of input length. It then receives the inputs and
prints out the number of stars corresponding to the number of occurrences per input.
Author: Alec Ortega
Date: 09/08/2021
*/
import java.util.*;
public class Histogram
{
    static int duplicateRemoval(int arr[],int o)
    {
        int[] occ = new int[o];
        int counter = 0;
        for (int i = 0; i < o - 1; i++)
        {
            if (arr[i] != arr[i + 1])
            {
                occ[counter++] = arr[i];
            }
        }
        occ[counter++] = arr[o-1];
        for (int i =0; i < counter;i++)
        {
            arr[i] = occ[i];
        }
        return counter;
    }
    public static void main(String[] args)
    {
        int input;
        Scanner kbd = new Scanner(System.in);
        int number;
        int occurMax = 0;
        int bars = 0;
        int occ;

        try {
            System.out.println("How many input values [max: 30]? ");
            input = kbd.nextInt();
            int[] numbers = new int[input];
            if (input < 0 || input > 30)
            {
                System.out.println("Input exceeds max value permitted.");
                System.exit(-1);
            } else
            {
                System.out.println("Enter " + input + " numbers.");
                for (int i = 0; i < input; i++) //stores input into numbers array
                {
                    number = kbd.nextInt();
                    numbers[i] = number;
                }
                System.out.println();
                System.out.print("Number");
                System.out.println("    Occurrence");
                Arrays.sort(numbers);
                int counter = numbers[numbers.length-1]+1;
                int[] occList = new int[counter];
                for(int r:numbers)
                {
                    occList[r]++;
                    if(occList[r] > occurMax)
                    {
                        occurMax = occList[r];
                    }
                }
                for(int k = 0;k<occList.length;k++)
                {
                    if(occList[k]>=1)
                    {
                        System.out.println(+k+"           "+occList[k]);
                    }
                }
                occ = numbers.length;
                occ = duplicateRemoval(numbers,occ);
                System.out.print("========= Vertical Bar =========\n");
                for (int j = occurMax; j >= 1; j--)
                {
                    System.out.print("| " + j + " | ");
                    for(int k = 0; k<occList.length;k++)
                    {
                        if(occList[k]>=j)
                        {
                            System.out.print(" *");
                        }
                        else
                        {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
                do
                {
                    System.out.print("=");
                    bars++;
                }
                while (bars < 32);
                System.out.println();
                System.out.print("| N | ");
                for (int k = 0; k <= 9; k++)
                {
                    System.out.print(" " + k);
                }
                System.out.println();
                bars = 0;
                do {
                    System.out.print("=");
                    bars++;
                }
                while (bars < 32);
                System.out.println();
            }//end else
        }// end try
        catch(InputMismatchException e)
        {
            System.out.println("This is not a whole number.");
            System.out.println("Good bye.");
            System.exit(0);
        }//end catch
    }//main
}//end class
