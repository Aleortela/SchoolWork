/*
Title: BillingDialog.java
Abstract: This program creates a new yourBill object and collects the following attributes to calculate
the bill of sale for the software house: hours worked, minutes worked, and a coupon code. It outputs the number of hours
worked, the rate per hour worked, and the amount due. If the correct coupon code is entered the rate is discounted, else
it is calculated as normal.
Author: Alec Ortega
Date: 09/09/2021
 */

public class BillingDialog {
  public static void main(String[] args) {
    System.out.println("Welcome to CSUMB software house!");
    Bill yourBill = new Bill();
    yourBill.inputTimeWorked();
    yourBill.updateFee();
    yourBill.outputBill();
    System.out.println("Thanks for doing business with us.");
  }
}