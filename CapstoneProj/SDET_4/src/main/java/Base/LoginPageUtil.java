package Base;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginPageUtil {

    public static void login(WebDriver driver, String username, String password) {

        driver.findElement(By.id("user-name")).sendKeys(username);
        
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public static Object[][] getTestData(String filePath, String sheetName) throws Exception, InvalidFormatException {
        Object[][] data = null;
        try {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            data = new Object[rowCount][colCount];

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
