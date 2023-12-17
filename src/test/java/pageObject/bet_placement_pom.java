package pageObject;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import testCases.Login;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bet_placement_pom extends Login {

	// Locators
	private By total_games_displayed = By.xpath("//div[@class='prebet-match__odd-market__container']");
	private By share_button = By.xpath("(//span[@class='share-betslip__closed__button__title'])[1]");
	private By copy_link_button = By.xpath("(//button[normalize-space()='Copy Link'])[1]");
	private By link_copied_success_msg = By.xpath("(//p[@class='message'])[1]");
	private By cancel_link = By.xpath("(//button[normalize-space()='Cancel'])[1]");
	private By place_bet = By.xpath("//span[normalize-space()='Place Bet KES100']");
	private By successful_bet_msg = By.xpath("//div[@class='title']");

	// Data
	private String expected_link_copied_msg = "Copied the link successfully";
	private String expected_bet_placed_msg = "Bet Placement Successful";

	// ACTIONS
	public int get_total_games_displayed() {
		int total_games = driver.findElements((total_games_displayed)).size();
		return total_games;
	}

	public void scroll_to_the_odd_selected(int randnumb) {
		JavascriptExecutor jscript = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//button[@class='prebet-match__odd'])[" + randnumb + "]"));

		jscript.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
				element);
	}

	public Set<Integer> select_three_random_games() {
		int totalItems = get_total_games_displayed();
		int count = 3;

		Set<Integer> uniqueNumbers = new HashSet<>();

		while (uniqueNumbers.size() < count) {
			int randomNumber = getRandomNumb(1, totalItems);
			uniqueNumbers.add(randomNumber);
		}

		return uniqueNumbers;
	}

	public void select_random_odds_for_each_games() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		Set<Integer> selected_games = select_three_random_games();

		for (int selected_game : selected_games) {

			int highest_odd = selected_game * 3;
			int lowest_odd = highest_odd - 2;

			// choose a random odd for the game selected
			int randomNumber = getRandomNumb(lowest_odd, highest_odd);

			scroll_to_the_odd_selected(randomNumber);

			WebElement element = driver
					.findElement(By.xpath("(//button[@class='prebet-match__odd'])[" + randomNumber + "]"));

			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//button[@class='prebet-match__odd'])[" + randomNumber + "]")));
			element.click();

		}
	}

	public void click_on_the_share_button() {
		driver.findElement(share_button).click();
	}

	public void copy_bet_link() {
		driver.findElement(copy_link_button).click();
	}

	public void close_link() {
		driver.findElement(cancel_link).click();
	}

	public void place_bet() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(place_bet).click();
	}

	public void assert_share_link_is_copied_successfully() {
		String actual_link_copied_msg = get_success_or_error_message(link_copied_success_msg, driver);
		assert_success_or_error_msg(actual_link_copied_msg, expected_link_copied_msg);
	}

	public void assert_successful_bet_placement() {
		String actual_bet_placed_msg = get_success_or_error_message(successful_bet_msg, driver);
		assert_success_or_error_msg(actual_bet_placed_msg, expected_bet_placed_msg);
	}

}
