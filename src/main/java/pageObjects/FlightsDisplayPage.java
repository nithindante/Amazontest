package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class FlightsDisplayPage extends AbstractComponents{
WebDriver driver;
	public FlightsDisplayPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	By bookbutton =  By.xpath("//button[contains(text(),'Book')]");
	public List<WebElement> getflightslist()
	{
		List<WebElement> flights = driver.findElements(By.xpath("//div[@class='_8effeee7']"));
		return flights;
		
	}
	


	public FlightDetailsPage selectflight(int num) {
		waittill(bookbutton);
		getflightslist().get(num).findElement(By.xpath("div[@class='_0d5ac290']")).click();	
		return new FlightDetailsPage(driver);
	}
}