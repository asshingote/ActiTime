package com.ECFW.ActiTimeGENERIC;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHandle implements AutoConstants
{
	private static Workbook book;
	private static Sheet sheet;
	private static Row row;
	private static Cell cell;
	public static String getExcelData(String sheetname, int rownum, int cellnum)
	{
		String path=EXCEL_PATH;
		try 
		{
				book=WorkbookFactory.create(new FileInputStream(path));
				sheet=book.getSheet(sheetname);
				row=sheet.getRow(rownum);
				cell=row.getCell(cellnum);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cell.toString();
	}
	
	public static void setExcelData(String sheetname, int rownum, int cellnum, String value)
	{
		String path=EXCEL_PATH;
		try 
		{
				book=WorkbookFactory.create(new FileInputStream(path));
				sheet=book.getSheet(sheetname);
				row=sheet.getRow(rownum);
				cell=row.createCell(cellnum);
				cell.setCellValue(value);
				book.write(new FileOutputStream(path));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

