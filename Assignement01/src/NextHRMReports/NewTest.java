package NextHRMReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  WebDriver driver;

	  FirefoxOptions firefoxOptions = new FirefoxOptions();
	    firefoxOptions.setCapability("marionette", true);
	    driver = new FirefoxDriver(firefoxOptions);
	  driver.get("https://staging.orthocareondemand.com/patient/login");
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("hashim.farooq+regression@nxb.com.pk");
	  driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
	  driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
	  Boolean error=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/main/section/div[2]/div/div"),"These credentials do not match our records."));
	  
	  if(error)
	  {
		  System.out.print("hello");
	  }
	  
	  //	  Thread.sleep(5000);
	  driver.quit();
  }
}
