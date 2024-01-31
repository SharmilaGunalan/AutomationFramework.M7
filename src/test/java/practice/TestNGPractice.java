package practice;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(invocationCount = 2, priority = 3)
	public void createCustomer()
	{
		System.out.println("Create");
	}
	
	@Test
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
