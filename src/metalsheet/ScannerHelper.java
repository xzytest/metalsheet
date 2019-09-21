package metalsheet;

import java.util.Scanner;

public class ScannerHelper {

	private static final String WARNING_VALUE_MUST_BE_AN_INTEGER = "The value must be an positive Integer!\nPlease enter a new value:";
	
	private Scanner scanner;

	public ScannerHelper() {
		this.scanner = new Scanner(System.in);
	}
	
	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Integer getNextInt() {
		Integer value = null;
		while (value == null) {
			if (!scanner.hasNextInt()) 
				nextLineWithWarning();
			else {
				value = scanner.nextInt();
				if (value < 0 ) 
					nextLineWithWarning();
			}
		}

		return value;
	}

	private void nextLineWithWarning() {
		System.out.println(WARNING_VALUE_MUST_BE_AN_INTEGER);
		scanner.nextLine();
	}
	
	public void closeSession() {
		if(scanner!=null) {
			scanner.close();
		}
	}

}
