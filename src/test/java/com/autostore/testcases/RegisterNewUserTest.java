package com.autostore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationstore.base.BaseClass;
import com.automationstore.dataprovider.DataProviders;
import com.automationstore.pageobjects.HomePage;
import com.automationstore.pageobjects.IndexPage;
import com.automationstore.pageobjects.LoginPage;
import com.automationstore.pageobjects.RegisterNewUserPage;

public class RegisterNewUserTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	RegisterNewUserPage registerNewUserPage;
	HomePage homePage;
	
	@Parameters("browserName")
	@BeforeMethod
	public void setup(String browserName){
		launchApp(browserName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1,enabled = true)
	public void verifyRegisterNewUserPage() {
		
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnLoginOrRegister();
		registerNewUserPage=loginPage.registerNewUser();
		boolean flag=registerNewUserPage.validateRegisterNewUserPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 2,dataProvider = "registerNewUserData" , dataProviderClass = DataProviders.class)
	public void registerNewUserTest(HashMap<String ,String> hashMap) {
		
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnLoginOrRegister();
		registerNewUserPage=loginPage.registerNewUser();
		registerNewUserPage.registerNewUser(hashMap.get("FirstName"), hashMap.get("LastName"), hashMap.get("Email"),
											hashMap.get("Telephone"), hashMap.get("Fax"), hashMap.get("Company"), 
											hashMap.get("Address1"), hashMap.get("Address2"), hashMap.get("City"), 
											hashMap.get("Region"), hashMap.get("ZipCode"), hashMap.get("Country"), 
											hashMap.get("LoginName"), hashMap.get("Password"), hashMap.get("PasswordConfirm"), 
											hashMap.get("Subscribe"));
	
		homePage=registerNewUserPage.validateRegistration();
		Assert.assertEquals( homePage.getCurrentURL(),"https://automationteststore.com/index.php?rt=account/success");
	}
		
}
