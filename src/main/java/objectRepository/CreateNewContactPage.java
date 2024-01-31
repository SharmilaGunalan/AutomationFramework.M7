package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility { //Rule 1 - Creating a Class
	
	//Rule 2 - Declaration
	@FindBy(name = "lastname") 
	private WebElement LastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']") 
	private WebElement SaveBtn;
	
	@FindBy(name = "leadsource") 
	private WebElement leadSourceDropDown;
	
	//Rule 3 - Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 - Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getleadSourceDropDown() {
		return leadSourceDropDown;
	}

	//Business Logic
	/**
	 * This method will create new contact with mandatory details
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create new contact with lead source drop-down value
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	public void createNewContact(String LASTNAME, String LEADSOURCE)
	{
		LastNameEdt.sendKeys(LASTNAME);
		handleDropdown(leadSourceDropDown, LEADSOURCE);
		SaveBtn.click();
	}
}
