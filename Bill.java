/*
Title: BillingDialog.java
Abstract: This program creates a new yourBill object and collects the following attributes to calculate
the bill of sale for the software house: hours worked, minutes worked, and a coupon code. It outputs the number of hours
worked, the rate per hour worked, and the amount due. If the correct coupon code is entered the rate is discounted, else
it is calculated as normal.
Author: Alec Ortega
Date: 09/09/2021
 */

import java.util.*;
public class Bill
{
    private int hours;
    private int minutes;
    private double rate;

    public void getHours()
    {
        hours = this.hours;
        minutes = this.minutes;
        rate = this.rate;
    }
    public void inputTimeWorked()
    {
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter number of full hours worked: ");
        hours = kbd.nextInt();
        System.out.print("Enter number of additional minutes worked: ");
        minutes = kbd.nextInt();
        System.out.println("Time worked: \n"+hours+" hours and "+minutes+" minutes");
    }
    public void updateFee()
    {
        int quarterRate  = 150;
        double workHours =  (hours*60)/15;
        double workMinutes = minutes/15;
        rate = quarterRate * (workHours+workMinutes);
    }
    public void outputBill()
    {
        Scanner kbd = new Scanner(System.in);
        String coupon = "1234";
        System.out.print("Enter a coupon number: ");
        String couponInput = kbd.nextLine();
        if (coupon.equals(couponInput))
        {
            System.out.println("Your coupon is valid. (10% discount)");
            System.out.println("Rate: $135.00 per quarter hour.");
            double quarterRate = 135.00;
            double workHours = (hours * 60) / 15;
            double workMinutes = minutes / 15;
            rate = quarterRate * (workHours + workMinutes);
            System.out.printf("Amount due: $%.2f\n", rate);
        }
        else
        {
            System.out.println("Rate: $150.00 per quarter hour");
            System.out.printf("Amount due: $%.2f\n", rate);
        }
    }


}
