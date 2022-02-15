package com.qa.visulon.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.visulon.basepackage.BaseSetup;
import com.qa.visulon.utils.Constant;
import com.qa.visulon.utils.ExcelReader;

@Parameters("browserType")
public class VF_Milestones extends BaseSetup {

	@Test(priority = 0 , groups = { "Smoke" ,"sanity" },dataProvider = "loginData" , dataProviderClass = ExcelReader.class)
	public void Userlogin(String username , String pwd)

	{

		lg.username(username);
		lg.password(pwd);
		lg.SignUp();

	}

	@Test(priority = 1,groups = {"sanity"})

	public void VF_Milestomes_homepage() {
		mt.ClickonCreateAssort();
		Assert.assertEquals(mt.ClickonAllMilestone(), Constant.AllMilestones);
		mt.CloseCreateAssortmentPopup();
	}

	@Test(priority = 2,groups = {"sanity"})

	public void VF_Milestomes_Assortment() {
		hp.getAllassortmetDetails();
		mile.ClickonFile();
		mile.ClickonChangemilestones();
		Assert.assertEquals(mile.Allmilestone_Assort(), Constant.AllMilestones);

	}

}
