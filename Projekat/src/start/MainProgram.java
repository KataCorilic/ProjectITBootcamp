package start;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.HomePage;
import page.objects.LogInPage;
import page.tests.HomePageTest;
import page.tests.LogInTest;
import page.tests.PostPageTest;
import page.tests.RegistrationTest;
import utility.HelperClass;

public class MainProgram {

	public static void main(String[] args) throws InterruptedException {
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			menu(browser);
		} catch (Exception e) {
			e.getMessage();
		} finally {
			browser.quit();
		}

	}

	// metoda prikazuje menu sa izborom opcija
	private static void showMenu() {
		System.out.println("1. Testing Registration form");
		System.out.println("2. Testing Log in page");
		System.out.println("3. Publish a post");
		System.out.println("4. Delete a post");
		System.out.println("5. Edit a post");
		System.out.println("6. Exit");
	}

//metoda prikazuje izbor tipa testiranja
	private static void chooseAnOption() {
		System.out.println("1. Manual testing");
		System.out.println("2. Automation testing");
	}

	private static void menu(WebDriver browser) throws Exception {
		int option = 0;
		int manualOption = 0;
		do {
			// unos opcije
			showMenu();
			System.out.println("Choose an option:");
			// poziv metode inputs() za unos teksta sa tastaure
			String optionText = "";
			optionText = HelperClass.inputs();
			// konvertovanje podatka tipa String u Integer
			option = Integer.parseInt(optionText);
			// poziv metode za izbor testiranja
			if (option != 6 && option < 7) {
				if (option != 4 && option != 5) {
					chooseAnOption();
					// konvertovanje podatka tipa String u Integer
					manualOption = Integer.parseInt(HelperClass.inputs());
				}
				HomePage.openPage(browser);
			}
			switch (option) {
			case 1:
				if (manualOption == 1)
					RegistrationTest.RegistrationForm(browser);
				else
					RegistrationTest.testWithAllData(browser);
				break;
			case 2:
				if (manualOption == 1) {
					LogInTest.LogInForm(browser);
					LogInPage.clickLogOut(browser);
				} else
					LogInTest.testWithAllData(browser);
				break;
			case 3:
				if (manualOption == 1)
					PostPageTest.Post(browser);
				else
					PostPageTest.postWithAllData(browser);
				break;
			case 4:
				PostPageTest.deletePost(browser);
				break;
			case 5:
				PostPageTest.editPost(browser);
				break;
			case 6:
				System.out.println("Thank you for using program");
				break;
			default:
			}
		} while (option != 6);

	}
}
