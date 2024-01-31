package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{ //Rule 1 - Creating a Class
	
	//Rule 2 - Declaration
	@FindBy(linkText = "Contacts") 
	private WebElement contactsLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") 
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out") 
	private WebElement signoutLnk;
	
	//Rule 3 - Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 - Utilization
	public WebElement getcontactsLnk() {
		return contactsLnk;
	}

	public WebElement getadministratorImg() {
		return administratorImg;
	}

	public WebElement getsignoutLnk() {
		return signoutLnk;
	}

	//Business Library
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	/**
	 * This method will logout the application
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, administratorImg);
		Thread.sleep(1000);
		signoutLnk.click();
	}
}
