package page.tests;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import page.objects.LogInPage;
import page.objects.RegistrationPage;
import utility.HelperClass;

public class HomePageTest {

	public static void goToRegistration(WebDriver browser) throws Exception {
		HomePage.openPage(browser);
		System.out.println("Input users id number(range 1-39)");
		int i = Integer.parseInt(HelperClass.inputs());
		RegistrationTest.fillForm(browser, i);
		LogInTest.logInFillForm(browser, i);
		if (browser.getCurrentUrl().contains(LogInPage.LOG_URL)) {
			System.out.println("Pass");
			LogInPage.clickLogOut(browser);

		}
	}
}
