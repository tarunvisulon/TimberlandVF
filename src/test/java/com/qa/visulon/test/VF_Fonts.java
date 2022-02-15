package com.qa.visulon.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.visulon.basepackage.BaseSetup;
import com.qa.visulon.utils.Constant;
import com.qa.visulon.utils.ExcelReader;

@Parameters("browserType")
public class VF_Fonts extends BaseSetup {

	@Test(priority = 0, groups = { "Smoke" ,"sanity" },dataProvider = "loginData" , dataProviderClass = ExcelReader.class)
	public void Userlogin(String username , String pwd)

	{

		
		lg.username(username);
	
		lg.password(pwd);
		
		lg.SignUp();
		
		System.out.println(Thread.currentThread().getId());

	}

	@Test(priority = 1, groups = { "Smoke" })
	public void User_roles() {
		rs.ClickOnAdministration();
		rs.ClickOnRolesandProfiles();
		rs.ClickonRoles();
		Assert.assertEquals(rs.ListOfRoles(), Constant.ManageUserRoles);
		rs.ClickonHome();

	}

	@Test(priority = 2, groups = { "sanity" })
	public void VF_fonts() {

		hp.getAllassortmetDetails();
		fs.fnote();
		fs.fonts_dropdown();
		Assert.assertEquals(fs.ListOfFonts(), Constant.fontsTotal);
		fs.Click_continue();

	}

}
