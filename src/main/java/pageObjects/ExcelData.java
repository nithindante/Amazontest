package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static int getRowCount(String path,String sh) throws IOException				//creating a method to get the row from the Excel Sheet
	{
		 
		try
		{
		File f = new File(path);
		FileInputStream fp = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fp);
		XSSFSheet sh1 = wb.getSheet(sh);
		return sh1.getLastRowNum(); 													//gets the last row number
		} 
		catch ( Exception e)
		{
			return 0;
		} 
	}
	public static String getCellValue(String path, String sh, int i, int c) throws IOException {		// gets the cell value from the Excel Sheet
		try 
		
		{
		File f = new File(path);
		FileInputStream fp = new FileInputStream(f); 
		XSSFWorkbook wb = new XSSFWorkbook(fp);
		XSSFSheet sh1 = wb.getSheet(sh);
		XSSFCell cell = sh1.getRow(i).getCell(c);
		return cell.getStringCellValue();																//gets the exact cell value
		}
		catch ( Exception e)
		{
			return " ";
		}
	}
}