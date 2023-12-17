package step_definition;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pageObject.bet_placement_pom;



public class bet_placement_sd extends bet_placement_pom{
	
	public void select_three_random_games_and_select_odd_for_each() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		select_random_odds_for_each_games();
		}
	
	
	public void verify_bet_slip_can_be_shared() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_on_the_share_button();
		copy_bet_link();
		assert_share_link_is_copied_successfully();
		close_link();
	}
	
	public void verify_successful_bet_placement() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		place_bet();
		assert_successful_bet_placement();
	}
}
