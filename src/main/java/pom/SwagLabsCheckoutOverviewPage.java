package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsCheckoutOverviewPage {
	@FindBy(xpath = "//button[@id='finish']")
	private WebElement finish;
	@FindBy(xpath = "//button[@id='cancel']")
	private WebElement cancel;

	public SwagLabsCheckoutOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnFinish() {
		finish.click();
	}

	public void clickOnCancle() {
		cancel.click();
	}

}
