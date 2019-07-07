package page.tests;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import page.objects.LogInPage;

import utility.Constant;
import utility.ExcelUtils;
import utility.HelperClass;

//log in metoda - manual
public class LogInTest {
	public static void LogInForm(WebDriver browser) throws InterruptedException {
		// korisnicko ime
		System.out.println("Username: ");
		String username = HelperClass.inputs();

		// sifra
		System.out.println("Password: ");
		String password = HelperClass.inputs();

		LogInPage.logInMethod(browser, username, password);
		Thread.sleep(5000);
		if (browser.getCurrentUrl().equals(LogInPage.LOG_URL)) {
			System.out.println("You have successfully logged in");
		} else {
			System.out.println("Unsuccessful attempt");
		}
	}

//metoda za logovanje jednog korisnika - automation
	public static void logInFillForm(WebDriver browser, int i) throws Exception {
		String data;
		if (i > 0) {
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME);
			// korisnicko ime
			LogInPage.clickUsername(browser);
			// uzimam podatak iz Excel tabele za zadati red i kolonu i smestam ga u
			// promenljivu tipa String
			data = ExcelUtils.getCellData(i, 2);
			LogInPage.sendKeysUsername(browser, data);

			// sifra
			LogInPage.clickPassword(browser);
			// uzimam podatak iz Excel tabele za zadati red i kolonu i smestam ga u
			// promenljivu tipa String
			data = ExcelUtils.getCellData(i, 4);
			LogInPage.sendKeysPassword(browser, data);

			LogInPage.clickLogIn(browser);
		

		} else {
			System.out.println("Input data are invalid");
		}
	}

//metoda za logovanje vise korisnika - automation
	public static void testWithAllData(WebDriver browser) throws Exception {

		// pozivam metodu koja postavlja Excel fajl i zadato ime Sheet-a
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME);

		// u for petlji prolazim kroz redove tabele
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {

			// pozivam metodu koja mi za zadati red unosi podatke iz kolone (username i
			// password) u aktivni prozor i vrsi logovanje
			logInFillForm(browser, i);
			Thread.sleep(1000);
			LogInPage.clickLogOut(browser);
		}

	}

}
