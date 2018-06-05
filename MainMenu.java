package JavaCertPrep;
import java.io.*;

/**
*  The MainMenu class launches the application and presents the user with a menu of study options
* 
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/

public class MainMenu{
	
	private PracticeTest newPT;
	
	/**
	* No-argument constructor; creates a new instance of the PracticeTest class.
	*/
	public MainMenu(){
		newPT = new PracticeTest();	
	}
	
	/**
	* a method that presents a menu of options to the user.  The user may take a Java SE 8 practice test or exit the program.
	*/
	
	public void userOptions(){
		System.out.println("\n*********  JAVA CERTIFICATION PREP  *********");
		System.out.println("\nMake a choice:\n1.) Take Practice Test\n2.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
				switch(userChoice){
					case 1: System.out.print("You selected: Take Practice Test");
						newPT.loadQB();
						break; 
					case 2: System.out.print("You selected: EXIT");
						System.exit(0);
						break;
					default: userOptions(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e);	
		}
	}
	
	/**
	* the main method launches the application
	* @param args command line arguments
	*/
	public static void main(String[] args){
		MainMenu newInst = new MainMenu();
		newInst.userOptions();
	}
}