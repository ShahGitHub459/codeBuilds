package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By userName= By.xpath("//*[@id=\"userName\"]");
	By passWord= By.xpath("//*[@id=\"password\"]");
	By signInButton= By.xpath("//*[@id=\"loginFormSubmit\"]");
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	//Setter
	public void setUserName(String userNameText) {
		driver.findElement(userName).sendKeys(userNameText);
	}
	public void setPassword(String passWordText) {
		driver.findElement(passWord).sendKeys(passWordText);
	}
	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}
	//Getter
	public String getSignInText() {
		String signinText=driver.findElement(signInButton).getText();
		return signinText;
	}
}
