package functional_interfaces;

import java.util.function.*;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		FuncInterfaceExamples[] examples = {
				new EjemplosConsumer(),
				new SupplierExamples(),
				new PredicateExamples(),
				new FunctionExamples(),
				new OperatorExamples()
		};
		
		for (FuncInterfaceExamples example : examples) {
			example.apply();
			System.out.println("\n*********************\n");
		}

	/*	
		System.out.println("Hello World!");
			
		Function<String, Integer> stringToInt = s -> Integer.parseInt(s);
		
		Integer numero = stringToInt.apply("125");
		
		System.out.println("FUNCTIONAL -- "+ numero);
		
		Consumer<String> printUpperCase =  s -> {
			System.out.println("CONSUMER -- " + s.toUpperCase());
		};
		
		printUpperCase.accept("Hello World!");
		
		Predicate<Integer> isNumberEven = i -> i % 2 == 0;
		
		boolean isEven = isNumberEven.test(4);
		
		System.out.println("PREDICATE -- "+isEven);
		
		Supplier<String[]> createArrayOfStrings = () -> new String[5];
		
		String[] texts = createArrayOfStrings.get();
		
		System.out.println("SUPPLIER -- "+ "Number of texts in array : " + texts.getClass().getSimpleName() + texts.length);
	*/
		
	}

}
