package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponents;

public class FlightDetailsPage extends AbstractComponents{
WebDriver driver;
public FlightDetailsPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
}
By travellerdetailsbutton = By.xpath("//a[contains(text(),'Proceed to traveller details')]");
public TravellersDetailsPage clickontravellerdetails() {
	waittill(travellerdetailsbutton);
	driver.findElement(travellerdetailsbutton).click();
	return new TravellersDetailsPage(driver);
}
}