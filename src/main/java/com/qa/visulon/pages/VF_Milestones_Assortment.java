package com.qa.visulon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class VF_Milestones_Assortment {
	
	WebDriver driver;
	private By file= By.xpath("//li[@id='lnkFile']");
	
	private By changeMilestones= By.xpath("//li[@id='liChangeMilestone']");
	

	public VF_Milestones_Assortment(WebDriver driver)
	{
		
		this.driver= driver;
		
	}
	
	
	
	public void ClickonFile()
	{
		
		driver.findElement(file).click();
	}

	
	public void ClickonChangemilestones()
	{
		driver.findElement(changeMilestones).click();
		
	}
	
	
	public List<String> Allmilestone_Assort()
	{

        Select s= new Select(driver.findElement(By.xpath("//div[@class='modernPopup changeMilestonePopup']//div[@class='modernPopupTitle']//following::select[@id='ContentPlaceHolder1_ddlAsrtChangeMileStone']")));
		
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
	
		
	}
	

