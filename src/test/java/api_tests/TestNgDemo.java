package api_tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.SauceDemoPage;
import utilities.Driver;

public class TestNgDemo {
	
	SauceDemoPage page;
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("this is before test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("this is after test");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method");
	}
	
	@Test(priority=0, description="this is saucedemo")
	public void uiTestDemo() {
		page=new SauceDemoPage();
		Driver.getDriver().get("https://saucedemo.com");
		page.username.sendKeys("standard_user");
		page.password.sendKeys("secret_sauce");
		page.loginbtn.click();
		Assert.assertEquals(page.inventoryItems.size(),6);
	}

	@Test(priority=10)
	public void assertionDemo() {
		//hard assert
		Assert.assertEquals(false, false);
		System.out.println("Hard assertion");
		
	}
	@Test
	public void softAsserDemo() {
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(false, false);
		System.out.println("soft aseert");
		//to capture the fail
		softassert.assertAll();
	}
}
