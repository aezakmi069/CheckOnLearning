package src;

import java.util.Scanner;

public class CheckOnLearning {

	public static void welcome() {
		// Welcome message with a prompt to select operation
		System.out.print("====|| WELCOME TO CHECK ON LEARNING ||====\n\n");
		System.out.print("Choose from the menu options: \n");
		System.out.print("1.\tCreate a Question\n2.\tTake a Quiz\n");

		// Get the input
		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.print("\nYour Choice: ");
			try {
				choice = Integer.parseInt(input.next());
				if (choice != 1 && choice != 2)
					System.out.print("Please Enter either 1 or 2\n");
			}
			catch (NumberFormatException e) {
				System.out.print("Please Enter either 1 or 2\n");
			}
		} while (choice != 1 && choice != 2);

	}
}