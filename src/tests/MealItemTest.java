package tests;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.AssertJUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;
import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public class MealItemTest extends BasicTest{

	
	@Test (priority=0)
	public void AddMealToCartTest()throws InterruptedException, IOException{
	this.driver.navigate().to(this.baseUrl+"meal/lobster-shrimp-chicken-quesadilla-combo");

	NotificationSistemPage nsp=new NotificationSistemPage(this.driver, this.wait, this.js);
	LocationPopupPage lpp=new LocationPopupPage(this.driver, this.wait, this.js);
	LoginPage lp=new LoginPage(this.driver, this.wait, this.js);
	ProfilePage pp=new ProfilePage(this.driver, this.wait, this.js);
	AuthPage ap=new AuthPage(this.driver, this.wait, this.js);
	MealPage mp=new MealPage(this.driver, this.wait, this.js);
	
	String mealquantity="2";
	
	lpp.ClosePopup ();
	Thread.sleep(2000);
	mp.AddToCart(mealquantity);

	
	Assert.assertTrue(nsp.MessageText().contains("The Following Errors Occurred:"+"\n"+
			"Please Select Location"));
	nsp.NoMessage();

	Thread.sleep(2000);
	lpp.Selectlocation();
	locationName="City Center - Albany";
	lpp.Setlocation(locationName);

	Thread.sleep(2000);

	mp.AddToCart(mealquantity);
	
	Thread.sleep(2000);
	Assert.assertTrue(nsp. MessageText().contains("Meal Added To Cart"),"[ERROR] Meal Adding To Cart failed!");

}
	@Test (priority=1)
	public void AddMealToFavouriteTest()throws InterruptedException, IOException{
	this.driver.navigate().to(this.baseUrl+"meal/lobster-shrimp-chicken-quesadilla-combo");
	
	NotificationSistemPage nsp=new NotificationSistemPage(this.driver, this.wait, this.js);
	LocationPopupPage lpp=new LocationPopupPage(this.driver, this.wait, this.js);
	LoginPage lp=new LoginPage(this.driver, this.wait, this.js);
	ProfilePage pp=new ProfilePage(this.driver, this.wait, this.js);
	AuthPage ap=new AuthPage(this.driver, this.wait, this.js);
	MealPage mp=new MealPage(this.driver, this.wait, this.js);

	lpp.ClosePopup ();
	mp.AddToFavourite();
	
	Assert.assertTrue(nsp. MessageText().contains("Please login first!"));
	this.driver.navigate().to(this.baseUrl+"guest-user/login-form");
	lp.UserLogin(email, password);
	this.driver.navigate().to(this.baseUrl+"meal/lobster-shrimp-chicken-quesadilla-combo");
	mp.AddToFavourite();
	Assert.assertTrue(nsp. MessageText().contains("Product has been added to your favorites"));
	}
	@Test (priority=2)
	public void ClearCartTest()throws InterruptedException, IOException{
	
	SoftAssert sa=new SoftAssert();
	File file=new File("data/Data.xlsx");
	FileInputStream fis=new FileInputStream(file);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheetAt(1);

	LocationPopupPage lpp=new LocationPopupPage(this.driver, this.wait, this.js);
	CartSummaryPage csp=new CartSummaryPage(this.driver, this.wait, this.js);
	NotificationSistemPage nsp=new NotificationSistemPage(this.driver, this.wait, this.js);
	MealPage mp=new MealPage(this.driver, this.wait, this.js);
	
	this.driver.navigate().to(this.baseUrl+"meals");
	
	locationName="City Center - Albany";
	lpp.Setlocation(locationName);
	
	for(int i=1; i<=6; i++) {
		XSSFRow row=sheet.getRow(i);
				driver.navigate().to(row.getCell(0).getStringCellValue());
		String mealquantity="2";
		mp.AddToCart(mealquantity);
		Thread.sleep(2000);
		sa.assertTrue(nsp. MessageText().contains("Meal Added To Cart"), "[ERROR] Meal Adding To Cart failed!");
	}

	csp.ClearAll();
	Assert.assertTrue(nsp. MessageText().contains("All meals removed from Cart successfully"), "[ERROR] Meals still in Cart!");
	}
}