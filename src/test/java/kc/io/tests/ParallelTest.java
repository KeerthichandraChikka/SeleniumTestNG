package kc.io.tests;

import org.testng.annotations.Test;

public class ParallelTest extends BaseTest {
	

	@Test(testName = "Sudo Test1", description = "Test Description Parallel tests")
	public void printParallelTest() {
		driver.get("https://www.google.com");
		System.out.println(Thread.currentThread().getId() + "   Hello there it is test print in Parallel Test");
	}

}
