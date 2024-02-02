package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	//HARD ASSERT:
	@Test
	public void sample()
	{
		String a = "hi";
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		
		//Assert.assertEquals(1, 1); //pass
		
		Assert.assertTrue(a.contains("i")); //pass
		
		System.out.println("step 4");
		System.out.println("step 5");
		
		System.out.println("step 5");
	}
	
	//SOFT ASSERT:
	@Test
	public void sample1()
	{
		SoftAssert sa = new SoftAssert();
		String a = "hi";
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		
		sa.assertEquals(0, 1); //fail
		
		//sa.assertTrue(a.contains("i")); //pass
		
		System.out.println("step 4");
		System.out.println("step 5");
		
		sa.assertAll(); //it will log all the assertion failures
	}
}
