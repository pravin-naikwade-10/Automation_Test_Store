package com.automationstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationstore.base.BaseClass;

public class IndexPage extends BaseClass{

	@FindBy(xpath = "//a[@class='logo']/img")
	WebElement pageLogo;
	
	@FindBy(xpath = "//a[text()='Login or register']")
	WebElement loginOrRegister;
	
	@FindBy(xpath = "")
	WebElement product;
	
	@FindBy(xpath = "")
	WebElement productCategory;
	
	@FindBy(xpath = "//input[@id='filter_keyword']")
	WebElement searchBox;
	
	@FindBy(xpath = "//div[@class='button-in-search']")
	WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnLoginOrRegister() {
		loginOrRegister.click();
		return new LoginPage();
	}
	
	public boolean validateLogo(){
		return pageLogo.isDisplayed();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public SearchResultPage searchProduct(String ProductName) {	
		searchBox.clear();
		searchBox.sendKeys(ProductName);
		searchButton.click();
		
		return new SearchResultPage();
	}
}
