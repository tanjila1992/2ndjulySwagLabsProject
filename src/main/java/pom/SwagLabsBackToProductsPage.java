package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsBackToProductsPage {
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement addToCart;
	@FindBy(xpath="//button[text()='Remove']")private WebElement remove;
	@FindBy(xpath="//button[@id='back-to-products']")private WebElement backToProduct;
    public SwagLabsBackToProductsPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    public void clickOnAddToCart() {
    	addToCart.click();
    }
    public boolean addToCartisDisplayed() {
		return addToCart.isDisplayed();    	
    }
    public void clickOnBackToProduct() {
    	backToProduct.click();
    }
    public boolean removeisDisplayed() {
		return remove.isDisplayed();    	
    }

}
