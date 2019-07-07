package page.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page.objects.HomePage;
import page.objects.LogInPage;
import page.objects.PostPage;

import utility.Constant;
import utility.ExcelUtils;
import utility.HelperClass;

public class PostPageTest {
//metoda za postavljanje posta-manual
	public static void Post(WebDriver browser) throws InterruptedException {
		LogInTest.LogInForm(browser);
		PostPage.clickMakePost(browser);

		// Naziv
		System.out.println("Enter post name: ");
		String name = HelperClass.inputs();
		PostPage.sendKeysPostName(browser, name);
		Thread.sleep(1000);

		// Lokacija
		System.out.println("Enter location: ");
		String location = HelperClass.inputs();
		PostPage.sendKeysLocation(browser, location);
		Thread.sleep(1000);

		// Ubacivanje dokumenta
		System.out.println("Attach document: ");
		PostPage.attachDocument(browser);

		// Izbor transporta
		PostPage.clickJourney(browser);
		PostPage.selectJourney(browser, HelperClass.transport());
		Thread.sleep(1000);
		// Opis
		System.out.println("Description: ");
		PostPage.clickDescription(browser);
		String description = HelperClass.inputs();
		PostPage.sendKeysDescription(browser, description);
		Thread.sleep(1000);

		PostPage.clickPostButton(browser);
		Thread.sleep(5000);
		LogInPage.clickLogOut(browser);
	}

	// metoda za postavljanje jednog posta-automation
	public static void postAutomation(WebDriver browser, int i) throws Exception {
		if (i > 0) {
			String data;
			// pozivam metodu koja postavlja Excel fajl i zadato ime Sheet-a
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME1);
			PostPage.clickMakePost(browser);

			// Naziv
			PostPage.clickPostName(browser);
			data = ExcelUtils.getCellData(i, 1);
			PostPage.sendKeysPostName(browser, data);

			// Lokacija
			PostPage.clickLocation(browser);
			data = ExcelUtils.getCellData(i, 2);
			PostPage.sendKeysLocation(browser, data);

			PostPage.attachDocument(browser);
			PostPage.selectJourney(browser, "Walk");

			// Opis
			PostPage.clickDescription(browser);
			data = ExcelUtils.getCellData(i, 0);
			PostPage.sendKeysDescription(browser, data);

			PostPage.clickPostButton(browser);

		} else {
			System.out.println("Wrong input data");
		}
	}

//metoda automatski postavlja vise postova
	public static void postWithAllData(WebDriver browser) throws Exception {
		LogInTest.logInFillForm(browser, 1);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME1);
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			postAutomation(browser, i);

		}
		HomePage.navigateTo(browser);
	}

//brisanje posta
	public static void deletePost(WebDriver browser) throws Exception {
		LogInTest.logInFillForm(browser, 1);
		for (int i = 0; i < 2; i++) {
			PostPage.clickMenu(browser);
			Thread.sleep(3000);
			PostPage.clickDeleteIcon(browser);
			if (browser.getCurrentUrl().equals(PostPage.POST_URL)) {
				System.out.println("Successful");
			} else {
				System.out.println("Unsuccessful");
			}
		}
		LogInPage.clickLogOut(browser);
	}

// izmena posta
	public static void editPost(WebDriver browser) throws Exception {
		LogInTest.logInFillForm(browser, 1);
		PostPage.clickMenu(browser);
		PostPage.clickEditPost(browser);
		Thread.sleep(3000);
		System.out.println("Name");
		if (HelperClass.edit()) {
			System.out.println("Edit the text field");
			PostPage.clickEditPostName(browser);
			PostPage.getEditPostName(browser).clear();
			PostPage.sendKeysEditPostName(browser, HelperClass.inputs());
		}
		System.out.println("Location");
		if (HelperClass.edit()) {
			System.out.println("Edit the text field");
			PostPage.clickEditLocation(browser);
			PostPage.getEditLocation(browser).clear();
			PostPage.sendKeysEditLocation(browser, HelperClass.inputs());
		}
		System.out.println("Attach document: ");
		if (HelperClass.edit()) {
			PostPage.attachChangedDocument(browser);
		}

		System.out.println("Transport");
		if (HelperClass.edit()) {
			PostPage.clickEditJourney(browser);
			PostPage.selectEditJourney(browser, HelperClass.transport());
		}
		System.out.println("Description");
		if (HelperClass.edit()) {
			System.out.println("Edit the text field");
			PostPage.clickEditDescription(browser);
			PostPage.getEditDescription(browser).clear();
			PostPage.clickEditDescription(browser);
			PostPage.sendKeysEditDescription(browser, HelperClass.inputs());
		}
		PostPage.clickEditPostButton(browser);
		Thread.sleep(8000);
		if (browser.getCurrentUrl().equals(PostPage.POST_URL)) {
			System.out.println("Successful");
		} else {
			System.out.println("Unsuccessful");
		}
		LogInPage.clickLogOut(browser);
	}

}
