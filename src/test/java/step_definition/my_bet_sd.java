package step_definition;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pageObject.bet_placement_pom;
import pageObject.my_bet_pom;



public class my_bet_sd extends my_bet_pom{
	

	public void login_and_place_successful_bet() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		login_successfully();
		place_bet_successfully();
		wait_until_success_msg_clear(successful_msg, driver);
		}
	
	public void navigate_to_my_bets_and_rebet_successfully() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_on_my_bets();
		open_bet();
		click_on_rebet_button();
		click_on_continue_button();
		verify_rebet_is_initiated_successfully();
		wait_until_success_msg_clear(successful_msg, driver);
		click_on_place_bet_button();
		
	}
	
	
	public void navigate_to_my_bets_page_and_initiate_cashout() {
		click_on_my_bets();
		initiate_cashout();
		proceed_cashout();
		continue_cashout();
	}
	
	
	public void navigate_to_my_bets_page_and_cancel_bet() {
		click_on_my_bets();
		open_bet();
		click_on_cancel_btn();
		click_on_continue_button();
	}
	
	public void login_successfully() throws InterruptedException {
		navigate_to_login_page_and_enter_details(valid_userName,valid_passWord);
	}
	
	public void place_bet_successfully() throws InterruptedException {
		select_odd_successfully();
		click_on_place_bet_button();
	}
	
	
	
}
