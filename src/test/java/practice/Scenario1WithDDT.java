package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1WithDDT {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Throwable {
		
		//Read the Required Data
		/*Read Common Data from Property File*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties P = new Properties();
		P.load(fisp);
		String URL = P.getProperty("url");
		String USERNAME = P.getProperty("username");
		String PASSWORD = P.getProperty("password");
		
		/*Read Test Data from Excel File*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		//Step 1: Launch the browser

				// opening chrome browser
				WebDriver driver = new EdgeDriver();
				// maximizing the browser
				driver.manage().window().maximize();
				// implicit statement
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			//Step 2: Load the URL
				driver.get(URL);
			
			//Step 3: Login to Application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
			
			//Step 4: Navigate to Contacts Link
				driver.findElement(By.linkText("Contacts")).click();
			
			//Step 5: Click on Create contact look up Image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
			//Step 6: Create a new contact with mandatory details
				driver.findElement(By.name("lastname")).sendKeys("Spiderman");
			
			//Step 7: Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Step 8: Validate
				String conHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(conHeader.contains(LASTNAME))
				{
					System.out.println("Pass");
					System.out.println(conHeader);
				}
				else
				{
					System.out.println("Fail");
				}
			
			//Step 9: Logout to Application
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign Out")).click();
			
			//Step 10: Close the Browser
				driver.quit();
	}
}
