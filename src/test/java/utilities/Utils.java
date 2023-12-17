package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Utils {
	
	public void scroll_down(WebDriver driver) {
		JavascriptExecutor jscript = (JavascriptExecutor) driver;
		jscript.executeScript("window.scrollBy(0, 500);");
	}
	
	public int getRandomNumb(int min, int max) {
		 Random random = new Random();
	        return random.nextInt((max - min) + 1) + min;
	}
	
	public static ExtentReports getReporterObject() {
		String ReportPath= System.getProperty("user.dir") + "\\reporters\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(ReportPath);
		reporter.config().setReportName("Test Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		File sourcee = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileDestination= System.getProperty("user.dir")+"\\reporters\\"+testcaseName+".png";
		File Destination= new File(fileDestination);
		FileUtils.copyFile(sourcee, Destination);
		return fileDestination;
	}
	
	public void assert_success_or_error_msg(String actual_result, String expected_result) {
		SoftAssert softassert = new SoftAssert();
		
		softassert.assertEquals(actual_result, expected_result);
		softassert.assertAll();
	}
	
	public void wait_until_success_msg_clear(By element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(element));
	}
	
	public String get_success_or_error_message(By element, WebDriver driver) {
		String successfully_msg= driver.findElement(element).getText();
		return successfully_msg;
	}


}
