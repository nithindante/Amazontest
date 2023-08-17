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
	Productresults obj2 = obj.searchitem("Frypans");
	ProductDisplayPage obj3 = obj2.selectitem("Butterfly Rapid Frypan 240 mm Induction Base");
	obj3.Tabhandling();
	obj3.clickonaddtocart();
	obj.searchitem("Speakers");
	obj2.selectitem("ZEBRONICS Zeb-Fame 5watts 2.0 Multi Media Speakers with AUX, USB and Volume Control (Black)");
	obj3.Tabhandling();	
	obj3.clickonaddtocart();
	Cartpage obj5 = new Cartpage(driver);
	obj5.redirecttocart();
	Cart obj4 =new Cart(driver);
	obj4.selectitem("Butterfly");	
	Assert.assertEquals(obj4.assertif(),"Butterfly Rapid Frypan 240 mm Induction Base was removed from Shopping Cart.");
}

@Test (description="adding items to cart and checking out")
public void checkingout() throws InterruptedException
{
	Homepage obj = new Homepage(driver);
	Loginpage obj1 = obj.clickSignin();
	obj1.enterphonedetails("8301087380");
	obj1.enterpassworddetails("Sreekuty");
	Productresults obj2 = obj.searchitem("Speakers");
	ProductDisplayPage obj3 = obj2.selectitem("boAt Stone 180 5W Bluetooth Speaker with Upto 10 Hours Playback, 1.75\" Driver, IPX7 & TWS Feature(Black)");
	obj3.Tabhandling();
	obj3.clickonaddtocart();
	obj3.extracart();	
	Cartpage obj4 = new Cartpage(driver);
	obj4.addtocheckout();
	Checkoutpage obj5 =  new Checkoutpage(driver);
	obj5.enternewaddress();
	obj5.enterdetailsofnewaddress("nithin rajkumar", "9995006380", "682309", "Vykundam,Sundernagar,Chitrapuzha", "Chitrapuzha,Tripunithura", "near petrol bunk", "Ernakulam");
	obj5.clickusethisaddress();
	obj5.clickusethisaddress();
	obj5.clickusethispayment();
	Assert.assertEquals(obj5.assertif(),"Place your order");
}	

	@Test (description="Adding items to wishlist and deleting the desired ones")
	public void addingitemstowishlist()
	{
		Homepage obj = new Homepage(driver);
		Loginpage obj1 = obj.clickSignin();
		obj1.enterphonedetails("8301087380");
		obj1.enterpassworddetails("Sreekuty");
		obj.clickonaddress();
		obj.enterpincode("682309");
		Productresults obj2 = obj.searchitem("Speakers");
		ProductDisplayPage obj3 = obj2.selectitem("boAt Stone 650 10W Bluetooth Speaker with Upto 7 Hours Playback, IPX5 and Integrated Controls (Black)");
		obj3.Tabhandling();
		obj3.addtowishlist();
		Wishlistpage obj4 = obj3.viewwishlist();
		obj4.searchitem("Frypan");
		obj2.selectitem("Hawkins Futura 26 cm Frying Pan, Non Stick Fry Pan with Glass Lid, Frypan, Black (NF26G)");
		obj3.Tabhandling();
		obj3.addtowishlist();
		obj3.viewwishlist();
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
		obj.clickmenu();
		FlightsHomepage obj2 = obj.clickflightsmenu();
		Thread.sleep(2000);
		obj2.enterdetailsoffromairport("Kozhikode");
		obj2.enterdetailsoftoairport("Bengaluru"); 
		obj2.selectmonth("October","10");
		obj2.NoOfAdults("2"); 
		obj2.NoOfChildren("1"); 
		obj2.NoOfInfants("1");
		FlightsDisplayPage obj3 = obj2.clickonsearch();
		FlightDetailsPage obj4 = obj3.selectflight(0);
		TravellersDetailsPage obj5 =obj4.clickontravellerdetails();
		obj5.enteradultsdetails("ram", "arun","Mr");	
		obj5.enterdetailsofchild("nithin","raj","2018","December","December 26, 2018");
		obj5.clickcheckboxes();
		obj5.clickreview();
		Assert.assertEquals(obj5.assertif(),"Review Booking");
	}

	@Test (description="Uploading files from Excel, Uploading files from PC,Scrolling down, Choosing from radio button and dropdown ")
	public void uploadphotos() throws Exception
	{
		Homepage obj = new Homepage(driver);
		Loginpage obj1 = obj.clickSignin();
		String path = "/D://data.XLSX";
		String sh = "Sheet1";  
		int rownum = ExcelData.getrowcount(path, sh);
		System.out.println(rownum); 
		for( int i=1;i<rownum;i++)
		{ 
			String user = ExcelData.getcellvalue(path, sh, i, 0);
			obj1.enterphonedetails(user);
			String pass = ExcelData.getcellvalue(path, sh, i, 1);
			obj1.enterpassworddetails(pass);
		}		
		Productresults obj2 = obj.searchitem("Photo frames with photo upload");
		ProductDisplayPage obj3 = obj2.selectitem("zig zag Personalized");		
		obj3.Tabhandling();
		obj3.customisebutton(); 
		Cartpage obj4 = obj3.fileupload("\"D:\\screenshot.png\"");
		obj4.redirecttocart();
		obj4.searchitem("Speakers");
		obj2.selectitem("ZEBRONICS Zeb-Fame 5watts 2.0 Multi Media Speakers with AUX, USB and Volume Control (Black)");	
		obj3.Tabhandling();
		obj3.setquantity();		
		obj3.clickonaddtocart();
		obj4.addtocheckout();	
		Checkoutpage obj5 =  new Checkoutpage(driver);
		obj5.clickanotheraddress();
		obj5.clickonusethisaddress();
		Assert.assertEquals(obj5.assertify(),"2 Select a payment method");
	}
	

}