package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice1 {

	@Test
	public void createCustomer()
	{
		Assert.fail();
		System.out.println("Create"); //failed
	}
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("Modify");
	}
	
	@Test
	public void deleteCustomer()
	{
		System.out.println("Delete");
	}
}
