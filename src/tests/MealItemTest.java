package tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;

import org.testng.annotations.Test;
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
	
	int mealquantity=2;
	
	lpp.ClosePopup ();
	Thread.sleep(2000);
	mp.AddToCart(mealquantity);

	
	Assert.assertTrue(nsp.MessageText().contains("The Following Errors Occurred:"
			+"Please Select Location"));
	nsp.NoMessage();
	Thread.sleep(2000);

	lpp.Selectlocation();
	locationName="City Center - Albany";
	lpp.Setlocation(locationName);

	mp.AddToCart(mealquantity);
	Thread.sleep(2000);
	Assert.assertTrue(nsp. MessageText().contains("Meal Added To Cart"));

}
//	@Test (priority=1)
//	public void AddMealToFavouriteTest()throws InterruptedException, IOException{
//	this.driver.navigate().to(this.baseUrl+"meal/lobster-shrimp-chicken-quesadilla-combo");
	
//	NotificationSistemPage nsp=new NotificationSistemPage(this.driver, this.wait, this.js);
//	LocationPopupPage lpp=new LocationPopupPage(this.driver, this.wait, this.js);
//	LoginPage lp=new LoginPage(this.driver, this.wait, this.js);
//	ProfilePage pp=new ProfilePage(this.driver, this.wait, this.js);
//	AuthPage ap=new AuthPage(this.driver, this.wait, this.js);
//	MealPage mp=new MealPage(this.driver, this.wait, this.js);

//	lpp.ClosePopup ();
//	mp.AddToFavourite();
	
//	Assert.assertTrue(nsp. MessageText().contains("Please login first!"));
//	this.driver.navigate().to(this.baseUrl+"guest-user/login-form");
//	lp.UserLogin(email, password);
//	this.driver.navigate().to(this.baseUrl+"meal/lobster-shrimp-chicken-quesadilla-combo");
//	mp.AddToFavourite();
//	Assert.assertTrue(nsp. MessageText().contains("Product has been added to your favorites"));
//	}
	//@Test (priority=2)
	//public void ClearCartTest()rows InterruptedException, IOException{
	//this.driver.navigate().to(this.baseUrl+"meals");

	//LocationPopupPage lpp=new LocationPopupPage(this.driver, this.wait, this.js);
	//CartSummaryPage csp=new CartSummaryPage(this.driver, this.wait, this.js);
	//NotificationSistemPage nsp=new NotificationSistemPage(this.driver, this.wait, this.js);
	//
	//locationName=" City Center - Albany";
	//lpp.Setlocation(locationName);

//	csp.ClearAll();
//	Assert.assertTrue(nsp. MessageText().contains("Product has been added to your favorites"));
//	}
}
