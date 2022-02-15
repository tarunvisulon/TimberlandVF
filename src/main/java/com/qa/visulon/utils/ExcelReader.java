package com.qa.visulon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelReader {

	
	@DataProvider
	public  String[][] loginData() throws IOException {
		
		File fis = new File(Constant.Excel_path);
		System.out.println(fis.exists());

		FileInputStream file = new FileInputStream(fis);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("userlogin");
		// count the number of row
		int noofRows = sheet.getPhysicalNumberOfRows();

		// count the number of column in row
		int noofColumn = sheet.getRow(0).getLastCellNum();

		// String[][] userData = new String[noofRows-1][noofColumn];

		String [][] userData= new String[noofRows-1][noofColumn];
		
		for (int i = 0; i < noofRows - 1; i++) {

			for (int j = 0; j < noofColumn; j++) {

		userData[i][j]	=sheet.getRow(i+1).getCell(j).getStringCellValue();
				
				

			}

		}

		workbook.close();
		file.close();

		/*
		  for (String[] strings : userData) {
		  
		  System.out.println(Arrays.toString(strings));
		  
		  }*/
		  
		 

		return userData;

	}

}
