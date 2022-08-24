package com.automationstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationstore.base.BaseClass;


public class ShoppingCartPage extends BaseClass{
	
	@FindBy(xpath = "//a[@id='cart_checkout2']")
	private WebElement checkOutButton;
	
	public ShoppingCartPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage checkOutProduct() {
		
		checkOutButton.click();	
		return new LoginPage();
	}

}
