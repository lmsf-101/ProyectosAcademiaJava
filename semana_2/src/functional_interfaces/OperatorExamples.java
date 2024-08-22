package functional_interfaces;

import java.util.Date;
import java.util.function.UnaryOperator;

public class OperatorExamples implements FuncInterfaceExamples {

	@Override
	public void apply() {
		System.out.println("UNARY EXAMPLES : ");
		
		UnaryOperatorClass.convertToCelsius(90.1f);
		UnaryOperatorClass.reverseCharBytes('/');
		

	}
	
	
	class UnaryOperatorClass {
		
		public static void convertToCelsius(Float farenheit) {
			System.out.println("\nConvert the temperature of " + farenheit + "°F into Celsius : ");
			
			UnaryOperator<Float> toCelsius = f -> (f - 32) * (5f / 9);
			
			
			float celsius = toCelsius.apply(farenheit);
			
			System.out.println(farenheit + "°F to Celsius is : " + String.format("%.2f", celsius) + "°C");
			
		}
		
		public static void reverseCharBytes(Character character) {
			System.out.println("\nReversing the bytes of char \'" + character + "\'... ");
			
			
			UnaryOperator<Character> reverseBytes = ch -> Character.reverseBytes(ch);
			
			char newChar = reverseBytes.apply(character);
			
			System.out.println("NEW CHAR : " + newChar);
		}
		
	}
	
	class BinaryOperatorClass {
		
		// TODO Create 4 BinaryOperator examples.
		
	}

}
