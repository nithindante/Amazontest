package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static int getrowcount(String path,String sh) throws IOException
	{
		 
		try
		{
		File f = new File(path);
		FileInputStream fp = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fp);
		XSSFSheet sh1 = wb.getSheet(sh);
		return sh1.getLastRowNum(); 		
		} 
		catch ( Exception e)
		{
			return 0;
		}
	}
	public static String getcellvalue(String path, String sh, int i, int c) throws IOException {
		try 
		
		{
		File f = new File(path);
		FileInputStream fp = new FileInputStream(f); 
		XSSFWorkbook wb = new XSSFWorkbook(fp);
		XSSFSheet sh1 = wb.getSheet(sh);
		XSSFCell cell = sh1.getRow(i).getCell(c);
		return cell.getStringCellValue();
		}
		catch ( Exception e)
		{
			return " ";
		}
	}
}