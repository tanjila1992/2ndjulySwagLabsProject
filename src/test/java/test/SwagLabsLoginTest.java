package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabsLoginPage;
import utility.BaseClass;
import utility.Parameterization;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class SwagLabsLoginTest extends BaseClass {
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

	@DataProvider(name = "LoginData")
	public Object[][] data() throws EncryptedDocumentException, IOException {
		String pass = Parameterization.getExcelData("credentials", 1, 1);
		return new Object[][] { { Parameterization.getExcelData("credentials", 1, 0), pass },
				{ Parameterization.getExcelData("credentials", 2, 0), pass },
				{ Parameterization.getExcelData("credentials", 3, 0), pass },
				{ Parameterization.getExcelData("credentials", 4, 0), pass } };
	}

	@Test(dataProvider = "LoginData")
	public void swagLabsLoginTestWithValidCredentials(String name, String pass) {
		test = reports.createTest("swagLabsLoginTestWithValidCredentials");
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserName(name);
		swagLabsLoginPage.enterPassword(pass);
		swagLabsLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

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
		driver.quit();

	}
	

}
