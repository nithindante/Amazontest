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
By addtowishlist = By.id("add-to-wishlist-button-submit");           
By viewwishlist = By.xpath("//a[text()='View Your List']");
By cartbutton = By.id("add-to-cart-button");
By gotocartpagebutton = By.id("nav-cart");
By waitelement = By.xpath("//a[@title='Go to Cart']");
By extracart = By.id("attach-sidesheet-view-cart-button");
By extrapopup = By.id("attach-sidesheet-checkout-button");
By customisebuton = By.id("gestalt-popover-button-announce");
By uploadbutton = By.xpath("//label[contains(text(),'Upload')]");
By chooseframe = By.xpath("//div[contains(text(),'Black Colour Frame')]");
By chooseframesize = By.xpath("//div[contains(text(),'9.5\" x 13.5\" + Glossy Sheet')]");
By customiseaddtocart = By.id("gc-add-to-cart");
public void Tabhandling() 
{ 
	String pattern = driver.getWindowHandle();
	Set<String> windows = driver.getWindowHandles();	
	for(String s:windows)
	{
		if(!s.contentEquals(pattern))			 								//when the tab is not parentwindow
		{  
			driver.switchTo().window(s); 
		}
	} 
}
public void clickonaddtocart() throws InterruptedException {	
	waittill(cartbutton);
	Thread.sleep(2000);
	driver.findElement(cartbutton).click();	
}
public void addtowishlist()
{
	driver.findElement(addtowishlist).click();
}
public Wishlistpage viewwishlist() {
	
	waittill(viewwishlist);
	driver.findElement(viewwishlist).click();
	return new Wishlistpage(driver); 
}
public void gotocart()
{
	driver.findElement(gotocartpagebutton).click();
}
public void extracart() {
	waittill(extracart);
	driver.findElement(extracart).click();	
}
public void extrapopuptocheckout()
{
	waittill(extrapopup);
	driver.findElement(extrapopup).click();
}
public void customisebutton() throws InterruptedException
{
	driver.findElement(customisebuton).click();
	waittill(uploadbutton);
	Thread.sleep(2000);
	driver.findElement(uploadbutton).click();
}
public Cartpage fileupload(String filepath) throws AWTException, InterruptedException {
	StringSelection str =  new StringSelection(filepath);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null); //copied the contents to Clipboard
	Robot rob = new Robot();
	rob.delay(3000); 
	rob.keyPress(KeyEvent.VK_CONTROL);
	rob.keyPress(KeyEvent.VK_V);
	rob.keyRelease(KeyEvent.VK_V);
	rob.keyRelease(KeyEvent.VK_CONTROL);
	rob.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(6000);
	driver.findElement(customiseaddtocart).click();
	return new Cartpage(driver);
}

public void setquantity()
{
	WebElement option = driver.findElement(By.id("quantity"));
	Select var = new Select(option);
	var.selectByIndex(5);
}
}