package com.automationstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationstore.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath="//select[@id='option320']")
	private WebElement size;
	
	@FindBy(xpath="//input[@id='product_quantity']")
	private WebElement quantity;
	
	@FindBy(xpath="//a[@class='cart']")
	private WebElement addToCartButton;

	public AddToCartPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void selectSize(String prodSize) {
		
		Select select=new Select(size);
		select.deselectByVisibleText(prodSize);	
	}
	
	public void enterQuantity(String prodQuantity) {
		quantity.clear();
		quantity.sendKeys(prodQuantity);
	}
	
	public ShoppingCartPage clickonAddTocart() {
		addToCartButton.click();
		
		return new ShoppingCartPage();
	}
}
