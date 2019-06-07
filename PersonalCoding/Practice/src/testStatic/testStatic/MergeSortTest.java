package testStatic.testStatic;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class MergeSortTest {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }


  @Test
  public void divide() {
	  // Then write test cases.
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void merge() {
    throw new RuntimeException("Test not implemented");
  }
}
