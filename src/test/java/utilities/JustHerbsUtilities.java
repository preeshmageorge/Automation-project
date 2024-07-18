package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JustHerbsUtilities {

	public static String getCellValue(String xl, String sheet, int r, int c) throws Exception
	
	{
	FileInputStream fi=new FileInputStream(xl);
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFCell cell=wb.getSheet(sheet).getRow(r).getCell(c);
	if(cell.getCellType()==CellType.STRING)
	{
		return cell.getStringCellValue();
		
	}
	else
	{
		return cell.getRawValue();
	}
	}
	public static int getRowcount(String xl, String sheet) throws IOException
	{
		FileInputStream fi=new FileInputStream(xl);
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		return wb.getSheet(sheet).getLastRowNum();
		
		
	}
	
	
}




