package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class rossmannObjects {
	public static WebElement element=null;
	public static WebDriverWait wait;
	public static WebElement innerTextmarca(WebDriver driver) {		
		try {
			wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/section[1]/div/div[4]/h1/span[1]")));
			element=driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div[4]/h1/span[1]"));		
			}
		catch (NoSuchElementException e) {
			element=null;
		    System.out.println("Element Not Found Marca");
		}
		return element;
	}
	public static WebElement innerTextnombre(WebDriver driver) throws InterruptedException {
	try {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/section[1]/div/div[4]/div[2]/h2")));
		element=driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div[4]/div[2]/h2"));
		
	}
	catch (NoSuchElementException e) {
		element=null;
	    System.out.println("Element Not Found Nombre");
	}
		return element;
	}
	public static WebElement innerTextprice(WebDriver driver) {
		try {
			wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/section[1]/div/div[4]/div[4]/div[1]/div[1]")));
			element=driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div[4]/div[4]/div[1]/div[1]"));
			while(!element.getText().contains(" "+"z")) {
				element=driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div[4]/div[4]/div[1]/div[1]"));
				System.out.println("Loop");
			}
			String name="dsds";
			
	}
	catch (NoSuchElementException e) {
		element=null;
	    System.out.println("Element Not Found Price");
	}
		return element;
	}
	public static WebElement innerTextean(WebDriver driver) {
		try {
		element=driver.findElement(By.xpath("/html/body/div[1]/section/main/section[2]/div/div/div/div/div[1]/div[2]/section[1]/div/div/div/div/section[2]/div/div/table/tbody/tr/td[2]/span"));
	}
	catch (NoSuchElementException e) {
		element=null;
	    System.out.println("Element Not Found EAN");
	}
		return element;
	}
	public static String availabilityCheck(WebDriver driver) {
		try {
			if(driver.findElement(By.xpath("//*[@id=\"js-add-to-cart\"]")).isEnabled())
			{
				return "Available";
			}
			else if(!driver.findElement(By.xpath("//*[@id=\"js-add-to-cart\"]")).isEnabled()){
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
