package com.qa.visulon.factory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;

  
	public WebDriver init_browser(Properties prop)
	{
	
		if (prop.getProperty("browserType").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();

		} else if (prop.getProperty("browserType").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver= new FirefoxDriver();

		} else

		{
			System.out.println("Please pass the correct browser :" + prop.getProperty("browserType"));

		}
		
				
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.get(prop.getProperty("URL"));
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			
		       return driver;
		
	
		
	}




	
		
	}
