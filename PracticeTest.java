package JavaCertPrep;
import java.io.*;

/**
* The PracticeTest class provides methods to review Java SE 8 programming concepts.
*
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/

public class PracticeTest{

	private int counter=0;
	private QuestionBank newInst = new QuestionBank();
	private int correct=0;
	
	/**
	* a method to (i) load each question in the question bank, one at a time, and (ii) return the final score at test completion.
	*/
	public void loadQB(){
		if(counter <  newInst.getALLQuestions().size()){
			System.out.println("\nQuestion " + (counter+1) + ") True or False: \n"+ newInst.getALLQuestions().get(counter).getQuestion());	
			counter++;
			trueOrFalse();
		}
		else{
			System.out.println("\n\nYou have completed this review!!!");	
			System.out.println("\nYOUR SCORE: " + correct + "/" + counter);
			MainMenu again = new MainMenu();
			again.userOptions();
		}
	}

	/**
	* a method that evaluates the user's response and provides feedback, based on each response.
	*/
	public void trueOrFalse(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter 1 for TRUE or 2 for FALSE\n");
			int userChoice = Integer.parseInt(reader.readLine());	
				switch(userChoice){
					case 1: System.out.print("Your response: TRUE");
						if(newInst.getALLQuestions().get(counter-1).getTrueFalse()==true){
							System.out.println("\nCorrect!");	
							correct++;
							loadQB();
						}
						else{
							System.out.println("\nIncorrect.  That is a false statement.");
							System.out.println("The correct answer is: " + newInst.getALLQuestions().get(counter-1).getAnswer()); 
							loadQB();
						}
						break; 
					case 2: System.out.print("Your response: FALSE");
						if(newInst.getALLQuestions().get(counter-1).getTrueFalse()==false){
							System.out.println("\nYes, that is a false statement.");	
							System.out.println("The corrected answer is: " + newInst.getALLQuestions().get(counter-1).getAnswer()); 
							correct++;
							loadQB();
						}
						else{
							System.out.println("\nIncorrect.");
							System.out.println("That statement is true."); 
							loadQB();
						}
						break;
					default: trueOrFalse(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e);	
	}
	}


}