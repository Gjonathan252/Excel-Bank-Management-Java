package com.example.bankmanagementsystemwithexcel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

public class readMethods {
    public static final String EXCEL_FILE_PATH = "./data/Routing.xlsx";
    private double Checking, Saving, Business;

    // System.out.println( "Hello World!" );
    // Creating a Workbook from an Excel file (.xls or .xlsx)
    Workbook workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));

    public void bal(){
        this.Checking = checkingBal();
        this.Saving = savingBal();
        this.Business = businessBal();
    }
    public double checkingBal() {
        try {
            Sheet sheet = workbook.getSheetAt(1);
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(13);
            String s = cell.toString();
            Checking = Double.parseDouble(s);
            // if (cell != null)
            //     System.out.println("Data: " + Checking);
            // else
            //     System.out.println("Cell is empty");
        } catch (Exception e) {
            System.out.println(e);
        }
        return Checking;
    }
    public double savingBal() {
        try {
            Sheet sheet = workbook.getSheetAt(2);
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(13);
            String s = cell.toString();
            Saving = Double.parseDouble(s);
            // if (cell != null)
            //     System.out.println("Data: " + Saving);
            // else
            //     System.out.println("Cell is empty");
        } catch (Exception e) {
            System.out.println(e);
        }
        return Saving;
    }
    public double businessBal() {
        try {
            Sheet sheet = workbook.getSheetAt(3);
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(13);
            String s = cell.toString();
            Business = Double.parseDouble(s);
            // if (cell != null)
            //     System.out.println("Data: " + Business);
            // else
            //     System.out.println("Cell is empty");
        } catch (Exception e) {
            System.out.println(e);
        }
        return Business;
    }

    public void getSheetNum() {
        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
    }

    public void sheets() {
        System.out.println("Retrieving Sheets using for-each loop");
        for (Sheet sheet : workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }
    }

    public void rowAndcol() throws IOException {
        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
    }

    public readMethods() throws IOException {
        this.Checking = checkingBal();
        this.Saving = savingBal();
        this.Business = businessBal();
    }


    public double getChecking() {
        return this.Checking;
    }

    public double getSaving() {
        return this.Saving;
    }

    public double getBusiness() {
        return this.Business;
    }

}