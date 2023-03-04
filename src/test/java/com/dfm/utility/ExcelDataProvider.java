/**
 * 
 */
package com.dfm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Nitesh
 *
 */
public class ExcelDataProvider {

	public XSSFWorkbook workbook;
	public XSSFSheet xssfSheet;
	public FileInputStream fileInputStream;
	public File source;
	static Xls_Reader reader;

	// This constructor will load the Excel as soon as we create object of this
	// class
	public ExcelDataProvider() throws FileNotFoundException {

		source = new File("./TestData/Data Sheet.xlsx");

//		DataFormatter dataFormatter = new DataFormatter();
//		xssfSheet = workbook.getSheetAt(0);
//		String value1 = dataFormatter.formatCellValue(xssfSheet.getRow(1).getCell(1));
//		int number4 = Integer.parseInt(value1);

		try {
			fileInputStream = new FileInputStream(source);

			// In order to read xlsx file we need one class called XSSFWorkBook
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {

			System.out.println("Unable to read Excel file " + e.getMessage());
		}

	}

	// Method to get details of Add user from excel
	public static ArrayList<Object[]> getUserDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		reader = new Xls_Reader("./TestData/Data Sheet.xlsx");
		
		for (int rowNum=2; 	rowNum <= reader.getRowCount("UserDetails"); rowNum++) 
		{
			        String firstName = reader.getCellData("UserDetails", "firstName", rowNum);
					String lastName = reader.getCellData("UserDetails", "lastName", rowNum);
					String email  = reader.getCellData("UserDetails", "email", rowNum);
					String type = reader.getCellData("UserDetails", "type", rowNum);
					
					Object ob[] = {firstName,lastName,email,type};
					myData.add(ob);	
					break;
		}		
		return myData;
		

	}
	
	// Method to get newly created user details from excel
	public static ArrayList<Object[]> getNewUserDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		reader = new Xls_Reader("./TestData/Data Sheet.xlsx");
		
		for (int rowNum=2; 	rowNum <= reader.getRowCount("newlyCreatedUserDetails"); rowNum++) 
		{
			        String username = reader.getCellData("UserDetails", "username", rowNum);
					String password = reader.getCellData("UserDetails", "password", rowNum);
					
					Object ob[] = {username,password};
					myData.add(ob);	
					break;
		}		
		return myData;

	}

	
	// Method Overloading Scenario
	public String getStringData(int sheetIndex, int row, int column) {
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringData(String SheetName, int row, int column) {
		return workbook.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public double getNumericData(String SheetName, int row, int column) {
		return workbook.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}

	public int getNumericData1(String SheetName, int row, int column) {
		return (int) workbook.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}

}
