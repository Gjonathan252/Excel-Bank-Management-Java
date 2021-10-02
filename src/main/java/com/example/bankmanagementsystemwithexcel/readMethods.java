package com.example.bankmanagementsystemwithexcel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
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
import org.apache.poi.ss.util.CellReference;

public class readMethods {
    public static final String EXCEL_FILE_PATH = "./data/Routing.xlsx";
    private double Checking, Saving, Business;
    private String balString;

    // System.out.println( "Hello World!" );
    // Creating a Workbook from an Excel file (.xls or .xlsx)
    Workbook workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));

    public void bal() {
        this.Checking = checkingBal();
        this.Saving = savingBal();
        this.Business = businessBal();
    }

    public double checkingBal() {
        try {
            Sheet sheet = workbook.getSheetAt(4);
            Row row = sheet.getRow(2);
            Cell cell = row.getCell(0);
            String s = cell.toString();
            Checking = Double.parseDouble(s);
            // if (cell != null)
            // System.out.println("Data: " + Checking);
            // else
            // System.out.println("Cell is empty");
        } catch (Exception e) {
            // System.out.println(e);
        }
        return Checking;
    }

    public double savingBal() {
        try {
            Sheet sheet = workbook.getSheetAt(4);
            Row row = sheet.getRow(5);
            Cell cell = row.getCell(0);
            String s = cell.toString();
            Saving = Double.parseDouble(s);
            // if (cell != null)
            // System.out.println("Data: " + Saving);
            // else
            // System.out.println("Cell is empty");
        } catch (Exception e) {
            // System.out.println(e);
        }
        return Saving;
    }

    public double businessBal() {
        try {
            Sheet sheet = workbook.getSheetAt(4);
            Row row = sheet.getRow(8);
            Cell cell = row.getCell(0);
            String s = cell.toString();
            Business = Double.parseDouble(s);
            // if (cell != null)
            // System.out.println("Data: " + Business);
            // else
            // System.out.println("Cell is empty");
        } catch (Exception e) {
            // System.out.println(e);
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

    public void showBal() throws IOException {
        boolean check = false;
        while (!check) {
            System.out.println("\nSelect Bank Account\n" + "1.Checking\n" + "2.Savings\n" + "3.Business\n" + "4.All\n"
                    + "\nType: \"STOP\" to stop the program");
            Scanner balScanner = new Scanner(System.in);
            balString = balScanner.nextLine();
            if (balString.toUpperCase().equals("STOP")) {
                System.out.println("\nExiting Program");
                System.exit(0);
            }

            Boolean flag = true;
            for (int a = 0; a < balString.length(); a++) {
                if (!Character.isDigit(balString.charAt(a))) {
                    flag = false;
                    System.out.println("\nIncorrect input.\nPlease Select from the give selections\n");
                    break;
                }
            }
            if (flag) {
                // int temp = Integer.valueOf(Token);
                switch (balString) {
                    case "1":
                        checkingsRow();
                        check = true;
                        break;
                    case "2":
                        savingsRow();
                        check = true;
                        break;
                    case "3":
                        BusinessRow();
                        check = true;
                        break;
                    case "4":
                        rowAndcol();
                        check = true;
                        break;
                    default:
                        System.out.println("\nIncorrect input.\nPlease Select from the give selections\n");
                        break;
                }
            }
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

    public void checkingsRow() throws IOException {
        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(1);

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

    public void savingsRow() throws IOException {
        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(2);

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

    public void BusinessRow() throws IOException {
        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(3);

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