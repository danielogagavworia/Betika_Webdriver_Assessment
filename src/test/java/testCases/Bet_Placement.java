package testCases;



import org.testng.annotations.Test;
import step_definition.Registration_sd;
import step_definition.bet_placement_sd;

public class Bet_Placement extends bet_placement_sd{
	
	@Test(priority = 1, description = "Verify successful bet placement.")
	public void successful_bet_placement() throws InterruptedException {
		successful_login();
		select_three_random_games_and_select_odd_for_each();
		verify_bet_slip_can_be_shared();
		verify_successful_bet_placement();
	}
}
