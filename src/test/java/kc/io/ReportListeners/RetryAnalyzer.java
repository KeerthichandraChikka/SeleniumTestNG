package kc.io.ReportListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int count = 0;
	int reTry = 3;

	public boolean retry(ITestResult result) {
		
		if(count < reTry) {
			count++;
			return true;
		}
		else {
		return false;
		}
	}

}
