package kc.io.reports;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import kc.io.context.ProjectConstants;

/**
 * @author Keerthichandra.Chikka
 */

public class ExtentManager {
	
	private static ExtentReports extent;
	
	private static Map<Long, ExtentTest> map = new HashMap<Long, ExtentTest>();
	
	public static ExtentReports getExtentReports() {
		if(extent == null) {
		extent = new ExtentReports(ProjectConstants.REPORT_DIRECTORY, true);
		extent.assignProject(ProjectConstants.PROJECT_NAME);
		extent.loadConfig(new File(ProjectConstants.EXTENT_FILE));
		}
		return extent;
	}
	
	public synchronized static void startTest(String testname, String description) {
		ExtentTest test = getExtentReports().startTest(testname, description); 
		map.put(Thread.currentThread().getId(), test);
	}
	
	public synchronized static ExtentTest getCurrentTest() {	
		return map.get(Thread.currentThread().getId());	
	}
	
	public synchronized static void endCurrentTest() {
		getExtentReports().endTest(getCurrentTest());
	}

}
