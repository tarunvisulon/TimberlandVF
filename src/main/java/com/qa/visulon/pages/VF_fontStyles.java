package com.qa.visulon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VF_fontStyles {
	
	WebDriver driver;
	
	private By formattedNote = By .id("ContentPlaceHolder1_ImageButton6");
	
	private By font_drpdown= By.className("wrapper_fontFamily");
	
	private By allFontList= By.xpath("//li[@class='ck ck-list__item']");
	
	private By Continue= By.xpath("(//input[@value='Continue'])[2]");
	
	
	
	
	
	public VF_fontStyles(WebDriver driver)
	{
		
		this.driver= driver;
		
		
	}
	
	
	public void fnote()
	{
		driver.findElement(formattedNote).click();
		
		driver.switchTo().frame("FormatedNoteIframe");
		
	}
	
	public void fonts_dropdown()
	{
	
		driver.findElement(font_drpdown).click();
		
	}
	
	
	public List<String> ListOfFonts()
	{
		
		List<String> Storevalue = new ArrayList<>();
		List<WebElement> ele1 =driver.findElements(allFontList); 
		
		  for(WebElement e: ele1) 
		  {
		  String TotalFonts = e.getText();
		  
		  System.out.println(TotalFonts);
		   
		  Storevalue.add(TotalFonts);
	      Storevalue.removeIf(p -> p.isEmpty());
	       
	      
		  
		  }
		  
		  System.out.println(Storevalue);
		  return Storevalue;
		 
		 
	}
	
   public void Click_continue()
   {
	   driver.switchTo().defaultContent();
	   
	   driver.findElement(Continue).click();
	   
   }
	

}
