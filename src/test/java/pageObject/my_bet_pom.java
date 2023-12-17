package pageObject;

import org.openqa.selenium.By;
import testCases.Login;

public class my_bet_pom extends Login{

	// Locators
	
	private By mybets_btn= By.xpath("//span[normalize-space()='My Bets']");
	private By open_bet_btn= By.xpath("(//span[contains(text(),'Open')])[2]");
	private By rebet_btn= By.xpath("//span[normalize-space()='Rebet']");
	private By continue_btn= By.xpath("(//span[@class='confirm-dialogue__ok-btn'])[1]");
	protected By successful_msg= By.xpath("//div[@class='title']");
	private By place_bet= By.xpath("//span[normalize-space()='Place Bet KES100']");
	private By cashout_btn= By.xpath("(//span[contains(text(),'Cashout')])[1]");
	private By proceed_cashout= By.xpath("//span[contains(text(),'Cashout Kes')]");
	private By continue_cashout= By.xpath("(//span[@class='confirm-dialogue__ok-btn'])[1]");
	private By cancel_btn= By.xpath("(//span[@class='betdetails__summary__actions__item__progress__bar__cancel'])[1]");
	private By select_odd=By.xpath("(//button[@class='prebet-match__odd'])[3]");
	
	//Data
	private String expected_rebet_msg= "Rebet";
	private String expected_rebet_placement="Bet Placement Successful";
	private String expected_cashout_msg="Cashout Request Submitted";
	private String expected_cancel_msg="Bet Cancellation Request Received";
	
	
	//Actions
	public void click_on_my_bets() {
		driver.findElement(mybets_btn).click();
	}
	
	public void open_bet() {
		driver.findElement(open_bet_btn).click();
	}
	
	public void click_on_rebet_button() {
		driver.findElement(rebet_btn).click();
	}
	
	public void click_on_continue_button() {
		driver.findElement(continue_btn).click();
	}
	
	public void click_on_place_bet_button() {
		driver.findElement(place_bet).click();
	}
	
	public void select_odd_successfully() {
		driver.findElement(select_odd).click();
	}
	
	public void initiate_cashout() {
		driver.findElement(cashout_btn).click();
	}
		
	public void proceed_cashout() {
		driver.findElement(proceed_cashout).click();
	}
	
	public void continue_cashout() {
		driver.findElement(continue_cashout).click();
	}
	
	public void click_on_cancel_btn() {
		driver.findElement(cancel_btn).click();
	}
	
	
	public void verify_rebet_is_initiated_successfully() {
		String actual_rebet_msg=  get_success_or_error_message(successful_msg, driver);	
		assert_success_or_error_msg(actual_rebet_msg, expected_rebet_msg);
	}
	
	public void verify_rebet_is_successfully() {
		String actual_rebet_placement=  get_success_or_error_message(successful_msg, driver);	
		assert_success_or_error_msg(actual_rebet_placement, expected_rebet_placement);
	}
	
	public void verify_cashout_is_successfully() {
		String actual_cashout_msg=  get_success_or_error_message(successful_msg, driver);	
		assert_success_or_error_msg(actual_cashout_msg, expected_cashout_msg);
	}
	
	public void verify_cancel_is_successfully() {
		String actual_cancel_msg=  get_success_or_error_message(successful_msg, driver);	
		assert_success_or_error_msg(actual_cancel_msg, expected_cancel_msg);
	}
	
	
}	