package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SaucedemoLoginPage;

public class SaucedemoLoginTest extends SaucedemoBaseClass {
	
	@Test
	public void LoginSuccessTest() {
		
		SaucedemoLoginPage login = new SaucedemoLoginPage();
		login.LoginFunction("standard_user", "secret_sauce");
		
	}
	
	@Test
	public void LoginFailureTest() {
		
		SaucedemoLoginPage login = new SaucedemoLoginPage();
		login.LoginFunction("standard_user", "secret_s");
		
		WebElement ErrorMessage = driver.findElement(By.xpath("//*[@class='error-message-container error']/h3"));
		String ActualMsg = ErrorMessage.getText();
		String ExpectedMsg = "Epic sadface: Username and password do not match any user in this service";
		
		Assert.assertEquals(ActualMsg, ExpectedMsg);
	}

}
