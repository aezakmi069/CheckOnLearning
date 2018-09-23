package src;
import java.util.ArrayList;
import java.util.Iterator;

public class Quiz{
	ArrayList<Question> qr = new ArrayList<Question>();

	//Create a Quiz 
	public Quiz(ArrayList<Question>){
		this.qr = qr;

	}

	// Get methods
	public ArrayList<Question> qr(){
		Iterator it = qr.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}

		return qr;
	}

	public void setqr(ArrayList<Question>){
		this.qr = qr;
	}

}