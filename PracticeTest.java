package JavaCertPrep;
import java.io.*;

/**
* The PracticeTest class provides methods to load the user-selected review of Java SE 8 programming concepts.
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
	private boolean isPT;
	private boolean isWG;
	
	/**
	* No-argument constructor ensures question bank is available for use during review test/game
	*/
	public PracticeTest(){
		newInst = new QuestionBank();
	}
	
	/**
	* Constructor to initialize Practice Test fields
	* @param cnt question counter
	* @param c counter of correct responses
	*/
	public PracticeTest(int cnt, int c){
		this();
		counter = cnt;
		correct = c;
		isPT = true;
	}
	
	/**
	* Constructor to initialize Word Guess game fields
	* @param l lives
	*/
	public PracticeTest(int l){
		this();
		lives = l;
		isWG = true;
	}
	
	/**
	* a method to (i) load each question in the Practice Test question bank, one at a time, and (ii) return the final score at test completion.
	*/
	public void loadQB(){
		if(counter <  newInst.getALLTFQuestions().size()){
			System.out.println("\nQuestion " + (counter+1) + ") True or False: \n"+ newInst.getALLTFQuestions().get(counter).getQuestion());	
			counter++;
			trueOrFalse();
		}
		else{
			win();
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
			getWGAnswerFormat();
		}
		else{
			win();
		}
	}
	
	/**
	* a method that outputs the answer format of each word guess game question
	*/
	public void getWGAnswerFormat(){
		System.out.print("\nANSWER FORMAT: ");
			for(int i = 0; i < mysteryWord.length() ; i++){
				System.out.print("_ ");
			}
			System.out.println("\n");
			GuessWord();
	}
	
	/**
	* a method to let the user know that he/she has successfully completed the chosen review
	*/
	public void win(){
		String result = isWG ? "\n**********WINNER!!!**********" : "\n\nYou have completed this review!!!\nYOUR SCORE: " + correct + "/" + counter;
		System.out.println(result);
		MainMenu again = new MainMenu();
		again.userOptions();
	}
	
	/**
	* a method to evaluate user's response; if correct a new question is loaded, 
	* if incorrect the user is prompted to guess again provided the user has lives remaining.
	* if no more lives remain, the user is informed that the game is over.
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
					System.out.println("The correct answer was: " + mysteryWord);
					System.out.println("\n***GAME OVER***");	
					MainMenu again = new MainMenu();
					again.userOptions();
				}
			}
		}
		catch(Exception e){
			System.out.println("oh noz, there is an exception: " + e);	
		}
	}

}