package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

public class NewClass {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		// Initialize the Runner for your test.
		EyesRunner runner = new ClassicRunner();

		// Initialize the eyes SDK
		Eyes eyes = new Eyes(runner);

		// Change the APPLITOOLS_API_KEY API key with yours
		eyes.setApiKey("VBdcg7WHCup1wGOJWmSUXx88oUxFdiM6wS4R0ucQBcY110");
		
		// Set AUT's name, test name and viewport size (width X height)
		// We have set it to 800 x 600 to accommodate various screens. Feel free to
		// change it.
		eyes.open(driver, "Demo App", "Smoke Test", new RectangleSize(800, 600));

		// Navigate the browser to the "ACME" demo app.
		driver.get("https://nextbridge.com/");
		
		// This line takes the screenshot
		eyes.checkWindow("Hello");
		driver.findElement(By.xpath("/html/body/div/div[3]/button")).click();
		eyes.checkWindow("Click");
		// End the test.
		eyes.closeAsync();

		// Close the browser.
		driver.quit();

		// If the test was aborted before eyes.close was called, ends the test as
		// aborted.
		eyes.abortIfNotClosed();
		
		// Wait and collect all test results
		TestResultsSummary allTestResults = runner.getAllTestResults();

		// Print results
		System.out.println(allTestResults);
	}
}
