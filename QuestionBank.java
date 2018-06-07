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
		Question Q5 = new Question("Instance and class variables have no default value.", false, 
			"Instance and class variables are given default values.  Local variables have no default value; "+
			"they must be initialized before use.");
		questions.add(Q5);
		Question Q6 = new Question("Method hiding is when a child class defines a static method "+
			"with the same name and signature as a static method defined in a parent class.", true);	
		questions.add(Q6);
		Question Q7 = new Question("The abstract specifier is used when a method is not " + 
			"allowed to be overriden by a subclass.", false, "The final specifier is used " + 
			"when a method is not allowed to be overridden by a subclass.");
		questions.add(Q7);
		Question Q8 = new Question("Static imports (written import static) are for importing static members of classes.", true);
		questions.add(Q8);
		Question Q9 = new Question("Java is a 'pass-by-value' language.", true);
		questions.add(Q9);
		Question Q10 = new Question("An int can be passed to a method taking a long parameter.", true);
		questions.add(Q10);
		Question Q11 = new Question("Java will automatically convert to a narrower type "+ 
			"(e.g., a long can be passed to a method taking an int parameter).", false, 
			"Java will not automatically convert to a narrower type; an explicit cast " + 
			"is required to pass a long to a method taking an int parameter.");
		questions.add(Q11);
		Question Q12 = new Question("Having a private constructor in a class prevents " +
			"other classes from instantiating the class.", true);
		questions.add(Q12);
		Question Q13 = new Question("A lambda expression is like a method that you can pass as if it were a variable.", true);
		questions.add(Q13);
		Question Q14 = new Question("With lambda expressions, the ? operator separates the parameter and body.", false,
			"With lambda expressions, the -> operator separates the parameter and body.");
		questions.add(Q14);
		Question Q15 = new Question("With lambda expressions, parentheses around the parameter list can only be omitted "+
			"if there is a single parameter and its type is not explicitly stated.", true);
		questions.add(Q15);
		Question Q16 = new Question("The order of initialization within a java class is static variables/initializers, "
			+ "instance variables/initializers, the constructor, the superclass.", false, 
			"The order of initialization within a java class is the superclass, static variables/initializers, "
			+ "instance variables/initializers, and the constructor.");
		questions.add(Q16);
		Question Q17 = new Question("Java supports single inheritance.  Single inheritance precludes parents from having multiple children.", 
			false, "Java supports single inheritance.  Single inheritance does NOT preclude parents from having multiple children.");
		questions.add(Q17);
		Question Q18 = new Question("You can use the keyword this to access a member of the class.  You may also use this " +
			"to access members of the parent class that are accessible from the child class, since a child class inherits all of its parent members.", true);
		questions.add(Q18);
		Question Q19 = new Question("An interface is an abstract data type that defines a list of "+
			"abstract public methods that any class implementing the interface must provide.", true);
		questions.add(Q19);
		Question Q20 = new Question("Call instance methods by using the classname and the dot operator before the method.", false,
			"Call instance methods by using the object name and the dot operator before the method.");
		questions.add(Q20);
		Question Q21 = new Question("A default method is a method defined within an interface with the default keyword in which a method body is not provided.",
			false, "A default method is a method defined within an interface with the default keyword in which a method body is provided.");
		questions.add(Q21);
		Question Q22 = new Question("A static method defined in an interface is not inherited in any classes that implement the interface.", true);
		questions.add(Q22);
		Question Q23 = new Question("Instance initializers are code blocks that appear outside a method.", true);
		questions.add(Q23);
		Question Q24 = new Question("A reference type refers to an object (an instance of a class)", true);
		questions.add(Q24);
		Question Q25 = new Question("Reference and primitive types can be assigned null", false, 
			"Reference types can be assigned null, which means they do not currently refer to an object.  "+
			"Primitive types will give a compiler error if you attempt to assign them null.");
		questions.add(Q25);
		Question Q26 = new Question("valid@variable_name will compile.", false, "Legal identifiers "+
			"(i) must begin with a letter or the symbol $ or _ (ii) subsequent characters may also be numbers " +
			"(iii) cannot be a Java reserved word; so @ will cause a compilation error.");
		questions.add(Q26);
		Question Q27 = new Question("Instance variables are in scope from declaration until program ends", false,
			"Instance variables are in scope from declaration until object is garbage collected; "+
			"class variables are in scope from declaration until program ends.");
		questions.add(Q27);
		Question Q28 = new Question("An object is eligible for garbage collection when the object no longer "+
			"has any references pointing to it, or all references to the object have gone out of scope.", true);
		questions.add(Q28);
		Question Q29 = new Question("If either operand is a String, + means concatenation.", true);
		questions.add(Q29);
		Question Q30 = new Question("Binary search works on any type of array.", false, 
			"Binary search only produces predictable output with sorted arrays.");
		questions.add(Q30);
		Question Q31 = new Question("Each primitive type has a wrapper class, which is an object type that corresponds to the primitive.", true);
		questions.add(Q31);
		Question Q32 = new Question("Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes.", true);
		questions.add(Q32);
		Question Q33 = new Question("import java.util.ArrayList to use both arrays and ArrayLists in a java class.", false, "import java.util.* to use both arrays and ArrayLists in a java class.");
		questions.add(Q33);
		Question Q34 = new Question("For Strings, equals() checks if both objects point to the same memory location.", false, "For Strings, == performs a reference comparison, "+
			"and equals() will check whether the sequence of characters is the same.");
		questions.add(Q34);
		Question Q35 = new Question("You can store an ArrayList in a List reference variable and you can store "+
			"a List in an ArrayList reference variable.", false, "You can store an ArrayList in a List reference variable; "+
			"you CANNOT store a List in an ArrayList reference variable because List is an interface and interfaces cannot be instantiated.");
		questions.add(Q35);
		Question Q36 = new Question("You may convert a String to a primitive with the valueOf() method.", false, 
			"You may convert a String to a primitive with the parse methods; the valueOf() method returns a wrapper class.");
		questions.add(Q36);
		Question Q37 = new Question("Smaller data types, namely byte, short, and char, are first promoted to int "+
			"any time they are used with a Java binary arithmetic operator, even if neither of the operands is int.", true);
		questions.add(Q37);
		Question Q38 = new Question("The conditional operators, && and ||, ensure that the right-hand side of the expression is evaluated.", false, 
			"The right-hand side of a conditional operator may never be evaluated if the final result can be determined by the left-hand side of the expression.");
		questions.add(Q38);
		Question Q39 = new Question("The ternary operator is of the form booleanExpression ? expression_1 : expression_2", true);
		questions.add(Q39);
		Question Q40 = new Question("With the post-increment operator and the post-decrement operator, "+
			"the original value of the expression is returned, with the operator applied after the value is returned.", true);
		questions.add(Q40);
		Question Q41 = new Question("Methods with no access modifier can only be called from classes in the same package or subclasses.", false, 
			"Methods with no access modifier can only be called from classes in the same package.  "+
			"Methods with the protected access modifier can only be called from classes in the same package or subclasses.");
		questions.add(Q41);
		Question Q42 = new Question("Public and default class access modifiers are the only access modifiers that can be applied to top-level classes within a Java file.", true);
		questions.add(Q42);
		Question Q43 = new Question("You are not allowed to construct a date or time object directly; the Java SE 8 date and time classes have private constructors to force you to use the static methods.", true);
		questions.add(Q43);
		Question Q44 = new Question("Java requires checked exceptions to be handled or declared.", true);
		questions.add(Q44);
		Question Q45 = new Question("The finally block of a try statement runs only when an exception is thrown.", false, "The finally block runs last regardless of whether an exception is thrown.");
		questions.add(Q45);
		Question Q46 = new Question("If it is impossible for one of the catch blocks of a try statement to be executed, a compiler error about unreachable code occurs.", true);
		questions.add(Q46);
	}
	
	/**
	* returns the Java SE 8 certification prep question bank
	* @return ArrayList the question bank
	*/
	public ArrayList<Question> getALLQuestions(){
		return questions;	
	}
}