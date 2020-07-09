package Skills;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SkillAddRemove {
	
	public WebDriver driver;
	public WebDriverWait wait;
	FirefoxOptions firefoxOptions;
	ArrayList<String> multipleTabs;
	
	@BeforeTest
	public void initializeParameters() {
		firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("marionette", true);
	    driver = new FirefoxDriver(firefoxOptions);
		wait=new WebDriverWait(driver,20);
		
		//multipleTabs=new ArrayList<String>(driver.getWindowHandles());
		
		System.out.println("initializeParameters");
	}
	@Parameters({"baseURL"})
	@BeforeClass
	public void initializeBrowser(String baseURL) {
		driver.get(baseURL);
		String texttoCheck=driver.findElement(By.xpath("//*[@id=\"loginFormSubmit\"]")).getText();
		Assert.assertEquals(texttoCheck, "SIGN IN");
		System.out.println("initializeBrowser");
	}
	@Parameters({"userName","passWord"})
	@BeforeMethod
	public void login(String userName,String passWord) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"userName\"]")));
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(userName);;
		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passWord);
		driver.findElement(By.xpath("//*[@id=\"loginFormSubmit\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[1]/div[1]/div[3]/a/div")));
		System.out.println("login");
	}
	@Parameters({"Skill"})
	@Test(priority=0)
	public void setSkill(String Skill) {
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div[1]/div[3]/a/div")).click();			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/div/div[3]/div[1]/h4/a/i")));
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/div/div[3]/div[1]/h4/a/i")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/div/div[3]/div[2]/div/ul/li[4]/a")));
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/div/div[3]/div[2]/div/ul/li[4]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div[2]/form/div[2]/span/span[1]/span/ul/li/input")));
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div[2]/form/div[2]/span/span[1]/span/ul/li/input")).sendKeys(Skill);
		Robot robot;
		try {
			robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addskilltypesformsubmit\"]")));
		driver.findElement(By.xpath("//*[@id=\"addskilltypesformsubmit\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"regressionexp_id\"]")));
		Select Experience=new Select(driver.findElement(By.xpath("//*[@id=\"regressionexp_id\"]")));
		Experience.selectByValue("1");
		Select Rating=new Select(driver.findElement(By.xpath("//*[@id=\"regressionlevel\"]")));
		Rating.selectByValue("1");
		driver.findElement(By.xpath("//*[@id=\"skillSave\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div[2]/p")));
		System.out.println("Test Set Skill");
	}
	@Test(priority=1)
	public void removeSkill() {
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div[1]/div[3]/a/div")).click();			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/div/div[3]/div[1]/h4/a/i")));
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/div/div[3]/div[1]/h4/a/i")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/div/div[3]/div[2]/div/ul/li[4]/a")));
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/div/div[3]/div[2]/div/ul/li[4]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/form/div[3]/div[1]/div[5]/a/img")));
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/form/div[3]/div[1]/div[5]/a/img")).click();
		
		Robot robot;
		try {

			robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"regressionlevel\"]")));
		driver.findElement(By.xpath("//*[@id=\"skillSave\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div[2]/p")));
		System.out.println("Test Remove Skill");
	}
	
	@AfterMethod
	public void Logout() {
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/a[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/form/div[1]/div/div")));
		System.out.println("Logout");
	}
	
	@AfterClass
	public void destroyDriver() {
		driver.close();
		System.out.println("destroyDriver");
	}
	
	@AfterTest
	public void removeParametes() {
		
		System.out.println("After Test");
	}
}
