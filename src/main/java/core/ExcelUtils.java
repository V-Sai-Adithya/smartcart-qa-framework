package core;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;



public class ExcelUtils {
    private static Workbook workbook;
    private static Properties userProps = new Properties();

    // Load the TestSuite.xlsx file
    public static void loadExcel(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }

    // Get RunMode for a test case from MasterSuite
    public static boolean shouldRunTest(String testCaseName) {
        Sheet sheet = workbook.getSheet("MasterSuite");
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // skip header
            if (row.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                return row.getCell(2).getStringCellValue().equalsIgnoreCase("Yes");
            }
        }
        return false;
    }

    // Get all steps for a test case from its sheet
    public static List<Map<String, String>> getTestSteps(String testCaseName) {
        List<Map<String, String>> steps = new ArrayList<>();
        Sheet sheet = workbook.getSheet(testCaseName);

        Row header = sheet.getRow(0);
        int colCount = header.getLastCellNum();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Map<String, String> step = new HashMap<>();
            for (int j = 0; j < colCount; j++) {
                step.put(header.getCell(j).getStringCellValue(),
                        row.getCell(j) != null ? row.getCell(j).toString() : "");
            }
            steps.add(step);
        }
        return steps;
    }

    // Load user credentials from user-data.properties
    public static void loadUserProperties(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        userProps.load(fis);
    }

    public static String getUserData(String key) {
        return userProps.getProperty(key);
    }
}

