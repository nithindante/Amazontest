package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class Cartpage extends AbstractComponents{					// The page that pops up when you click on add to cart and between cart. 
WebDriver driver;
public Cartpage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
}
By addtocheckoutbutton = By.name("proceedToRetailCheckout");
By redirecttocartbutton = By.id("nav-cart-count-container");
By searchbar = By.id("twotabsearchtextbox");
public Checkoutpage addToCheckout() 								// Clicks on Add to checkout button
{
	driver.findElement(addtocheckoutbutton).click();
	return new Checkoutpage(driver);
}

public void redirectToCart() throws InterruptedException			// Redirects to Cart
{
	
	waittill(redirecttocartbutton);
	driver.findElement(redirecttocartbutton).click();
}

public Productresults searchItem(String productname)				// Searches the the desired item within Search bar
{
	driver.findElement(searchbar).sendKeys(productname + Keys.ENTER);
	return new Productresults(driver);		
}




}