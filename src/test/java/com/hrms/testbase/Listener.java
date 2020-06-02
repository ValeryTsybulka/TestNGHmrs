package com.hrms.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import net.bytebuddy.asm.Advice.OnDefaultValue;

public class Listener implements ITestListener{
	@Override
	public void onStart(ITestContext context) {// this method executes when @Test method starts
	System.out.println("Functionality Testing Start ");
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Functionality Testing Finished");
		//ITestListener.super.onFinish(context);
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started " + result.getName());
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed " + result.getName());
		//ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed " + result.getName());
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
}
