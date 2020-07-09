package firsttestngpackage;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class LogIn_Page {

private static WebElement element = null;

public static WebElement txtbx_UserName(WebDriver driver){

element = driver.findElement(By.xpath("//*[@id=\"username\"]"));

return element;
}

public static WebElement txtbx_Password(WebDriver driver){

element = driver.findElement(By.xpath("//*[@id=\"password\"]"));

return element;
}

public static WebElement btn_LogIn(WebDriver driver){

element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/article/div/div/div[2]/div[1]/form/p[3]/button"));

return element;
}

}