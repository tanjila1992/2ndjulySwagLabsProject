package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabsProductPage {
	@FindBy(xpath="//button[text()='Add to cart']")private List<WebElement> addToCart;
	@FindBy(xpath="//button[text()='Remove']")private List<WebElement> remove;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")private WebElement pageOption;
	@FindBy(xpath="//a[text()='All Items']")private WebElement allItems;
	@FindBy(xpath="//a[text()='About']")private WebElement about;
	@FindBy(xpath="//a[text()='Logout']")private WebElement logout;
	@FindBy(xpath="//a[text()='Reset App State']")private WebElement resetAppState;
	@FindBy(xpath="//button[@id='react-burger-cross-btn']")private WebElement close;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement cart;	
	@FindBy(xpath="//select[@class='product_sort_container']")private WebElement filter;
	@FindBy(xpath="//a[text()='Twitter']")private WebElement twitter;
	@FindBy(xpath="//a[text()='Facebook']")private WebElement facebook;
	@FindBy(xpath="//a[text()='LinkedIn']")private WebElement linkedIn;
    @FindBy(xpath="//img[@alt='Sauce Labs Backpack']")private WebElement singleProduct;
    public SwagLabsProductPage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
    public void addProductToCart(int product) {
    addToCart.get(product).click();
    }
    public void removeProductFromCart(int product) {
    	remove.get(product).click();
    }
    public void clickOnPageOption() {
    	pageOption.click();
    }
    public void clickOnAllItems() {
    	allItems.click();
    }
    public void clickOnAbout() {
    	about.click();
    }
    public void clickOnLogout() {
    	logout.click();
    }
    public void clickOnResetAppState() {
    	resetAppState.click();
    }
    public void clickOnClose() {
    	close.click();
    }
    public void clickOnCart() {
    	cart.click();
    }
    public void selectFromName(String val) {
    	Select s=new Select(filter);
    	s.selectByValue(val);
    }

    public void openTwitterPage() {
    	twitter.click();
    }
    public void openFacebookPage() {
    	facebook.click();
    }
    public void openLinkedInPage() {
    	linkedIn.click();
    }
    public boolean isRemoveButtonIsDisplayed(int product) {
    	return remove.get(product).isDisplayed();
    }
    public boolean isAddToCartButtonIsDisplayed(int product) {
    	return addToCart.get(product).isDisplayed();
    }
    public void addMultipleProductToCart() {
    	for(int i=addToCart.size()-1;i>=0;i--) {
    		addToCart.get(i).click();
    	}
    }
    public void removeMultipleProductFromCart() {
    	for(int i=remove.size()-1;i>=0;i--) {
    		 remove.get(i).click();
    	}
    }
    public int getNumberOfAddToCart() {
    	return addToCart.size();
    }
    public int getNumberOfRemove() {
    	return remove.size();
    }
    public void clickOnSingleProduct() {
     singleProduct.click();
    }
    
    }



