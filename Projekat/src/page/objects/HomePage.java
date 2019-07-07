package page.objects;

import org.openqa.selenium.WebDriver;

public class HomePage {
	public static final String PAGE_URL = "http://localhost/izlet/";

	public static void openPage(WebDriver browser) {
		browser.get(PAGE_URL);
	}

	public static void navigateTo(WebDriver browser) {
		browser.navigate().to(PAGE_URL);
	}

}
