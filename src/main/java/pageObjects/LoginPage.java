package pageObjects;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage
{  
WebDriver driver;

public LoginPage(WebDriver driver)
{
	this.driver=driver;
}   
  
By phoneNo = By.id("ap_email");
By password = By.id("ap_password");
public void enterPhoneDetails(String phonenumber) {										//Entering the phone number details
	driver.findElement(phoneNo).sendKeys(phonenumber + Keys.ENTER);	
} 
public void enterPasswordDetails(String passwrd)										//entering the password
{
	driver.findElement(password).sendKeys(passwrd + Keys.ENTER);
}  

}