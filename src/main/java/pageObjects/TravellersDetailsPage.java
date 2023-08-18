package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; 

import AbstractComponents.AbstractComponents;
 
public class TravellersDetailsPage extends AbstractComponents{			//Represents the Page that shows Travelers Details Page 

	WebDriver driver;
	public TravellersDetailsPage(WebDriver driver)
	{
		
		super(driver);
		this.driver= driver;
	}
	By addNewAdult = By.xpath("//div[contains(text(),'Add new adult')]");
	By addNewChild = By.xpath("//div[contains(text(),'Add new child')]");
	By firstName= By.id("input-firstName");
	By lastName= By.id("input-lastName");
	By addButton = By.xpath("//button[contains(text(),'Add adult')]");
	By selectButton = By.xpath("//button[@tabindex='0']");
	By calender = By.xpath("//i[@class='_9f155a97 _33987687']");
	By addChildButton = By.xpath("//button[contains(text(),'Add child')]");
	By checkboxInfant = By.xpath("//span[contains(text(),'sad asd')]//preceding-sibling::i");
	By emailAddress = By.id("input-communication_email");
	By checkboxAdult = By.xpath("//span[contains(text(),'nitha rajkumar')]");
	By reviewButton = By.xpath("//button[contains(text(),'Proceed to review')]");
	By reviewBooking = By.xpath("//h2[contains(text(),'Review Booking')]");
	By randomPopup = By.xpath("//div[@class='hfcApayHeader']");
	public List<WebElement> getrows()														// To get the rows of all the Infants,Childs,Adults divs
	{
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='_5279138b']"));
		return rows;
	}
	public void enterAdultsDetails(String fname,String lname,String title)					//entering the details of new Adult 
	{
		waittill(addNewAdult);
		getrows().get(0).findElement(By.xpath("parent::div/preceding-sibling::div//span")).click();
		getrows().get(0).findElement(By.id("input-firstName")).sendKeys(fname);
		getrows().get(0).findElement(By.id("input-lastName")).sendKeys(lname);
		getrows().get(0).findElement(By.xpath("//button[@tabindex='0']")).click();
		getrows().get(0).findElement(By.xpath("//li[contains(text(),'"+title+"')]")).click();
		getrows().get(0).findElement(By.xpath("//button[contains(text(),'Add adult')]")).click();
	}
	  
	public void enterDetailsOfChild(String fname,String lname,String year,String month,String exactdate) throws InterruptedException
	{	
		waittill(addNewChild);																		//entering the details of new child
		getrows().get(1).findElement(By.xpath("parent::div/preceding-sibling::div//span")).click();
		
		getrows().get(1).findElement(By.id("input-firstName")).sendKeys(fname);
		
		getrows().get(1).findElement(By.id("input-lastName")).sendKeys(lname);
		  
		driver.findElement(calender).click();
		Thread.sleep(3000); 																											//Selecting the date of birth of the Child
				while(!driver.findElement(By.xpath("//a[@class='rc-calendar-year-select']")).getText().equalsIgnoreCase(year))			// if not the desired year, click on previous year
				{
					driver.findElement(By.xpath("//a[@title='Previous month (PageUp)']")).click();			
				}
				while(!driver.findElement(By.xpath("//a[@class='rc-calendar-month-select']")).getText().equalsIgnoreCase(month))  // if not the desired month, click on previous month
				{  
					driver.findElement(By.xpath("//a[@title='Previous month (PageUp)']")).click();
				}
					List<WebElement> dateslist = driver.findElements(By.xpath("//td[@role='gridcell']"));							// get the list of all the dates within a month div
					WebElement dates = dateslist.stream().filter(date->date.getAttribute("Title").contains(exactdate)).findFirst().orElse(null);		//Selecting the desired date from the list throgh Streams
					dates.click();			
					getrows().get(1).findElement(By.id("fl_tr_title")).click();
					getrows().get(1).findElement(By.id("fl_tr_title")).click();		
					driver.findElement(addChildButton).click();
	}
	
	public void clickCheckBoxes()																									//Clicking on check boxes
	{
		driver.findElement(checkboxAdult).click();
		driver.findElement(checkboxInfant).click();
	}
	public void enterEmailAddresss(String email)																					//Enter email address
	{
		driver.findElement(emailAddress).sendKeys(email);
	}
	public void clickReview()																										//Performing actions class to enter on Review button 
	{
		Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.xpath("//div[@class='hfcApayHeader']"))).build().perform();
		driver.findElement(reviewButton).click();
	} 
	
	public String assertIf() {																								// Confirming that Review booking text is formed and getting the text
		waittill(reviewBooking);
		String title = driver.findElement(reviewBooking).getText();
		return title;
	}
}