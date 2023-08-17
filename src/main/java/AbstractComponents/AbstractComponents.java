package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Basepackage;

public class AbstractComponents extends Basepackage{
WebDriver driver;

public AbstractComponents(WebDriver driver)
{
	
	this.driver=driver;
}
	public void waittill(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable((element)));
	}

	
}