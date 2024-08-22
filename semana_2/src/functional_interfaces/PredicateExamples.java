package functional_interfaces;

import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PredicateExamples implements FuncInterfaceExamples{

	@Override
	public void apply() {
		System.out.println("PREDICATE EXAMPLES : ");
		UniPredicate.isLastCharLetter("Edson21");
		UniPredicate.numberRaffle(5);
		
		System.out.println("BIPREDICATE EXAMPLES : ");
		DuoPredicate.isContainedInList(List.of("Hello", "World", "Java", "!", 2, 5), 5);
		DuoPredicate.isBiggerThan1000(4.0, 10.0);
		DuoPredicate.isDateBefore(new Date(), new SimpleDateFormat("dd-MM-yyyy").parse("18-12-2026", new ParsePosition(0)));
		
	}

	class UniPredicate {
		
		public static void isLastCharLetter(String s) {
			
			System.out.println("\nCheck if String {" + s + "} contains a letter as its last char: ");
			
			Predicate<String> checkLastChar = (str -> Character.isLetter(str.charAt(str.length()-1)));
			
			boolean isLetter = checkLastChar.test(s);
			
			System.out.println("Does " + s + " have a letter as its last char ? " + isLetter);
		}
		
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
	}

	class DuoPredicate {
		
		public static <E> void isContainedInList(List<E> list, E item ) {
			System.out.println("\nExamine if the List " + list + " contains the following list : " + item.toString());
			
			BiPredicate<List<E>, E> checkForItem = (l, e) -> l.contains(e);
			
			boolean isItemAvailable = checkForItem.test(list, item);
			
			System.out.println("Is " + item.toString() + " in the list ? " + isItemAvailable);
			
		}
		
		public static void isBiggerThan1000(Double num1, Double num2) {
			System.out.println("\nIs the exponential of " + num1 + " ^ " + num2 + " bigger than 1000 ? ");
			
			BiPredicate<Double, Double> checkExponential = (n1, n2) -> Math.pow(n1, n2) > 1000;
			
			boolean isBigger = checkExponential.test(num1, num2);
			
			System.out.println("Is " + Math.pow(num1, num2) + " bigger than 1000 ? " + isBigger);
			
		}
		
		public static void isDateBefore(Date firstDate, Date secondDate) {
			System.out.println("\nDoes the date " + firstDate.toString() + " comes before " + secondDate.toString() +"?");
			
			BiPredicate<Date, Date> checkDates = (date1, date2) -> date1.before(date2);
			
			boolean isOlderDate = checkDates.test(firstDate, secondDate);
			
			System.out.println(isOlderDate);
			
		}
	}
}
