package com.automationstore.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automationstore.base.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ListenerClass extends ExtentManager implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass test case is: "+result.getName());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			test.log(Status.FAIL, MarkupHelper.createLabel("Fail test case is: "+result.getName(), ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel("Fail test case is: "+result.getThrowable(), ExtentColor.RED));
			
			String screenShotPath=ScreenShotUtiltiy.getScreenShot(BaseClass.driver, result.getName());
			try {
				test.fail("Screenshot is attached", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped test case is: "+result.getName());
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
}
