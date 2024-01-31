package genericUtilities;

import java.util.Date;

/**
 * This class consists of generic methods related to java
 * @author sharmi
 * 
 */
public class JavaUtility {

	/**
	 * This method will capture the system date in required format
	 * @return
	 */
	public String getSystemDate() 
	{
		Date d = new Date();
		String[] dArr = d.toString().split("");
		String date = dArr[2]+"_"+dArr[1]+"_"+dArr[5]+"_"+dArr[3].replace(":", "-");
		return date;
	}
}
