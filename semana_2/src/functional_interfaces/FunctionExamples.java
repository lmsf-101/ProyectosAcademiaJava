package functional_interfaces;

import java.util.function.Function;

public class FunctionExamples implements FuncInterfaceExamples {

	@Override
	public void apply() {
		System.out.println("FUNCTION EXAMPLES : ");
		FunctionClass.roundNumber(3.6f);

	}
	
	
	class FunctionClass {
		
		public static void roundNumber(Float number) {
			System.out.println("\nRound " + number + " to the nearest integer: ");
			
			Function<Float, Integer> round = num -> Math.round(num);
			
			int wholeNum = round.apply(number);
			
			System.out.println("The closest integer to " + number + " is " + wholeNum);
			
		}
		
	}

}
