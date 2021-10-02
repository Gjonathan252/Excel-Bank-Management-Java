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

    public void loopExcel() throws IOException {

        readMethods readMethods = new readMethods();
        String checkString;
        boolean check = false;
        while (!check) {
            System.out.println("\nMake Transaction or Check latest Transactions\n" + "1.Make Transaction\n"
                    + "2.Check Balance\n" + "\nType: \"STOP\" to stop the program");
            Scanner inputScanner = new Scanner(System.in);
            checkString = inputScanner.nextLine();
            if (checkString.toUpperCase().equals("STOP")) {
                System.out.println("\nExiting Program");
                System.exit(0);
            }

            Boolean flag = true;
            for (int a = 0; a < checkString.length(); a++) {
                if (!Character.isDigit(checkString.charAt(a))) {
                    flag = false;
                    System.out.println("\nIncorrect input.\nPlease Select from the give selections\n");
                    break;
                }
            }
            if (flag) {
                // int temp = Integer.valueOf(Token);
                switch (checkString) {
                    case "1":
                        updateExcelFile();
                        break;
                    case "2":
                        readMethods.showBal();
                        break;
                    default:
                        System.out.println("\nIncorrect input.\nPlease Select from the give selections\n");
                        break;
                }
            }

        }
    }

    public void updateExcelFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(EXCEL_FILE_PATH);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet1 = workbook.getSheetAt(0);
            List<Charge> chargeList = getChargeList();
            readMethods rMethods = new readMethods();

            for (int i = 0; i < chargeList.size(); i++) {
                // Row dataRow = sheet1.getRow(++lastRowCount1); //example of creating cells in
                // pos without deleting data
                Row dataRow = sheet1.createRow(sheet1.getLastRowNum() + 1);
                dataRow.createCell(5).setCellValue(chargeList.get(i).getDate());
                dataRow.createCell(6).setCellValue(chargeList.get(i).getTime());
                dataRow.createCell(7).setCellValue(chargeList.get(i).getToken());
                dataRow.createCell(8).setCellValue(chargeList.get(i).getCost());
                dataRow.createCell(9).setCellValue(chargeList.get(i).getStore());
                switch (chargeList.get(0).getToken()) {
                    case "Checkings":
                        // Double tempC = rMethods.getChecking() - chargeList.get(i).getCost();
                        dataRow.createCell(10).setCellValue(rMethods.getChecking() - chargeList.get(i).getCost());
                        break;
                    case "Savings":
                        dataRow.createCell(10).setCellValue(rMethods.getSaving() - chargeList.get(i).getCost());
                        break;
                    case "Business":
                        dataRow.createCell(10).setCellValue(rMethods.getBusiness() - chargeList.get(i).getCost());
                        break;
                    default:
                        break;

                }
            }
            switch (chargeList.get(0).getToken()) {
                case "Checkings":
                    Sheet sheet2 = workbook.getSheetAt(1);
                    for (int i = 0; i < chargeList.size(); i++) {
                        Row dataRow = sheet2.createRow(sheet2.getLastRowNum() + 1);
                        dataRow.createCell(5).setCellValue(chargeList.get(i).getDate());
                        dataRow.createCell(6).setCellValue(chargeList.get(i).getTime());
                        dataRow.createCell(7).setCellValue(chargeList.get(i).getToken());
                        dataRow.createCell(8).setCellValue(chargeList.get(i).getCost());
                        dataRow.createCell(9).setCellValue(chargeList.get(i).getStore());
                        dataRow.createCell(10).setCellValue(rMethods.getChecking() - chargeList.get(i).getCost());
                        sheet2 = workbook.getSheetAt(4);
                        dataRow = sheet2.createRow(2);
                        dataRow.createCell(0).setCellValue(rMethods.getChecking() - chargeList.get(i).getCost());
                    }
                    break;
                case "Savings":
                    Sheet sheet3 = workbook.getSheetAt(2);
                    for (int i = 0; i < chargeList.size(); i++) {
                        Row dataRow = sheet3.createRow(sheet3.getLastRowNum() + 1);
                        dataRow.createCell(5).setCellValue(chargeList.get(i).getDate());
                        dataRow.createCell(6).setCellValue(chargeList.get(i).getTime());
                        dataRow.createCell(7).setCellValue(chargeList.get(i).getToken());
                        dataRow.createCell(8).setCellValue(chargeList.get(i).getCost());
                        dataRow.createCell(9).setCellValue(chargeList.get(i).getStore());
                        dataRow.createCell(10).setCellValue(rMethods.getSaving() - chargeList.get(i).getCost());
                        sheet3 = workbook.getSheetAt(4);
                        dataRow = sheet3.createRow(5);
                        dataRow.createCell(0).setCellValue(rMethods.getSaving() - chargeList.get(i).getCost());
                    }
                    break;
                case "Business":
                    Sheet sheet4 = workbook.getSheetAt(3);
                    for (int i = 0; i < chargeList.size(); i++) {
                        Row dataRow = sheet4.createRow(sheet4.getLastRowNum() + 1);
                        dataRow.createCell(5).setCellValue(chargeList.get(i).getDate());
                        dataRow.createCell(6).setCellValue(chargeList.get(i).getTime());
                        dataRow.createCell(7).setCellValue(chargeList.get(i).getToken());
                        dataRow.createCell(8).setCellValue(chargeList.get(i).getCost());
                        dataRow.createCell(9).setCellValue(chargeList.get(i).getStore());
                        dataRow.createCell(10).setCellValue(rMethods.getBusiness() - chargeList.get(i).getCost());
                        sheet2 = workbook.getSheetAt(4);
                        dataRow = sheet2.createRow(8);
                        dataRow.createCell(0).setCellValue(rMethods.getSaving() - chargeList.get(i).getCost());
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
