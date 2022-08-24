package com.automationstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationstore.base.BaseClass;

public class OrderConfirmPage extends BaseClass{
	
	@FindBy(xpath = "//span[@class='maintext']")
	private WebElement orderCofirmPage;
	
	@FindBy(xpath = "//section[@class='mb40']/p[2]")
	private WebElement orderConfirmID;
	
	public OrderConfirmPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getOrderIDMessage() {
		
		return orderConfirmID.getText();
	}
	public String verifyOrderConfirmMessage() {
		
		return orderCofirmPage.getText();
	}
	
}
