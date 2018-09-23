package src;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.io*;

public class Quiz{
	private ArrayList<Question> q= new ArrayList<Question>();
	private int correct = 0;

	//Create a Quiz 
	public Quiz(ArrayList<Question> q){
		this.setQ();

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
		this.corect = num;
	}


	/** Starts a quiz
	*** Increments the correct variable if Corrct	
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
			
		}
	}


}