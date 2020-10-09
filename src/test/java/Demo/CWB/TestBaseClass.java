package Demo.CWB;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBaseClass 
{
   
	WebDriver driver;
	int i=1;
	String driverPath = "C:\\ComplyBook_Selenium\\New folder\\chromedriver.exe";
	public static final String currentDir = System.getProperty("user.dir");
	public TestBaseClass() throws Exception {
		}
  public void setUP() {
	String driverPath = "C:\\ComplyBook_Selenium\\New folder\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", driverPath);
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.commbank.com.au");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
  }
}
   
