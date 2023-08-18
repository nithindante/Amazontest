package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponents;

public class Checkoutpage extends AbstractComponents{    // The page that represents Checkoutpage

	WebDriver driver;
	public Checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver; 
	}
	By newAddressLink = By.id("add-new-address-popover-link");
	By fullName = By.id("address-ui-widgets-enterAddressFullName");
	By phoneNumber = By.id("address-ui-widgets-enterAddressPhoneNumber");
	By postalCode = By.id("address-ui-widgets-enterAddressPostalCode");
	By addressLine1 = By.id("address-ui-widgets-enterAddressLine1");
	By addressLine2 = By.id("address-ui-widgets-enterAddressLine2"); 
	By landmark = By.id("address-ui-widgets-landmark");
	By city = By.id("address-ui-widgets-enterAddressCity");
	By addressButton = By.xpath("//input[@class='a-button-input' and @aria-labelledby='address-ui-widgets-form-submit-button-announce']");
	By element = By.cssSelector("input[class='a-button-input'][aria-labelledby='address-ui-widgets-form-submit-button-announce']");
	By paymentButton = By.xpath("//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent' and @type='submit']");
	By confirmButton = By.id("bottomSubmitOrderButtonId-announce");
	By newAddress=  By.xpath("//span[contains(text(),'Vykundam')]");
	By thisAddress =  By.id("shipToThisAddressButton");
	By paymentConfirmation = By.xpath("//*[@id=\"payment\"]/div[3]/div/div/div[1]/div/h3");
	public void enterNewAddress() 																// Click on new address 
	{  
		waittill(newAddressLink);
		driver.findElement(newAddressLink).click();
	}
	public void enterDetailsOfNewAddress(String fullnam,String phoneno,String pocode, String addline1, String addline2, String landma,String cities) throws InterruptedException {
	driver.findElement(fullName).sendKeys(fullnam);
		driver.findElement(phoneNumber).sendKeys(phoneno);								//entering the details to new address pop up
		driver.findElement(postalCode).clear();
		driver.findElement(postalCode).sendKeys(pocode);
		driver.findElement(addressLine1).sendKeys(addline1);
		driver.findElement(addressLine2).sendKeys(addline2);
		driver.findElement(landmark).sendKeys(landma);
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(cities);
	}
	public void clickUseThisAddress() {	 													//clicking on use this address
		waittill(element);
		driver.findElement(addressButton).click();
	}
	public void clickOnUseThisAddress() throws InterruptedException							//clicking on the next "use this addresss" so that it goes to next step. 
	{
		Thread.sleep(2000);
		driver.findElement(thisAddress).click();
	} 
	public void clickUseThisPayment() {														//clicking on use this Payment
		waittill(paymentButton); 
		driver.findElement(paymentButton).click();		
	}
	public String assertIf()																// getting the text to get the confirmation that order is successfully confirmed
	{		
		waittill(confirmButton);
		String title = driver.findElement(confirmButton).getText();
		return title;
	}
	public void clickAnotherAddress()														//selecting one of the radio buttons 
	{
		driver.findElement(newAddress).click();
	}
	public String assertIfPayment()															// getting the text to get the confirmation that payment is successfully displayed
	{
		waittill(paymentConfirmation);
		String title = driver.findElement(paymentConfirmation).getText();
		return title;
	}
}