package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class FlightsHomepage extends AbstractComponents{
WebDriver driver;
public FlightsHomepage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
}
By fromairport = By.xpath("//div[@class='_82328473']//div[@class='_3cb848bf']//div//span[2]");
By toairport = By.xpath("//input[@name='searchText']");
By searchbutton =  By.xpath("//button[contains(text(),'Search')]");
By nextbutton = By.xpath("//button[@class='_4a388932']"); 
public void enterdetailsoffromairport(String departureairport) throws InterruptedException {  
	waittill(fromairport);
	driver.findElement(fromairport).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name=\"searchText\"]")).sendKeys(departureairport); 
	By dropdown = By.xpath("//p[contains(text(),'"+departureairport+"')]");
	waittill(dropdown);
	waittill(dropdown);
	waittill(dropdown);
	Thread.sleep(2000);
	driver.findElement(dropdown).click();
}
public void enterdetailsoftoairport(String arrivalairport) throws InterruptedException
{	
	waittill(toairport);
	driver.findElement(toairport).sendKeys(arrivalairport); 
	By dropdown = By.xpath("//p[contains(text(),'"+arrivalairport+"')]");
	waittill(dropdown);
	waittill(dropdown);
	Thread.sleep(2000);
	driver.findElement(dropdown).click();
} 


public List<WebElement> getmonthslist() {
 List<WebElement> months = driver.findElements(By.xpath("//div[@class='_1711da50']"));
return months;
}
	
public void selectmonth(String selectedmonth,String selecteddate)
{	
	WebElement mon = getmonthslist().stream().filter(month->month.findElement(By.xpath("div//p")).getText().contains(selectedmonth)).findFirst().orElse(null);
	while(mon==null)
	{
		driver.findElement(nextbutton).click();
		WebElement mont = getmonthslist().stream().filter(month->month.findElement(By.xpath("div//p")).getText().contains(selectedmonth)).findFirst().orElse(null);
		mont.findElement(By.xpath("div[3]//ul//li[contains(text(),'"+selecteddate+"')]")).click();
		break;
	} 
	if(mon!=null) 
	{
	mon.findElement(By.xpath("div[3]//ul//li[contains(text(),'"+selecteddate+"')]")).click();
	}

}
public List<WebElement> rows()
{
	List<WebElement> adults = driver.findElements(By.xpath("//div[@class='ecbd2509 _769d5a4a _6078df67']"));
	return adults;
} 
public void NoOfAdults(String noofadults) 
{
	rows().get(0).findElement(By.xpath("button[contains(text(),"+noofadults+")]")).click();
}
public void NoOfInfants(String noofinfants) 
{
	rows().get(1).findElement(By.xpath("button[contains(text(),"+noofinfants+")]")).click();
} 
public void NoOfChildren(String noofchildren) 
{
	rows().get(2).findElement(By.xpath("button[contains(text(),"+noofchildren+")]")).click();	
}
public FlightsDisplayPage clickonsearch() {	
	driver.findElement(searchbutton).click();
	return new FlightsDisplayPage(driver);
}
}