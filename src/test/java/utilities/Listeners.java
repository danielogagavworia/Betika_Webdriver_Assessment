package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listeners extends Utils implements ITestListener{
	
	ExtentReports extent = Utils.getReporterObject();
	ExtentTest test;
	WebDriver driver;
	
	public void onTestStart(ITestResult result) {
		//Prints in the report for every started case and gives testcase name
		test = extent.createTest(result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "This is successful");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getDescription(), driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onFinish(ITestContext context){
		extent.flush();

	}
}
