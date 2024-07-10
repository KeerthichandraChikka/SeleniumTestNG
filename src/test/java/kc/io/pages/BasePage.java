package kc.io.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {

	protected WebDriver driver;
	protected FluentWait<WebDriver> waiter;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchFieldException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(3));
	}

}