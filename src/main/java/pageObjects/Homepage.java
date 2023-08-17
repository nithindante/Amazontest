package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import AbstractComponents.AbstractComponents;


public class Homepage extends AbstractComponents
{
	WebDriver driver;
	public Homepage(WebDriver driver)  
	{
		super(driver);
		this.driver = driver; 
	}   
	By signin = By.id("nav-link-accountList");
	By searchbar = By.id("twotabsearchtextbox"); 
	By addresschange = By.id("glow-ingress-line1");
	By newpincode = By.id("GLUXZipUpdateInput");
	
	By cartbutton = By.id("nav-cart-count");
	By Allmenubutton = By.xpath("//span[@class='hm-icon-label']");
	By flightbutton = By.xpath("//a[contains(text(),'Flight Tickets')]");
	public  Loginpage clickSignin()
	{    
		driver.findElement(signin).click();
		return new Loginpage(driver);
	}   
	public Productresults searchitem(String productname)
	{
		driver.findElement(searchbar).sendKeys(productname + Keys.ENTER);
		return new Productresults(driver);		
	} 
	public void clickonaddress()
	{
		driver.findElement(addresschange).click();
	}
	public void enterpincode(String pocode)
	{
		waittill(newpincode);
		driver.findElement(newpincode).clear();
		driver.findElement(newpincode).sendKeys(pocode+Keys.ENTER);
	}
	public Cart cartbutton() {
		
		driver.findElement(cartbutton).click();
		return new Cart(driver);
	}
	public void clickmenu()
	{
		driver.findElement(Allmenubutton).click();		
	}
	public FlightsHomepage clickflightsmenu()
	{
		waittill(flightbutton);	
		driver.findElement(flightbutton).click();	
		return new FlightsHomepage(driver);
	}
}