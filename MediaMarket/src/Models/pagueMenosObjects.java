package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pagueMenosObjects {
	public static WebElement element=null;
	public static WebElement innerTextmarca(WebDriver driver) {	
		
		//WebDriverWait wait = new WebDriverWait(driver, 60);

		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div[4]/div/div[6]/div/div[3]/div/div[2]/ul/li[5]/section/a/article/div[5]/div/div/div[2]/span"))));
		
		try {
			element=driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div[4]/div/div[2]/div/section/div/div[2]/div/div[1]/div/span"));		
			}
		catch (NoSuchElementException e) {
			element=null;
		    System.out.println("Element Not Found");
		}
		return element;
	}
	public static WebElement innerTextnombre(WebDriver driver) {
	try {
		element=driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div[4]/div/div[2]/div/section/div/div[2]/div/div[2]/h1/span"));
	}
	catch (NoSuchElementException e) {
		element=null;
	    System.out.println("Element Not Found");
	}
		return element;
	}
	public static WebElement innerTextprice(WebDriver driver) {
		try {
		element=driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div[4]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/div[1]/div/div[2]/div/div[2]/span"));
	}
	catch (NoSuchElementException e) {
		element=null;
	    System.out.println("Element Not Found");
	}
		return element;
	}
	public static WebElement innerTextean(WebDriver driver) {
		try {
		element=driver.findElement(By.xpath("/html/body/div[1]/section/main/section[2]/div/div/div/div/div[1]/div[2]/section[1]/div/div/div/div/section[2]/div/div/table/tbody/tr/td[2]/span"));
	}
	catch (NoSuchElementException e) {
		element=null;
	    System.out.println("Element Not Found");
	}
		return element;
	}
	public static String availabilityCheck(WebDriver driver) {
		try {
			if(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div[4]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/div[2]/div/div[2]/button")).isEnabled())
			{
				return "Available";
			}
			else if(!driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div[4]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/div[2]/div/div[2]/button")).isEnabled()){
				return "Not Available";			
			}
			else {
				return "Not Found";
			}
			}
			 catch (NoSuchElementException e) {
				 return "Not Found";	
			    }
	}
	
/*	public static WebElement() {
		element=
		return element;
	}
*/
}
