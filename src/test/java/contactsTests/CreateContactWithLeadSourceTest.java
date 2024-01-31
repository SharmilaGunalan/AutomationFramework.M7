package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactWithLeadSourceTest extends BaseClass{

	@Test(groups = {"SmokeSuite", "RegressionSuite"})
	public void createContactWithLeadSourceTest() throws IOException, InterruptedException {
		
		
		/*Read Test Data from Excel File*/
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 4, 3);
		
			
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
			
		
	}
}
