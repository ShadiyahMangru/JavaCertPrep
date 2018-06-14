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
	private StringBuilder answerKey;
	private StringBuilder alreadyGuess;
	private boolean isPT;
	private boolean isWG;
	private boolean isHM;
	
	/**
	* No-argument constructor ensures question/word bank is available for use during review test/game
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
	
	/**Constructor to initialize Hangman game fields
	* @param guess guesses remaining
	* @param HMval true 
	*/
	public PracticeTest(int guess, boolean HMval){
		this();
		lives = guess;
		mysteryWord = newInst.getAllHWords().get(0).toLowerCase();
		isHM = HMval;
		answerKey = new StringBuilder(mysteryWord.length());
		alreadyGuess = new StringBuilder();
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

	/**
	* a method that outputs the format of the mystery word and requests user's initial letter guess
	*/
	public void playHangman(){
		for(int i = 0; i < mysteryWord.length() ; i++){
			answerKey.append("*");
		}
		System.out.print("\nMYSTERY WORD FORMAT: " + answerKey.toString() + "\n");
		guessLetter();
	}		
	
	/**
	* a method that requests letter guesses from user until user correctly guesses mystery word or has no remaining guesses.
	* If no guesses remain, this method outputs correct answer, informs the user that the game is over, and reloads the main menu.
	* In this game, there is no penalty for duplicate guesses.
	*/
	public void guessLetter(){	
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("\nGuess a letter in the word:  ");
			String guess = reader.readLine().toLowerCase();
			if(guess.length()!=1){
				System.out.println("Invalid entry.  Try again.");	
				playHangman();
			}
			else{
				char g = guess.charAt(0);
				if(alreadyGuess.toString().contains(guess)==true){
					System.out.println("You have already guessed '" + g + "'");
					System.out.println("\nMYSTERY WORD: " + answerKey.toString());
					guessLetter();
				}
				else if(mysteryWord.contains(guess)==true & alreadyGuess.indexOf(guess)==-1){
					for(int i=0; i<mysteryWord.length(); i++){
						if(mysteryWord.charAt(i)==g){
							answerKey.deleteCharAt(i);
							answerKey.insert(i, g);	
						}
					}
				System.out.println(answerKey.toString());
				alreadyGuess.append(guess);
				if(answerKey.indexOf("*")!=-1){
					guessLetter();
				}
				else{
					System.out.println("*****YOU WON!*****");
					PracticeTest playAgain = new PracticeTest(6, true);
				}
				}
				else{
					alreadyGuess.append(g);
					System.out.println("That letter is not in the word.");
					lives--;
					System.out.println("You have " + lives + " guesses remaining.");
					if(lives>0){
						System.out.println("MYSTERY WORD: " + answerKey.toString());
						guessLetter();
					}
					else{
						System.out.println("The mystery word was: " + mysteryWord + ".  BETTER LUCK NEXT TIME!");
						System.out.println("\n***GAME OVER***");	
						MainMenu again = new MainMenu();
						again.userOptions();
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("oh noz, there is an exception: " + e);	
		}	
	}
	
}