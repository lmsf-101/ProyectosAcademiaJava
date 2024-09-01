package decorator;

// DECORATOR
// Has a reference to a wrapped object. Must be declared as the Component interface in order
// to contain both a concrete Component or other decorators. Delegates all operations to the wrapped object
public abstract class MovieItemDecorator implements MovieItem {
	
	// HAS-A
	MovieItem item;
	String name;
	double price;
	
	MovieItemDecorator(MovieItem item, String name) {
		this.item = item;
		this.name = name;
	}
	
	MovieItemDecorator(MovieItem item, String name, double price) {
		this.item = item;
		this.name = name;
		this.price = price;
	}

	@Override
	public String getItem() {
		return item.getItem() + "\n"
				+ name + " - "+  price;
	}

	@Override
	public double getPrice() {
		return item.getPrice() + price;
	}
	
	
	@Override
	public String toString() {
		return this.getItem();
	}

}
