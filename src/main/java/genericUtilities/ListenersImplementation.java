package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class provides implementation to ITestListener interface of testNG
 * @author sharm
 */
public class ListenersImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		//start of @Test - Test method
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------ Test Execution Started ------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------ Test Passed ------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------ Test Failed -------");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------ Test Skipped ------");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("------ Suite Execution Started ------");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("------ Suite Execution Finished ------");
	}

	
}
