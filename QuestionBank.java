package JavaCertPrep;
import java.util.*;

public class QuestionBank extends Question{

/**
* The QuestionBank class organizes the available Java SE 8 cert prep questions.
* 
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/
	
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	/**
	* No-argument constructor -- initializes all questions in the question bank
	*/
	public QuestionBank(){
		setALLQuestions();	
	}
	
	/**
	* creates a Java SE 8 certification prep question bank arraylist
	*/
	public void setALLQuestions(){
		Question Q1 = new Question("When you override a method, you may reference "+
			"the parent version of the method using the this keyword.", false, "When you override a method, " +
			" you may reference the parent version of the method using the super keyword.");
		questions.add(Q1);
		Question Q2 = new Question("A class that is not declared as abstract, can have abstract methods.",
			false, "A class that is not declared as abstract, cannot have abstract methods.");
		questions.add(Q2);
		Question Q3 = new Question("A default constructor is only supplied if there are no constructors present.",
			true);
		questions.add(Q3);
		Question Q4 = new Question("Static methods require an instance of the class.", false, 
			"Static methods do not require an instance of the class; they are shared among all users of the class.");
		questions.add(Q4);
		Question Q5 = new Question("Instance and class variables have no default value", false, 
			"Instance and class variables are given default values.  Local variables have no default value; "+
			"they must be initialized before use.");
		questions.add(Q5);
		Question Q6 = new Question("Method hiding is when a child class defines a static method "+
			"with the same name and signature as a static method defined in a parent class", true);	
		questions.add(Q6);
	}
	
	/**
	* returns the Java SE 8 certification prep question bank
	* @return ArrayList the question bank
	*/
	public ArrayList<Question> getALLQuestions(){
		return questions;	
	}
}