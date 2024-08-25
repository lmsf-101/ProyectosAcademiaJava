package functional_interfaces;

/*
 * FUNCTIONAL INTERFACES EXERCISE - WEEK 2
 * Created by: Luis Miguel Sánchez Flores
 * 
 */



public class Principal {

	public static void main(String[] args) {
		
		// Get all the examples from each Functional Interface:
		
		FuncInterfaceExamples[] examples = {
				new ConsumerExamples(),
				new SupplierExamples(),
				new PredicateExamples(),
				new FunctionExamples(),
				new OperatorExamples()
		};
		
		// Run the examples:
		
		for (FuncInterfaceExamples example : examples) {
			example.apply();
			System.out.println("\n*********************\n");
		}
		
	}

}
