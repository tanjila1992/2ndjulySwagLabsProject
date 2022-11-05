package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsChechoutYourInformationPage {
	@FindBy(xpath="//input[@id='first-name']")private WebElement fName;
	@FindBy(xpath="//input[@id='last-name']")private WebElement lName;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement zipCode;
	@FindBy(xpath="//input[@id='continue']")private WebElement continu;
	@FindBy(xpath="//button[@id='cancel']")private WebElement cancle;
	
	public SwagLabsChechoutYourInformationPage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
	public void enterFirstName(String fn) {
		fName.sendKeys(fn);
	}
	public void enterLastName(String ln) {
		lName.sendKeys(ln);
	}
	public void enterZipCode(String zip) {
		zipCode.sendKeys(zip);
	}
	public void clickOnContinue() {
		continu.click();
	}
	public void clickOnCancle() {
		cancle.click();
	}
}
