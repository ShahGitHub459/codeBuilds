package ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import Constants.ConstantsTobeUsed;

public class ExcelRead {
	public ConstantsTobeUsed readExcel(String FilePath,String FileName,String SheetName)  throws IOException{
		File file=new File(FilePath+"\\"+FileName);
		FileInputStream inputStream=new FileInputStream(file);
		Workbook guru99workbook=null;
		String FileExtensionName=FileName.substring(FileName.indexOf("."));
		if(FileExtensionName.equals(".xlsx")) {
			guru99workbook=new XSSFWorkbook(inputStream);
		}
		else if(FileExtensionName.equals(".xls")) {
			guru99workbook=new HSSFWorkbook(inputStream);
		}
		
		
		Sheet guru99Sheet=guru99workbook.getSheet(SheetName);
		int rowCount=guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
		ConstantsTobeUsed C1=new ConstantsTobeUsed();
		C1.nombre=new String[rowCount];
		C1.marca=new String[rowCount];
		C1.precio=new Double[rowCount];
		C1.link=new String[rowCount];
		C1.link_img=new String[rowCount];
		C1.ean=new String[rowCount];
		C1.availability=new int[rowCount];
		for (int i=1;i<rowCount+1;i++)
		{
			Row row=guru99Sheet.getRow(i);
			String nombreTemp=row.getCell(columnName("nombre",guru99Sheet)).getStringCellValue();
			String marcaTemp=row.getCell(columnName("marca",guru99Sheet)).getStringCellValue();
			Double precioTemp=row.getCell(columnName("precio",guru99Sheet)).getNumericCellValue();
			String linkTemp=row.getCell(columnName("link",guru99Sheet)).getStringCellValue();
			String link_imgTemp=row.getCell(columnName("link_img",guru99Sheet)).getStringCellValue();
			String eanTemp=row.getCell(columnName("ean",guru99Sheet)).getStringCellValue();
			int availabilityTemp=(int) row.getCell(columnName("availability",guru99Sheet)).getNumericCellValue();
			C1.nombre[i-1]=nombreTemp;
			C1.marca[i-1]=marcaTemp;
			C1.precio[i-1]=precioTemp;
			C1.link[i-1]=linkTemp;
			C1.link_img[i-1]=link_imgTemp;
			C1.ean[i-1]=eanTemp;
			C1.availability[i-1]=availabilityTemp;

		}
		int length=rowCount;
		inputStream.close();
		ConstantsTobeUsed C2=new ConstantsTobeUsed(C1.nombre,C1.marca,C1.precio,C1.link,C1.link_img,C1.ean,C1.availability,length);
		return C2;
//		C1.nombre,C1.marca,C1.precio,C1.link,C1.link_img,C1.ean
				
	}
	public static int columnName(String a,Sheet sh) throws EncryptedDocumentException, IOException {

	    int coefficient = 0;
	    Row row = sh.getRow(0);
	    int cellNum = row.getPhysicalNumberOfCells();
	    for (int i = 0; i < cellNum; i++) {
	        if ((row.getCell(i).toString()).equals(a)) {
	            coefficient = i;
	        }
	    }

	    return coefficient;
	}
	public void writeExcel(String FilePath,String FileName,String SheetName,String Result,  int RowNum)  throws IOException{
		File file=new File(FilePath+"\\"+FileName);
		FileInputStream inputStream=new FileInputStream(file);
		Workbook guru99workbook=null;
		String FileExtensionName=FileName.substring(FileName.indexOf("."));
		if(FileExtensionName.equals(".xlsx")) {
			guru99workbook=new XSSFWorkbook(inputStream);
		}
		else if(FileExtensionName.equals(".xls")) {
			guru99workbook=new HSSFWorkbook(inputStream);
		}
		
		
		Sheet guru99Sheet=guru99workbook.getSheet(SheetName);		
		Row row=guru99Sheet.getRow(RowNum);
		Cell cell=row.getCell(columnName("Note",guru99Sheet));
		cell.setCellValue(Result);
		inputStream.close();

	    //Create an object of FileOutputStream class to create write data in excel file

	    FileOutputStream outputStream = new FileOutputStream(file);

	    //write data in the excel file

	    guru99workbook.write(outputStream);

	    //close output stream

	    outputStream.close();


	}	
}
