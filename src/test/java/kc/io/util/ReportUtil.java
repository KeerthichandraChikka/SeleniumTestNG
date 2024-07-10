package kc.io.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;

import kc.io.reports.ExtentManager;

public class ReportUtil {
	
	
	
	public static void addScreenshot(String message){
		
		//TakesScreenshot screenshot = (TakesScreenshot) kc.io.context.WebDriverManager.getDriver();
		
		String base64Image = "data:image/png;base64," +
							((TakesScreenshot)kc.io.context.WebDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentManager.getCurrentTest().log(
				LogStatus.INFO,message, 
				ExtentManager.getCurrentTest().addBase64ScreenShot(base64Image));	
	}
	
	public static void addScreenshot(LogStatus status, String message) {
		String base64Image = "data:image/png;base64,"+
							((TakesScreenshot)kc.io.context.WebDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);	
		ExtentManager.getCurrentTest().log(status, message, ExtentManager.getCurrentTest().addBase64ScreenShot(base64Image));
	}

}
