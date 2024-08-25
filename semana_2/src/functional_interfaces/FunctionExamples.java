package functional_interfaces;

import java.util.function.Function;
import java.util.function.BiFunction;

public class FunctionExamples implements FuncInterfaceExamples {

	// Run the examples of both Function and BiFunction interfaces:
	@Override
	public void apply() {
		System.out.println("\nFUNCTION EXAMPLES : ");
		FunctionClass.roundNumber(3.6f);
		FunctionClass.getHexValue(29);
		FunctionClass.greetings("Luis");
		FunctionClass.squareOfNumber(9.5f);
		
		System.out.println("\n\nBIFUNCTION EXAMPLES : ");
		BiFunctionClass.isCharAFirstThanB('n', 'N');
		BiFunctionClass.concatenateStrings("This is", " Java language!");
		BiFunctionClass.fullName("Luis", "Miguel");
		BiFunctionClass.censorCharacter("THIS IS VERY IMPORTANT TEXT HERE", 'E');

	}
	
	
	class FunctionClass {
		
		// Round the floating value to the nearest Integer:
		public static void roundNumber(Float number) {
			System.out.println("\nRound " + number + " to the nearest integer: ");
			
			Function<Float, Integer> round = num -> Math.round(num);
			
			int wholeNum = round.apply(number);
			
			System.out.println("The closest integer to " + number + " is " + wholeNum);
			
		}
		
		// Calculate the square of a number:
		public static void squareOfNumber(Float number) {
			System.out.println("\nCalculate the square of number " + number + " : ");
			
			Function<Float, Float> getSquareOfNum = n -> n * n;
			
			float squareNumber = getSquareOfNum.apply(number);
			
			System.out.println("The square of number " + number + " is " + squareNumber);
		}
		
		
		// Print out the hex value of the provided number:
		public static void getHexValue(Integer num) {
			System.out.println("\nGet the hex value from the decimal value : " + num);
			
			Function<Integer, String> getHex = i -> Integer.toHexString(i);
			
			String hex = getHex.apply(num);
			
			System.out.println(num + " -> " + hex);
		}
		
		
		// Greet the user by their name:
		public static void greetings(String name) {
			System.out.println("\nGreet user by their name : ");
			
			Function<String, String> greet = n -> "Hello " + name + ", nice to meet you!";
			
			String greeting = greet.apply(name);
			
			System.out.println(greeting);
			
		}
		
	}
	
	// --------------------------------------------------------
	
	class BiFunctionClass {
		
		
		// Examine if the first char comes before the second one, based on their ASCII values:
		public static void isCharAFirstThanB(Character char1, Character char2) {
			System.out.println("\nCheck if char \'" + char1 + "\' comes before the char \'" + char2 + "\': ");
			
			BiFunction<Character, Character, Integer> checkChars = Character::compare;
			
			int result = checkChars.apply(char1, char2);
			
			System.out.println(result < 0 ?
					"The character " + char1 + " comes BEFORE " + char2 :
						"The character " + char1 + " comes AFTER " + char2 
			);
			
		}
		
		// Concatenate two strings into one:
		public static void concatenateStrings(String s1, String s2) {
			System.out.println("\nConcatenate the string \"" + s1 + "\" with the string \"" + s2 + "\" : ");
			
			BiFunction<String, String, String> concatStrings = String::concat;
			
			String newString = concatStrings.apply(s1, s2);
			
			System.out.println("NEW STRING : " + newString);
		}
		
		// Print out the full name of the person given their first and last name:
		public static void fullName(String firstName, String lastName) {
			System.out.println("\nGet the full name of the user : ");
			
			BiFunction<String, String, String> fullName = (fn, ln) -> firstName + " " + lastName;
	        
			System.out.println("Full Name: " + fullName.apply(firstName, lastName));
		}
		
		
		// Censor a specific character in the string:
		public static void censorCharacter(String text, Character ch) {
			System.out.println("\nCensor the character {"+ch+"} from the String \""+text+"\" : ");
			
			BiFunction<String, Character, String> censorChar = (s, c) -> s.replace(c, '*');
			
			System.out.println("CENSORED TEXT : " + censorChar.apply(text, ch));
		}
		
		
	}

}
