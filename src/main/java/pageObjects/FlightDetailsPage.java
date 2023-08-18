package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponents;

public class FlightDetailsPage extends AbstractComponents{ 						// the page that represents that comes before we enter Traveler details 
WebDriver driver;
public FlightDetailsPage(WebDriver driver)
{
	super(driver);
	
	this.driver=driver;
}
By travellerDetailsButton = By.xpath("//a[contains(text(),'Proceed to traveller details')]");
public TravellersDetailsPage clickOnTravellerDetails() {				//clicking the Button to redirect to Travelers details page and returning its Constructor as well. 
	waittill(travellerDetailsButton);
	driver.findElement(travellerDetailsButton).click();
	return new TravellersDetailsPage(driver);
}
}