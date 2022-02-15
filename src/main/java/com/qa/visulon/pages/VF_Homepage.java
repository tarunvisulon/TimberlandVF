package com.qa.visulon.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VF_Homepage {

	WebDriver driver;

	private By getAllAssortmentName = By.xpath("//td[@class='regularDoc ForDocumentName']");

	private By getAssortment = By.xpath("//td[@class='regularDoc ForDocumentName']//div[contains(text(),'TEST_FONTS_DND')]");

	public VF_Homepage(WebDriver driver) {

		this.driver = driver;

	}

	public void getAllassortmetDetails()
	{
		
		List<WebElement> ele= driver.findElements(getAllAssortmentName);
		int document_size=ele.size();
	    System.out.println(document_size);
		
		for(int i= 0 ; i<document_size; i++)
		{
			String doc_name = ele.get(i).getText();
			
			System.out.println(doc_name);
			
			
			if(doc_name.contains("TEST_FONTS_DND"))
			{
				driver.findElement(getAssortment).click();
				break;
			}
			
		
		
	     }
	
	}
	
	public String Homepage_Title()
	{
		
		return driver.getTitle();
	}
	
}
