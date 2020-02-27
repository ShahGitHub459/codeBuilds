package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTestMavenTry {
	public WebDriver driver;
	
	  @Test
	  public void openMyBlog() {
		driver.get("https://www.softwaretestingmaterial.com/");
		System.out.print("------------------------------HELLO----1------------------------------");
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
		  
		  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

	}