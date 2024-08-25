package functional_interfaces;

import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PredicateExamples implements FuncInterfaceExamples{

	// Run the examples of both Predicate and BiPredicate interfaces:
	@Override
	public void apply() {
		System.out.println("\nPREDICATE EXAMPLES : ");
		UniPredicate.isPrimeNumber(97);
		UniPredicate.isLastCharLetter("Edson21");
		UniPredicate.numberRaffle(5);
		UniPredicate.checkTwoPredicates(7, (n -> n < 10), (n -> n != 5));
		
		
		System.out.println("\n\nBIPREDICATE EXAMPLES : ");
		DuoPredicate.isContainedInList(List.of("Hello", "World", "Java", "!", 2, 5), 5);
		DuoPredicate.isBiggerThan1000(4.0, 10.0);
		DuoPredicate.isDateBefore(new Date(), new SimpleDateFormat("dd-MM-yyyy").parse("18-12-2026", new ParsePosition(0)));
		DuoPredicate.isInMap(Map.of("a", 1, "b", 2, "c", 3, "d", 4), 3);
	}

	class UniPredicate {
		
		// Check if the parameter is a prime number or not:
		public static void isPrimeNumber(Integer number) {
			System.out.println("\nExamine if the number "+number+ " is a prime number or not.");
			
			Predicate<Integer> checkNumber = n -> {
				for(int i = 2; i < n; i++) {
					if (n%i == 0)
						return false;
				}
				return true;
			};
			
			
			boolean isPrimeNumber = checkNumber.test(number);
			
			System.out.println( isPrimeNumber ? 
					number + " is a prime number." :
					number + " is NOT a prime number"
			);
			
		}
		
		// Examine if the string input has a letter as its last character:
		public static void isLastCharLetter(String s) {
			
			System.out.println("\nCheck if String {" + s + "} contains a letter as its last char: ");
			
			Predicate<String> checkLastChar = (str -> Character.isLetter(str.charAt(str.length()-1)));
			
			boolean isLetter = checkLastChar.test(s);
			
			System.out.println("Does " + s + " have a letter as its last char ? " + isLetter);
		}
		
		
		// Evaluate if the number input IS the lucky number!
		public static void numberRaffle(Integer luckyNumber) {
			System.out.println("\nIs the number " + luckyNumber + " the lucky number of the Raffle? ");
			
			Random rand = new Random();
			int totalNumbers = rand.nextInt(1, (luckyNumber+1) + rand.nextInt(11));
			int winnerNumber = rand.nextInt(totalNumbers);
			
			Predicate<Integer> checkLuckyNumber = (i -> i == winnerNumber);
			
			boolean isLuckyNumber = checkLuckyNumber.test(luckyNumber);
			
			System.out.println(
					isLuckyNumber? "Congratulations! " + luckyNumber + " IS the lucky number!":
							"Sorry! " + luckyNumber + " IS NOT the lucky number today. The winner number was : " + winnerNumber);
		}
		
		
		// Evaluate if the number satisfies both predicates:
		public static void checkTwoPredicates(Integer num, Predicate<Integer> pre1, Predicate<Integer> pre2) {
			
			System.out.println("\nEvaluate if the number " + num + " satisfies both predicates : ");
			
			Predicate<Integer> checkBothPredicates = i -> pre1.test(i) && pre2.test(i);
			
			boolean areBothPredicatesTrue = checkBothPredicates.test(num);
			
			System.out.println("Does " + num + " satisfies both predicates ? " + areBothPredicatesTrue);
			
		}
	}
	
	// ------------------------------------------------------------

	class DuoPredicate {
		
		// Check if a specific item is stored in a specific list:
		public static <E> void isContainedInList(List<E> list, E item ) {
			System.out.println("\nExamine if the List " + list + " contains the following item : " + item.toString());
			
			BiPredicate<List<E>, E> checkForItem = (l, e) -> l.contains(e);
			
			boolean isItemAvailable = checkForItem.test(list, item);
			
			System.out.println("Is " + item.toString() + " in the list ? " + isItemAvailable);
			
		}
		
		// Evaluate if the exponential between two numbers is bigger than 1000:
		public static void isBiggerThan1000(Double num1, Double num2) {
			System.out.println("\nIs the exponential of " + num1 + " ^ " + num2 + " bigger than 1000 ? ");
			
			BiPredicate<Double, Double> checkExponential = (n1, n2) -> Math.pow(n1, n2) > 1000;
			
			boolean isBigger = checkExponential.test(num1, num2);
			
			System.out.println("Is " + Math.pow(num1, num2) + " bigger than 1000 ? " + isBigger);
			
		}
		
		
		// Check if the first date came before the second one:
		public static void isDateBefore(Date firstDate, Date secondDate) {
			System.out.println("\nDoes the date " + firstDate.toString() + " comes before " + secondDate.toString() +"?");
			
			BiPredicate<Date, Date> checkDates = (date1, date2) -> date1.before(date2);
			
			boolean isOlderDate = checkDates.test(firstDate, secondDate);
			
			System.out.println(isOlderDate);
			
		}
		
		
		// Check if a specific object is included in a Map collection either as a key or as a value:
		public static <K, V> void isInMap(Map<K, V> map, Object value) {
			System.out.println("\nCheck if the value {"+value+"} is in a Map collection (as a key or value) : ");
			
			BiPredicate<Map<K,V>, Object> checkMap = (m, o) -> (m.containsKey(o) || m.containsValue(o)) ? true : false;
			
			boolean isValueInMap = checkMap.test(map, value);
			
			System.out.println("Is "+value+" {"+value.getClass().getSimpleName()+"} in the map ? " + isValueInMap);
			
		}
	}
}
