package com.automationstore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.automationstore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite
	public void loadConfig() {
		
		ExtentManager.setExtent();
		
		prop=new Properties();
		FileInputStream ip;
		
		try {
			//System.out.println(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@AfterSuite
	public void afterSuite() {
		
		ExtentManager.endReport();
	}
	
	public static void launchApp(String browserName) {
		
		//String browserName=prop.getProperty("browser");
		//System.out.println("browserName: "+browserName);
		if(browserName.trim().equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.trim().equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.trim().equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("Edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			//System.out.println("No broswser type sent");
			Assert.assertFalse(false, "No broswser type sent");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
