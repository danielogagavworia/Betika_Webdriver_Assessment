package pageObject;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class Login_pom extends BaseClass{
	
	//Locators
	private By homepg_login_Btn =By.xpath("(//a[normalize-space()='Login'])[1]");
	private By phoneNumb_txtField= By.xpath("//input[@placeholder='e.g. 0712 234567']");
	private By password_txtField= By.xpath("(//input[@type='password'])[1]");
	private By login_btn= By.xpath("(//span[contains(text(),'Login')])[2]");
	private By user_profile_btn= By.xpath("//span[normalize-space()='Profile']");
	private By error_msg= By.xpath("(//p[@class='message'])[1]");
	
	
	//Data
	protected String valid_userName= "0735638271";
	protected String valid_passWord= "2020";
	protected String invalid_passWord= "20210";
	private String expected_invalid_error_msg= "The mobile and password provided do not match";
	private String expected_invalid_error_msg2= "This phone number does not exist, please register a new account";
	
	//ACTIONS
		public void click_On_Home_Page_Register_Button() {
			driver.findElement((homepg_login_Btn)).click();
		}
		
		public void enter_PhoneNumber(String phoneNumber) {
			driver.findElement((phoneNumb_txtField)).sendKeys(phoneNumber);
		}
		
		public void enter_Password(String password) {
			driver.findElement((password_txtField)).sendKeys(password);
		}
		
		public void click_On_login_Button() {
			driver.findElement((login_btn)).click();
		}
		
		public Boolean validate_user_profile_is_displayed() {
			Boolean profile_displayed= driver.findElement(user_profile_btn).isDisplayed();
			return profile_displayed;
		}
		
		public void assert_user_is_logged_in_successfully() {
			SoftAssert softAssert= new SoftAssert();
			Boolean actual_result = validate_user_profile_is_displayed();
			softAssert.assertTrue(actual_result);
			softAssert.assertAll();	
		}
		
		public void assert_invalid_details_error_msg() {
			String actual_invalid_error_msg= get_success_or_error_message(error_msg, driver);;
			assert_success_or_error_msg(actual_invalid_error_msg, expected_invalid_error_msg);
			
		}
		
		public void assert_invalid_error_msg_is_one_of() {
			SoftAssert softAssert= new SoftAssert();
			String actual_invalid_error_msg= get_success_or_error_message(error_msg, driver);
			
			//Asserts passes if one of the error messages below is displayed
			softAssert.assertTrue(
					actual_invalid_error_msg.equals(expected_invalid_error_msg) || actual_invalid_error_msg.equals(expected_invalid_error_msg2)        
	        );
			softAssert.assertAll();	
		}
	
}
