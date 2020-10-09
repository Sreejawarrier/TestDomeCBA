package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CbaLoginClass {
	private final WebDriver driver;

	// Page Object constructor which passes the driver context forward
	public CbaLoginClass(WebDriver driver) {
		this.driver = driver;
	}

	By usernameloc = By.id("fakeUsername");
	By passwordloc = By.id("password");
	By loginButtonloc = By.name("submit-commsec-form");

	public CbaLoginClass testCommSecLogin() {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		// Tap on Logon icon on the right top corner
		driver.findElement(By.className("log-on-text")).click();
		// Click on Common Section/NetBank/
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[contains(text(),'CommSec')]")))
				.click();
		driver.findElement(By.id("fakeUsername")).sendKeys("fakename");
		driver.findElement(By.id("password")).sendKeys("passwd");
		driver.findElement(By.name("submit-commsec-form")).click();
		return this;// As it fails to login return the Login page url
	}

	public CbaLoginClass testNetbankLogin() {
		driver.get("https://www.commbank.com.au");
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		// Tap on Logon icon on the right top corner
		driver.findElement(By.className("log-on-text")).click();
		// Click on Common Section/NetBank/
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[contains(text(),'NetBank')]")))
				.click();
		// The login fields are within a frame.Hence switch to that before trying to
		// input client number and password
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("input#txtMyClientNumber_field")).sendKeys("12345");
		// driver.findElement(By.cssSelector("#txtMyPassword_label")).sendKeys("pwd");
		driver.findElement(By.cssSelector("input#txtMyPassword_field")).sendKeys("pwd");
		driver.findElement(By.cssSelector("input#btnLogon_field")).click();
		// Switch back the control to default content
		driver.switchTo().defaultContent();
		return this;// As it fails to login return the Login page url
	}

	public void testTravelProducts() {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		// Tap on Logon icon on the right top corner
		// WebElement travelProd =
		// driver.findElement(By.xpath("//a[@href='https://www.commbank.com.au/travel.html?ei=hp-prodnav_Travel']"));
		wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Travel products')]")))
				.click();
		// act.click(travelProd).build().perform();
		// https://www.commbank.com.au/bank-accounts.html?ei=hp-prodnav_BankAccounts
		// Click on Common Section/NetBank/
		// assertTrue(driver.getCurrentUrl().endsWith("prodnav_Travel"));
		System.out.println(driver.findElement(By.xpath("//div[@class='card-header']")).getText());
		// Assert.assertEquals(driver.findElement(By.partialLinkText("Travel
		// produc")).getText(),"Travel products");
		// Assert.assertEquals(driver.findElement(By.partialLinkText("Financial
		// Independen")).getText(),"Travel products");
		System.out.println(driver.findElement(By.partialLinkText("Travel produc")).getText());
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Discover more"))).click();

	}

	public void nextChapterTest() {//
		driver.get("https://www.commbank.com.au");
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		// Tap on Tell me more button on the homescreen
		// driver.findElement(By.linkText("Tell me more"));
		// Click on financial abuse Section
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button_secondary"))).click();
		// assertTrue(driver.getCurrentUrl().endsWith("financialabuse"));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#hub']"))).click();
		// Assert.assertEquals(driver.findElement(By.partialLinkText("Financial
		// Independen")).getText(),"Travel products");
		System.out.println(driver.findElement(By.partialLinkText("Financial Independen")).getText());

		// wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Discover
		// more"))).click();
	}

}
