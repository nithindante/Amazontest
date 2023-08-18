package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Productresults{				// The page that represents the Products results page
 
	WebDriver driver;	
	
	public Productresults(WebDriver driver)
	{ 
		this.driver = driver;  
		 
	}   
	public List<WebElement> getProductsList()				// Getting the list of all the products displayed 
	{
	List<WebElement> productslist = driver.findElements(By.cssSelector("img[class='s-image']"));
	return productslist;
	}   	
	
	public ProductDisplayPage selectItem(String productname)  	//Selecting the desired item, and returning a Constructor for Product Display page 
	{		
		WebElement item = getProductsList().stream().filter(product->product.getAttribute("alt").contains(productname)).findFirst().orElse(null);	//Using Streams function to filter out the desired item 
		scrollItem(item);																															//Scrolling till we reach the item
		item.click();
		return new ProductDisplayPage(driver); 		
	} 
	void scrollItem(WebElement item)						//Scrolling till the element is reached
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", item);
	} 
}