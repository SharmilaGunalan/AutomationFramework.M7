package practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericMethodPractice {

	public static void main(String[] args) throws IOException { // caller
		
		PropertyFileUtility p = new PropertyFileUtility();
		String val = p.readDataFromPropertyFile("password");
		System.out.println(val);
		
		ExcelFileUtility e = new ExcelFileUtility();
		String value = e.readDataFromExcel("Contacts", 1, 1);
		System.out.println(value);
		
		JavaUtility j = new JavaUtility();
		System.out.println(j.getSystemDate());
		
		
		// int a=10;
		// int b=20;
		// int c=a+b;
		// System.out.println(c);
		
		int sum = add(20,40);
		System.out.println(sum);
		add(400,540);
		
	}
	
	public static int add(int a, int b) // called //reusable?
	{
		int c = a+b;
		return c;
	}
}
