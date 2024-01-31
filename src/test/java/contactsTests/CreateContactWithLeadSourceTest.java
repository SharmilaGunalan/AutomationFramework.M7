package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactWithLeadSourceTest extends BaseClass{

	@Test(groups = {"SmokeSuite", "RegressionSuite"})
	public void createContactWithLeadSourceTest() throws IOException, InterruptedException {
		
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
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 4, 3);
		
		//Step 1: Launch the browser

				// opening browser
				//WebDriver driver = new EdgeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
				// maximizing the browser
				sUtil.maximizeWindow(driver);
				// implicit statement
				sUtil.addImplicityWait(driver);
				
			//Step 2: Load the URL
				driver.get(URL);
			
			//Step 3: Login to Application
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
			
			//Step 4: Navigate to Contacts Link
				HomePage hp = new HomePage(driver);
				hp.clickOnContactsLink();
			
			//Step 5: Click on Create contact look up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
			//Step 6: Create a new contact with mandatory details and save
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME, LEADSOURCE);
			
			//Step 8: Validate
				ContactInfoPage cip = new ContactInfoPage(driver);
				String conHeader = cip.captureHeadertext();
				Assert.assertTrue(conHeader.contains(LASTNAME));
				System.out.println(conHeader);
			
			//Step 9: Logout to Application
				hp.logoutOfApp(driver);
				
			//Step 10: Close the Browser
				driver.quit();
	}
}
