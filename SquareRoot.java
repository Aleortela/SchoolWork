/*
Title: SquareRoot.java
Abstract: This program takes a user input and estimates the square root of said input.
Author: Alec Ortega
Date: 09/05/21
 */
import java.util.*;
public class SquareRoot
{
    public static void main(String[] args)
    {
        int number;
        double store1;
        double store2;
        int counter = 0;
        double approx;
        double answer;
        Scanner kbd = new Scanner(System.in);
        ArrayList decArray = new ArrayList();
        
            try {
                System.out.println("This program estimates square roots.");
                System.out.println("Please enter a whole number:");
                number = kbd.nextInt();
                approx = 0;
                if (number < 0)
                {
                    System.out.println("Please enter a whole number (number must be greater than or equal to 1):");
                    number = kbd.nextInt();
                    if (number < 0)
                    {
                        System.out.println("Goodbye.");
                        System.exit(-1);
                    }
                    else
                    {
                        store1 = (double) number / 2;    /*x0*/
                        System.out.println();
                        System.out.println("Initial guess: " + store1);
                        decArray.add(store1);        //x0  "1"
                        store2 = 0;
                        for (int i = 0; i < decArray.size(); i++)
                        {
                            store1 = (double) decArray.get(i);
                            store2 = ((store1 + (number / store1)) / 2);
                            decArray.add(store2);
                            approx = (store1 - store2) / store1;
                            counter++;
                            System.out.printf("Guess %d: %.6f\n", counter, store2);
                            if (approx < 0.01)
                            {
                                answer = (double) decArray.get(i + 1);
                                System.out.printf("The estimated square root of %d is %.2f\n", number, answer);
                                System.exit(0);
                            }
                        }
                    }
                }
                else
                {
                    store1 = (double) number / 2;    /*x0*/
                    System.out.println();
                    System.out.println("Initial guess: " + store1);
                    decArray.add(store1);//x0  "1"
                    store2 = 0;
                    for (int i = 0; i < decArray.size(); i++) {
                        store1 = (double) decArray.get(i);
                        store2 = ((store1 + (number / store1)) / 2);
                        decArray.add(store2);
                        approx = (store1 - store2) / store1;
                        counter++;
                        System.out.printf("Guess %d: %.6f\n", counter, store2);
                        if (approx < 0.01)
                        {
                            System.out.println();
                            answer = (double) decArray.get(i + 1);
                            System.out.printf("The estimated square root of %d is %.2f\n", number, answer);
                            System.out.println();
                            System.exit(0);
                        }
                    }
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter a whole number (no words, just numbers):");
                kbd.nextLine();
                number = kbd.nextInt();
                if (number < 0)
                {
                    System.out.println("Goodbye.");
                    System.exit(-1);
                }
                else
                {
                        store1 = (double) number / 2;    /*x0*/
                         System.out.println();
                        System.out.println("Initial guess: " + store1);
                        decArray.add(store1);//x0  "1"
                        store2 =0;
                        for(int i=0; i < decArray.size();i++)
                        {
                            store1 = (double) decArray.get(i);
                            store2 = ((store1+(number/store1))/2);
                            decArray.add(store2);
                            approx = (store1-store2)/store1;
                            counter++;
                            System.out.printf("Guess %d: %.6f\n",counter,store2);
                            if(approx < 0.01)
                            {
                                answer = (double)decArray.get(i+1);
                                System.out.printf("The estimated square root of %d is %.2f\n", number,answer);
                                System.exit(0);
                            }// end of approximation loop
                        } // end of catch for loop
                }//end  if else
            } // end of catch// end of while
    }// end of main
}// end of class
