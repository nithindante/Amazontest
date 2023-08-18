package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponents;

public class ProductDisplayPage extends AbstractComponents{ 
WebDriver driver;
public ProductDisplayPage(WebDriver driver)   
{
	super(driver);
	this.driver = driver;                             
} 
By addToWishlist = By.id("add-to-wishlist-button-submit");           
By viewWishlist = By.xpath("//a[text()='View Your List']");
By cartButton = By.id("add-to-cart-button");
By cartPageButton = By.id("nav-cart");
By waitElement = By.xpath("//a[@title='Go to Cart']");
By extraCart = By.id("attach-sidesheet-view-cart-button"); 
By extraPopup = By.id("attach-sidesheet-checkout-button");
By customiseButon = By.id("gestalt-popover-button-announce");
By uploadButton = By.xpath("//label[contains(text(),'Upload')]");
By chooseFrame = By.xpath("//div[contains(text(),'Black Colour Frame')]");
By chooseFramesize = By.xpath("//div[contains(text(),'9.5\" x 13.5\" + Glossy Sheet')]");
By customiseAddToCart = By.id("gc-add-to-cart");
public void tabHandling() 														//Switching windows 
{ 	
	String pattern = driver.getWindowHandle();									//Getting parent window
	Set<String> windows = driver.getWindowHandles();					
	for(String s:windows)
	{
		if(!s.contentEquals(pattern))			 								//Comparing and if not parent window, Switch to Next window
		{  
			driver.switchTo().window(s); 
		}
	} 
}
public void clickOnAddToCart() throws InterruptedException {					//Clicking on add to cart 
	waittill(cartButton);
	driver.findElement(cartButton).click();	
}	
public void addToWishlist()														//Clicking on Add to Wishlist
{
	driver.findElement(addToWishlist).click();
}
public Wishlistpage viewWishlist() {											
	waittill(viewWishlist);
	driver.findElement(viewWishlist).click();
	return new Wishlistpage(driver); 
}
public void goToCart()
{
	driver.findElement(cartPageButton).click();
}
public void clickOnExtraCart() {												//if the pop up opens up once you add a product to cart
	waittill(extraCart);
	driver.findElement(extraCart).click();	
}
public void clickOnExtraPopupToCheckout()										//Clicking on the Checkout button in the extra popup 
{
	waittill(extraPopup);
	driver.findElement(extraPopup).click();
}
public void clickCustomiseButton() throws InterruptedException
{
	driver.findElement(customiseButon).click();
	waittill(customiseButon);
	Thread.sleep(2000);
	driver.findElement(uploadButton).click();
}
public Cartpage fileUpload(String filepath) throws AWTException, InterruptedException {			// Creating the method to upload image into our Website and cusatomise the photo frame 
	StringSelection str =  new StringSelection(filepath);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null); 					//copied the contents to Clipboard 
	Robot rob = new Robot();																	//Created Robots class, so that we use the following action: Control+ V and Enter
	rob.delay(3000);  
	rob.keyPress(KeyEvent.VK_CONTROL);
	rob.keyPress(KeyEvent.VK_V);
	rob.keyRelease(KeyEvent.VK_V);
	rob.keyRelease(KeyEvent.VK_CONTROL);
	rob.keyPress(KeyEvent.VK_ENTER);
	waittill(customiseAddToCart);
	driver.findElement(customiseAddToCart).click();
	return new Cartpage(driver);
}

public void setQuantity(int num)																		//Selecting the Quantity via dropdown
{
	WebElement option = driver.findElement(By.id("quantity"));
	Select var = new Select(option);
	var.selectByIndex(num);
}
}