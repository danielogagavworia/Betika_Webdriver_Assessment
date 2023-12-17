package testCases;



import org.testng.annotations.Test;
import step_definition.Registration_sd;
import step_definition.bet_placement_sd;
import step_definition.my_bet_sd;

public class My_bets extends my_bet_sd{
	
	@Test(priority = 1, description = "Verify successful rebet placement.")
	public void successful_rebet_placement() throws InterruptedException {
		login_and_place_successful_bet();
		navigate_to_my_bets_and_rebet_successfully();
		verify_rebet_is_successfully();
	}
	
	@Test(priority = 2, description = "Verify successful cashout.")
	public void successful_cashout() throws InterruptedException {
		login_and_place_successful_bet();
		navigate_to_my_bets_page_and_initiate_cashout();
		verify_cashout_is_successfully();
	}
	

	@Test(priority = 3, description = "Verify successful bet cancelation.")
	public void cancel_a_bet() throws InterruptedException {
		login_and_place_successful_bet();
		navigate_to_my_bets_page_and_cancel_bet();
		verify_cancel_is_successfully();
	}
}
