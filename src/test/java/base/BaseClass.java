package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Utils;

public class BaseClass extends Utils {

	public static WebDriver driver;
	public static String browser= "chrome";

	public static FileReader fr;
	public static Properties prop = new Properties();

	@BeforeMethod
	@Parameters("browser")
	public void launch_browser() throws InterruptedException, IOException {
		fr = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\Config.properties");

		prop.load(fr);

		if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);

			driver.get(prop.getProperty("Url"));
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless","--remote-allow-origins=*", "ignore-certificate-errors");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
			driver.get(prop.getProperty("Url"));
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
			driver.get(prop.getProperty("Url"));
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}

	@AfterMethod
	public void close_browser() {
		driver.quit();
	}
}
