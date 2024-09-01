package decorator;

import java.time.LocalDate;

/*
 * JAVA PROGRAM EXAMPLE SHOWCASING THE DECORATOR PATTERN
 * Made by: Luis Miguel Sánchez Flores
 */

public class Main {

	public static void main(String[] args) {
		
		
		// Assuming that the customer orders a ticket for "Young Woman and the Sea":
		MovieItem baseTicket = new MovieTicket("Young Woman and the Sea");

		System.out.println(baseTicket);
		System.out.println("TOTAL COST : " + baseTicket.getPrice());
		System.out.println();
		
		// Now let's upgrade it to a premium ticket!
		baseTicket = new PremiumTicket(baseTicket);
		
		System.out.println(baseTicket);
		System.out.println("TOTAL COST : " + baseTicket.getPrice());
		System.out.println();
		
		// Another customer wants to order a movie ticket....
		MovieItem baseTicket2 = new MovieTicket("Alien: Romulus");
		
		// ...that its a premiere for the Alien: Romulus movie!
		baseTicket2 = new SpecialEvent(baseTicket2, EventType.PREMIERE, LocalDate.now());
		
		// Print out how much it will cost...
		System.out.println(baseTicket2);
		System.out.println("TOTAL COST : " + baseTicket2.getPrice());
		System.out.println();
		
		// ANOTHER customer wants to watch the Trap movie...
		MovieItem baseTicket3 = new MovieTicket("Trap");
		
		
		// ...but applies a 20% discount!
		baseTicket3 = new Discount(baseTicket3, 0.20);
		
		// How much cheaper will the movie ticket be?
		System.out.println(baseTicket3);
		System.out.println("TOTAL COST : " + baseTicket3.getPrice());
		System.out.println();
		
		
		// COMBINING ALL DECORATORS
		MovieItem baseTicket4 = new Discount(
									new PremiumTicket(
											new SpecialEvent(new MovieTicket("Shrek 2"), 
															 EventType.ANNIVERSARY,
															 LocalDate.now())
									)
									, 0.30
								);
				
		System.out.println(baseTicket4);
		System.out.println("TOTAL COST : " + baseTicket4.getPrice());
		
		
		
	}

}
