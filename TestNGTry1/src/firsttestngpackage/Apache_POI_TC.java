package firsttestngpackage;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;



import firsttestngpackage.Constants;
import firsttestngpackage.ExcelUtils;

import firsttestngpackage.SignIn_Action;
public class Apache_POI_TC {
  
  private static WebDriver driver = null;
  static String driverPath = "C:\\geckodriver.exe";
  public static void main(String[] args) throws Exception {
  
         //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
  
         ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Sheet1");
  	   System.out.println("Total Number of Rows in the excel is : "+ExcelUtils.rowCount());
  	   System.out.println("Total Number of Columns in the excel is : "+ExcelUtils.columnCount());

         System.setProperty("webdriver.gecko.driver",driverPath);
         driver = new FirefoxDriver();
  
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
         driver.get(Constants.URL);
  
         SignIn_Action.Execute(driver);
  
         System.out.println("Login Successfully, now it is the time to Log Off buddy.");
  
         Home_Page.lnk_LogOut(driver).click(); 
  
         driver.quit();
  
         //This is to send the PASS value to the Excel sheet in the result column.
  
         ExcelUtils.setCellData("Pass", 1, 3);
  
  }
  
  }