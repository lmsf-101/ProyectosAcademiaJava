package functional_interfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorExamples implements FuncInterfaceExamples {

	// Run the examples of both UnaryOperator and BinaryOperator interfaces:
	@Override
	public void apply() {
		System.out.println("\nUNARY OPERATOR EXAMPLES : ");
		
		UnaryOperatorClass.convertToCelsius(90.1f);
		UnaryOperatorClass.reverseCharBytes('/');
		UnaryOperatorClass.calculateCircleArea(6.7);
		UnaryOperatorClass.calculateSquareRoot(121d);
		
		System.out.println("\n\nBINARY OPERATOR EXAMPLES : ");
		
		BinaryOperatorClass.sumOfNumbers(5, 193);
		BinaryOperatorClass.concatString("Mike", " Wazowski");
		BinaryOperatorClass.calculateHypotenuse(9.75, 12.5);
		BinaryOperatorClass.concatArrayListsOfStrings(
				new ArrayList<String>(List.of("Dalle", "Freddy", "Sarah")),
				new ArrayList<String>(List.of("Carly", "Edward", "Cindy"))
		);

	}
	
	
	class UnaryOperatorClass {
		
		// Convert Farenheit degrees to Celsius:
		public static void convertToCelsius(Float farenheit) {
			System.out.println("\nConvert the temperature of " + farenheit + "°F into Celsius : ");
			
			UnaryOperator<Float> toCelsius = f -> (f - 32) * (5f / 9);
			
			
			float celsius = toCelsius.apply(farenheit);
			
			System.out.println(farenheit + "°F to Celsius is : " + String.format("%.2f", celsius) + "°C");
			
		}
		
		// Invert the order of the character's bytes:
		public static void reverseCharBytes(Character character) {
			System.out.println("\nReversing the bytes of char \'" + character + "\'... ");
			
			
			UnaryOperator<Character> reverseBytes = ch -> Character.reverseBytes(ch);
			
			char newChar = reverseBytes.apply(character);
			
			System.out.println("NEW CHAR : " + newChar);
		}
		
		
		// Calculate the area of an circle, given their radius:
		public static void calculateCircleArea(Double radius) {
			System.out.println("\nCalculate the area of the circle, given the radius of : " + radius);
			
			UnaryOperator<Double> getArea = r -> Math.PI * Math.pow(r, 2);
			
			Double area = getArea.apply(radius);
			
			System.out.println("RADIUS : " + area);
		
		}
		
		// Calculate the square root of the provided number:
		public static void calculateSquareRoot(Double number) {
			System.out.println("\nCalculate the square root of the number : " + number);
			
			UnaryOperator<Double> getSquareRoot = Math::sqrt;
			
			Double root = getSquareRoot.apply(number);
			
			System.out.println("Square root of " + number + " is " + root);
		}
		
	}
	
	//-----------------------------------------------------------
	
	class BinaryOperatorClass {
		
			// Sum the first and last numbers:
			public static void sumOfNumbers(int num1, int num2) {
				System.out.println("\nSum of numbers " + num1 + " and " + num2);
				
				BinaryOperator<Integer> sum = (n1, n2) -> n1 + n2;
				
				int result = sum.apply(num1, num2);
				
				System.out.println("RESULT : " + result);
				
			}
			
			// Concatenate the first string with the second one into a new string:
			public static void concatString(String initStr, String newStr ) {
				System.out.println("\nConcatenate the string \"" + initStr + "\" with \"" + newStr + "\"");
				
				BinaryOperator<String> concatNewString = String::concat;
				
				String concatString = concatNewString.apply(initStr, newStr);
				
				System.out.println("NEW STRING : " + concatString);
			}
			
			
			// Calculate the hypotenuse of a right triangle, given the length of sides A and B:
			public static void calculateHypotenuse(Double a, Double b) {
				System.out.println("\nCalculate the hypotenuse of a right triangle based on side A {" +a+"} and B {"+b+"}");
				
				BinaryOperator<Double> calculate = (n1, n2) -> Math.sqrt(n1 * n1 + n2 * n2);
				
				Double hypotenuse = calculate.apply(a, b);
				
				System.out.println("HYPOTENUSE : " + String.format("%.3f", hypotenuse));
			}
			
			
			// Add the elements from one list into another, and return a new concatenated list:
			public static void concatArrayListsOfStrings(ArrayList<String> list1, ArrayList<String> list2) {
				System.out.println("\nJoin the list : " + list1 + ", with the list : " + list2);
				
				BinaryOperator<ArrayList<String>> concatListOfStrings = (l1, l2) -> {
					ArrayList<String> newList = new ArrayList<>(l1);
					newList.addAll(l2);
					return newList;
				};
				
				ArrayList<String> extendedList = concatListOfStrings.apply(list1, list2);
				
				System.out.println("NEW ARRAYLIST : " + extendedList);
			}
		
	}

}
