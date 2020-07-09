package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mediaMarketObjects {
	public static WebElement element=null;
	public static WebElement innerTextmarca(WebDriver driver) {		
		try {
			element=driver.findElement(By.xpath("/html/body/div[1]/section/main/section[2]/div/div/div/div/div[1]/div[1]/div[2]/div[1]/h5/a"));		
			}
		catch (NoSuchElementException e) {
			element=null;
		    System.out.println("Element Not Found");
		}
		return element;
	}
	public static WebElement innerTextnombre(WebDriver driver) {
	try {
		element=driver.findElement(By.xpath("/html/body/div[1]/section/main/section[2]/div/div/div/div/div[1]/div[1]/div[2]/div[1]/h1"));
	}
	catch (NoSuchElementException e) {
		element=null;
	    System.out.println("Element Not Found");
	}
		return element;
	}
	public static WebElement innerTextprice(WebDriver driver) {
		try {
		element=driver.findElement(By.xpath("/html/body/div[1]/section/main/section[2]/div/div/div/div/div[1]/div[1]/div[3]/div[1]/form/div[1]/span/div/div[2]"));
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
			if(driver.findElement(By.xpath("//*[@id=\"AddToCart\"]")).isEnabled())
			{
				return "Available";
			}
			else if(!driver.findElement(By.xpath("//*[@id=\"AddToCart\"]")).isEnabled()){
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
