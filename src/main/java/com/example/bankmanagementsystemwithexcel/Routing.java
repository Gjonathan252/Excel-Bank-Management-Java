package com.example.bankmanagementsystemwithexcel;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Routing extends writeMethods{
    private String Date, Time, Token, Store;
    private double Cost;
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
    DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public Routing() {
        this.Date = (df.format(now)).toString();
        this.Time = (tf.format(now).toString());
    }

    public void collectCharge(){
        System.out.println("\nInformation collection method called.");
        Charge chargeMethod = new Charge();
        Token = chargeMethod.tokenCheck();
        Cost = chargeMethod.costToken();
        Store = chargeMethod.storeToken();
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

    public DateTimeFormatter getDf() {
        return this.df;
    }

    public void setDf(DateTimeFormatter df) {
        this.df = df;
    }

    public DateTimeFormatter getTf() {
        return this.tf;
    }

    public void setTf(DateTimeFormatter tf) {
        this.tf = tf;
    }

    public LocalDateTime getNow() {
        return this.now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    
}

