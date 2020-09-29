package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getEmail () {
		return this.driver.findElement(By.xpath("//*[@id=\'frm_fat_id_frmLogin\']/fieldset[1]/input"));
	}

	public WebElement getPassword () {
		return this.driver.findElement(By.xpath("//*[@id=\'frm_fat_id_frmLogin\']/fieldset[2]/input"));
	}
	
	public WebElement getRememberMe () {
		return this.driver.findElement(By.xpath("//*[@id=\'frm_fat_id_frmLogin\']/fieldset[3]/label/input"));
	}
	
	public WebElement getLogin () {
		return this.driver.findElement(By.xpath("//*[@id=\'frm_fat_id_frmLogin\']/fieldset[4]/input"));
	}

	public void UserLogin(String email, String password){
		this.getEmail().sendKeys(email);
		this.getEmail().click();
		this.getPassword().sendKeys(password);
		this.getPassword().click();
		this.getRememberMe().click();
		this.getLogin().click();
}
}