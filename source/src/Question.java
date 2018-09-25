package src;

public class Question {
	//instance variables
	private String question ; // a question statement from the user
	private String[] ans = new String[5]; // an array of answers
	

	/****************************************************** 
	**   constructs a question with a question statement,** 
	**   an array of answers                             **
	*******************************************************/

	public Question(String question, String[] ans) {
		this.setQuestion(question) ;
		this.setAns(ans);
		
	}

	// get methods
	public String getQuestion(){
		return question;
	}

	public String[] getAns(){
		return ans;
	}
	// set methods
	public void setQuestion(String question){
		this.question = question;
	}

	public void setAns(String[] ans){
		this.ans = ans;
	}
	
}