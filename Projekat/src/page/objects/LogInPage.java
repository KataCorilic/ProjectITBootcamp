package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	public static final String LOG_URL = "http://localhost/izlet/dashboard.php";
	private static final String USERNAME_LOG = "//input[@placeholder='username']";
	private static final String PASSWORD_LOG = "//input[@placeholder='password']";
	private static final String LOG_IN = "//input[@name='login']";
	private static final String LOG_OUT = "//a[@id='logoutBtn']";

	// korisnicko ime
	public static WebElement getUsername(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(USERNAME_LOG));
		return wb;
	}

	public static void clickUsername(WebDriver browser) {
		getUsername(browser).click();
	}

	public static void sendKeysUsername(WebDriver browser, String data) {
		getUsername(browser).sendKeys(data);
	}

	// sifra
	public static WebElement getPassword(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(PASSWORD_LOG));
		return wb;
	}

	public static void clickPassword(WebDriver browser) {
		getPassword(browser).click();
	}

	public static void sendKeysPassword(WebDriver browser, String data) {
		getPassword(browser).sendKeys(data);
	}

	// Login
	public static WebElement getLogIn(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(LOG_IN));
		return wb;
	}

	public static void clickLogIn(WebDriver browser) {
		getLogIn(browser).click();
	}

	// Logout
	public static WebElement getLogOut(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(LOG_OUT));
		return wb;
	}

	public static void clickLogOut(WebDriver browser) {
		getLogOut(browser).click();
	}

	public static void logInMethod(WebDriver browser, String username, String password) {
		sendKeysUsername(browser, username);
		sendKeysPassword(browser, password);
		clickLogIn(browser);
	}

}
