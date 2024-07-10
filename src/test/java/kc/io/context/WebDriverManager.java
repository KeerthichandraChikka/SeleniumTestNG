package kc.io.context;

import org.openqa.selenium.WebDriver;

/**
 * @author Keerthichandra.Chikka
 */
public class WebDriverManager {

	private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>();

	/**
	 * @return WebDriver instance
	 */
	public static WebDriver getDriver() {
		if (driverInstance.get() == null)
			throw new IllegalStateException("Please set WebDriver");
		else
			return driverInstance.get();
	}

	/**
	 * @param driver
	 */
	public static void setDriver(WebDriver driver) {
		driverInstance.set(driver);
	}

	public void removeDriver() {
		driverInstance.remove();
	}
}
