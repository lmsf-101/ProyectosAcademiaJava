package decorator;

import java.time.LocalDate;

//CONCRETE DECORATOR
public class SpecialEvent extends MovieItemDecorator{
	
	private EventType event;
	private LocalDate date;

	// Set up the event type and date in which the special event will take place:
	SpecialEvent(MovieItem item, EventType event, LocalDate date) {
		super(item, "SPECIAL EVENT : " + event.name(), 0);
		this.date = date;
		this.event = event;
		this.price = checkEventType(event); // <- Assign the event's price based on the type:
	}
	
	
	
	@Override
	public double getPrice() {
		return super.getPrice() + checkEventType(event);
	}



	@Override
	public String getItem() {
		// Check if the event is today. If it is, print what kind of event is it and its charge
		// Otherwise, print it as unavailable and do not apply charges
		String isEventToday = isToday() ? getEventType() : "SPECIAL EVENT UNAVAILABLE";
		return item.getItem() + "\n" +
				isEventToday + " - " + price;
	}


	// Return an appropriate charge for the ticket based on the event's type:
	double checkEventType(EventType event) {
		double eventPrice;
		if (!isToday()) // <- Do not charge if the event is not today
			return 0;
		
		switch (event) {
		case PREMIERE:
			eventPrice = item.getPrice() * .20;
			break;
		case QASESSION:
			eventPrice = item.getPrice() * .40;
			break;
		case ANNIVERSARY:
			eventPrice = item.getPrice() * .10;
			break;
		default:
			return 0;
		}
		
		return Math.floor(eventPrice * 100) / 100;
	}
	
	// Get event's name:
	String getEventType() {
		return event.name();
	}
	
	// Check if the event's date is today:
	boolean isToday() {
		return LocalDate.now().equals(date);
	}
	
	

}
