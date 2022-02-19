package com.selenium.report;

import java.util.*;
import org.testng.*;
import org.testng.xml.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;

public class ExtentTestNGIReporterListener implements IReporter {
    
   
    
    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        init();
        
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
                buildTestNodes(context.getPassedTests(), Status.PASS);
                
            }
        }
        
        for (String s : Reporter.getOutput()) {
            extent.setTestRunnerOutput(s);
        }
        
        extent.flush();
    }
    
    private void init() {
    	String projectPath = System.getProperty("user.dir");
         ExtentHtmlReporter extentHtmlReporter=new ExtentHtmlReporter(projectPath+"\\TestReport\\ExtentReport.html");
		 extentHtmlReporter.config().setDocumentTitle("Regression Report");
		 extentHtmlReporter.config().setReportName("TestYou Login Test");
       
        
        extent = new ExtentReports();
        extent.attachReporter(extentHtmlReporter);
        extent.setReportUsesManualConfiguration(true);
        extent.setSystemInfo("Selenium", "3.141.59");
        extent.setSystemInfo("Java", "8");
        extent.setSystemInfo("TestNG", "7.4.0");
    }
    
    private void buildTestNodes(IResultMap tests, Status status) {
        ExtentTest test;
        
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());
                
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                }
                else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                
                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }
    
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();      
    }
}
