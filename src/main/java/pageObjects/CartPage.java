package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonMethods.CommonMethods;

public class CartPage extends CommonMethods{					// The page that pops up when you click on add to cart and between cart. 
WebDriver driver;
public CartPage(WebDriver driver)
{  
	super(driver);
	this.driver=driver;
}
By addToCheckoutButton = By.name("proceedToRetailCheckout");
By reDirectToCartButton = By.id("nav-cart-count-container");
By searchBar = By.id("twotabsearchtextbox");
public CheckoutPage addToCheckout() 								// Clicks on Add to checkout button
{
	driver.findElement(addToCheckoutButton).click();
	return new CheckoutPage(driver);
}

public void redirectToCart() throws InterruptedException			// Redirects to Cart
{
	
	waitTill(reDirectToCartButton);
	driver.findElement(reDirectToCartButton).click();
}

public ProductResultsPage searchItem(String productname)				// Searches the the desired item within Search bar
{
	driver.findElement(searchBar).sendKeys(productname + Keys.ENTER);
	return new ProductResultsPage(driver);		
}




}