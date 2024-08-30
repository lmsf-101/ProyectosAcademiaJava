package decorator;

// CONCRETE DECORATOR
public class PremiumTicket extends MovieItemDecorator{

	PremiumTicket(MovieItem item) {
		super(item, "PREMIUM TICKET", 3.99);
	}
	

}
