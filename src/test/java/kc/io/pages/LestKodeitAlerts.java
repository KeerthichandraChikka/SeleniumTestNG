package kc.io.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LestKodeitAlerts extends BasePage {

	public LestKodeitAlerts(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='alert-example-div']//input[1]")
	private WebElement alertEnterName;
	
	@FindBy(xpath = "//div[@id='alert-example-div']//input[2]")
	private WebElement alert;
	
	@FindBy(xpath = "//div[@id='alert-example-div']//input[3]")
	private WebElement alertOk;
	
	
	public LestKodeitAlerts enterName(String name) {
		alertEnterName.clear();
		alertEnterName.sendKeys(name);
		return this;
	}
	
	public void clickAlert() {
		alert.click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	}
	
	public void clickAlertCancel() {
		alertOk.click();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
	}

}
