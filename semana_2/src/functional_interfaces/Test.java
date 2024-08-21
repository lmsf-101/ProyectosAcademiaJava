package functional_interfaces;

public interface Test<T, U, R> {

	/*void apply(T input);
	void applyBi(T input1, U input2);
	R applyBiReturn(T input1, U input2);*/
	
	
	interface Consumer<T, U> {
		void apply(T input);
		void applyBi(T input1, U input2);
	}
	
	interface Predicate<T, U> {
		Boolean apply(T input);
		Boolean apply(T input1, U input2);
	}
	
	interface Function<T, U, R> {
		R apply(T input);
		R apply(T input1, U input2);
	}
	
	interface Operator<T> {
		T apply(T input);
		T apply(T input1, T input2);
	}
	
	interface Supplier<T> {
		
	}
}
