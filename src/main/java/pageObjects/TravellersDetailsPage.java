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

public class TravellersDetailsPage extends AbstractComponents{

	WebDriver driver;
	public TravellersDetailsPage(WebDriver driver)
	{
		
		super(driver);
		this.driver= driver;
	}
	By addnewadult = By.xpath("//div[contains(text(),'Add new adult')]");
	By addnewchild = By.xpath("//div[contains(text(),'Add new child')]");
	By firstname= By.id("input-firstName");
	By lastname= By.id("input-lastName");
	By addbutton = By.xpath("//button[contains(text(),'Add adult')]");
	By selectbutton = By.xpath("//button[@tabindex='0']");
	By calender = By.xpath("//i[@class='_9f155a97 _33987687']");
	By clickaddchildbutton = By.xpath("//button[contains(text(),'Add child')]");
	By checkboxinfant = By.xpath("//span[contains(text(),'sad asd')]//preceding-sibling::i");
	By emailaddress = By.id("input-communication_email");
	By checkboxadult = By.xpath("//span[contains(text(),'nitha rajkumar')]");
	By reviewbutton = By.xpath("//button[contains(text(),'Proceed to review')]");
	By reviewbooking = By.xpath("//h2[contains(text(),'Review Booking')]");
	By randompopup = By.xpath("//div[@class='hfcApayHeader']");
	public List<WebElement> getrows()
	{
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='_5279138b']"));
		return rows;
	}
	public void enteradultsdetails(String fname,String lname,String title)
	{
		waittill(addnewadult);
		getrows().get(0).findElement(By.xpath("parent::div/preceding-sibling::div//span")).click();
		getrows().get(0).findElement(By.id("input-firstName")).sendKeys(fname);
		getrows().get(0).findElement(By.id("input-lastName")).sendKeys(lname);
		getrows().get(0).findElement(By.xpath("//button[@tabindex='0']")).click();
		getrows().get(0).findElement(By.xpath("//li[contains(text(),'"+title+"')]")).click();
		getrows().get(0).findElement(By.xpath("//button[contains(text(),'Add adult')]")).click();
	}
	  
	public void enterdetailsofchild(String fname,String lname,String year,String month,String exactdate) throws InterruptedException
	{	
		waittill(addnewchild);
		getrows().get(1).findElement(By.xpath("parent::div/preceding-sibling::div//span")).click();
		Thread.sleep(3000);
		getrows().get(1).findElement(By.id("input-firstName")).sendKeys(fname);
		Thread.sleep(3000);
		getrows().get(1).findElement(By.id("input-lastName")).sendKeys(lname);
		Thread.sleep(3000);  
		driver.findElement(calender).click();
		Thread.sleep(3000); 
				while(!driver.findElement(By.xpath("//a[@class='rc-calendar-year-select']")).getText().equalsIgnoreCase(year))
				{
					driver.findElement(By.xpath("//a[@title='Previous month (PageUp)']")).click();
				}
				while(!driver.findElement(By.xpath("//a[@class='rc-calendar-month-select']")).getText().equalsIgnoreCase(month))
				{  
					driver.findElement(By.xpath("//a[@title='Previous month (PageUp)']")).click();
				}
					List<WebElement> dateslist = driver.findElements(By.xpath("//td[@role='gridcell']"));
					WebElement dates = dateslist.stream().filter(date->date.getAttribute("Title").contains(exactdate)).findFirst().orElse(null);
					dates.click();		
					getrows().get(1).findElement(By.id("fl_tr_title")).click();
					getrows().get(1).findElement(By.id("fl_tr_title")).click();		
					driver.findElement(clickaddchildbutton).click();
	}
	
	public void clickcheckboxes()
	{
		driver.findElement(checkboxadult).click();
		driver.findElement(checkboxinfant).click();
	}
	public void enteremailaddresss(String email)
	{
		driver.findElement(emailaddress).sendKeys(email);
	}
	public void clickreview()
	{
		Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.xpath("//div[@class='hfcApayHeader']"))).build().perform();
		driver.findElement(reviewbutton).click();
	}
	public String assertif() {
		waittill(reviewbooking);
		String title = driver.findElement(reviewbooking).getText();
		return title;
	}
}