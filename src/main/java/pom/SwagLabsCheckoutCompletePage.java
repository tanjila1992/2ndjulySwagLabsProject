package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsCheckoutCompletePage {
	@FindBy(xpath="//button[text()='Back Home']")private WebElement backHome;
	public SwagLabsCheckoutCompletePage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
	public void clickOnBackHome() {
		backHome.click();
	}

}
