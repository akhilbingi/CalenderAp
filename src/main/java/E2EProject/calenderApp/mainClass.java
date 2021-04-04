package E2EProject.calenderApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class mainClass {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initialize() throws IOException
	{
		FileInputStream fis=new FileInputStream("/Users/bingis/eclipse-workspace/calenderApp/src/main/java/E2EProject/calenderApp/Data.properties");
		prop=new Properties();
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		
		//taking the browser value from jenkins jon
		
		//String browsername=System.getProperty("browser");
		System.out.println(browsername);
		
		if(browsername.equals("chrome"))
		{
			//String path=System.getProperty("user.dir")+"src/main/java/resources/chromedriver";
			//System.out.println(path);
			///Users/bingis/Downloads/ETEFramework1/src/main/java/resources1/chromedriver
			
			System.setProperty("webdriver.chrome.driver","/Users/bingis/Downloads/chromedriver");
			ChromeOptions options=new ChromeOptions();
			if(browsername.contains("headless")) 
			{
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			
			
		}
		
		else if(browsername.equals("firefox"))
		{
			///Users/bingis/Downloads/geckodriver
			//String path=System.getProperty("user.dir")+"/src/main/java/EndtoEnd1/ETEFramework1/geckodriver";
			System.setProperty("webdriver.gecko.driver","/Users/bingis/Downloads/geckodriver");
			driver=new FirefoxDriver();
			
			
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
		
		
		
		
		
	}

	public String TakingScreenshot(String getTestCasename,WebDriver driver) throws IOException 
	{
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File source= ts.getScreenshotAs(OutputType.FILE);
	 String DestinationFile=System.getProperty("user.dir")+"/reports/demo.html";
	 FileUtils.copyFile(source, new File(DestinationFile));
	 return DestinationFile;
	}
	

	
}
