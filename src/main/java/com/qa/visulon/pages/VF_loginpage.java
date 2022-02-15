package com.qa.visulon.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VF_loginpage 
{
   
	WebDriver driver;
	
	private By userName= By.id("txtUserName");
	
	private By passWord= By.id("txtPassword");
	
	private By login= By.id("LinkButton1");
	
	
	public VF_loginpage(WebDriver driver)
	{
		
		this.driver=driver;
		
		
	}
	
	
	public void username(String uname)
	{
		driver.findElement(userName).sendKeys(uname);
		
	}
	
	
	public void password(String pass)
	{
		
		driver.findElement(passWord).sendKeys(pass);
	}
	
	
	
	public void SignUp()
	{
		driver.findElement(login).click();
		
		
	}
	
	public String get_Title()
	{
		
		return driver.getTitle();
		
		
	}
	
	
	
	
}
