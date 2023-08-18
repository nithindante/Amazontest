package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents; 

public class FlightsHomepage extends AbstractComponents{				// the page which represents the Flights Home page
WebDriver driver;
public FlightsHomepage(WebDriver driver)
{
	super(driver);	
	this.driver=driver;
}
By fromAirport = By.xpath("//div[@class='_82328473']//div[@class='_3cb848bf']//div//span[2]");
By toAirport = By.xpath("//input[@name='searchText']");
By searchButton =  By.xpath("//button[contains(text(),'Search')]");
By nextButton = By.xpath("//button[@class='_4a388932']"); 
public void enterDetailsOfFromAirport(String departureairport) throws InterruptedException {  				// Creating method to enter details of From airport 
	waittill(fromAirport);
	driver.findElement(fromAirport).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name=\"searchText\"]")).sendKeys(departureairport); 				//entering the desired airport 
	By dropdown = By.xpath("//p[contains(text(),'"+departureairport+"')]");
	waittill(dropdown);
	Thread.sleep(2000);
	driver.findElement(dropdown).click();
}  
public void enterDetailsOfToAirport(String arrivalairport) throws InterruptedException						// Creating method to enter details of To airport
{	
	waittill(toAirport);
	driver.findElement(toAirport).sendKeys(arrivalairport); 
	By dropdown = By.xpath("//p[contains(text(),'"+arrivalairport+"')]");									//entering the to airport 
	waittill(dropdown);
	Thread.sleep(2000);
	driver.findElement(dropdown).click();
} 

public List<WebElement> getMonthsList() {																	// getting the list of all the months div 
 List<WebElement> months = driver.findElements(By.xpath("//div[@class='_1711da50']"));
return months;
}
	
public void selectMonth(String selectedmonth,String selecteddate)											//Selecting the desired month
{	
	WebElement mon = getMonthsList().stream().filter(month->month.findElement(By.xpath("div//p")).getText().contains(selectedmonth)).findFirst().orElse(null); 		//Checking whether our entered month is as same as the Month displayed
	while(mon==null)
	{
		driver.findElement(nextButton).click();
		WebElement months = getMonthsList().stream().filter(s->s.findElement(By.xpath("div//p")).getText().contains(selectedmonth)).findFirst().orElse(null);				// if not displayed click on next month
		months.findElement(By.xpath("div[3]//ul//li[contains(text(),'"+selecteddate+"')]")).click();
		break;
	} 
	if(mon!=null) 																																	//if we selected the right month, it will select the desired date
	{
	mon.findElement(By.xpath("div[3]//ul//li[contains(text(),'"+selecteddate+"')]")).click();
	}
}
public List<WebElement> rows()																														//finding the equivalent rows in Adult, Infants and children
{
	List<WebElement> adults = driver.findElements(By.xpath("//div[@class='ecbd2509 _769d5a4a _6078df67']"));
	return adults;
} 
public void NoOfAdults(String noofadults) 
{
	rows().get(0).findElement(By.xpath("button[contains(text(),"+noofadults+")]")).click();															//entering desired no of adults
}
public void NoOfInfants(String noofinfants) 
{
	rows().get(1).findElement(By.xpath("button[contains(text(),"+noofinfants+")]")).click();							//entering desired no of infants
} 
public void NoOfChildren(String noofchildren) 
{
	rows().get(2).findElement(By.xpath("button[contains(text(),"+noofchildren+")]")).click();	              //entering desired no of children
}
public FlightsDisplayPage clickonsearch() {																	//click on search button and return the Constructor of Flights Display page
	driver.findElement(searchButton).click();
	return new FlightsDisplayPage(driver);
}
}