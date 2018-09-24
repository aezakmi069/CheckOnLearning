package src;

import java.util.*;

public class Quiz{
	private ArrayList<Question> q= new ArrayList<Question>();
	private int correct = 0;

	//Create a Quiz 
	public Quiz(ArrayList<Question> q){
		this.setQ(q);

	}

	// Get methods
	public ArrayList<Question> getQ(){
		return q;
	}

	public int getCorrect() {
		return this.correct;
	}

	// Set methods
	public void setQ (ArrayList<Question> q){
		this.q = q;
	}

	public void setCorrect (int num) {
		this.correct = num;
	}


	/** Starts a quiz
	*** Increments the correct variable if Correct	
	**  If incorrect, displays the correct answer
	*/
	public void start() {
		ListIterator<Question> iterator = this.getQ().listIterator();

		System.out.print("\n\n=======|| Welcome to THE QUIZ ||========\n\n");

		// Take the quiz
		while (iterator.hasNext()) {
			Question x = iterator.next();

			// Print the question statement along with answer choices
			System.out.print(x.getQuestion() + "\n");
			String[] ans = x.getAns();
			String rightAnswer = ans[0];
			ArrayList<String> answers = new ArrayList<String>();
			for (String a : ans) {
				answers.add(a);
			}
			Collections.shuffle(answers);

			// Print answer choices
			ListIterator<String> it = answers.listIterator();
			int choice = 1;
			while (it.hasNext()) {
				System.out.print(choice + ". " + it.next() + "\n");
				choice++;
			}

			// Ask for answer
			Scanner input = new Scanner(System.in);
			System.out.print("Your answer: ");
			int yourAnswer = Integer.parseInt(input.next()) - 1; 
			
			// Check if the answer is correct
			if (answers.get(yourAnswer).equals(rightAnswer)) {
				this.correct += 1;
			}
		}

		System.out.print("\n\n ======|| You Got " + this.correct + " answers correct. ||=========");
	}


}