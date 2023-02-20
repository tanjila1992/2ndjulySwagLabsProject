package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabsLoginPage;
import pom.SwagLabsProductPage;
import utility.BaseClass;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class VerifyAddToCartButton extends BaseClass{
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReports() {
		reports = Reports.createReports();
	}
  
	@BeforeMethod
	public void launchBrowser() {
		driver = Browser.openBrowser();
	}
	
	@Test(priority=1)
	public void verifyAddToCartButton() {
		test=reports.createTest("verifyAddToCartButton");
		SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
		SwagLabsProductPage swagLabsProductPage=new SwagLabsProductPage(driver);
		swagLabsProductPage.addProductToCart(0);
		Assert.assertTrue(swagLabsProductPage.isRemoveButtonIsDisplayed(0));
		}
	@Test(priority=2)
	public void addingMultipleProductToCart() {
		test=reports.createTest("addingMultipleProductToCart");
		SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
		SwagLabsProductPage swagLabsProductPage=new SwagLabsProductPage(driver);
		int numberOfAddToCart=swagLabsProductPage.getNumberOfAddToCart();
		swagLabsProductPage.addMultipleProductToCart();
		Assert.assertEquals(swagLabsProductPage.getNumberOfRemove(),numberOfAddToCart );
	}
	
	@Test(priority=3)
	public void verifyProductRemoveFromProductPage() {
		test=reports.createTest("verifyProductRemoveFromProductPage");
		SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
		SwagLabsProductPage swagLabsProductPage=new SwagLabsProductPage(driver);
		int numberOfAddToCart=swagLabsProductPage.getNumberOfAddToCart();
		swagLabsProductPage.addMultipleProductToCart();
		Assert.assertEquals(swagLabsProductPage.getNumberOfRemove(),numberOfAddToCart );
		swagLabsProductPage.removeProductFromCart(0);
		Assert.assertTrue(swagLabsProductPage.isAddToCartButtonIsDisplayed(0));
	}
	@Test(priority=4)
	public void verifyAllProductRemoveFromProductPage() {
		test=reports.createTest("verifyAllProductRemoveFromProductPage");
		SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
		SwagLabsProductPage swagLabsProductPage=new SwagLabsProductPage(driver);
		int numberOfAddToCart=swagLabsProductPage.getNumberOfAddToCart();
		swagLabsProductPage.addMultipleProductToCart();
		Assert.assertEquals(swagLabsProductPage.getNumberOfRemove(),numberOfAddToCart );
		int numberOfremove=swagLabsProductPage.getNumberOfRemove();
		swagLabsProductPage.removeMultipleProductFromCart();
		Assert.assertEquals(numberOfremove,swagLabsProductPage.getNumberOfAddToCart());
	}
	@AfterMethod
	public void getTestResults(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		} else {
			test.log(Status.SKIP, result.getName());
		}
	}

	@AfterTest
	public void publishResult() {
		reports.flush();
	}

}
