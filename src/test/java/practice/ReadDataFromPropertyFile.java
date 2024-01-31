package practice;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		//step 1:Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create obj of properties from java.util
		Properties P = new Properties();
		
		//Step 3: Load fis to the properties class
		P.load(fis);
		
		//Step 4: Provide the key and read the value
		String value = P.getProperty("url");
		System.out.println(value);
	}
}
