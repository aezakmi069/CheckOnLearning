package src;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.*;
import java.util.ArrayList;
public class Db {

	public File source = new File("/Users/pkhanal/Projects/CheckOnLearning/data/db.txt");

	public String getinfo() {
		return source.getAbsolutePath();
	}

	/** Writes the Question Object in the database
	** @param Question 
	**/
	public void save(Question q) {
		try {
			// Create file writer to append the received question to file
			FileWriter writer = new FileWriter(this.source, true);
			
			// Get question statement and answers
			String question = q.getQuestion();
			String str = Arrays.toString(q.getAns());
			String answers = str.substring(1, str.length()-1).replace(",", "\t");

			// Prepare the Question Statement + Answers to be Written.
			String qNa = question + "\t" + answers + "\n";

			// Write to File
			writer.write(qNa);
			writer.close();

		}

		catch (IOException e) {
			System.out.print("File Not Found\n");
		}
	}


	/** Gets all the Question objects from database and returns an ArrayList  
	*** ArrayList contains all the questions in the database
	**/
	public ArrayList<Question> retrieve() {
		// Question ArrayList to store Question objects
		ArrayList<Question> arr = new ArrayList<Question>();
		try {
			// Scanner to read from file and 
			Scanner input  = new Scanner(this.source);
			

			while (input.hasNextLine()) {
			// Get the line and split it into an array
				String[] line = input.nextLine().split("\t");

			// Create a Question object and add it to the ArrayList
				Question q = new Question(line[0], Arrays.copyOfRange(line, 1, line.length));
				arr.add(q);
			}			
		}

		catch (FileNotFoundException e) {
			System.out.print("File Not Found\n");
		}

		// Return the ArrayList of Question objects
		return arr;
	}

}