package TestNG;
import TestNG.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Util_ManagingExcelFile {
	
	private static XSSFSheet ExcelWSheet; 
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	
	public static Object[][] getTableAsArray(String FilePath, String SheetName) throws Exception {   
		 
		   String[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);

			   // Access the required test data sheet
			   ExcelWBook = new XSSFWorkbook(ExcelFile);
			   ExcelWSheet = ExcelWBook.getSheet(SheetName);

			   int startRow = 1;
			   int startCol = 1;
			   int ci,cj;
			   int totalRows = ExcelWSheet.getLastRowNum();
			   // you can write a function as well to get Column count
			   int totalCols = 2;
			   
			   tabArray=new String[totalRows][totalCols];
			   ci=0;

			   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

				  cj=0;

				   for (int j=startCol;j<=totalCols;j++, cj++){

					   tabArray[ci][cj]=getCellData(i,j);

					   System.out.println(tabArray[ci][cj]);  

						}

					}

				}

			catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}
	
	//
	@SuppressWarnings("deprecation")
	public static String getCellData(int RowNum, int ColNum) throws Exception{
	try{
		 
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		int dataType = Cell.getCellType();

		if  (dataType == 3) {

			return "";

		}else{

			String CellData = Cell.getStringCellValue();
			return CellData;

		}
	}
		catch (Exception e){

		System.out.println(e.getMessage());

		throw (e);

		}

	}
}
	/*public static String getCellData(int rowNum, int colNum) throws Exception{
		
		try{
			Cell=ExcelWSheet.getRow(rowNum).getCell(colNum);
			String CellData=Cell.getStringCellValue();
			return CellData;
		}
		catch(Exception e){
			return "";
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void setCellData(String Result,int Rownum, int ColNum ) throws Exception{
		
		try{
			Row=ExcelWSheet.getRow(Rownum);
			Cell=Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
			
			if(Cell== null){
				Cell=Row.createCell(ColNum);
				Cell.setCellValue(Result);	
			}else{
				Cell.setCellValue(Result);	
	
			}
			
			FileOutputStream fileOut=new FileOutputStream(Util.TESTDATA_PATH + Util.TESTDATA_FILE);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}catch (Exception e){
			throw(e);
		}
	}
}

/*
 * 
		public static String getCellData(int RowNum, int ColNum) throws Exception {
 
			try{
 
				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
 
				int dataType = Cell.getCellType();
 
				if  (dataType == 3) {
 
					return "";
 
				}else{
 
					String CellData = Cell.getStringCellValue();
 
					return CellData;
 
				}catch (Exception e){
 
				System.out.println(e.getMessage());
 
				throw (e);
 
				}
 
			} */
