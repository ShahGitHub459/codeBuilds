package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wortenModel {

	public static WebElement element=null;
	public static WebElement innerTextmarca(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/section/section[1]/div[2]/div/div[1]/h2/a"));
		return element;
	}
	public static WebElement innerTextnombre(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/section/section[1]/div[2]/div/div[1]/div/h1"));
		return element;
	}
	public static WebElement innerTextprice(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@id=\"price_ref\"]"));
		return element;
	}
	public static WebElement innerTextean(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/section/section[4]/article/div[2]/ul/li[1]/span[2]"));
		return element;
	}
	public static String availabilityCheck(WebDriver driver) {
		try {
			if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/section/section[1]/div[2]/form[1]/div[2]/div[2]/button")).isEnabled())
			{
				return "Available";
			}
			else if(!driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/section/section[1]/div[2]/form[1]/div[2]/div[2]/button")).isEnabled()){
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
