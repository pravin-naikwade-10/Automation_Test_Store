package com.automationstore.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.automationstore.base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrentURL(){		
		return driver.getCurrentUrl();
	}
}
