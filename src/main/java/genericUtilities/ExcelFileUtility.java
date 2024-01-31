package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	/**
	 * This method will read data from excel and return the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param CelNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException 
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int CelNo)throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(CelNo).getStringCellValue();
		return value;
	}
}
