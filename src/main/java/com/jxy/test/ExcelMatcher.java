package com.jxy.test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExcelMatcher {

    public static void main(String[] args) {
        // 输入字符串数组
        String[] strArr = {"200058611"};

        // 读取 Excel 文件
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(Objects.requireNonNull(ExcelMatcher.class.getResourceAsStream("/Users/bytedance/IdeaProjects/JxyStudy/src/main/java/com/jxy/test/excel2.xlsx"))); // 替换为你的 Excel 文件路径
        } catch (IOException e) {
            System.out.println("Error opening Excel file: " + e.getMessage());
            return;
        }

        Sheet sheet = workbook.getSheetAt(0); // 获取第一个 Sheet

        // 创建新的 Excel 文件
        Workbook newWorkbook = new XSSFWorkbook();
        Sheet newSheet = newWorkbook.createSheet("MatchedData");

        // 匹配字符串数组并写入新 Excel 文件
        List<Row> matchedRows = new ArrayList<>();
        for (Row row : sheet) {
            Cell cell = row.getCell(9); // 获取第 10 列数据
            if (cell != null) {
                String cellValue = cell.getStringCellValue();
                for (String str : strArr) {
                    if (str.equals(cellValue)) {
                        // 将匹配的行添加到新数组
                        matchedRows.add(row);
                        // 将匹配的行写入新 Excel 文件
                        Row newRow = newSheet.createRow(newSheet.getLastRowNum() + 1);

                        // 复制匹配行到新 Excel 文件
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            Cell sourceCell = row.getCell(j);
                            Cell targetCell = newRow.createCell(j);
                            targetCell.setCellValue(sourceCell.getStringCellValue());
                        }
                        break;
                    }
                }
            }
        }

        // 保存新的 Excel 文件
        try (FileOutputStream outputStream = new FileOutputStream("matched_data.xlsx")) { // 替换为你的新 Excel 文件名
            newWorkbook.write(outputStream);
            System.out.println("Matched data saved to matched_data.xlsx");
        } catch (IOException e) {
            System.out.println("Error saving Excel file: " + e.getMessage());
            return;
        }
    }
}