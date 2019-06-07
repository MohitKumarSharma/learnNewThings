package learnTestNG;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderParamTest {
	PrimeNumberCheck primeNumberCheck;
	
	@BeforeClass
	public void init() {
		primeNumberCheck = new PrimeNumberCheck();
	}
	
	@DataProvider(name="numberList")
	public static Object[][] primeNumbers() {
		return new Object[][] {{7, true}, {10, false}, {16, false}, {11, true}};
	}
	
	@DataProvider(name="genObjData")
	public static Object[][] generateObjData(Method _metho) {
		Object[][] data = new Object[3][];
		
		if (_metho.getName().equals("testPrime")) {
			int num = 9;
			for (int i = 0; i < 3; i++) {
				data[i] = new Object[] {num++, false};
			}
			
		} else {
			for (int i = 0; i < 3; i++) {
				BeanClass bc = new BeanClass("" + i, i);
				data[i] = new Object[]{bc};
			}
		}
		
		return data;
	}
	
	@DataProvider(name="genData")
	public Iterator<Object[]> genData(Method _method) {
		
		if (_method.getName().equals("testIterableData")) {
			ArrayList<Object[]> dataList = new ArrayList<>();
			String name = "abc";
			int num = 5;
			
			for (int i = 0; i < 3; i++) {
				dataList.add(new Object[] {name + i, num + i});
			}
			
			return dataList.iterator();
		} {
			return null;
		}
	}
	
	@Test(dataProvider="genObjData")
	public void testObjData(BeanClass _beanObj) {
		System.out.println(_beanObj.getDesc() + "  " + _beanObj.getVal());
	}
	
	@Test(enabled=true, dataProvider="numberList")
	public void testPrime(Integer _number, boolean _expectedResult) {
		System.out.println(_number + " result " + _expectedResult);
		
		assertEquals(primeNumberCheck.isValidate(_number), _expectedResult);
	}
	
	@Test(dataProvider="genData")
	public void testIterableData(String _name, int _num) {
		System.out.println(_name + " " + _num);
	}
}
