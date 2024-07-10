package kc.io.context;

/**
 * 
 * @author Keerthichandra.Chikka
 *
 */

public class ProjectConstants {
	
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");
	
	public static final String REPORT_DIRECTORY = WORKING_DIRECTORY +"/Reports/AutomationReport.html";
	
	public static final String CHROME_DIRECTORY = WORKING_DIRECTORY+"/src/test/resources/drivers/chromedriver";
	
	public static final String PROJECT_NAME = "Selenium With TestNG and Extent Reports";
	
	public static final String EXTENT_FILE = WORKING_DIRECTORY+"/src/test/resources/config/extent-config.xml";
	
	public static final String PROPERTY_FILE = WORKING_DIRECTORY+"/src/test/resources/properties.prop";

}
