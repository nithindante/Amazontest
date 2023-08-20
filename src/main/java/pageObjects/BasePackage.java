package pageObjects;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BasePackage 
{ 
	public WebDriver driver;
	public ExtentReports extent;
    public ExtentTest test;
	@BeforeMethod
	public void setupBrowser(Method method)							//Initializing driver and getting the website link to automate
	{		
		driver = new ChromeDriver();
		String website= "https://www.amazon.in";
		driver.get(website); 
		driver.manage().window().maximize();
		test = extent.createTest(method.getName());					// creating a variable to generate extent reports
	} 	
	
	@BeforeSuite
	public void extendSetup()												// Creating a method to use Extentreports() and create a "extent.html"file
	{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");
	    extent.attachReporter(spark);
	}
	@AfterMethod
	
	 public void closeBrowser(ITestResult result)			//closing the browser after each test and getting the pass or fail status 
	{
		if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed is "+result.getName());
            test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
        }
        else
            test.log(Status.PASS, "Test Case Passed is "+result.getName());
		driver.quit();
    }
	@AfterSuite
	public void tearDown()							
	{
		 extent.flush();
	}
}
	