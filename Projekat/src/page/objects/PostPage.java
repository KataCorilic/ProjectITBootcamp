package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PostPage {
	private static final String MAKE_POST_PATH = "//a[contains(text(),'Make a post')]";
	private static final String LOKACIJA_PATH = "//input[@placeholder='Lokacija']";
	private static final String NAZIV_PATH = "//input[@placeholder='Naziv']";
	private static final String BROWSE_PATH = "//input[@id='image']";
	private static final String JOURNEY_PATH = "//div[@class='popupPost']//select[@name='transport']";
	private static final String OPIS_PATH = "//textarea[@placeholder='Opis']";
	private static final String POST_PATH = "//div[@class='popupPost']//input[@name='postSubmit']";
	private static final String MENU = "fa-ellipsis-v";
	private static final String EDIT = "fa-edit";
	private static final String DELETE = "fa-trash-alt";
	public static final String POST_URL = "http://localhost/izlet/dashboard.php";
	private static final String LOKACIJA_PATHEDIT = "//input[@id='location']";
	private static final String NAZIV_PATHEDIT = "//input[@id='title']";
	private static final String JOURNEY_PATHEDIT = "//select[@id='transport']";
	private static final String OPIS_PATHEDIT = "//textarea[@id='description']";
	private static final String POST_PATHEDIT = "//div[@class='popupEdit']//input[@name='postSubmit']";
	private static final String CHANGE_PATH = "//input[@id='editImage']";
	private static final String IMG1_PATH = "C:\\workspace1\\Projekat\\Data\\download.jpg";
	private static final String IMG2_PATH = "C:\\workspace1\\Projekat\\Data\\cudoumilanu.jpg";

//Make Post
	public static WebElement getMakePost(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(MAKE_POST_PATH));
		return wb;
	}

	public static void clickMakePost(WebDriver browser) {
		getMakePost(browser).click();
	}

//Naziv
	public static WebElement getPostName(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(NAZIV_PATH));
		return wb;
	}

	public static void clickPostName(WebDriver browser) {
		getPostName(browser).click();
	}

	public static void sendKeysPostName(WebDriver browser, String data) {
		getPostName(browser).sendKeys(data);
	}

//Lokacija
	public static WebElement getLocation(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(LOKACIJA_PATH));
		return wb;
	}

	public static void clickLocation(WebDriver browser) {
		getLocation(browser).click();
	}

	public static void sendKeysLocation(WebDriver browser, String data) {
		getLocation(browser).sendKeys(data);
	}

//Browse
	public static WebElement getBrowse(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(BROWSE_PATH));
		return wb;
	}

	public static void clickBrows(WebDriver browser) {
		getBrowse(browser).click();
	}

	public static void attachDocument(WebDriver browser) {
		getBrowse(browser).sendKeys(IMG1_PATH);

	}

//Journey
	public static WebElement getJourney(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(JOURNEY_PATH));
		return wb;
	}

	public static void clickJourney(WebDriver browser) {
		getJourney(browser).click();
	}

	public static void selectJourney(WebDriver browser, String options) {
		Select st = new Select(getJourney(browser));
		st.selectByVisibleText(options);
	}

// Opis
	public static WebElement getDescription(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(OPIS_PATH));
		return wb;
	}

	public static void clickDescription(WebDriver browser) {
		getDescription(browser).click();
	}

	public static void sendKeysDescription(WebDriver browser, String text) {
		getDescription(browser).sendKeys(text);
	}

// Post
	public static WebElement getPostButton(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(POST_PATH));
		return wb;
	}

	public static void clickPostButton(WebDriver browser) {
		getPostButton(browser).click();
	}

//edit/delete menu
	public static WebElement getMenu(WebDriver browser) {
		WebElement wb = browser.findElement(By.className(MENU));
		return wb;
	}

	public static void clickMenu(WebDriver browser) {
		getMenu(browser).click();
	}

	// Izbrisi post
	public static WebElement getDeleteIcon(WebDriver browser) {
		WebElement wb = browser.findElement(By.className(DELETE));
		return wb;
	}

	public static void clickDeleteIcon(WebDriver browser) {
		getDeleteIcon(browser).click();
	}

	// Izmeni post
	public static WebElement getEditPost(WebDriver browser) {
		WebElement wb = browser.findElement(By.className(EDIT));
		return wb;
	}

	public static void clickEditPost(WebDriver browser) {
		getEditPost(browser).click();
	}

	// Izmena naziva
	public static WebElement getEditPostName(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(NAZIV_PATHEDIT));
		return wb;
	}

	public static void clickEditPostName(WebDriver browser) {
		getEditPostName(browser).click();
	}

	public static void sendKeysEditPostName(WebDriver browser, String data) {
		getEditPostName(browser).sendKeys(data);
	}

	// Izmena lokacije
	public static WebElement getEditLocation(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(LOKACIJA_PATHEDIT));
		return wb;
	}

	public static void clickEditLocation(WebDriver browser) {
		getEditLocation(browser).click();
	}

	public static void sendKeysEditLocation(WebDriver browser, String data) {
		getEditLocation(browser).sendKeys(data);
	}

//Change
	public static WebElement getChange(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(CHANGE_PATH));
		return wb;
	}

	public static void clickChange(WebDriver browser) {
		getChange(browser).click();
	}

	public static void attachChangedDocument(WebDriver browser) {
		getChange(browser).sendKeys(IMG2_PATH);

	}

	// Edit Journey
	public static WebElement getEditJourney(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(JOURNEY_PATHEDIT));
		return wb;
	}

	public static void clickEditJourney(WebDriver browser) {
		getEditJourney(browser).click();
	}

	public static void selectEditJourney(WebDriver browser, String options) {
		Select st = new Select(getEditJourney(browser));
		st.selectByVisibleText(options);
	}

	// Edit Opis
	public static WebElement getEditDescription(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(OPIS_PATHEDIT));
		return wb;
	}

	public static void clickEditDescription(WebDriver browser) {
		getEditDescription(browser).click();
	}

	public static void sendKeysEditDescription(WebDriver browser, String text) {
		getEditDescription(browser).sendKeys(text);
	}

	public static WebElement getEditPostButton(WebDriver browser) {
		WebElement wb = browser.findElement(By.xpath(POST_PATHEDIT));
		return wb;
	}

	public static void clickEditPostButton(WebDriver browser) {
		getEditPostButton(browser).click();
	}

}
