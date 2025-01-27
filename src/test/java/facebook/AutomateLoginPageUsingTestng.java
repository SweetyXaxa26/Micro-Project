package facebook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutomateLoginPageUsingTestng {
	
	@Test
	public  void run () throws IOException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\FacebookExcel\\Database.xlsx");
        //open file in reading mode 
		
		
		// Load workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // Get the total number of rows
        int totalRows = sheet.getLastRowNum();

     // HashMap to store email-password pairs
        Map<String, String> credentials = new HashMap<>();
        
        // Loop through rows in Excel
        
        for (int i = 1; i <= totalRows; i++)
        {
            XSSFRow celldata = sheet.getRow(i);

            // Fetch email and password from the current row
            String email = celldata.getCell(0).getStringCellValue();
            String pass = celldata.getCell(1).getStringCellValue();

             // Add the email-password pair to the HashMap
            credentials.put(email, pass);
            
           
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement emailLoc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            emailLoc.clear();
            emailLoc.sendKeys(email);

          
            WebElement passwordLoc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
            passwordLoc.clear();
            passwordLoc.sendKeys(pass);

            
            WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
            loginBtn.click();

            
        }


        workbook.close();
        driver.quit();
     // Print all stored email-password pairs serially
        
        System.out.println("Serial-wise email and password data:");
        int serialNo = 1;
        for (Map.Entry<String, String> entry : credentials.entrySet())
        {
            System.out.println(serialNo++ + ". Email: " + entry.getKey() + ", Password: " + entry.getValue());
        }
		
	}

}
