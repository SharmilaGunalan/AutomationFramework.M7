package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU {

	public static void main(String[] args) throws Throwable {
		
		//Create object of Utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
	
		//Read the Required Data
		/*Read Common Data from Property File*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/*Read Test Data from Excel File*/
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		//Step 1: Launch the browser

				// opening chrome browser
				WebDriver driver = new EdgeDriver();
				// maximizing the browser
				sUtil.maximizeWindow(driver);
				// implicit statement
				sUtil.addImplicityWait(driver);
				
			//Step 2: Load the URL
				driver.get(URL);
			
			//Step 3: Login to Application
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
			//	lp.getUsernameEdt().sendKeys(USERNAME);
			//	lp.getPasswordEdt().sendKeys(PASSWORD);
			//	lp.getLoginBtn().click();
				
			//	driver.findElement(By.name("user_name")).sendKeys("admin");
			//  driver.findElement(By.name("user_password")).sendKeys("admin");
			//	driver.findElement(By.id("submitButton")).click();
			
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
				
				sUtil.mouseOverAction(driver, ele);
				
				Thread.sleep(1000);
				
				driver.findElement(By.linkText("Sign Out")).click();
			
			//Step 10: Close the Browser
				driver.quit();
	}
}
