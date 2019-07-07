package page.objects;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	private static final String FIRST_NAME = "//input[@name='firstname']";
	private static final String LAST_NAME = "//input[@name='lastname']";
	private static final String USERNAME = "//div[@class='register_form']//input[@name='username']";
	private static final String EMAIL = "//input[@name='email']";
	private static final String PASSWORD = "//div[@class='register_form']//input[@name='password']";
	private static final String REGISTER = "//input[@id='blue_btn']";

//ime
	public static WebElement getFirstName(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(FIRST_NAME));
		return wb;
	}

	public static void clickFirstName(WebDriver browser) {
		getFirstName(browser).click();
	}

	public static void sendKeysFirstName(WebDriver browser, String data) {
		getFirstName(browser).sendKeys(data);
	}

//prezime
	public static WebElement getLastName(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(LAST_NAME));
		return wb;
	}

	public static void clickLastName(WebDriver browser) {
		getLastName(browser).click();
	}

	public static void sendKeysLastName(WebDriver browser, String data) {
		getLastName(browser).sendKeys(data);
	}

//korisnicko ime
	public static WebElement getUsername(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(USERNAME));
		return wb;
	}

	public static void clickUsername(WebDriver browser) {
		getUsername(browser).click();
	}

	public static void sendKeysUsername(WebDriver browser, String data) {
		getUsername(browser).sendKeys(data);
	}

//email
	public static WebElement getEmail(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(EMAIL));
		return wb;
	}

	public static void clickEmail(WebDriver browser) {
		getEmail(browser).click();
	}

	public static void sendKeysEmail(WebDriver browser, String data) {
		getEmail(browser).sendKeys(data);
	}

//sifra
	public static WebElement getPassword(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(PASSWORD));
		return wb;
	}

	public static void clickPassword(WebDriver browser) {
		getPassword(browser).click();
	}

	public static void sendKeysPassword(WebDriver browser, String data) {
		getPassword(browser).sendKeys(data);
	}

//registracija
	public static WebElement getRegister(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(REGISTER));
		return wb;
	}

	public static void clickRegister(WebDriver browser) {
		getRegister(browser).click();
	}

}
