package com.selenium.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerCode implements ITestListener {

	public void onTestStart(ITestResult result) {

		System.out.println("On Test start");
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("on passed : "+result.getMethod().getMethodName());
		
		
		/*
		 * try { FixedDeposit_PageObj.takeSreenshot("Pass",
		 * result.getMethod().getMethodName()); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("on failed"+result.getMethod().getMethodName());
		
		/*
		 * try { FixedDeposit_PageObj.takeSreenshot("Fail",
		 * result.getMethod().getMethodName()); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("on skipped"+result.getMethod().getMethodName());
		
		/*
		 * try { FixedDeposit_PageObj.takeSreenshot("Skip",
		 * result.getMethod().getMethodName()); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("on complete");

	}

}
