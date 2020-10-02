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
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.hpsf.Date;
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
	//protected Screenshot screenshot;
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
	System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
	this.driver=new ChromeDriver();

	driver.manage().window().maximize();
	this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	//TakesScreenshot ts = (TakesScreenshot) driver;
	//screenshot=new AShot().takeScreenshot(driver);
	this.js=(JavascriptExecutor)this.driver;

//	NotificationSistemPage nsp=new NotificationSistemPage(this.driver, this.wait, this.js);
//	LocationPopupPage lpp=new LocationPopupPage(this.driver, this.wait, this.js);
//	LoginPage lp=new LoginPage(this.driver, this.wait, this.js);
//	MealPage mp=new MealPage(this.driver, this.wait, this.js);
//	ProfilePage pp=new ProfilePage(this.driver, this.wait, this.js);
	//AuthPage ap=new AuthPage(this.driver, this.wait, this.js);
//	CartSummaryPage cp=new CartSummaryPage(this.driver, this.wait, this.js);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
	//String time=new SimpleDateFormat("yyyMMddHHmm’.txt’").format(new Date());
	//screenshots=new AShot().takeScreenshot(driver);
	if (result.getStatus()==ITestResult.FAILURE) {

	TakesScreenshot ts = (TakesScreenshot) driver;
	//File ss =ts.getScreenshotAs(OutputType.FILE);
	//FileUtils.copyDirectory(ss, new File("./screenshots/"+time+".png"));
	FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),
				new File("\"screenshots/\"+DateTime.now().toString(\"yyyy-dd-MM-HH-mm-ss\")+\" .png"));
	//ImageIO.write(screenshots.getImage(),  "png",  new File("screenshots/"+DateTime.now().toString("yyyy-dd-MM-HH-mm-ss")+" .png"));	"
	}
	this.driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void AfterClass(){
	this.driver.quit();
	}
	}