package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponents;

public class Checkoutpage extends AbstractComponents{

	WebDriver driver;
	public Checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	By newaddresslink = By.id("add-new-address-popover-link");
	By fullname = By.id("address-ui-widgets-enterAddressFullName");
	By phonenumber = By.id("address-ui-widgets-enterAddressPhoneNumber");
	By postalcode = By.id("address-ui-widgets-enterAddressPostalCode");
	By addressline1 = By.id("address-ui-widgets-enterAddressLine1");
	By addressline2 = By.id("address-ui-widgets-enterAddressLine2"); 
	By landmark = By.id("address-ui-widgets-landmark");
	By city = By.id("address-ui-widgets-enterAddressCity");
	By addressbutton = By.xpath("//input[@class='a-button-input' and @aria-labelledby='address-ui-widgets-form-submit-button-announce']");
	By element = By.cssSelector("input[class='a-button-input'][aria-labelledby='address-ui-widgets-form-submit-button-announce']");
	By paymentbutton = By.xpath("//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent' and @type='submit']");
	By confirmbutton = By.id("bottomSubmitOrderButtonId-announce");
	By clickonnewaddress=  By.xpath("//span[contains(text(),'Vykundam')]");
	By usethisaddress =  By.id("shipToThisAddressButton");
	By paymentconfirmation = By.xpath("//*[@id=\"payment\"]/div[3]/div/div/div[1]/div/h3");
	public void enternewaddress() 
	{
		waittill(newaddresslink);
		driver.findElement(newaddresslink).click();
	}
	public void enterdetailsofnewaddress(String fullnam,String phoneno,String pocode, String addline1, String addline2, String landma,String cities) throws InterruptedException {
	driver.findElement(fullname).sendKeys(fullnam);
		driver.findElement(phonenumber).sendKeys(phoneno);
		driver.findElement(postalcode).clear();
		driver.findElement(postalcode).sendKeys(pocode);
		driver.findElement(addressline1).sendKeys(addline1);
		driver.findElement(addressline2).sendKeys(addline2);
		driver.findElement(landmark).sendKeys(landma);
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(cities);
	}
	public void clickusethisaddress() {	 
		waittill(element);
		driver.findElement(addressbutton).click();
	}
	public void clickonusethisaddress() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(usethisaddress).click();
	} 
	public void clickusethispayment() {
		waittill(paymentbutton); 
		driver.findElement(paymentbutton).click();		
	}
	public String assertif()
	{
		
		waittill(confirmbutton);
		String title = driver.findElement(confirmbutton).getText();
		return title;
	}
	public void clickanotheraddress()
	{
		driver.findElement(clickonnewaddress).click();
	}
	public String assertify()
	{
		waittill(paymentconfirmation);
		String title = driver.findElement(paymentconfirmation).getText();
		return title;
	}
}