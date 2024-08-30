package decorator;

import java.time.LocalDate;

//CONCRETE DECORATOR
public class SpecialEvent extends MovieItemDecorator{
	
	private EventType event;
	private LocalDate date;

	SpecialEvent(MovieItem item, EventType event, LocalDate date) {
		super(item, "SPECIAL EVENT : " + event.name(), 0);
		this.date = date;
		this.event = event;
		this.price = checkEventType(event);
	}
	
	
	
	@Override
	public double getPrice() {
		return super.getPrice() + checkEventType(event);
	}



	@Override
	public String getItem() {
		String isEventToday = isToday() ? getEventType() : "SPECIAL EVENT UNAVAILABLE";
		return item.getItem() + 
				isEventToday + " - " + price;
	}



	double checkEventType(EventType event) {
		if (!isToday())
			return 0;
		
		switch (event) {
		case PREMIERE:
			return item.getPrice() * .20;
		case QASESSION:
			return item.getPrice() * .40;
		case ANNIVERSARY:
			return item.getPrice() * .10;
		default:
			return 0;
		}
	}
	
	String getEventType() {
		return event.name();
	}
	
	boolean isToday() {
		return LocalDate.now().equals(date);
	}
	
	

}
