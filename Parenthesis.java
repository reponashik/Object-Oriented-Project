import java.util.Stack; //Import package for stack
import java.util.Scanner; //Import package for scanner
public class Parenthesis {
	
		//To test run balancedParenthesis(); in main method.
		//To test uncomment and run program
		//public static void main(String[]args){
		//	balancedParenthesis();
		//}
	
		static void balancedParenthesis() { //method signature
			boolean repeatInp = true; //variable to ask for input
			while(repeatInp == true) { //while loop enclosing standard input 
			Scanner sc = new Scanner(System.in); //scanner utilization to ask for standard input
			System.out.println("Enter your string:        "); //message asking for input
			String string = sc.nextLine(); //scanner next line for entering message
			//covert string content into array
			char[] str = string.toCharArray();//converting  content into array
			//Create Stack
			Stack<Character> s = new Stack<>();
			boolean balanced = true; //set balanced to true to start with
			for(int i = 0; i<str.length;i++) { //parse through string 
				if(Open(str[i])==true) //Open is defined below
					s.push(str[i]); //pushing into stack content of array if respects conditions imposed by Open 
				else
				{
					if(s.isEmpty() == true) { //check if stack is empty
						balanced = false; //boolean balanced is false
						break; //exit for loop
					}
					else if(s.peek() != checkTop(str[i])) { //if the top of the stack is equal to any bracket which is not closing another bracket, then balanced is set to false
						balanced = false; //balanced set to false 
						break; //break the loop
					}
					else 
						s.pop(); //otherwise pop element from the stack
				}
			}
			if(!s.empty())//if stack empty, balanced is false
				balanced = false; //boolean set to false
			
			if(balanced == true) { //if balance is true, proceed
				System.out.println("True - Balanced"); //show appropriate message
			}
			else {
				System.out.println("False - Not Balanced"); //show appropriate message
			}
			}
			}
	//arrays with opening and closing arrays
	static char[] opening = { '(', '{', '[' };
	static char[] closing = {')', '}', ']' };
	//function open to use the elements of the arrays opening and closing to compare against in the stack
	//this function is called in balanced parenthesis() for comparing the first element of stack
	static boolean Open(char a) {
		for(int i = 0;i<opening.length;i++) 
			if (opening[i] == a)
				return true;
		return false;
	}
	//The s.peek() stack functionality cannot compare an object to a char
	//Therefore a separate method is required to replace peek to check if the 
	//corresponding character at the top of the stack its an opening or a closing 
	//parenthesis - CheckTop()
	static char checkTop(char a) {
		for(int i = 0; i<opening.length;i++)
			if(opening[i]==a)
				return closing[i];
		for(int i = 0; i<closing.length;i++)
			if(closing[i]==a)
				return opening[i];
		return ' '; //static return 
	}
	}