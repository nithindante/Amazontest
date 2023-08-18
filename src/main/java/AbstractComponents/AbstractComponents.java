package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Basepackage;

public class AbstractComponents extends Basepackage{					//Creating a class to to avail all the common functions used within each classes. 
WebDriver driver;

public AbstractComponents(WebDriver driver)
{
	
	this.driver=driver;
}
	public void waittill(By element)											// Creating a function to wait till the element is clickable
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable((element)));
	}

	public String assertif(By element)
	{  
		waittill(element);
		String title = driver.findElement(element).getText();
		return title;
	}
}