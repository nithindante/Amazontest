package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Productresults{
 
	WebDriver driver;	
	
	public Productresults(WebDriver driver)
	{ 
		this.driver = driver;  
		 
	}  
	public List<WebElement> getproductslist()
	{
	List<WebElement> productslist = driver.findElements(By.cssSelector("img[class='s-image']"));
	return productslist;
	}  
	
	void scrollitem(WebElement item)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", item);
	} 
	public ProductDisplayPage selectitem(String productname)  
	{		
		WebElement item = getproductslist().stream().filter(product->product.getAttribute("alt").contains(productname)).findFirst().orElse(null);	
		scrollitem(item);
		item.click();
		return new ProductDisplayPage(driver); 		
	} 
  
}