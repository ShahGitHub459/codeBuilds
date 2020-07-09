import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {

	 //WebDriver driver;
	static AppiumDriver<MobileElement> driver;
	//AndroidDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			openCalculator();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getCause());
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	public static void openCalculator() throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "HUAWEI Y7 Prime 2019");
		cap.setCapability("udid","58KRX19307004176");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","8.1.0");
		cap.setCapability("appPackage","com.android.calculator2");
		cap.setCapability("appActivity","com.android.calculator2.Calculator");
		cap.setCapability("automationName","UiAutomator2");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,cap);
		System.out.print("application Started");
		MobileElement two=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.GridLayout/android.widget.Button[12]"));
		MobileElement one=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.GridLayout/android.widget.Button[11]"));
		MobileElement plus=driver.findElement(By.id("com.android.calculator2:id/op_add"));
		MobileElement equal=driver.findElement(By.id("com.android.calculator2:id/eq"));
		MobileElement result=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
		two.click();
		plus.click();
		one.click();
		equal.click();
		String res=result.getText();
		System.out.print("Result is -------------------------------------"+res);
	}
}
