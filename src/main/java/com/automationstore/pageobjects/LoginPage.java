package com.automationstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationstore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath = "//input[@id='loginFrm_loginname']")
	private WebElement loginName;
	
	@FindBy(xpath = "//input[@id='loginFrm_password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@class='btn btn-orange pull-right' and @title='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//input[@id='accountFrm_accountregister']")
	private WebElement registerRadioButton;
	
	@FindBy(xpath = "//button[@class='btn btn-orange pull-right' and @title='Continue']")
	private WebElement registerContinueButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage userLogin(String userName,String userPassword) {
		loginName.clear();
		loginName.sendKeys(userName);
		password.clear();
		password.sendKeys(userPassword);
		
		return new HomePage();
	}
	
	public OrderSummaryPage userLogin(String userName,String userPassword,OrderSummaryPage orderSummaryPage) {
		loginName.clear();
		loginName.sendKeys(userName);
		password.clear();
		password.sendKeys(userPassword);
		loginButton.click();
		
		return new OrderSummaryPage();
	}
	
	public RegisterNewUserPage registerNewUser() {
		if(!registerRadioButton.isSelected()){
			registerRadioButton.click();
		}
		
		registerContinueButton.click();
		
		return new RegisterNewUserPage();
	}
}
