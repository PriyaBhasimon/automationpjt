package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPg {
	
	WebDriver driver;
	By loginshow=By.id("account-show");
	By registerbox=By.xpath("//*[@id=\"account-box\"]/div[4]/a");
	By emailaddress=By.id("account_email");
	By accountpswrd=By.id("account_password");
	By passconfirm=By.id("account_password_confirmation");
	By signupbutton=By.name("commit");
	
public RegistrationPg(WebDriver driver)
{
	this.driver=driver;
}
public void loginbt()
{
	driver.findElement(loginshow).click();
}
public void register()
{
	driver.findElement(registerbox).click();
}
public void registersetval(String email,String password,String confirmpassword)
{
	driver.findElement(emailaddress).sendKeys(email);
	driver.findElement(accountpswrd).sendKeys(password);
	driver.findElement(passconfirm).sendKeys(confirmpassword);
}
public void signup()
{
	driver.findElement(signupbutton).click();
}

}
