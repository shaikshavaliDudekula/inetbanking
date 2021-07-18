package pom_utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityXL {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	String path=null;
	public UtilityXL(String path)
	{
		this.path=path;
	}
	public int getRowscount(String sheetname) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	public int getcolumnscount(String sheetname,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		int colcount=sheet.getRow(rownum).getLastCellNum();
		wb.close();
		fi.close();
		return colcount;
	}
	
	public String getcellvalue(String sheeetname,int rownum,int colnum) throws IOException 
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheeetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter formatter=new DataFormatter();
		String data;
		try
		{
		data=formatter.formatCellValue(cell);
		}catch (Exception e)
		{
			data="";
		}
		wb.close();
		fi.close();
		
		return data;
		
	}
	
	

}
