package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class Cart extends AbstractComponents{						// Cart in the Amazon website
WebDriver driver;

public Cart(WebDriver driver)
{
	super(driver);
	this.driver=driver; 
}
By addtocheckoutbutton = By.name("proceedToRetailCheckout");
By confirmation = By.xpath("//*[text()=\" was removed from Shopping Cart. \"]");
public Checkoutpage addToCheckout()															// clicking the checkout button
{  
	driver.findElement(addtocheckoutbutton).click();
	return new Checkoutpage(driver);														//returning the next class constructor as return statement 
}
public List<WebElement> getCartList()
{
 List<WebElement> cartlist = driver.findElements(By.xpath("//div[@data-bundleitem=\"absent\"]"));
return cartlist;
} 
public void selectItem(String productname) throws InterruptedException  			//finding the exact product to delete from the string using Streams() function 
{		
	WebElement item = getCartList().stream().filter(s->s.findElement(By.cssSelector("span[class='a-truncate-cut']")).getText().contains(productname)).findFirst().orElse(null);		//selecting the desired product
	Thread.sleep(2000);
	WebElement selectedElement = item.findElement(By.xpath("div[@class='sc-list-item-content']//div//div[@class='sc-item-content-group']/child::div//span[@data-feature-id=\"delete\"]//span//input"));	//clicking the delete button within the selected item
	selectedElement.click();
}
public String assertIf()													// Checking whether the Quote" was removed from Shopping Cart." has appeared or not 
{
	waittill(confirmation);
	String title = driver.findElement(confirmation).getText();
	return title;
}
}