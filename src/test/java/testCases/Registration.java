package testCases;



import org.testng.annotations.Test;
import step_definition.Registration_sd;

public class Registration extends Registration_sd{
	
	@Test(priority = 1, description = "Verify that a verification code is sent to the user during registration")
	public void successful_registration() throws InterruptedException {
		navigate_to_registration_page_and_enter_details();
		assert_verification_code_is_sent_to_user();
	}
}
