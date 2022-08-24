package com.automationstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationstore.base.BaseClass;

public class OrderSummaryPage extends BaseClass{
	
	@FindBy(xpath = "//button[@id='checkout_btn']")
	private WebElement confirmOrderButton;
	
	public OrderSummaryPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmPage clickOnConfirmOrder() {
		
		confirmOrderButton.click();
		return new OrderConfirmPage();
	}

}
