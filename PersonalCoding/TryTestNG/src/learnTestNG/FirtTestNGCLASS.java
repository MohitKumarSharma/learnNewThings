package learnTestNG;

import org.testng.annotations.Test;

public class FirtTestNGCLASS {
	
	@Test(enabled=false)
	public void loginApplication() {
		System.out.println("My first test case");
	}
}
