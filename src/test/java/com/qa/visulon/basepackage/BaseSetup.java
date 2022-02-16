package com.qa.visulon.basepackage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.visulon.factory.DriverFactory;
import com.qa.visulon.listeners.TestListener;
import com.qa.visulon.pages.VF_Homepage;
import com.qa.visulon.pages.VF_Milestones_Assortment;
import com.qa.visulon.pages.VF_Roles;
import com.qa.visulon.pages.VF_fontStyles;
import com.qa.visulon.pages.VF_loginpage;

import com.qa.visulon.pages.VF_milestones_Homepage;
import com.qa.visulon.utils.ConfigReader;
import com.qa.visulon.utils.Constant;

public class BaseSetup {

	WebDriver driver;

	public TestListener tl;
		
	public DriverFactory df;

	public ConfigReader cr;

	public Properties prop;

	public VF_loginpage lg;

	public VF_Homepage hp;

	public VF_fontStyles fs;

	public VF_Roles rs;

	public VF_milestones_Homepage mt;

	public VF_Milestones_Assortment mile;

	
	

	/* @Parameters("broswer") */
	@BeforeClass(groups = { "Smoke", "sanity" })
	public void init_browsers() {

		df = new DriverFactory();
		cr = new ConfigReader();

		prop = cr.init_prop();
		driver = df.init_browser(prop);

		lg = new VF_loginpage(driver);

		hp = new VF_Homepage(driver);

		rs = new VF_Roles(driver);

		fs = new VF_fontStyles(driver);

		mt = new VF_milestones_Homepage(driver);

		mile = new VF_Milestones_Assortment(driver);

	}

	@BeforeClass(groups = { "Smoke", "sanity" })
	public WebDriver getDriver() {
		return driver;
	}

	@AfterClass(groups = { "Smoke", "sanity" })
	public void tearDown() {

		if(driver!=null) 
		{
			System.out.println("Closing browser");
		driver.quit();
		}
	}

	
	
	
}
