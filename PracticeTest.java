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

	private int counter;
	private QuestionBank newInst;
	private int correct;
	private int lives;
	private String mysteryWord;
	
	/**
	* No-argument constructor initializes fields
	*/
	public PracticeTest(){
		counter = 0;
		newInst = new QuestionBank();
		correct = 0;
		lives = 5;
	}
	
	/**
	* a method to (i) load each question in the question bank, one at a time, and (ii) return the final score at test completion.
	*/
	public void loadQB(){
		if(counter <  newInst.getALLTFQuestions().size()){
			System.out.println("\nQuestion " + (counter+1) + ") True or False: \n"+ newInst.getALLTFQuestions().get(counter).getQuestion());	
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
	* a method that evaluates the user's true/false response and provides feedback, based on each response.
	*/
	public void trueOrFalse(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter 1 for TRUE or 2 for FALSE\n");
			int userChoice = Integer.parseInt(reader.readLine());	
				switch(userChoice){
					case 1: System.out.print("Your response: TRUE");
						if(newInst.getALLTFQuestions().get(counter-1).getTrueFalse()==true){
							System.out.println("\nCorrect!");	
							correct++;
							loadQB();
						}
						else{
							System.out.println("\nIncorrect.  That is a false statement.");
							System.out.println("The correct answer is: " + newInst.getALLTFQuestions().get(counter-1).getAnswer()); 
							loadQB();
						}
						break; 
					case 2: System.out.print("Your response: FALSE");
						if(newInst.getALLTFQuestions().get(counter-1).getTrueFalse()==false){
							System.out.println("\nYes, that is a false statement.");	
							System.out.println("The corrected answer is: " + newInst.getALLTFQuestions().get(counter-1).getAnswer()); 
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
	
	/** 
	* a method that loads each question of the Word Guess game and announces when the user is a winner, if applicable.
	*/
	public void loadGame(){	
		if(counter <  newInst.getAllWordGuessQuestions().size() & lives >0){
			System.out.println("\nQuestion " + (counter+1) + ")  "+ newInst.getAllWordGuessQuestions().get(counter).getQuestion());	
			mysteryWord = newInst.getAllWordGuessQuestions().get(counter).getAnswer();
			counter++;
			System.out.print("\nANSWER FORMAT: ");
			for(int i = 0; i < mysteryWord.length() ; i++){
				System.out.print("_ ");
			}
			System.out.println("\n");
			GuessWord();
		}
		else{
			System.out.println("\n**********WINNER!!!**********");	
			MainMenu again = new MainMenu();
			again.userOptions();
		}
	}
	
	/**
	* a method to evaluate user's response; if correct a new question is loaded, 
	* if incorrect the user is prompted to guess again provided the user has lives remaining.
	* if no more lives remain, the user if informed that the game is over.
	*/
	public void GuessWord(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter answer:  ");
			String guess = reader.readLine();
			if(guess.equalsIgnoreCase(mysteryWord)){
				System.out.println("CORRECT!");
				loadGame();
			}
			else{
				lives--;
				System.out.println("INCORRECT.  You have " + lives + " lives left.");
				if(lives >0){
					GuessWord();
				}
				else{
					System.out.println("\n***GAME OVER***");	
				}
			}
		}
		catch(Exception e){
			System.out.println("oh noz, there is an exception: " + e);	
		}
	}

}