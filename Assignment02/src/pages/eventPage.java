package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class eventPage {
	WebDriver driver;
	By linkToClick=By.xpath("//*[@id=\"EVENTS_href\"]");
	By newButton=By.xpath("/html/body/div[4]/div/div/div/div/div[2]/div/div/a[1]");
	By eventName=By.xpath("//*[@id=\"name\"]");
	By startDate=By.xpath("//*[@id=\"dailyReminderStart\"]");
	By saveButton=By.xpath("/html/body/div[4]/div/div/div[1]/div/div/div/form/div/div/div[4]/div[6]/div/div/input");
	By editButton;
	By deleteButton;
	By reminderTime=By.xpath("/html/body/div[4]/div/div/div[1]/div/div/div/form/div/div/div[3]/div[2]/div[4]/div/div/button/span[1]");
	By reminderTimeText=By.xpath("/html/body/div[4]/div/div/div[1]/div/div/div/form/div/div/div[3]/div[2]/div[4]/div/div/div/ul/li[2]/a/span[1]");
	By tableRows=By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr");
	By tableColumns=By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/thead/tr/th");
	List <WebElement> rows;
	public eventPage(WebDriver driver) {
		this.driver=driver;
	}
	//Clicker
	public void setLinkToClick() {
		driver.findElement(linkToClick).click();
	}
	public void setnewButtonClick() {
		driver.findElement(newButton).click();
	}
	public void setEditButtonClick(String editText) {
		List <WebElement> rows=driver.findElements(tableRows);
		for(int i=1;i<=rows.size();i++)
		  {
			  String textName=driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr["+i+"]/td["+2+"]")).getText();
			  if(editText.equals(textName)) {
				  editButton=By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr["+i+"]/td["+7+"]/a[1]");
			  }
		  }
		driver.findElement(editButton).click();
	}
	public void setDeleteButton(String editText) {
		List <WebElement> rows=driver.findElements(tableRows);
		for(int i=1;i<=rows.size();i++)
		  {
			  String textName=driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr["+i+"]/td["+2+"]")).getText();
			  if(editText.equals(textName)) {
				  deleteButton=By.xpath("/html/body/div[4]/div/div/div/div/div[3]/table/tbody/tr["+i+"]/td["+7+"]/a[2]");
			  }
		  }
		driver.findElement(deleteButton).click();
	}
	public void clickSaveButton() {
		driver.findElement(saveButton).click();
	}
	//setter
	public void setEventName(String eventNameText) {
		driver.findElement(eventName).sendKeys(eventNameText);
	}
	public void setStartDate(String startDateText) {
		WebElement fromDateBox= driver.findElement(startDate);
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", fromDateBox);
		driver.findElement(startDate).sendKeys(startDateText);
	}
	public void setTimer(String value) {
		driver.findElement(reminderTime).click();
		driver.findElement(reminderTimeText).click();
		//Select drptimer=new Select(driver.findElement(reminderTime));
		//drptimer.selectByValue(value);
		//drptimer.selectByVisibleText(value);
	}
	
}
