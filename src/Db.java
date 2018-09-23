package src;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.*;
public class Db {

	public File source = new File("/Users/pkhanal/Projects/CheckOnLearning/data/db.txt");

	public String getinfo() {
		return source.getAbsolutePath();
	}

	/** Writes the Question Object in the database
	** @param Question 
	**/
	public void save(Question q) {
		//Create file writer to append the received question to file

		try {
			FileWriter writer = new FileWriter(source, true);
			String question = q.getQuestion();
			String str = Arrays.toString(q.getAns());
			String answers = str.substring(1, str.length()-1).replace(",", "\t");

			String qNa = question + "\t" + answers + "\n";

			System.out.print(qNa + "\n");

			writer.write(qNa);
			writer.close();

		}
		catch (IOException e) {
			System.out.print("File Not Found\n");
		}
		
		

	}
}