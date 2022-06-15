package com.perficient.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	public XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src = new File("./TestData/data.xlsx");
		
		try {
			FileInputStream fi = new FileInputStream(src);		
			 wb= new XSSFWorkbook(fi);
		} catch (Exception e) {
			System.out.println("Unable to read excel file: "+e.getMessage());
		}
				
	}
	
	
	public String getStringData(int sheetIndex, int row,int col)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(row).getStringCellValue();
	}
	
	
	public String getStringData(String sheet, int row,int col)
	{
		return wb.getSheet(sheet).getRow(row).getCell(row).getStringCellValue();
	}
	
	public double getNumericData(String sheet, int row,int col) 
	{
		return wb.getSheet(sheet).getRow(row).getCell(row).getNumericCellValue();
 
	}
	
}
