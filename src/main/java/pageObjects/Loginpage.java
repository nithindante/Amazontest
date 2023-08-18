package pageObjects;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Loginpage 				//Represents the Login page
{  
WebDriver driver;

public Loginpage(WebDriver driver)
{
	this.driver=driver;
}   
  
By phoneno = By.id("ap_email");
By passwrd = By.id("ap_password");
public void enterphonedetails(String phonenumber) {										//Entering the phone number details
	driver.findElement(phoneno).sendKeys(phonenumber + Keys.ENTER);	
} 
public void enterpassworddetails(String password)										//entering the password
{
	driver.findElement(passwrd).sendKeys(password + Keys.ENTER);
}  

}