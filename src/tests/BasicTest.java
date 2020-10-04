package tests;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicTest {
	
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected String email="customer@dummyid.com";
	protected String password="12345678a";
	protected String locationName="City Center-Albany";
	protected String baseUrl="http://demo.yo-meals.com/";
	protected String path2file="";
	protected String FirstName="";
	protected String LastName="";
	protected String Address="";
	protected String PhoneNo="";
	protected String ZipCode="";
	protected String Country="";
	protected String City="";
	protected String State="";
	

	@BeforeClass
	public void beforeClass(){
	System.setProperty("webdriver.chrome.driver",
			"driver-lib\\chromedriver.exe");
	
	this.driver=new ChromeDriver();
	driver.manage().window().maximize();
	this.wait = new WebDriverWait(driver, 30);
	this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	this.js=(JavascriptExecutor)this.driver;
	}

	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {
		File ts=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);;
		String name=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.png'").format(new Date());
	    File save=new File("screenshots/"+name);
		if (result.getStatus() == ITestResult.FAILURE) {
		FileHandler.copy(ts,save);
		}
		driver.manage().deleteAllCookies();
		}		

	
	@AfterClass
	public void afterClass(){
	this.driver.quit();
	}
	}