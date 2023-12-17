package step_definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import pageObject.Registration_pom;



public class Registration_sd extends Registration_pom{
	
	public void navigate_to_registration_page_and_enter_details() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String mobileNumber= generate_random_phone_numbers();
		
		click_On_Home_Page_Register_Button();
		enter_PhoneNumber(mobileNumber);
		enter_Password(passWord);
		confirm_Password(passWord);
		click_on_the_terms_and_condition_checkbox();
		click_on_the_registration_button();
		}
}
