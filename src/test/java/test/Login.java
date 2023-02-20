package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	@Test(dataProvider = "Login")
	public void loginWithTestData(String userName, String pass) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		driver.findElement(By.id("login-button")).click();

		// driver.close();
	}

	@DataProvider(name = "Login")
	public Object[] data() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "locked_out_user\r\n", "secret_sauce" },
				{ "problem_user", "secret_sauce" }, { "performance_glitch_user\r\n", "secret_sauce" } };

	}
	
	
	@Test
    public void fileUpload() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://the-internet.herokuapp.com/upload");
	driver.manage().window().maximize();
	driver.findElement(By.id("file-upload")).sendKeys("C:\\fileuploade\\file.txt");
	driver.findElement(By.id("file-submit")).click();
	WebElement uploaded=driver.findElement(By.tagName("h3"));
	System.out.println(uploaded.getText()+"****");
	Assert.assertEquals(uploaded.getText(),"File Uploaded!");
    }
	
	
	@Test
	public void textFileDownload() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("textbox")).sendKeys("testing+++");
		driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();
		driver.findElement(By.id("link-to-download")).click();
	}
	
	@Test
	public void pdfFileDownload() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("pdfbox")).sendKeys("testing+++----");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
	}

}
