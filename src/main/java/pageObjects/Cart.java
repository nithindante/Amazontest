package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonMethods.CommonMethods;
 
public class Cart extends CommonMethods{						// Cart in the Amazon website
WebDriver driver; 
 
public Cart(WebDriver driver)
{
	super(driver);
	this.driver=driver; 
}
By addToCheckoutButton = By.name("proceedToRetailCheckout");
By confirmation = By.xpath("//*[text()=\" was removed from Shopping Cart. \"]");
public CheckoutPage addToCheckout()															// clicking the checkout button
{  
	driver.findElement(addToCheckoutButton).click();
	return new CheckoutPage(driver);														//returning the next class constructor as return statement 
}
public List<WebElement> getCartList()
{
 List<WebElement> cartlist = driver.findElements(By.xpath("//div[@data-bundleitem=\"absent\"]"));
return cartlist;
} 
public void selectItem(String product) throws InterruptedException  			//finding the exact product to delete from the string using Streams() function 
{		
	WebElement item = getCartList().stream().filter(s->s.findElement(By.cssSelector("span[class='a-truncate-cut']")).getText().contains(product)).findFirst().orElse(null);		//selecting the desired product
	Thread.sleep(2000);
	WebElement selectedElement = item.findElement(By.xpath("div[@class='sc-list-item-content']//div//div[@class='sc-item-content-group']/child::div//span[@data-feature-id=\"delete\"]//span//input"));	//clicking the delete button within the selected item
	selectedElement.click();
}
public String assertIf()													// Checking whether the Quote" was removed from Shopping Cart." has appeared or not 
{
	waitTill(confirmation);
	String title = driver.findElement(confirmation).getText();
	return title;
}
}