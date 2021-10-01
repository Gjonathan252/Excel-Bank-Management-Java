package com.example.bankmanagementsystemwithexcel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BankingApp {
    public static void main(String[] args) throws IOException {       
        writeMethods excel = new writeMethods();
        excel.loopWriteExcel();


    }
}
