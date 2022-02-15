package com.qa.visulon.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.visulon.basepackage.BaseSetup;
import com.qa.visulon.utils.Constant;

public class TestListener extends BaseSetup implements ITestListener {

	WebDriver driver;
    
	private static ExtentReports reports= new ExtentReports();
	
    private static ExtentSparkReporter reporter= new ExtentSparkReporter(Constant.ExtentReport_path);
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String ScreenshotDir="../VF_Sprints2021/FailureScreenshot";
      
		Object currentclass = result.getInstance();

		WebDriver driver = ((BaseSetup) currentclass).getDriver();

		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodName = result.getName().toString().trim();
		int status = result.getStatus();

		if (ITestResult.FAILURE == status) {
			Takescreenshot(driver, methodName);
			
			reports.attachReporter(reporter);
			reports.createTest(methodName)
			.log(Status.FAIL,result.getThrowable()).addScreenCaptureFromPath(ScreenshotDir+ methodName + ".png");
		
			reports.flush();
			             
		}
			
		
	}

	public void Takescreenshot(WebDriver driver, String methodName) {
		Date d = new Date();

		SimpleDateFormat s = new SimpleDateFormat("dd_MM_YYYY");

		String date = s.format(d);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(Constant.Screenshot_path + methodName + date + ".png");

		try {
			FileUtils.copyFile(src, dest);

			System.out.println("Successfully captured a screenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception While taking screenshot" + e.getMessage());
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
	
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
	      
		Object currentclass = result.getInstance();

		WebDriver driver = ((BaseSetup) currentclass).getDriver();

		System.out.println("***** Success " + result.getName() + " test has Passed *****");
		String methodName = result.getName().toString().trim();
		int status = result.getStatus();

		if (ITestResult.SUCCESS == status) {
			
			Takescreenshot(driver, methodName);
			
			reports.attachReporter(reporter);
			reports.createTest(methodName)
			.log(Status.PASS,"Test Result Passed");
		
			reports.flush();
			             
		}
	
		
	}

}
