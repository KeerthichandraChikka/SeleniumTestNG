package kc.io.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import kc.io.context.WebDriverManager;
import kc.io.pageFactory.PageInstanceFactory;
import kc.io.pages.LestKodeitAlerts;

public class LetsKodeitAlertTest extends BaseTest {
	
	

	@Test(testName = "Alert Test", description = "Alert test functionality", priority = 0)
	public void lestKodeit() {
		
		System.out.println(Thread.currentThread().getId() + "   From alert test method");
		driver.get("https://www.letskodeit.com/practice");
		LestKodeitAlerts letPage = PageInstanceFactory.getPageInstance(LestKodeitAlerts.class);
		letPage.enterName("Keerthichandra");
		letPage.clickAlert();
		letPage.clickAlertCancel();
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(false, true);

	}

	@Test(testName = "Sudo Test", description = "Test Description", priority = 1)
	public void print() {
		driver.get("https://www.letskodeit.com/practice");
		System.out.println(Thread.currentThread().getId() + "   Hello there it is test print");
	}

}
