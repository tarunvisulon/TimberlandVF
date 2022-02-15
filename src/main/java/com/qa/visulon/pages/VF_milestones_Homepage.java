package com.qa.visulon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class VF_milestones_Homepage {
	
	WebDriver driver;
	private By createAssort= By.xpath("//div[@id='btnNewAssortment']");
	
	private By milestones= By.id("ddlASrtMilestones");
	
	private By closeassort= By.xpath("//div[@onclick='HideCreateSaveAsPopup();']");
	
	
	public VF_milestones_Homepage(WebDriver driver)
	{	
		this.driver=driver;
		
	}
	
	
	public void ClickonCreateAssort()
	{
		
		driver.findElement(createAssort).click();
		

	}

	
	public List<String> ClickonAllMilestone()
	{
		
		
        Select s= new Select(driver.findElement(By.id("ddlASrtMilestones")));
		
		List<String> Milestone_name= new ArrayList<String>();
		
		
		List<WebElement> Allmilestone = s.getOptions();

		
		  for (WebElement e: Allmilestone) 
		  {
		  
		  String Allmiltestonename = e.getText();
		  	  
		  if(Allmiltestonename.toLowerCase().equals("select"))
		  {
			 continue;
			  
		  }else 
		  {
			  
			  Milestone_name.add(Allmiltestonename);
			  
		  }
		  
		  }
		 
		  return Milestone_name;
		
		
		
	  }
	
	public void CloseCreateAssortmentPopup()
	{
		
		driver.findElement(closeassort).click();
		
	}
	
	  }
	
	

