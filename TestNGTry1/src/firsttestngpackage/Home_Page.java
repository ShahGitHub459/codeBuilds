package firsttestngpackage;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Home_Page {

private static WebElement element = null;

public static WebElement lnk_MyAccount(WebDriver driver){

element = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul[2]/li[2]/a"));


return element;

}

public static WebElement lnk_LogOut(WebDriver driver){

element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/article/div/div/div/p[1]/a"));

return element;

}

}