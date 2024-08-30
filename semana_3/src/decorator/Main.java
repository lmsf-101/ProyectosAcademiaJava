package decorator;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		MovieItem baseTicket = new MovieTicket("Young Woman and the Sea");

		System.out.println(baseTicket);
		
		System.out.println();
		
		baseTicket = new PremiumTicket(baseTicket);
		
		System.out.println(baseTicket);
		System.out.println();
		
		baseTicket = new SpecialEvent(baseTicket, EventType.PREMIERE, LocalDate.now());
		
		System.out.println(baseTicket);
		System.out.println();
		
		baseTicket = new Discount(baseTicket, 0.20);
		
		System.out.println(baseTicket);
		System.out.println("TOTAL COST : " + baseTicket.getPrice());
	}

}
