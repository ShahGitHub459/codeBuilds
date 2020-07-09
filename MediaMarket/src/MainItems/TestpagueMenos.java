package MainItems;

import java.io.IOException;
import java.math.BigDecimal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Constants.ConstantsTobeUsed;
import ExcelUtils.ExcelRead;
import Models.pagueMenosObjects;

public class TestpagueMenos {
	public ConstantsTobeUsed C3;
	public ExcelRead objExcelFile;
	public String filePath;
	public WebDriver driver;
	public String baseURL;
	public ConstantsTobeUsed fileConstants=new ConstantsTobeUsed();
	@BeforeTest
	public void doBeforeTest() throws IOException {
		ExcelRead objExcelFile = new ExcelRead();
		//ConstantsTobeUsed fileConstants=new ConstantsTobeUsed();
		String filePath = fileConstants.FilePath;
		String fileName=fileConstants.FileName;
		String SheetName=fileConstants.SheetName;
	    try {
	    	C3=objExcelFile.readExcel(filePath,fileName,SheetName);
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    FirefoxBinary firefoxBinary = new FirefoxBinary();
	    FirefoxOptions options = new FirefoxOptions();
	    options.setBinary(firefoxBinary);
	    options.setHeadless(true);  // <-- headless set here
	    driver = new FirefoxDriver(options);
	    //driver=new FirefoxDriver();
  }
	@Test
	public void Test() throws IOException {
		for(int i=0;i<C3.rowLength;i++) {
			
			baseURL=C3.link[i];
			driver.get(baseURL);
			String Result="";
			String innerTextmarca;
			String innerTextnombre;
			String innerTextprice;
			String innerTextean;
			String Availabilityflag;
			if(pagueMenosObjects.innerTextmarca(driver)!=null) {
				innerTextmarca=pagueMenosObjects.innerTextmarca(driver).getText();
			}
			else {
				innerTextmarca=pagueMenosObjects.innerTextmarca(driver).getText();
			}
			if(pagueMenosObjects.innerTextnombre(driver)!=null) {
				innerTextnombre=pagueMenosObjects.innerTextnombre(driver).getText();
			}
			else {
				innerTextnombre="Not Found from element";
			}
			if(pagueMenosObjects.innerTextprice(driver)!=null) {
				innerTextprice=pagueMenosObjects.innerTextprice(driver).getText();
			}
			else {
				innerTextprice="Not Found from element";
			}
			if(pagueMenosObjects.innerTextean(driver)!=null) {
				innerTextean=pagueMenosObjects.innerTextean(driver).getText();
			}
			else {
				innerTextean="Not Found from element";
			}
			if(pagueMenosObjects.availabilityCheck(driver)!=null) {
				Availabilityflag=pagueMenosObjects.availabilityCheck(driver);
			}
			else {
				Availabilityflag="Not Found from element";
			}

			if(!C3.marca[i].equals("N")) {
				if(innerTextmarca.contains(C3.marca[i])){
					Reporter.log("Verification Passed for Marca-"+i);
					}
					else {
					Reporter.log("Verification Failed for Marca-"+i+"-"+innerTextmarca);
					Result=Result+"Verification Failed for Marca||";
					}
			}
			else {
				Reporter.log("Verification Skipped for Marca-"+i);	
				Result=Result+"Verification Skipped for Marca||";
			}
			if(!C3.nombre[i].equals("N")) {
				//String textwithoumarca=C3.nombre[i].replace(C3.marca[i]+" ", "");
				String textToVerify=C3.nombre[i].toUpperCase();
				String textNombreVerify=innerTextnombre.toUpperCase();
				if(textNombreVerify.equals(textToVerify)){
					Reporter.log("Verification Passed for Nombre-"+i);
					}
					else {
					Reporter.log("Verification Failed for Nombre-"+i+"-"+innerTextnombre);
					Result=Result+"Verification Failed for Nombre||";
					}	
			}
			else {
				Reporter.log("Verification Skipped for Nombre-"+i);	
				Result=Result+"Verification Skipped for Nombre||";	
			}
			if(!C3.precio[i].toString().equals("N")) {
				boolean areTheyEqual = new BigDecimal(C3.precio[i].toString().replaceAll("[^0-9]", "")).compareTo(new BigDecimal(innerTextprice.replaceAll("[^0-9]", ""))) == 0;
				//String.valueOf(C3.precio[i]).equals(innerTextprice)
				if(areTheyEqual){
					Reporter.log("Verification Passed for Price-"+i);
					}
					else {
					Reporter.log("Verification Failed for Price-"+i+"-"+innerTextprice);
					Result=Result+"Verification Failed for Price||";
					}		
			}
			else {
				Reporter.log("Verification Skipped for Price-"+i);	
				Result=Result+"Verification Skipped for Price||";				
			}
			if(!C3.ean[i].equals("N")) {
				if(innerTextean.contains(C3.ean[i])){
					Reporter.log("Verification Passed for EAN-"+i);
					}
					else {
					Reporter.log("Verification Failed for EAN-"+i+"-"+innerTextean);
					Result=Result+"Verification Failed for EAN||";
					}
			}
			else {
				Reporter.log("Verification Skipped for EAN-"+i);	
				//Result=Result+"Verification Skipped for EAN||";	
			}
			if(!String.valueOf(C3.availability[i]).equals("N")) {
				if(String.valueOf(C3.availability[i]).equals("0")){
					if(Availabilityflag.equals("Available")) {
					Reporter.log("Verification Passed for Availability-"+i);
					}
					else {
						Reporter.log("Verification Failed for Availability-"+i+"-"+Availabilityflag);
						Result=Result+"Verification Failed for Availability||";
					}
					}
					else if(String.valueOf(C3.availability[i]).equals("3")) {
						if(Availabilityflag.equals("Not Available")) {
							Reporter.log("Verification Passed for Availability-"+i);
							}
							else {
								Reporter.log("Verification Failed for Availability-"+i+"-"+Availabilityflag);
								Result=Result+"Verification Failed for Availability||";
							}
					}
					else if(String.valueOf(C3.availability[i]).equals("4")) {
						if(Availabilityflag.equals("Not Found")) {
							Reporter.log("Verification Passed for Availability-"+i);
							}
							else {
								Reporter.log("Verification Failed for Availability-"+i+"-"+Availabilityflag);
								Result=Result+"Verification Failed for Availability||";
							}
					}
				
			}
			else {
				Reporter.log("Verification Skipped for Availability-"+i);	
				Result=Result+"Verification Skipped for Availability||";	
			}
			try {
				ExcelRead objExcelFile = new ExcelRead();
				//String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
				objExcelFile.writeExcel(fileConstants.FilePath,fileConstants.FileName,fileConstants.SheetName, Result, i+1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			baseURL = null;
	        
			
		}
  }
	@AfterTest
	public void driverdestroy() {
		driver.quit();
	}
	
}