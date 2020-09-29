package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getReadMore () {
		return this.driver.findElement(By.name("//*[@id=\'body\']/section[1]/div/div/div[2]/div/div[2]/span[2]/a"));
	}
	
	public WebElement getQuantity () {
		return this.driver.findElement(By.name("product_qty"));
	}

	public WebElement getAddExtraTopping () {
		return this.driver.findElement(By.name("//*[@id=\'body\']/section[1]/div/div/div[2]/div/div[3]/div[2]/div/div[1]"));
	}
	
	public WebElement getLemonPowder () {
		return this.driver.findElement(By.name("//*[@id=\'body\']/section[1]/div/div/div[2]/div/div[3]/div[2]/div/div[2]/ul/li/div/div[1]/img"));
	}
	
	public WebElement getFavourite () {
		return this.driver.findElement(By.name("//*[@id=\'item_119\']/i/svg/g/path"));
	}
	
	public WebElement getAddToCartbtn () {
		return this.driver.findElement(By.name("//*[@id=\'body\']/section[1]/div/div/div[2]/div/div[3]/div[2]/a"));
	}
	
	public void AddToCart(int mealquantity) {
	this.getQuantity().sendKeys("mealquantity");
	this.getAddToCartbtn().click();
	}
	
	public void AddToFavourite() {
	this.getFavourite().click();
	}
}
