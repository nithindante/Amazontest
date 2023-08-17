package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class Cart extends AbstractComponents{
WebDriver driver;

public Cart(WebDriver driver)
{
	super(driver);
	this.driver=driver;
}
By addtocheckoutbutton = By.name("proceedToRetailCheckout");
By confirmation = By.xpath("//*[text()=\" was removed from Shopping Cart. \"]");
public List<WebElement> cartlist()
{
	List<WebElement> cartitems = driver.findElements(By.xpath("//li[@class='a-carousel-card']"));
	return cartitems;
}
public void youalsolike() {
	 WebElement item = cartlist().stream().filter(product->product.findElement(By.cssSelector("img")).getAttribute("alt").equalsIgnoreCase("Meyer Pre-Seasoned Cast Iron Frypan | Cast Iron Skillet | Iron Pan | Induction Frying Pan | Iron Fry Pan | Omlette Pan | Cast Iron Utensils for Cooking | Iron Cookware for Kitchen, 22cm, Black")).findFirst().orElse(null);
	System.out.println(item); 
	item.findElement(By.id("a-autoid-12-announce")).click();	
}

public Checkoutpage addtocheckout()
{
	driver.findElement(addtocheckoutbutton).click();
	return new Checkoutpage(driver);
}
public List<WebElement> getcartlist()
{
   List<WebElement> cartlist = driver.findElements(By.xpath("//div[@data-bundleitem=\"absent\"]"));
return cartlist;
} 
public void selectitem(String productname) throws InterruptedException  
{
	
	
	WebElement item = getcartlist().stream().filter(s->s.findElement(By.cssSelector("span[class='a-truncate-cut']")).getText().contains(productname)).findFirst().orElse(null);
	Thread.sleep(2000);
	WebElement nextelement = item.findElement(By.xpath("div[@class='sc-list-item-content']//div//div[@class='sc-item-content-group']/child::div//span[@data-feature-id=\"delete\"]//span//input"));
	nextelement.click();
	System.out.println();
}
public String assertif()
{
	waittill(confirmation);
	String title = driver.findElement(confirmation).getText();
	return title;
}
}