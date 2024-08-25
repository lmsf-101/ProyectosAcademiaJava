package functional_interfaces;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class ConsumerExamples implements FuncInterfaceExamples{

	
	
	// Run both Consumer and BiConsumer interfaces examples:
	@Override
	public void apply() {
		System.out.println("\nCONSUMER EXAMPLES : ");
		ConsumerClass.printUpperCaseMessage("Hello World!");
		ConsumerClass.printOptionalValue(null);
		ConsumerClass.printList(List.of("Alan", "Carlos", "Jorge", "Frida"));
		ConsumerClass.printCharVal('P');
		
		System.out.println("\n\nBICONSUMER EXAMPLES : ");
		
		BiConsumerClass.addNumbersInMiddle(new ArrayList<Integer>(List.of(2, 3)), 6, 10, 12);
		BiConsumerClass.calculateRectArea(52.75, 192.3);
		
		HashMap<String, Integer> hm = new HashMap<>(Map.of("Harry", 2, "Steve", 1, "Kevin", 9, "Stuart", 21, "David", 90));
		BiConsumerClass.checkEachKey(hm, "Harry", "Larry", "Gary", "David", "Stuart");
		
		BiConsumerClass.happyBirthday("Luis", 25);
	}
	
	
	
	class ConsumerClass {
		
		// Transforms and prints outs the message in upper case letters:
		public static void printUpperCaseMessage(String msg) {
			System.out.println("\nPrint Message {" + msg + "} in Upper Case : ");
			
			Consumer<String> message = s -> System.out.println(s.toUpperCase());
			
			message.accept(msg);
		}
		
		// Prints out the individual elements of the list, each on their own line:
		public static <E> void printList(List<E> list) {
			System.out.println("\nPrint each element of the list {" + list + "} individually : ");
			
			Consumer<List<E>> printList = l -> {
				int i = 0;
				for(E e : list) {
					System.out.println(i++ + " : " + e);
				}
			};
			
			printList.accept(list);
		}
		
		
		// Prints out the Optional value if it exists. If not, print out dots:
		public static <T> void printOptionalValue(T t) {
			System.out.println("\nPrint the Optional Value (if available) : ");
			
			Optional<T> opt = Optional.ofNullable(t);
			
			opt.ifPresentOrElse(val -> System.out.println(val), () -> System.out.println("..."));
		}
		
		
		// Prints out the numeric value of the character provided:
		public static void printCharVal(Character ch) {
			System.out.println("\nPrint the numerical value of char : " + ch);
			
			Consumer<Character> printNumValue = c -> System.out.println("Numeric value of {"+c+"} = "+ Character.getNumericValue(c));
			
			printNumValue.accept(ch);
		}
	}
	
	// ---------------------------------------------------------------
	
	
	class BiConsumerClass {
		
		// Add the array of integers at the middle part of the ArrayList:
		public static void addNumbersInMiddle(ArrayList<Integer> example, Integer... items) {
			System.out.println("\nAdd numbers " + Arrays.toString(items) + " to the middle of list : ");
			
			System.out.println("OLD LIST : " + example);
			
			BiConsumer<List<Integer>, Integer[]> changeList = (l, i) -> {
				l.addAll(l.size()/2, Arrays.asList(i));
			};
			
			
			changeList.accept(example, items);
			
			System.out.println("NEW LIST : " + example);
		}
		
		
		// Calculate the area of a rectangle, given the parameters of length and width of said rectangle:
		public static void calculateRectArea(Double length, Double width) {
			System.out.println("\nCalculate the rectangle's area, given its length {"+length+"} and width {"+width+"} : ");
			
			BiConsumer<Double, Double> calcRectArea = (l, w) -> System.out.println("The area of the rectangle {"+l+" * "+w+"} is :" + l*w);
			
			calcRectArea.accept(length, width);
		}
		
		// Check if each key is included in the Map collection:
		public static <K,V> void checkEachKey(Map<K,V> map, K... keys) {
			System.out.println("\nCheck if each key of the list " + Arrays.toString(keys) + " are available in the Map object : ");
			
			BiConsumer<Map<K,V>, K[]> checkKeys = (m, k) -> {
				for(K key: k)
					System.out.println( m.containsKey(key) ?
							key + " is a Key" :
						    "There is no " + key + " as a key"
							);
			};
			
			checkKeys.accept(map, keys);
		}
		
		
		// Print out a happy birthday message to the user, using their name and age:
		public static void happyBirthday(String name, Integer age) {
			System.out.println("\nPrint a happy birthday message towards the user : ");
			
			BiConsumer<String, Integer> generateHappyBirthday = (s, i) -> System.out.println(
																"Congratulations "+s+" on your "+i+ " birthday! May all your wishes come true!"
																);
			
			generateHappyBirthday.accept(name, age);
			
		}
		
		
	}
	
}
