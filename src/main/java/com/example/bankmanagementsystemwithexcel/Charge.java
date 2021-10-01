package com.example.bankmanagementsystemwithexcel;

import java.util.Scanner;

import org.apache.commons.math3.analysis.function.Cos;

public class Charge {
    private String Date, Time, Token, Store;
    private double Cost;

    public Charge() {

    }

    public Charge(String Date, String Time, String Token, double Cost, String Store) {
        this.Date = Date;
        this.Time = Time;
        this.Token = Token;
        this.Cost = Cost;
        this.Store = Store;
    }

    public String getDate() {
        return this.Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return this.Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getToken() {
        return this.Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public double getCost() {
        return this.Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public String getStore() {
        return this.Store;
    }

    public void setStore(String Store) {
        this.Store = Store;
    }

    public String tokenCheck() {
        boolean check = false;
        Scanner tokenScanner = new Scanner(System.in);
        while (!check) {
            System.out.println("\nSelect Bank Account\n" + "1.Checking\n" + "2.Savings\n" + "3.Business\n"
                    + "\nType: \"STOP\" to stop the program");
            Token = tokenScanner.nextLine();
            if (Token.toUpperCase().equals("STOP")) {
                System.out.println("\nExiting Program");
                System.exit(0);
            }

            Boolean flag = true;

            for (int a = 0; a < Token.length(); a++) {
                if (!Character.isDigit(Token.charAt(a))) {
                    flag = false;
                    System.out.println("\nIncorrect input.\nPlease Select from the give selections\n");
                    break;
                }
            }
            if (flag) {
                // int temp = Integer.valueOf(Token);
                switch (Token) {
                    case "1":
                        Token = "Checkings";
                        check = true;
                        break;
                    case "2":
                        Token = "Savings";
                        check = true;
                        break;

                    case "3":
                        Token = "Business";
                        check = true;
                        break;
                    default:
                        System.out.println("\nIncorrect input.\nPlease Select from the give selections\n");
                        break;
                }
            }
        }
        return Token;
    }

    public double costToken() {
        Scanner costScanner = new Scanner(System.in);
        boolean check = false;
        System.out.println("\nEnter Charge $:");
        while (!costScanner.hasNextDouble()) {
            System.out.println("\nInvalid input\nType the double-type number:");
            costScanner.next();
            System.out.println("\nEnter Charge $:");
        }
        Cost = costScanner.nextDouble();
        return Cost;
    }

    public String storeToken() {
        Scanner storeScanner = new Scanner(System.in);
        System.out.println("\nEnter Store");
        Store = storeScanner.nextLine();
        return Store;
    }

    @Override
    public String toString() {
        return "{" + " Date='" + getDate() + "'" + ", Time='" + getTime() + "'" + ", Token='" + getToken() + "'"
                + ", Store='" + getStore() + "'" + ", Cost='" + getCost() + "'" + "}";
    }

}
