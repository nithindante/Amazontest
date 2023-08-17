package pageObjects;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class Wishlistpage extends AbstractComponents{

WebDriver driver;
public Wishlistpage(WebDriver driver)
{
	super(driver);
	this.driver =driver;
}

By deletewishlist = By.xpath("//span[@id='delete-button-I3L620HYIDZSJW']//span//input");
By deletedicon = By.xpath("//div[text()='Deleted']");
By searchbutton = By.id("twotabsearchtextbox");
public void clickondelete()
{
	driver.findElement(deletewishlist).click();
}
public void selectitemtodelete(String itemname)  
{  
	
	WebElement selecteditem = driver.findElement(By.xpath("//div[contains(@id,'itemMain_')][./div//h2[@class='a-size-base'][contains(.,'" + itemname + "')]]//input[@name='submit.deleteItem']"));
	selecteditem.click();
}   
public String assertif()
{  
	waittill(deletedicon);
	String title = driver.findElement(deletedicon).getText();
	return title;
}
public void searchitem(String item) 
{	
	driver.findElement(searchbutton).sendKeys(item + Keys.ENTER);
}	
} 