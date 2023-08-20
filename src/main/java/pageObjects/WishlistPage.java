package pageObjects;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonMethods.CommonMethods;
 
public class WishlistPage extends CommonMethods{ 			//Represents the Wishlist page

WebDriver driver;
public WishlistPage(WebDriver driver)
{
	
	super(driver);
	this.driver =driver;
}
 
By deleteWishlist = By.xpath("//span[@id='delete-button-I3L620HYIDZSJW']//span//input");
By deletedIcon = By.xpath("//div[text()='Deleted']");
By searchButton = By.id("twotabsearchtextbox");
public void clickOnDelete()										//Click on Delete button 
{ 
	driver.findElement(deleteWishlist).click();
}
public void selectItemToDelete(String item)  				//Selecting the desired item via Streams method
{  	
	WebElement selecteditem = driver.findElement(By.xpath("//div[contains(@id,'itemMain_')][./div//h2[@class='a-size-base'][contains(.,'" + item + "')]]//input[@name='submit.deleteItem']"));//Selecting the desired item
	selecteditem.click();
}   
public String assertIf()										// Getting the confirmation message that the item is deleted 
{  
	waitTill(deletedIcon);
	String title = driver.findElement(deletedIcon).getText();
	return title;
}
public void searchItem(String item) 							//Searching for a item in the Search bar
{	
	driver.findElement(searchButton).sendKeys(item + Keys.ENTER);
}	
} 