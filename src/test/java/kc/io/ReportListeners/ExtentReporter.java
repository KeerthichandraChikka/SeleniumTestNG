package kc.io.ReportListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import kc.io.reports.ExtentManager;
import kc.io.util.ReportUtil;

public class ExtentReporter implements ITestListener {

	public void onTestStart(ITestResult result) {
		ExtentManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		ReportUtil.addScreenshot(LogStatus.PASS, result.getMethod().getMethodName() + " Test case passed");
	}

	public void onTestFailure(ITestResult result) {

		Throwable t = result.getThrowable();
		String reason = "";
		if (t != null) {
			reason = t.getMessage();
		}
		ReportUtil.addScreenshot(LogStatus.FAIL,
				result.getMethod().getMethodName() + " Test case Failed due to " + reason);
	}

	public void onTestSkipped(ITestResult result) {
		
		ExtentManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		ExtentManager.getCurrentTest();
		ExtentManager.getExtentReports().flush();
	}

}
