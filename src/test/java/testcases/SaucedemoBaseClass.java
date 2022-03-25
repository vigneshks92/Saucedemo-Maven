package testcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaucedemoBaseClass {
	
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeTest
	public void DataSetUP() {
	
		reports = new ExtentReports("ExtentReport.html");
	}
	
	@AfterTest
	public void DataTearDown() {
		
		reports.flush();
		reports.close();
	}

	@BeforeMethod
	public void Setup(Method method) {
		
		test = reports.startTest(method.getName());
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
}
	
	@AfterMethod
	public void TearDown() {
		
		reports.endTest(test);
		
		driver.quit();
		
	}

}
