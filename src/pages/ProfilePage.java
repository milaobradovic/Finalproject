package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage extends BasicPage{
	
	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getFirstName () {
		return this.driver.findElement(By.xpath("//*[@id=\'profileInfoFrm\']/div[1]/div[1]/fieldset/input"));
	}
	
	public WebElement getLastName () {
		return this.driver.findElement(By.xpath("//*[@id=\'profileInfoFrm\']/div[1]/div[2]/fieldset/input"));
	}
	
	public WebElement getEmail () {
		return this.driver.findElement(By.xpath("//*[@id=\'profileInfoFrm\']/div[2]/div[1]/fieldset/input"));
	}
	
	public WebElement getAddress () {
		return this.driver.findElement(By.xpath("//*[@id=\'profileInfoFrm\']/div[2]/div[2]/fieldset/input"));
	}
	
	public WebElement getPhoneNo () {
		return this.driver.findElement(By.xpath("//*[@id=\'profileInfoFrm\']/div[3]/div[1]/fieldset/input"));
	}
	
	public WebElement getZipCode () {
		return this.driver.findElement(By.xpath("//*[@id=\'profileInfoFrm\']/div[3]/div[2]/fieldset/input"));
	}
	
	public Select getState () {
		WebElement state=this.driver.findElement(By.id("user_state_id"));
		Select selectstate=new Select(state);
		return selectstate;
	}
	
	public Select getCountry () {
		WebElement country=this.driver.findElement(By.id("user_country_id"));
		Select selectcountry=new Select(country);
		return selectcountry;
	}
	
	public Select getCity () {
		WebElement city=this.driver.findElement(By.id("user_city_id"));
		Select selectcity=new Select(city);
		return selectcity;
	}
	
	public WebElement getSavebtn () {
		return this.driver.findElement(By.xpath("//*[@id=\'profileInfoFrm\']/div[5]/div/fieldset/input"));
	}
	
	public WebElement getUploadPicture () {
		return this.driver.findElement(By.xpath("//*[@id=\'profileInfo\']/div/div[1]/div/a[1]"));
	}
	
	public WebElement getRemovePicture () {
		return this.driver.findElement(By.xpath("//*[@id=\'profileInfo\']/div/div[1]/div/a[2]/i"));
	}
	
	public void deletePicture () {
		js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].click();",this.getRemovePicture());
	}
	
	//public void uploadPicture (String fileName) {
	//	js=(JavascriptExecutor)driver;
	//	js.executeAsyncScript("arguments[0].click();",this.getUploadPicture());
	//}
	
	public void uploadPicture (String path2file) throws Exception{
		js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].click();",this.getUploadPicture());
		String PicturePath=new File(path2file).getCanonicalPath();
		getUploadPicture().sendKeys(PicturePath);
}
	
	
	public void changeBasicInformations (String FirstName, String LastName, String Address, String Phone, String ZipCode, String Country, String State, String City) throws InterruptedException {
	this.getFirstName().clear();
	this.getFirstName().sendKeys(FirstName);
	this.getLastName().clear();
	this.getLastName().sendKeys(LastName);
	this.getAddress().clear();
	this.getAddress().sendKeys(Address);
	this.getPhoneNo().clear();
	this.getPhoneNo().sendKeys(Phone);
	this.getZipCode().clear();
	this.getZipCode().sendKeys(ZipCode);
	this.getCountry().deselectByVisibleText(Country);
	Thread.sleep(2000);
	this.getState().deselectByVisibleText(State);
	this.getCity().deselectByVisibleText(City);
	this.getSavebtn().click();
	}
}
