package src;

import java.util.Scanner;
import java.util.*;

public class CheckOnLearning {

	private static Scanner input;


	/** Displays a welcome message
	*** Asks user for a selection: Create Question or Take Quiz
	*** Transfers operation to appropriate method based on the selection	
	*/
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
		
		// Use selection to call appropriate methods
		if (choice == 1) {
			CheckOnLearning.createQuestion();
		}
		if (choice == 2) {
			CheckOnLearning.takeQuiz();
		}
	}

	/** Creates a Question Object by asking user for Input
	*** Passes the Question Object to Db object for writing to a file
	*/
	public static void createQuestion() {
		input = new Scanner(System.in);

		// Get question statement
		System.out.print("Question Statement: ");
		String question = input.nextLine();
		question = question.replaceAll("\\r|\\n", "");
        
        // Get answer choices
        String[] ans = new String[5];
		System.out.print("Correct Answer: ");
		ans[0] = input.next();
		input.nextLine();

		for (int i = 1; i < ans.length; i++) {
			System.out.print("Incorrect options: ");
			ans[i] = input.next();
			input.nextLine();
		}

		// Make Question object and write to database
		Question q = new Question(question, ans);

		Db db = new Db();

		db.save(q);
				
	}


	/** Creates a Quiz object
	*** Call start() method of Quiz object to start the quiz
	**/
	public static void takeQuiz() {
		Db db = new Db();

		// Get ArrayList of Question from database and create a ArrayList of Ten random questions 
		ArrayList<Question> allQuestion = db.retrieve();
		
		// Shuffle the questions
		Collections.shuffle(allQuestion);
		
		// Print the size of allQuestion
		System.out.print("The size of allQuestion is: " + allQuestion.size() + "\n");

		ArrayList<Question> tenQuestion = new ArrayList<Question>();


		// Populate the ArrayList tenQuestion with random 10 questions
		int counter = 0;
		while (counter < 10 && counter < allQuestion.size()) {
			tenQuestion.add(allQuestion.get(counter));
			counter++;
		}
		
		// Print the length of tenQuestion
		System.out.print("The length of tenQuestion is: " + tenQuestion.size() + "\n");

		// Create a quiz object
		Quiz quiz = new Quiz(tenQuestion);

		// Start quiz
		quiz.start();

	}


}