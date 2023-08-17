package pageObjects;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Basepackage 
{ 
	public WebDriver driver;
	@BeforeMethod
	public void setupbrowser()							//initialising driver and getting the website link to automate
	{		
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in"); 
		driver.manage().window().maximize();
	} 	
	@AfterMethod
	
	 public void closebrowser(ITestResult result)			//closing the browser afer each test
	{
	
		driver.quit();
    }
	
}
	