package com.automationstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationstore.base.BaseClass;

public class RegisterNewUserPage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'Create Account')]")
	private WebElement formTitleElement;
		
	@FindBy(xpath = "//input[@id='AccountFrm_firstname']")
	private WebElement firstNameElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_lastname']")
	private WebElement lastNameElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_email']")
	private WebElement emailElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_telephone']")
	private WebElement telephoneElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_fax']")
	private WebElement faxElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_company']")
	private WebElement companyElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_address_1']")
	private WebElement address1Element;
	
	@FindBy(xpath = "//input[@id='AccountFrm_address_2']")
	private WebElement address2Element;
	
	@FindBy(xpath = "//input[@id='AccountFrm_city'] ")
	private WebElement cityElement;
	
	@FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
	private WebElement regionOrStateElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_postcode']")
	private WebElement zipCodeElement;
	
	@FindBy(xpath = "//select[@id='AccountFrm_country_id']")
	private WebElement countryElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_loginname']")
	private WebElement loginNameElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_password']")
	private WebElement passwordElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_confirm']")
	private WebElement passwordConfirmElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_newsletter1']")
	private WebElement subscribeYesElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_newsletter0']")
	private WebElement subscribeNoElement;
	
	@FindBy(xpath = "//input[@id='AccountFrm_agree']")
	private WebElement privacyPolicyElement;
	
	@FindBy(xpath = "//button[@class='btn btn-orange pull-right lock-on-click']")
	private WebElement continueButtonElement;
	
	public RegisterNewUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateRegisterNewUserPage() {

		return formTitleElement.isDisplayed();
	}
	
	public void registerNewUser(String firstName,String lastName,String email,
								String telephone,String fax,String company,
								String address1,String address2,String city,
								String region,String zipCode,String country,
								String loginName,String password,String passwordConfirm,String subscribe) {
		
		firstNameElement.clear();
		firstNameElement.sendKeys(firstName);
		
		lastNameElement.clear();
		lastNameElement.sendKeys(lastName);
		
		emailElement.clear();
		emailElement.sendKeys(email);
		
		telephoneElement.clear();
		telephoneElement.sendKeys(telephone);
		
		faxElement.clear();
		faxElement.sendKeys(fax);
		
		companyElement.clear();
		companyElement.sendKeys(company);
		
		address1Element.clear();
		address1Element.sendKeys(address1);
		
		address2Element.clear();
		address2Element.sendKeys(address2);
		
		Select select2=new Select(countryElement);
		select2.selectByVisibleText(country);
		
		cityElement.clear();
		cityElement.sendKeys(city);
		
		zipCodeElement.clear();
		zipCodeElement.sendKeys(zipCode);
		
		Select select1=new Select(regionOrStateElement);
		select1.selectByVisibleText(region);
			
		loginNameElement.clear();
		loginNameElement.sendKeys(loginName);
		
		passwordElement.clear();
		passwordElement.sendKeys(password);
		
		passwordConfirmElement.clear();
		passwordConfirmElement.sendKeys(passwordConfirm);
		
		if(subscribe.equalsIgnoreCase("Yes")) {
			subscribeYesElement.click();
		}
		else {
			subscribeNoElement.click();
		}
		
		privacyPolicyElement.click();
			
	}
	public HomePage validateRegistration() {
		
		continueButtonElement.click();
		return new HomePage();
	}
}
