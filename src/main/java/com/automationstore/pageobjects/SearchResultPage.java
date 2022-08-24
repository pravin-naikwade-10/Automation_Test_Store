package com.automationstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationstore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath = "//div[@class=\"col-md-3 col-sm-6 col-xs-12\"]//img")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() {
		
		return productResult.isDisplayed();
	}
	
	public AddToCartPage clickOnProduct() {
		productResult.click();
		
		return new AddToCartPage();
	}
}
