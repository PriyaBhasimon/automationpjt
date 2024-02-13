package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyPg {
	WebDriver driver;

By logo=By.id("header_logo");
By tag=By.tagName("a");

public VerifyPg(WebDriver driver)
{
	this.driver=driver;
}
//title,logo,content,link verifications
public void titleverify()
{
	String actualtitle=driver.getTitle();
	System.out.println("Actual title is:"+actualtitle);
	String expectedtitle="https://www.mirraw.com/";
	if(actualtitle.equals(expectedtitle))
	{
		System.out.println("Title verification passed");
	}
	else
	{
		System.out.println("title verification failed");
	}
}
public void logoverify()
{
	if(driver.findElement(logo).isDisplayed())
	{
		System.out.println("logo displayed");
	}
	else
	{
		System.out.println("logo not displayed");
	}
}
public void contentverify()
{
	if(driver.getPageSource().contains("Jewellery"))
	{
		System.out.println("content verification passed");
	}
	else
	{
		System.out.println("content verification failed");
	}
}
public void linkverify()//link validation
{
	List<WebElement> ln=driver.findElements(tag);
	System.out.println("number of links:"+ln.size());
	for(WebElement li:ln)
	{
		String link=li.getAttribute("href");
		verify(link);
	}
}
public void verify(String link) 
{
   try
   {
	   URL obv=new URL(link);
	   HttpURLConnection con=(HttpURLConnection)obv.openConnection();
	   con.connect();
	   if(con.getResponseCode()==200)
	   {
		   System.out.println("valid link:"+link);
	   }
	   else
	   {
		  System.out.println("invalid link:"+link); 
	   }
   }
   catch(Exception e)
   {
	   System.out.println(e.getMessage());
   }		
}
}
