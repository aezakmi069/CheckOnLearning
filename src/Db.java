package src;
import java.io.File;
import java.util.Scanner;
public class Db {

	public File source = new File("/Users/pkhanal/Projects/CheckOnLearning/data/db.txt");

	public String getinfo() {
		return source.getAbsolutePath();
	}
}