package com.qa.visulon.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VF_Roles 
{
	
	WebDriver driver;
	private By Adminstration= By.id("linkAdmin");
	
	private By RolesProfiles= By.xpath("(//div[@class='arrowlistmenu']//div)[3]");
	
	private By UserRoles = By.linkText("Roles");
	
	private By ListRoleNames= By.xpath("//table[@class='adminDataGrid']//tr//td[1]");
	
	private By home= By.xpath("//a[@id='lnkHome']");
	
	
	
	public VF_Roles(WebDriver driver)
	{
		this.driver= driver;
		
	}
	
	
	
	public void ClickOnAdministration()
	{
		
		driver.findElement(Adminstration).click();
	}
	
	public void ClickOnRolesandProfiles()
	{
		
		driver.findElement(RolesProfiles).click();
		
	}
	
	public void ClickonRoles()
	{
		driver.findElement(UserRoles).click();
		
	}
	
	public List<String> ListOfRoles()
	
	{
		        List<String> userlist= new ArrayList<String>();
				List<WebElement> UserRoles_Column = driver.findElements(ListRoleNames);
				
				System.out.println(UserRoles_Column.size());
				
				boolean status= false;
				
				for (WebElement e1 : UserRoles_Column)
				{
					String Total_column=e1.getText();
					
				    System.out.println(Total_column);
				    userlist.add(Total_column);
					if (Total_column.contains("Global Category Managers")&&Total_column.contains("Global Merchants")&&Total_column.contains("Regional Category Managers")&&Total_column.contains("Regional Merchants")&&Total_column.contains("Merch Ops")&&Total_column.contains("Merch Planning"))
					{
						
						status=true;
						break;
						
				     }
			         }
				
		        return userlist;
		
		        
		
	}
	
	public void ClickonHome()
	{
		  driver.findElement(home).click();
		
	}
	
	

}
