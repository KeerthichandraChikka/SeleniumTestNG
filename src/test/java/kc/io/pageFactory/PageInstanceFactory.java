package kc.io.pageFactory;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import kc.io.context.WebDriverManager;
import kc.io.pages.BasePage;

public class PageInstanceFactory {
	
	public static <T extends BasePage> T getPageInstance(Class<T> type) {
		
		try {
			return type.getConstructor(WebDriver.class).newInstance(WebDriverManager.getDriver());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
