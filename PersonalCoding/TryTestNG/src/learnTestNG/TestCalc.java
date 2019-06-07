
package learnTestNG;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCalc {
	Calculator cal;
	int band = 10;
	
	@BeforeSuite(groups= {"increment"})
	public void init() {
		System.out.println("Init is called");
		cal = new Calculator(10);
	}
	
	@BeforeMethod
	public void testBeforeMethod(Method m) {
		String desc = m.getAnnotation(Test.class).description();
		
		System.out.println("Starting testCases " + m.getName() + " " + desc);
	}
	
	@Test(groups= {"increment"}, timeOut=100, invocationCount=2, priority=1, description="Testing add method")
	@Parameters("firstName")
	public void testAdd(String _firstName) {
		System.out.println(_firstName);
		assertEquals(cal.add(5, 6), 11/this.band);
		assertEquals(cal.add(0, 0), 0);
		
	}
	
	@Test(groups= {"increment"}, enabled=true, priority=2)
	public void testMul() {
		assertEquals(cal.mul(10, 5), 50/this.band);
		assertEquals(cal.mul(10, 5), 50);
	}
	
	@Test(groups= {"decrement"}, dependsOnGroups= {"increment.*"}, enabled=true, priority=3, expectedExceptions=ArithmeticException.class)
	public void testDiv() {
		assertEquals(cal.div(10, 0), 100);
		assertEquals(50/10, 5);
		assertEquals(10,  15, 1.0, "2");
	}
	
	@AfterClass
	public void destroy() {
		cal = null;
	}
}
