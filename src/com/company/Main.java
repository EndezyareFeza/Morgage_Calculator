package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte months = 12;
        final byte percent = 100;
        int principal = 0;
        float monthlyInterest = 0;
        int numOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true){
        System.out.print("Principal: ");
        principal = scanner.nextInt();
        if(principal >= 1000 && principal <= 1_000_000)
            break;
            System.out.println("Enter a value between 1K and 1M");
        }
        while (true) {
            System.out.print("Annual Interest Rate (i.e. 3.92): ");
            float annualInterest = scanner.nextFloat();
            if(annualInterest >= 1 && annualInterest <= 30){
                monthlyInterest = annualInterest / (percent * months);
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numOfPayments = years * months;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments)) /
                (Math.pow(1 + monthlyInterest, numOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
