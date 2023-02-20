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
import pom.SwagLabsBackToProductsPage;
import pom.SwagLabsLoginPage;
import pom.SwagLabsProductPage;
import utility.BaseClass;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class VerifyAddToCartForSingleProduct extends BaseClass {
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

	@Test
	public void verifyAddToCartForSingleProduct() {
		test = reports.createTest("verifyAddToCartForSingleProduct");
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		SwagLabsProductPage swagLabsProductPage = new SwagLabsProductPage(driver);
		swagLabsProductPage.clickOnSingleProduct();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");
		SwagLabsBackToProductsPage swagLabsBackToProductsPage = new SwagLabsBackToProductsPage(driver);
		swagLabsBackToProductsPage.clickOnAddToCart();
		Assert.assertTrue(swagLabsBackToProductsPage.removeisDisplayed());
	}

	@Test
	public void verifyBackToProductButton() {
		test = reports.createTest("verifyBackToProductButton");
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		SwagLabsProductPage swagLabsProductPage = new SwagLabsProductPage(driver);
		swagLabsProductPage.clickOnSingleProduct();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");
		SwagLabsBackToProductsPage swagLabsBackToProductsPage = new SwagLabsBackToProductsPage(driver);
		swagLabsBackToProductsPage.clickOnAddToCart();
		Assert.assertTrue(swagLabsBackToProductsPage.removeisDisplayed());
		swagLabsBackToProductsPage.clickOnBackToProduct();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}

	@Test
	public void verifyProductIsAddedToCart() {
		test = reports.createTest("verifyProductIsAddedToCart");
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		SwagLabsProductPage swagLabsProductPage = new SwagLabsProductPage(driver);
		swagLabsProductPage.clickOnSingleProduct();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");
		SwagLabsBackToProductsPage swagLabsBackToProductsPage = new SwagLabsBackToProductsPage(driver);
		swagLabsBackToProductsPage.clickOnAddToCart();
		Assert.assertTrue(swagLabsBackToProductsPage.removeisDisplayed());
		swagLabsBackToProductsPage.clickOnBackToProduct();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		swagLabsProductPage.clickOnCart();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

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
