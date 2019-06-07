package learnTestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestNgListener1 implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " onTestStart");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " onTestSuccess");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " onTestFailure");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod() + " onTestFailure");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
