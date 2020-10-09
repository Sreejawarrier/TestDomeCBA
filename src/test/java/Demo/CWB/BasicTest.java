package Demo.CWB;

import org.testng.annotations.*;
import pages.CbaLoginClass;////

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;

public class BasicTest extends TestBaseClass {
    static CbaLoginClass lp;
	public BasicTest() throws Exception {
	super();
	setUP();
		}
	
 	@Test
	public void commSecTest() throws Exception {
    lp=new CbaLoginClass(driver);
	lp.testCommSecLogin();
    assertTrue(driver.getCurrentUrl().endsWith("LoginFailed"));

	}
	@Test
	public void netBankTest() throws Exception {
	lp=new CbaLoginClass(driver);
	lp.testNetbankLogin();
    assertTrue(driver.getCurrentUrl().endsWith("CommBankVersion2"));

	}
	/*@Test
	public void testTravelMoney() throws Exception {
	lp=new CbaLoginClass(driver);
	lp.testTravelProducts();
	assertTrue(driver.getCurrentUrl().endsWith("Travel"));
	}
	@Test
	public void testNextChapterPage() throws Exception {
	lp=new CbaLoginClass(driver);
	lp.nextChapterTest();
	assertTrue(driver.getCurrentUrl().endsWith("financialabuse"));
	}*/
	
 
@AfterTest
  public void afterTest() {
	 driver.quit();
	 assertTrue( true );
  }

}

