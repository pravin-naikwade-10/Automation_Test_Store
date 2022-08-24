package com.autostore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationstore.base.BaseClass;
import com.automationstore.dataprovider.DataProviders;
import com.automationstore.pageobjects.AddToCartPage;
import com.automationstore.pageobjects.IndexPage;
import com.automationstore.pageobjects.LoginPage;
import com.automationstore.pageobjects.OrderConfirmPage;
import com.automationstore.pageobjects.OrderSummaryPage;
import com.automationstore.pageobjects.SearchResultPage;
import com.automationstore.pageobjects.ShoppingCartPage;

public class EndToEndCheckOutTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmPage orderConfirmPage;
	LoginPage loginPage;
	
	@Parameters("browserName")
	@BeforeMethod
	public void setup(String browserName){
		launchApp(browserName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "getProductDetails",dataProviderClass = DataProviders.class)
	public void checkOutTest(String productName,String quantity,String size) {
		
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct(productName);
		boolean flag=searchResultPage.isProductAvailable();
		Assert.assertEquals(flag, true);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(quantity);
		shoppingCartPage=addToCartPage.clickonAddTocart();
		loginPage=shoppingCartPage.checkOutProduct();
		orderSummaryPage=loginPage.userLogin(prop.getProperty("username"), prop.getProperty("password"),orderSummaryPage);	
		orderConfirmPage=orderSummaryPage.clickOnConfirmOrder();		
		String orderIdMessage=orderConfirmPage.getOrderIDMessage();
		System.out.println("orderIdMessage: "+orderIdMessage);
		String OrderConfirmMessage=orderConfirmPage.verifyOrderConfirmMessage();	
		System.out.println("orderMessage: "+OrderConfirmMessage);
		
		
		Assert.assertEquals(OrderConfirmMessage.trim().toUpperCase(), "YOUR ORDER HAS BEEN PROCESSED!");
	}

}
