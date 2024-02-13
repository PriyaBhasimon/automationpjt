package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPg;
import pages.RegistrationPg;
import pages.SearchWindowHandle;
import pages.VerifyPg;

public class MirrawTesting {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.mirraw.com/");
		driver.manage().window().maximize();
	}
	
	@Test(enabled=false)
	public void signuptest()
	{
		RegistrationPg rp=new RegistrationPg(driver);
		rp.loginbt();
		rp.register();
		rp.registersetval("primanageworks123@gmail.com", "14@Mydevarsh", "14@Mydevarsh");
		rp.signup();
	}	
	@Test
	public void logintest() throws IOException
	{
		LoginPg lp=new LoginPg(driver);
		lp.loginbutn();
		lp.loginbx();
		
		String xl="C:\\Users\\priya\\OneDrive\\Desktop\\Mirrawlogin.xlsx";
		String Sheet="Sheet1";
		
		int rowcount=LoginPg.getrowcount(xl, Sheet);
		for(int i=1;i<=rowcount;i++)
		{
			String accntemail=LoginPg.getvalues(xl, Sheet, i, 0);
			System.out.println("email---"+accntemail);
			String accntpswrd=LoginPg.getvalues(xl, Sheet, i, 1);
			System.out.println("password---"+accntpswrd);
			
			lp.setloginval(accntemail,accntpswrd);
			lp.signinbtnclk();
		}
		{
			VerifyPg vf=new VerifyPg(driver);
			vf.titleverify();
			vf.logoverify();
			vf.contentverify();
			vf.linkverify();
		}
		{
			SearchWindowHandle sw=new SearchWindowHandle(driver);
			sw.searchwinhandle();
		}
	}
}
