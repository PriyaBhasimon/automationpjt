package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPg {
	WebDriver driver;
	By loginlink=By.id("account-show");
	By loginbox=By.xpath("//*[@id=\"account-box\"]/div[2]/a");
	By accntemail=By.id("account_email");
	By accntpsword=By.id("account_password");
	By signinbutton=By.name("commit");

public LoginPg(WebDriver driver)
{
	this.driver=driver;
}

public static String getvalues(String xl,String Sheet,int r,int c)
{
	try
	{
		File f=new File(xl);
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFCell cell=(XSSFCell)wb.getSheet(Sheet).getRow(r).getCell(c);
	
		if(cell.getCellType()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else
		{
			return cell.getRawValue();
		}
	}
	catch (Exception e)
	{
		return "";
	}
}

		//to get row count
		public static int getrowcount(String xl,String Sheet)
		{
			try
			{
			
				File f=new File(xl);
				FileInputStream fi=new FileInputStream(f);
				XSSFWorkbook wb=new XSSFWorkbook(fi);
				
				return wb.getSheet(Sheet).getLastRowNum();
			}
			catch (Exception e)
			{
				return 0;
			}
			}

public void loginbutn()
{
	driver.findElement(loginlink).click();
}
public void loginbx()
{
	driver.findElement(loginbox).click();
}
public void setloginval(String emailadrs,String psword)
{
	driver.findElement(accntemail).clear();
	driver.findElement(accntemail).sendKeys(emailadrs);
	driver.findElement(accntpsword).clear();
	driver.findElement(accntpsword).sendKeys(psword);
}
public void signinbtnclk()
{
	driver.findElement(signinbutton).click();
}

}
