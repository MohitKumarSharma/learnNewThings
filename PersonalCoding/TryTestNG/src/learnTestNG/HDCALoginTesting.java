package learnTestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HDCALoginTesting {
	WebDriver driver;
	private final String URL = "https://localhost:8443/";
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "D:\\Devlopment\\testingFrameworkR&D\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
	}
	
	@DataProvider
	public Iterator<Object[]> loginData() {
		List<Object[]> dataList = new ArrayList<>();
		
		dataList.add(new Object[] {"admin", "Cumulu1", false});
		dataList.add(new Object[] {"mohit", "Cumulu1", false});
		dataList.add(new Object[] {"admin", "Cumulus@1", true});
		
		return dataList.iterator();
	}
	
	@Test(priority=1)
	public void startApp() {
		String currentUrl = driver.getCurrentUrl();
		
		assertTrue(currentUrl.contains("appLogin.htm"));
	}
	
	@Test(priority=2, dependsOnMethods="startApp", dataProvider="loginData")
	public void loginApp(String _userName, String _password, boolean _result) {
		loginTest(_userName, _password, _result);
	}
	
	public void loginTest(String _userName, String _password, boolean _expected) {
		WebElement loginField = this.findElement(By.xpath(".//*[@id='login_UserId']"));
		WebElement passwordField = this.findElement(By.xpath(".//*[@id='login_Password']"));
		WebElement button = this.findElement(By.xpath(".//*[@id='login_Submit']"));
		
		if (loginField != null) {
			loginField.clear();
			loginField.sendKeys(_userName);
		}
		
		if (_password != null) {
			passwordField.clear();
			passwordField.sendKeys(_password);
		}
		
		if (button != null) {
			button.click();
		}
		
		By manage = By.xpath(".//*[@id='manage']");
		
		WebElement manageLink;
		
		manageLink = this.findElement(manage);
		
		if (manageLink != null) {
			assertEquals(_expected, manageLink.isDisplayed());
		} 
	
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	public WebElement findElement(By _by) {
		WebElement webElement = null;
		
		try {
			webElement = driver.findElement(_by); 
		} catch (Exception _nse) {
			System.out.println("Exception " + _nse.getMessage());
		}
		
		return webElement;
	}
	
	@Test(priority=3, dependsOnMethods="loginApp")
	public void logoutApp() {
		driver.findElement(By.xpath(".//*[@id='logout']")).click();
		
		WebElement manageLink = this.findElement(By.xpath(".//*[@id='manage']"));
		
		
		if (manageLink != null) {
			System.out.println("Inside mange link");
			assertFalse(manageLink.isDisplayed());
		}
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		String currentUrl = driver.getCurrentUrl();
		
		assertTrue(currentUrl.contains("appLogin.htm"));
	}
}
