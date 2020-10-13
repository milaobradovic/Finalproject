package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;

public class ProfileTest extends BasicTest{

	
	@Test (priority=0)
	public void EditProfileTest()throws InterruptedException, IOException{
	this.driver.navigate().to(baseUrl+"guest-user/login-form");
	
	FirstName="Milan";
	LastName="Jovanovic";
	Address="Nikole Pasica 16";
	PhoneNo="064123456";
	ZipCode="18000";
	Country="United States";
	State="California";
	City="Seaside";
	String PicturePath="";
	
	
	NotificationSistemPage nsp=new NotificationSistemPage(this.driver, this.wait, this.js);
	LocationPopupPage lpp=new LocationPopupPage(this.driver, this.wait, this.js);
	LoginPage lp=new LoginPage(this.driver, this.wait, this.js);
	ProfilePage pp=new ProfilePage(this.driver, this.wait, this.js);
	AuthPage ap=new AuthPage(this.driver, this.wait, this.js);
	

	lpp.ClosePopup ();
	lp.UserLogin(email, password);
	Thread.sleep(2000);

	Assert.assertTrue(nsp. MessageText().contains("Login Successfull"), "[ERROR] Login failed!");

	this.driver.navigate().to(this.baseUrl+"member/profile");
	Thread.sleep(2000);
	pp.changeBasicInformations(FirstName, LastName, Address, PhoneNo, ZipCode, Country, State, City);
	Thread.sleep(2000);
	Assert.assertTrue(nsp. MessageText().contains("Setup Successful"), "[ERROR] Setup failed!");
	Thread.sleep(2000);
	ap.Logout();
	Assert.assertTrue(nsp. MessageText().contains("Logout Successfull!"), "[ERROR] Login failed!");
	}

	@Test (priority=1)
	public void ChangeProfileImage()throws Exception{
	this.driver.navigate().to(this.baseUrl+"guest-user/login-form");

	NotificationSistemPage nsp=new NotificationSistemPage(this.driver, this.wait, this.js);
	LocationPopupPage lpp=new LocationPopupPage(this.driver, this.wait, this.js);
	LoginPage lp=new LoginPage(this.driver, this.wait, this.js);
	ProfilePage pp=new ProfilePage(this.driver, this.wait, this.js);
	AuthPage ap=new AuthPage(this.driver, this.wait, this.js);
	
	lpp.ClosePopup ();
	Thread.sleep(2000);
	lp.UserLogin(email, password);
	
	Assert.assertTrue(nsp. MessageText().contains("Login Successfull"), "[ERROR] Login failed!");

	this.driver.navigate().to(this.baseUrl+"member/profile");
	String imagePath=new File("images/koala.jpg").getCanonicalPath();
	pp.uploadPicture(imagePath);
	Thread.sleep(2000);
	Assert.assertTrue(nsp. MessageText().contains("Profile Image Uploaded Successfully"), "[ERROR] Profile Image Upload failed!");
	nsp.NoMessage();
	Thread.sleep(2000);
	pp.deletePicture();
	Thread.sleep(2000);
	Assert.assertTrue(nsp. MessageText().contains("Profile Image Deleted Successfully"), "[ERROR] Profile Image failed!");
	nsp.NoMessage();
	Thread.sleep(2000);
	ap.Logout();
	Assert.assertTrue(nsp. MessageText().contains("Logout Successfull!"), "[ERROR] Login failed!");

}
}