package NextHRMReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NextHRMReportsTest {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://nexthrm.vteamslabs.com/");
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("gulraiz.shabbir@nxb.com.pk");;
		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Shah3030");
		driver.findElement(By.xpath("//*[@id=\"loginFormSubmit\"]"));
		driver.findElement(By.xpath("//*[@id=\"REPORTS_href\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"fromDate\"]")).sendKeys("01/12/2019");
		driver.findElement(By.xpath("//*[@id=\"toDate\"]")).sendKeys("01/12/2019");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/form/div/div/div[2]/input[2]")).click();
		
	}

}
