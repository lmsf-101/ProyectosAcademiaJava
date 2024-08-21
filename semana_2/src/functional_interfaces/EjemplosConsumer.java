package functional_interfaces;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class EjemplosConsumer implements FuncInterfaceExamples{

	
	@Override
	public void apply() {
		System.out.println("CONSUMER EXAMPLES : ");
		printUpperCaseMessage("Hello World!");
		BiCons.addNumbersInMiddle(6, 10, 12);
		
	}
	
	class BiCons {
		
		public static void addNumbersInMiddle(Integer... items) {
			System.out.println("Add numbers " + Arrays.toString(items) + " to the middle of list : ");
			List<Integer> example = new ArrayList<>(List.of(1,2,3,4,5));
			
			System.out.println("OLD LIST : " + example);
			
			BiConsumer<List<Integer>, Integer[]> changeList = (l, i) -> {
				l.addAll(l.size()/2, Arrays.asList(i));
			};
			
			
			changeList.accept(example, items);
			
			System.out.println("NEW LIST : " + example);
		}
	}
	
	public static void printUpperCaseMessage(String msg) {
		System.out.println("Print Message {" + msg + "} in Upper Case : ");
		
		Consumer<String> message = s -> System.out.println(s.toUpperCase());
		
		message.accept(msg);
	}

	
	
	

}
