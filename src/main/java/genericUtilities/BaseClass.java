package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations of TestNG
 * @author sharm
 */
public class BaseClass {

	private static final Object BROWSER = null;
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	@BeforeSuite(groups = {"SmokeSuite", "RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("======== DB Connection Successful ========");
	}
	
//	@Parameters("Browser")
//	@BeforeTest
	@BeforeClass(groups = {"SmokeSuite", "RegressionSuite"})
	public void bcConfig(/*String Browser*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		
//		driver = new EdgeDriver();
		
//		if(BROWSER.equals("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(BROWSER.equals("firefox"))
//		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
//		}
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicityWait(driver);
		
		driver.get(URL);
		
		System.out.println("========= Browser Launch Successful =========");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException 
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("========= Login To App Successful ==========");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("======== Logout of App Successful =========");
	}
	
//	@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("========= Browser Closure Successful ==========");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("========= DB Closure Successful ==========");
	}
}
