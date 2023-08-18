package testMain;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Basepackage;
import pageObjects.Cart;
import pageObjects.Cartpage;
import pageObjects.Checkoutpage;
import pageObjects.ExcelData;
import pageObjects.FlightDetailsPage;
import pageObjects.FlightsDisplayPage;
import pageObjects.FlightsHomepage;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.ProductDisplayPage;
import pageObjects.Productresults;
import pageObjects.TravellersDetailsPage;
import pageObjects.Wishlistpage;

public class MainTest extends Basepackage{
	
	
@Test (description="Automating adding items to cart and deleting it ")
public void additemstocart() throws InterruptedException
{
	 
	Homepage obj = new Homepage(driver);
	Loginpage obj1 = obj.clickSignin();
	obj1.enterphonedetails("8301087380"); 
	obj1.enterpassworddetails("Sreekuty");
	Productresults obj2 = obj.searchItem("Frypans");
	ProductDisplayPage obj3 = obj2.selectItem("Butterfly Rapid Frypan 240 mm Induction Base");
	obj3.tabHandling();
	obj3.clickOnAddToCart();
	obj.searchItem("Speakers");
	obj2.selectItem("ZEBRONICS Zeb-Fame 5watts 2.0 Multi Media Speakers with AUX, USB and Volume Control (Black)");
	obj3.tabHandling();	
	obj3.clickOnAddToCart();
	Cartpage obj5 = new Cartpage(driver);
	obj5.redirectToCart();
	Cart obj4 =new Cart(driver);
	obj4.selectItem("Butterfly");	
	
	
	Assert.assertEquals(obj4.assertIf(),"Butterfly Rapid Frypan 240 mm Induction Base was removed from Shopping Cart.");
}

@Test (description="adding items to cart and checking out")
public void checkingout() throws InterruptedException
{
	Homepage obj = new Homepage(driver);
	Loginpage obj1 = obj.clickSignin();
	obj1.enterphonedetails("8301087380");
	obj1.enterpassworddetails("Sreekuty");
	Productresults obj2 = obj.searchItem("Speakers");
	ProductDisplayPage obj3 = obj2.selectItem("boAt Stone 180 5W Bluetooth Speaker with Upto 10 Hours Playback, 1.75\" Driver, IPX7 & TWS Feature(Black)");
	obj3.tabHandling();
	obj3.clickOnAddToCart();
	obj3.clickOnExtraCart();	
	Cartpage obj4 = new Cartpage(driver);
	obj4.addToCheckout();
	Checkoutpage obj5 =  new Checkoutpage(driver);
	obj5.enterNewAddress();
	obj5.enterDetailsOfNewAddress("nithin rajkumar", "9995006380", "682309", "Vykundam,Sundernagar,Chitrapuzha", "Chitrapuzha,Tripunithura", "near petrol bunk", "Ernakulam");
	obj5.clickUseThisAddress();
	obj5.clickUseThisAddress();
	obj5.clickUseThisPayment();
	Assert.assertEquals(obj5.assertIf(),"Place your order");
}	

	@Test (description="Adding items to wishlist and deleting the desired ones")
	public void addingitemstowishlist()
	{
		Homepage obj = new Homepage(driver);
		Loginpage obj1 = obj.clickSignin();
		obj1.enterphonedetails("8301087380");
		obj1.enterpassworddetails("Sreekuty");
		obj.clickOnAddress();
		obj.enterPincode("682309");
		Productresults obj2 = obj.searchItem("Speakers");
		ProductDisplayPage obj3 = obj2.selectItem("boAt Stone 180 5W Bluetooth Speaker with Upto 10 Hours Playback, 1.75\" Driver, IPX7 & TWS Feature(Black)");
		obj3.tabHandling();
		obj3.addToWishlist();
		Wishlistpage obj4 = obj3.viewWishlist();
		obj4.searchitem("Frypan");
		obj2.selectItem("Hawkins Futura 26 cm Frying Pan, Non Stick Fry Pan with Glass Lid, Frypan, Black (NF26G)");
		obj3.tabHandling();
		obj3.addToWishlist();
		obj3.viewWishlist();
		obj4.selectitemtodelete("boAt");	
		Assert.assertEquals(obj4.assertif(),"Deleted");
	}

	@Test (description="Booking a flight and doing the date picker")
	public void abookingflight() throws InterruptedException
	{
		Homepage obj = new Homepage(driver);
		Loginpage obj1 = obj.clickSignin();
		obj1.enterphonedetails("8301087380");
		obj1.enterpassworddetails("Sreekuty");
		obj.clickMenu();
		FlightsHomepage obj2 = obj.clickFlightsMenu();
		Thread.sleep(2000);
		obj2.enterDetailsOfFromAirport("Kozhikode");
		obj2.enterDetailsOfToAirport("Bengaluru"); 
		obj2.selectMonth("October","8");
		obj2.NoOfAdults("2"); 
		obj2.NoOfChildren("1"); 
		obj2.NoOfInfants("1");
		FlightsDisplayPage obj3 = obj2.clickonsearch();
		FlightDetailsPage obj4 = obj3.selectFlight(0);
		TravellersDetailsPage obj5 =obj4.clickOnTravellerDetails();
		obj5.enterAdultsDetails("ram","arun","Mr");	
		obj5.enterDetailsOfChild("nithin","raj","2018","December","December 26, 2018");
		obj5.clickCheckBoxes();
		obj5.clickReview();
		Assert.assertEquals(obj5.assertIf(),"Review Booking");
	}

	@Test (description="Uploading files from Excel, Uploading files from PC,Scrolling down, Choosing from radio button and dropdown ")
	public void uploadFiles() throws Exception
	{
		Homepage obj = new Homepage(driver);
		Loginpage obj1 = obj.clickSignin();
		String path = "/D://data.XLSX";
		String sh = "Sheet1";  
		int rownum = ExcelData.getRowCount(path, sh);
		System.out.println(rownum); 
		for( int i=1;i<rownum;i++)
		{ 
			String user = ExcelData.getCellValue(path, sh, i, 0);
			obj1.enterphonedetails(user);
			String pass = ExcelData.getCellValue(path, sh, i, 1);
			obj1.enterpassworddetails(pass);
		}		
		Productresults obj2 = obj.searchItem("Photo frames with photo upload");
		ProductDisplayPage obj3 = obj2.selectItem("zig zag Personalized");		
		obj3.tabHandling();
		obj3.clickCustomiseButton(); 
		Cartpage obj4 = obj3.fileUpload("\"D:\\screenshot.png\"");
		obj4.redirectToCart();
		obj4.searchItem("Speakers");
		obj2.selectItem("ZEBRONICS Zeb-Fame 5watts 2.0 Multi Media Speakers with AUX, USB and Volume Control (Black)");	
		obj3.tabHandling();
		obj3.setQuantity(5);		
		obj3.clickOnAddToCart();
		obj4.addToCheckout();	
		Checkoutpage obj5 =  new Checkoutpage(driver);
		obj5.clickAnotherAddress();
		obj5.clickOnUseThisAddress();
		Assert.assertEquals(obj5.assertIfPayment(),"2 Select a payment method");
	}
	

}