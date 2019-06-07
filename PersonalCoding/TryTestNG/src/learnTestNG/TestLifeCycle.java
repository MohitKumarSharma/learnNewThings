package learnTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

@Test(enabled=true)
public class TestLifeCycle {
  @Test
  public void test() {
	  System.out.println("abc");
  }
  
  @BeforeSuite
  public void beforeSuite() {
	 System.out.println("beforeSuite");
  }
  
  @AfterSuite
  public void afterSuite() {
	 System.out.println("afterSuite");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Called before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Called After class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Called Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Called after TEst");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Called Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Called after Method");
  }

  @Test
  public void test1() {
	  System.out.println("test1");
  }
  
  @Test
  public void test2() {
	  System.out.println("test2");
  }
}
