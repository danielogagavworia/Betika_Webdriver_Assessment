package testCases;

import org.testng.annotations.Test;

import step_definition.Login_sd;

public class Login extends Login_sd{
	
	
	@Test(priority = 1, description = "Verify that valid login credentials allow access.")
	public void successful_login() throws InterruptedException {
		navigate_to_login_page_and_enter_details(valid_userName,valid_passWord);
		assert_user_is_logged_in_successfully();
	}
	
	@Test(priority = 2, description = "Verify that invalid credentials result in an error message.")
	public void invalid_login() throws InterruptedException {
		navigate_to_login_page_and_enter_details(valid_userName,invalid_passWord);
		assert_invalid_details_error_msg();
	}
	
	@Test(priority = 3, dataProvider = "logintestdata", description = "Modify the login test case to read test data from an external source\r\n"
			+ "(e.g., CSV, Excel, JSON) and execute the test with multiple sets of\r\n"
			+ "login credentials.")
	public void multiple_login(String usernme, String passwrd) throws InterruptedException {
		navigate_to_login_page_and_enter_details(usernme,passwrd);
		assert_invalid_error_msg_is_one_of();
	}
}
