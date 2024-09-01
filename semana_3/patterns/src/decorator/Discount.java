package decorator;

//CONCRETE DECORATOR
public class Discount extends MovieItemDecorator{
	
	Discount(MovieItem item, double percentage) {
		super(item, percentage*100 + " % DISCOUNT ", Math.floor((item.getPrice() * -percentage * 100) / 100));
	}
}
