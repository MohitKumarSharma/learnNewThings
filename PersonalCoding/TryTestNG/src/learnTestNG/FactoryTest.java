package learnTestNG;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

class SimpleTest
{
    private int param;
 
    public SimpleTest(int param) {
        this.param = param;
    }
 
    @Test
    public void testMethodOne() {
        int opValue = param + 1;
        System.out.println("Test method one output: " + opValue);
    }
 
    @Test
    public void testMethodTwo() {
        int opValue = param + 2;
        System.out.println("Test method two output: " + opValue);
    }
}
 
public class FactoryTest
{
    @Factory
    public Object[] factoryMethod() {
        return new Object[] { new SimpleTest(0), new SimpleTest(1) };
    }
    
	public static void main(String[] args) {
		SimpleTest st = new SimpleTest(0);
    	st.testMethodOne();
	}
   
}