package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class FlightsDisplayPage extends AbstractComponents{				// The page that shows all the flights available 
WebDriver driver;
	public FlightsDisplayPage(WebDriver driver) { 
		super(driver);
		this.driver=driver; 
	}
	By bookButton =  By.xpath("//button[contains(text(),'Book')]");
	public List<WebElement> getFlightsList()							//selecting the list of flights
	{
		List<WebElement> flights = driver.findElements(By.xpath("//div[@class='_8effeee7']"));
		return flights;
		
	}
	public FlightDetailsPage selectFlight(int num) {									// entering you want the "num" flight  in the list, i.e: if you want 1st flight from the flights displayed, it selects the 1st flight 
		waittill(bookButton);
		getFlightsList().get(num).findElement(By.xpath("div[@class='_0d5ac290']")).click();		
		return new FlightDetailsPage(driver);
	}
}