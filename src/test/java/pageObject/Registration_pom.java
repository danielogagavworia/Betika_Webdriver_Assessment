package pageObject;


import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import base.BaseClass;


public class Registration_pom extends BaseClass {
	
	// LOCATORS
	private By homepg_register_Btn =By.xpath("(//a[normalize-space()='Register'])[1]");
	private By phoneNumb_txtField= By.xpath("//input[@placeholder='e.g. 0712 234567']");
	private By password_txtField= By.xpath("(//input[@type='password'])[1]");
	private By confirm_passwd_txtFd= By.xpath("(//input[@type='password'])[2]");
	private By tNc_checkbox= By.xpath("//span[@class='checkmark']");
	private By registration_btn= By.xpath("(//span[contains(text(),'Register')])[3]");
	private By successful_msg= By.xpath("(//p[@class='message'])[1]");
	
	
	
	
	
	//INPUTS
	protected String expected_reg_successful_Msg="Account created. Enter the code sent to your phone to verify.";
	protected String passWord= "password";
	
	
	
	
	//ACTIONS
	public void click_On_Home_Page_Register_Button() {
		driver.findElement((homepg_register_Btn)).click();
	}
	
	public void enter_PhoneNumber(String phoneNumber) {
		driver.findElement((phoneNumb_txtField)).sendKeys(phoneNumber);
	}
	
	public void enter_Password(String password) {
		driver.findElement((password_txtField)).sendKeys(password);
	}
	
	public void confirm_Password(String password) {
		driver.findElement((confirm_passwd_txtFd)).sendKeys(password);
	}

	public void click_on_the_terms_and_condition_checkbox(){
		driver.findElement((tNc_checkbox)).click();
	}
	
	public void click_on_the_registration_button() throws InterruptedException {
		scroll_down(driver);
		Thread.sleep(4000);
		driver.findElement((registration_btn)).click();
	}
	
	
	public String generate_random_phone_numbers() {
		Faker fake= new Faker();
		
		String phone_number= "071"+fake.number().digits(7);
		return phone_number;
	}
	
	public void assert_verification_code_is_sent_to_user(){
		String actual_reg_successful_Msg= get_success_or_error_message(successful_msg, driver);
		assert_success_or_error_msg(actual_reg_successful_Msg, expected_reg_successful_Msg);
	}
	
}
