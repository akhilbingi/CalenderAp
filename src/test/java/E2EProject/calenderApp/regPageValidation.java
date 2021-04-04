package E2EProject.calenderApp;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class regPageValidation extends mainClass{

	
	public WebDriver driver;
	@Test(dataProvider="getdata")
	public void invokingRegistrationPage(String emailid,String Name,String Username,String password,String URL) throws IOException, InterruptedException
	
	{
		
        driver=initialize();
		invokeURLfromtextfile i=new invokeURLfromtextfile();
		driver.get(i.geturl());
		registrationPage reg=new registrationPage(driver);
		reg.EnterRegPage().click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		reg.getEmail().sendKeys(emailid);
		reg.getName().sendKeys(Name);
		reg.getUsernme().sendKeys(Username);
		reg.getpassword().sendKeys(password);
		reg.getAvatar().sendKeys(URL);
		reg.Submit().click();
		
	}
	
	@DataProvider
	public Object[][] getdata() 
	{
		Object[][] data=new Object[2][5];
		data[0][0]="akhilbingi@gmail.com";
		data[0][1]="akhil bingi";
		data[0][2]="akhilbingi32";
		data[0][3]="Matrix@321456";
		data[0][4]="https://www.google.com/";
		
		data[1][0]="akhilbingi64@gmail.com";
		data[1][1]="bingi64";
		data[1][2]="akhilbingi64@gmail.com";
		data[1][3]="Matrix@32164";
		data[1][4]="https://www.google.com/";
		
		return data;
		
	}
	
	@AfterTest
	public void aftertest() 
	{
		driver.close();
	}
	
	
	
	
}