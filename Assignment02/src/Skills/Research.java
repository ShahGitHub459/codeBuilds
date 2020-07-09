package Skills;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Research {
  @Test
  public void tableData() {
	  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	  WebDriver driver=new FirefoxDriver();
	  driver.get("https://nexthrm.vteamslabs.com/events/index/save/s");
	  List <WebElement> col=driver.findElements(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/thead/tr/th"));
	  List <WebElement> rows=driver.findElements(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr"));
	  System.out.println(col.size());
	  System.out.println(rows.size());
	  
	  for(int i=1;i<=rows.size();i++)
	  {
		  String textName=driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr["+i+"]/td["+2+"]")).getText();
		  if("Page Object Model".equals(textName)) {
			  driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr["+i+"]/td["+7+"]/a[1]")).click();
			  //String textlinkDelete=
		  }
/*		  for (int j=1;j<col.size();j++)
		  {
			  String text=driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			  System.out.print(text+"||");
		  }
		  System.out.println();*/
	  }
  }
/*  @Test
  public void tableData() {
	  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	  WebDriver driver=new FirefoxDriver();
	  driver.get("https://nexthrm.vteamslabs.com/events/index/save/s");
	  List <WebElement> col=driver.findElements(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/thead/tr/th"));
	  List <WebElement> rows=driver.findElements(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr"));
	  System.out.println(col.size());
	  System.out.println(rows.size());
	  
	  for(int i=1;i<=rows.size();i++)
	  {
		  for (int j=1;j<col.size();j++)
		  {
			  String text=driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			  System.out.print(text+"||");
		  }
		  System.out.println();
	  }
  }*/
}
