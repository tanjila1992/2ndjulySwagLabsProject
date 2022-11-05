package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsYourCartPage {
	@FindBy(xpath="//button[text()='Remove']")private List<WebElement> remove;
    @FindBy(xpath="")private WebElement checkout;
    @FindBy(xpath="")private WebElement continueShopping;
public SwagLabsYourCartPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void removeProductFronCart(int product) {
	remove.get(product).click();
}
public void clickOnCheckout() {
	checkout.click();
}
public void clickOnContinueShopping() {
	continueShopping.click();
}
}
