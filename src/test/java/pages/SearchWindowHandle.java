package pages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class SearchWindowHandle {
	WebDriver driver;
	
	By searchbox=By.id("unbxd_autosuggest_field");
	By searchbt=By.xpath("//*[@id=\"tfheader\"]/form/input[3]");
	By dress=By.xpath("//*[@id=\"design-row-block\"]/ul/div[5]/div[1]/div/li/div/a");
	By buynow=By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[1]/div[3]/div[8]");
	

public SearchWindowHandle(WebDriver driver)	
{
	this.driver=driver;
}

public void searchwinhandle() throws IOException
{
	driver.findElement(searchbox).sendKeys("dress");
	driver.findElement(searchbt).click();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,20)", "");
	
	driver.findElement(dress).click();
	
	String parentwindow=driver.getWindowHandle();
	System.out.println("parent window title "+driver.getTitle());
	driver.findElement(By.xpath("//*[@id=\"design-row-block\"]/ul/div[5]/div[1]/div/li/div/a")).click();
	
	Set<String> allwindowhandles=driver.getWindowHandles();
	for(String handle:allwindowhandles)
	{
		System.out.println(handle);
		if(!handle.equalsIgnoreCase(parentwindow))
		{
			driver.switchTo().window(handle);
			driver.findElement(buynow).click();
			
		}
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./screenshot//dress.png"));
			
			driver.close();
		}
	}
}
}
