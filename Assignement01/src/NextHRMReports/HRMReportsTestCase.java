package NextHRMReports;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class HRMReportsTestCase {
  @Test
  public void f() {
	  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://nexthrm.vteamslabs.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"userName\"]")));
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("gulraiz.shabbir@nxb.com.pk");;
		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Shah3030");
		driver.findElement(By.xpath("//*[@id=\"loginFormSubmit\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"REPORTS_href\"]")));
		driver.findElement(By.xpath("//*[@id=\"REPORTS_href\"]")).click();
		WebElement fromDateBox= driver.findElement(By.xpath("//*[@id=\"fromDate\"]"));
		WebElement ToDateBox= driver.findElement(By.xpath("//*[@id=\"toDate\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", fromDateBox);
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", ToDateBox);
		fromDateBox.clear();
		fromDateBox.sendKeys("2019-12-01");
		ToDateBox.clear();
		ToDateBox.sendKeys("2019-12-24");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/form/div/div/div[2]/input[2]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER); //press enter key
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			System.out.print("Robot Error");
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
  }

}
	