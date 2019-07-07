package utility;

import java.util.Scanner;

public class HelperClass {
	// unos podataka sa tastature
	public static String inputs() {
		Scanner sc = new Scanner(System.in);
		String input = null;
		try {
			input = sc.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return input;
	}

	enum journeyChoice {
		Walk("Walk"), Car("Car"), Motorbike("Motorbike"), Bicycle("Bicycle"), Bus("Bus");
		private String val;

		private journeyChoice(String val) {
			this.val = val;
		}

		public String Val() {
			return val;
		}

	}

//metoda vraca izabrani tip transporta
	public static String transport() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Choose transport:");
		System.out.println("1. Walk");
		System.out.println("2. Car");
		System.out.println("3. Motorbike");
		System.out.println("4. Bicycle");
		System.out.println("5. Bus");

		int n = sc.nextInt() - 1;
		journeyChoice izbor = journeyChoice.values()[n];
		System.out.println(izbor.Val());
		return izbor.Val();

	}

	// potvrda izmene polja
	public static boolean edit() {
		System.out.println("Change field?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int answer = Integer.parseInt(inputs());
		if (answer != 1) {
			return false;
		} else
			return true;
	}
}
