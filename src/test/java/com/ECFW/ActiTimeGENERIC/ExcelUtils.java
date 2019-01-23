package com.ECFW.ActiTimeGENERIC;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils implements AutoConstants
{
	private static Sheet ExcelWSheet;
	private static Workbook ExcelWBook;
	private static Cell cell;
	private static Row row;
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception 
	{   
		String[][] tabObjArray = null;
		try 
		{
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			ExcelWBook = WorkbookFactory.create(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int ci,cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			System.out.println(totalRows);
	 // you can write a function as well to get Column count
			int totalCols = 2;
			tabObjArray=new String[totalRows][totalCols];
			ci=0;
			for (int i=0;i<=totalRows;i++,ci++) 
			{  
				cj=0;
				for (int j=0;j<=totalCols;j++,cj++)
				{
					if(j==0)
					{
						tabObjArray[ci][cj]=getCellData(i,j);
						System.out.println(tabObjArray[ci][cj]);  
					}
					if(j==1)
					{
						tabObjArray[ci][cj]=getCellData(i,j);
						System.out.println(tabObjArray[ci][cj]);  
					}
				}
			}
		}
		catch (Exception e)
		{
		}
		return(tabObjArray);
	}
	public static String getCellData(int RowNum, int ColNum) throws Exception 
	{
		try
		{
			cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			//int dataType = cell.getCellType();
			cell.setCellType(Cell.CELL_TYPE_STRING);
				String CellData = cell.getStringCellValue();
				return CellData;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
	public static void setExcelData(String sheetname, int rownum, int cellnum, String value)
	{
		String path=EXCEL_PATH;
		try 
		{
			ExcelWBook=WorkbookFactory.create(new FileInputStream(path));
			ExcelWSheet=ExcelWBook.getSheet(sheetname);
				row=ExcelWSheet.getRow(rownum);
				cell=row.createCell(cellnum);
				cell.setCellValue(value);
				ExcelWBook.write(new FileOutputStream(path));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}