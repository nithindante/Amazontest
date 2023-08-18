package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import AbstractComponents.AbstractComponents;


public class Homepage extends AbstractComponents						//Represents the Home page
{
	WebDriver driver;
	public Homepage(WebDriver driver)  
	{
		super(driver);
		this.driver = driver; 
	}     
	By signIn = By.id("nav-link-accountList");
	By searchBar = By.id("twotabsearchtextbox"); 
	By addressChange = By.id("glow-ingress-line1");
	By newpinCode = By.id("GLUXZipUpdateInput");	
	By cartButton = By.id("nav-cart-count");
	By allMenuButton = By.xpath("//span[@class='hm-icon-label']");
	By flightButton = By.xpath("//a[contains(text(),'Flight Tickets')]");
	public  Loginpage clickSignin()															//Click on Sign in button 
	{    
		driver.findElement(signIn).click();
		return new Loginpage(driver);
	}   
	public Productresults searchItem(String productname)										// Enter the Desired item in the Search bar
	{
		driver.findElement(searchBar).sendKeys(productname + Keys.ENTER);
		return new Productresults(driver);		
	} 
	public void clickOnAddress()															//Clicking on Address tab 
	{
		driver.findElement(addressChange).click();
	}
	public void enterPincode(String pocode)													//Changing the post code 
	{
		waittill(newpinCode);
		driver.findElement(newpinCode).clear();
		driver.findElement(newpinCode).sendKeys(pocode+Keys.ENTER);		
	}

	public void clickMenu()																		//Clicking the Pop up Menu on the left hand side 
	{
		driver.findElement(allMenuButton).click();		
	}
	public FlightsHomepage clickFlightsMenu()												//Click on Booking flight and redirects to Flights home page 
	{
		waittill(flightButton);	
		driver.findElement(flightButton).click();	
		return new FlightsHomepage(driver);
	}
}