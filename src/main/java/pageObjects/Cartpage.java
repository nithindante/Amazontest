package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class Cartpage extends AbstractComponents{
WebDriver driver;
public Cartpage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
}
By addtocheckoutbutton = By.name("proceedToRetailCheckout");
By redirecttocartbutton = By.id("nav-cart-count-container");
By searchbar = By.id("twotabsearchtextbox");
public Checkoutpage addtocheckout() 
{
	driver.findElement(addtocheckoutbutton).click();
	return new Checkoutpage(driver);
}

public void redirecttocart() throws InterruptedException
{
	
	Thread.sleep(4000);
	driver.findElement(redirecttocartbutton).click();
}

public Productresults searchitem(String productname)
{
	driver.findElement(searchbar).sendKeys(productname + Keys.ENTER);
	return new Productresults(driver);		
}




}