package commonMethods;

import java.time.Duration;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BasePackage;

public class CommonMethods extends BasePackage{					//Creating a class to to avail all the common functions used within each classes. 
WebDriver driver;

public CommonMethods(WebDriver driver)
{ 
	
	this.driver=driver;
}
	public void waitTill(By element)											// Creating a function to wait till the element is clickable
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable((element)));
	}


}