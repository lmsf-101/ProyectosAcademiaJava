package decorator;


// CONCRETE / BASE COMPONENT
public class MovieTicket implements MovieItem {

	String movie;
	double price;
	
	MovieTicket(String movie) {
		this.movie = movie;
		price = 9.99;
	}
	
	@Override
	public String getItem() {
		return "TICKET FOR THE MOVIE : " + movie + "\nPRICE : " + price;
	}

	@Override
	public double getPrice() {
		return price;
	}
	
	
	@Override
	public String toString() {
		return this.getItem();
	}
	
	

}
