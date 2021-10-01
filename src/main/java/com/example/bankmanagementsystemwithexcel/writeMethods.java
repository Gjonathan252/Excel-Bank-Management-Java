package com.example.bankmanagementsystemwithexcel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class writeMethods {
    public static final String EXCEL_FILE_PATH = "./data/Routing.xlsx";

    public void writeExcel() {
        boolean exitCheck = false;
        while (!exitCheck) {
            updateExcelFile();
        }
    }

    public void updateExcelFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(EXCEL_FILE_PATH);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet1 = workbook.getSheetAt(0);
            int lastRowCount1 = sheet1.getLastRowNum() - 3;
            List<Charge> chargeList = getChargeList();
            for (int i = 0; i < chargeList.size(); i++) {
                Row dataRow = sheet1.getRow(++lastRowCount1);
                dataRow.createCell(5).setCellValue(chargeList.get(i).getDate());
                dataRow.createCell(6).setCellValue(chargeList.get(i).getTime());
                dataRow.createCell(7).setCellValue(chargeList.get(i).getToken());
                dataRow.createCell(8).setCellValue(chargeList.get(i).getCost());
                dataRow.createCell(9).setCellValue(chargeList.get(i).getStore());
            }
            switch (chargeList.get(0).getToken()) {
                case "Checkings":
                    Sheet sheet2 = workbook.getSheetAt(1);
                    // int lastRowCount1 = sheet2.getLastRowNum()-1;
                    lastRowCount1 = sheet2.getLastRowNum() - 1;

                    for (int i = 0; i < chargeList.size(); i++) {
                        Row dataRow = sheet2.getRow(++lastRowCount1);
                        dataRow.createCell(5).setCellValue(chargeList.get(i).getDate());
                        dataRow.createCell(6).setCellValue(chargeList.get(i).getTime());
                        dataRow.createCell(7).setCellValue(chargeList.get(i).getToken());
                        dataRow.createCell(8).setCellValue(chargeList.get(i).getCost());
                        dataRow.createCell(9).setCellValue(chargeList.get(i).getStore());
                    }
                    break;
                case "Savings":
                    Sheet sheet3 = workbook.getSheetAt(2);
                    // int lastRowCount1 = sheet3.getLastRowNum()-1;
                    lastRowCount1 = sheet3.getLastRowNum() - 1;
                    for (int i = 0; i < chargeList.size(); i++) {
                        Row dataRow = sheet3.getRow(++lastRowCount1);
                        dataRow.createCell(5).setCellValue(chargeList.get(i).getDate());
                        dataRow.createCell(6).setCellValue(chargeList.get(i).getTime());
                        dataRow.createCell(7).setCellValue(chargeList.get(i).getToken());
                        dataRow.createCell(8).setCellValue(chargeList.get(i).getCost());
                        dataRow.createCell(9).setCellValue(chargeList.get(i).getStore());
                    }
                    break;
                case "Business":
                    Sheet sheet4 = workbook.getSheetAt(3);
                    // int lastRowCount1 = sheet4.getLastRowNum()-1;
                    lastRowCount1 = sheet4.getLastRowNum() - 1;
                    for (int i = 0; i < chargeList.size(); i++) {
                        Row dataRow = sheet4.getRow(++lastRowCount1);
                        dataRow.createCell(5).setCellValue(chargeList.get(i).getDate());
                        dataRow.createCell(6).setCellValue(chargeList.get(i).getTime());
                        dataRow.createCell(7).setCellValue(chargeList.get(i).getToken());
                        dataRow.createCell(8).setCellValue(chargeList.get(i).getCost());
                        dataRow.createCell(9).setCellValue(chargeList.get(i).getStore());
                    }
                    break;
                default:
                    break;
            }
            fileInputStream.close();
            FileOutputStream fileOutputStream = new FileOutputStream(EXCEL_FILE_PATH);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("\nExcelFile Succesfully Updated...\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Charge> getChargeList() {
        Routing routing = new Routing();
        routing.collectCharge();
        List<Charge> chargeList = new ArrayList<Charge>();
        chargeList.add(new Charge(routing.getDate(), routing.getTime(), routing.getToken(), routing.getCost(),
                routing.getStore()));
        return chargeList;
    }
}
