package MainItems;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FamilaNed {
	public WebDriver driver;
	public String baseURL;
  @Test
  public void f() {
	  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	  driver=new FirefoxDriver();
		baseURL="https://www.cosicomodo.it/familanordest/mestre/Salumi-da-banco/Salame-Ungherese/p/UNICOMM_FAMILA_002038166001";
		driver.get(baseURL);
		try {
		if(driver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/div[2]/div/div[1]/a")).isDisplayed())
		{
			System.out.print("Found");
		}
		else {
			System.out.print("Not Found");			
		}
		}
		 catch (NoSuchElementException e) {
			 System.out.print("Not Found");	
		    }
		
  }
}
