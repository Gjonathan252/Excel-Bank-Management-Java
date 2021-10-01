package com.example.bankmanagementsystemwithexcel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

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

public class readMethods {
    public static final String EXCEL_FILE_PATH = "./data/Routing.xlsx";

    // System.out.println( "Hello World!" );
    // Creating a Workbook from an Excel file (.xls or .xlsx)
    Workbook workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));

    public void getSheetNum(){
        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
    }
    public void sheets(){
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }
    }

    public void rowAndcol() throws IOException {
        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row: sheet) {
            for(Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
    }

    

    public readMethods() throws IOException {
    }
}
