package Skills;

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

import pages.LoginPage;
import pages.eventPage;

public class eventAddandDeletion {
	public WebDriver driver;
	public WebDriverWait wait;
	FirefoxOptions firefoxOptions;
	ArrayList<String> multipleTabs;
	LoginPage objLoginPage;
	eventPage objEventPage;
	@BeforeTest
	public void initializeParameters() {
		firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("marionette", true);
	    driver = new FirefoxDriver(firefoxOptions);
		wait=new WebDriverWait(driver,20);
		objLoginPage=new LoginPage(driver);
		objEventPage=new eventPage(driver);
		System.out.println("initializeParameters");
	}
	@Parameters({"baseURL"})
	@BeforeClass
	public void initializeBrowser(String baseURL) {
		driver.get(baseURL);
		System.out.println("initializeBrowser");
	}
	@Parameters({"userName","passWord"})
	@BeforeMethod
	public void login(String userName,String passWord) {
		objLoginPage.setUserName(userName);
		objLoginPage.setPassword(passWord);
		objLoginPage.clickSignIn();
		System.out.println("login");
	}
	@Parameters({"EventName","startDate"})
	@Test(priority=0)
	public void setEvent(String EventName,String startDate) {
		objEventPage.setLinkToClick();
		objEventPage.setnewButtonClick();
		objEventPage.setEventName(EventName);
		objEventPage.setStartDate(startDate);
		objEventPage.clickSaveButton();
	}
	@Parameters({"EventName","tiMe"})
	@Test(priority=1)
	public void editEvent(String EventName,String tiMe) {
		objEventPage.setLinkToClick();
		objEventPage.setEditButtonClick(EventName);
		objEventPage.setTimer(tiMe);
		objEventPage.clickSaveButton();
	}
	@Parameters({"EventName"})
	@Test(priority=2)
	public void deleteEvent(String EventName) {
		objEventPage.setLinkToClick();
		objEventPage.setDeleteButton(EventName);
		Robot robot;
		try {
			robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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