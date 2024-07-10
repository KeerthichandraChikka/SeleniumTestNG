package kc.io.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import kc.io.ReportListeners.ExtentReporter;
import kc.io.context.ProjectConstants;
import kc.io.reports.ExtentManager;

/**
 * @author Keerthichandra.Chikka <Keerthichandra@hotmail.com>
 */

@Listeners({ ExtentReporter.class })
public class BaseTest {

	protected WebDriver driver;
	protected ExtentReports extent = null;

	@BeforeSuite(alwaysRun = true)
	public void gobalSetup() {
		extent = ExtentManager.getExtentReports();
	}

	@BeforeClass
	public void testSetup() {

		System.out.println(ProjectConstants.CHROME_DIRECTORY);
		System.setProperty("webdriver.chrome.driver", ProjectConstants.CHROME_DIRECTORY);
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("disable-infobars");
		driver = new ChromeDriver(op);
		kc.io.context.WebDriverManager.setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void beforeMethod() {

		kc.io.context.WebDriverManager.setDriver(driver);
		driver = kc.io.context.WebDriverManager.getDriver();
		
	}

	@AfterClass
	public void wrapupTest() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}
