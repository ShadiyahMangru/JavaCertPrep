package JavaCertPrep;

/**
* The Question class provides a template for each question object.
*
* @author  Shadiyah Mangru
* @version 1.0
* @since   June 2018
*/

public class Question{

	private String question;
	private boolean trueFalse;
	private String answer;

	
	/**
	* No-argument constructor
	*/
	public Question(){	
	}
	
	/**
	* Constructor for T/F questions that are true
	* @param q question
	* @param tf true/false, depending on question
	*/
	public Question(String q, boolean tf){
		question = q;
		 trueFalse = tf;
	}
	
	/**
	* Constructor for T/F questions that are false
	* @param q question
	* @param tf true/false, depending on question
	* @param a correct answer
	*/
	public Question(String q, boolean tf, String a){
		question = q;
		trueFalse = tf;
		answer = a;
	}
	
	/**
	* returns the original question
	* @return String the question
	*/
	public String getQuestion(){
		return question;
	}
	
	/**
	* returns true/false, depending on question
	* @return boolean true/false
	*/
	public boolean getTrueFalse(){
		return trueFalse;	
	}
	
	/**
	* returns the correct answer to false questions
	* @return String corrected statement
	*/ 
	public String getAnswer(){
		return answer;	
	}
}