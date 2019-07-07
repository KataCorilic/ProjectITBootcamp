package page.tests;

import org.openqa.selenium.WebDriver;

import page.objects.LogInPage;
import page.objects.RegistrationPage;
import utility.Constant;
import utility.ExcelUtils;
import utility.HelperClass;

public class RegistrationTest {
//metoda za registrovanje korisnika - manual
	public static void RegistrationForm(WebDriver browser) throws InterruptedException {
		System.out.println("Fill in registration form: ");
		// ime
		System.out.println("Name: ");
		String name = HelperClass.inputs();
		// prezime
		System.out.println("Surname: ");
		String lastName = HelperClass.inputs();
		// korisnicko ime
		System.out.println("Username: ");
		String username = HelperClass.inputs();
		// email
		System.out.println("Email: ");
		String email = HelperClass.inputs();
		// sifra
		System.out.println("Password: ");
		String password = HelperClass.inputs();

		RegistrationPage.sendKeysFirstName(browser, name);
		Thread.sleep(1000);
		RegistrationPage.sendKeysLastName(browser, lastName);
		Thread.sleep(1000);
		RegistrationPage.sendKeysUsername(browser, username);
		Thread.sleep(1000);
		RegistrationPage.sendKeysEmail(browser, email);
		Thread.sleep(1000);
		RegistrationPage.sendKeysPassword(browser, password);
		Thread.sleep(1000);
		RegistrationPage.clickRegister(browser);
		Thread.sleep(1000);
		LogInPage.logInMethod(browser, username, password);
		Thread.sleep(1000);
		if (browser.getCurrentUrl().equals(LogInPage.LOG_URL)) {
			System.out.println("You have successfully registered and logged in");
			LogInPage.clickLogOut(browser);
		} else {
			System.out.println("Unsuccessful attempt");
		}
	}

//metoda za registrovanje jednog korisnika - automation
	public static void fillForm(WebDriver browser, int i) throws Exception {
		String data;
		if (i > 0) {
			// postavlja excell fajl i poslato ime worksheeta
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME);
			// ime
			RegistrationPage.clickFirstName(browser);
			data = ExcelUtils.getCellData(i, 0);
			RegistrationPage.sendKeysFirstName(browser, data);
			// prezime
			RegistrationPage.clickLastName(browser);
			data = ExcelUtils.getCellData(i, 1);
			RegistrationPage.sendKeysLastName(browser, data);
			// korisnicko ime
			RegistrationPage.clickUsername(browser);
			data = ExcelUtils.getCellData(i, 2);
			RegistrationPage.sendKeysUsername(browser, data);
			// email
			RegistrationPage.clickEmail(browser);
			data = ExcelUtils.getCellData(i, 3);
			RegistrationPage.sendKeysEmail(browser, data);
			// sifra
			RegistrationPage.clickPassword(browser);
			data = ExcelUtils.getCellData(i, 4);
			RegistrationPage.sendKeysPassword(browser, data);

			// registracija
			RegistrationPage.clickRegister(browser);
		} else {
			System.out.print("Input data are invalid");
		}
	}

//metoda za registrovanje vise korisnika
	public static void testWithAllData(WebDriver browser) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME);
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillForm(browser, i);
			LogInTest.logInFillForm(browser, i);
			if (browser.getCurrentUrl().equals(LogInPage.LOG_URL)) {
				LogInPage.clickLogOut(browser);
			} else {
				System.out.println("Unsuccessful attempt");
			}
		}

	}
}
