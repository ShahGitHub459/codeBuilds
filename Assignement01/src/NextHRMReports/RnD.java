package NextHRMReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RnD {
	  @Test
	  public void f() {
		  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();	
			driver.get ("https://staging.orthocareondemand.com/search-doctors") ;
			System.out.println(driver.findElements(By.xpath("//*[@id=\"list\"]/div")).size());
			//*[@id="list"]
	  }
	}