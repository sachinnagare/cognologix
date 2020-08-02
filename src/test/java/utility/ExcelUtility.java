/**
 * The ExcelUtility.Java file will used to fetch data from .xlsx workbook sheet and provide it to test script.
 * There are still few actions are pending. need to work on it.
 * 
 * 
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-08-1
 */

package utility;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.XSSFBReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtility(String excelPath, String sheetName) {


		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet=workbook.getSheet(sheetName);
		} catch (IOException exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}


	public static void getRowCount()
	{
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("number of rows into sheet1 are: "+rowCount);
	}

	public static Object  getCellData(int rowNum,int colNum)
	{
		DataFormatter formatter =new DataFormatter();
		Object value=  formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println(value);
		return value;


	}
}

