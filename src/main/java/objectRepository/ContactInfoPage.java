package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage { //Rule 1 - Creating a Class
	
	//Rule 2 - Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']") 
	private WebElement ContactHeaderText;

	
	//Rule 3 - Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 - Utilization
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}

	//Business Library
	/**
	 * This method will capture the header text and return it to caller
	 * @return
	 */
	public String captureHeadertext()
	{
		return ContactHeaderText.getText();
	}
}
