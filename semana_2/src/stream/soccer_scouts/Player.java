package stream.soccer_scouts;

public abstract class Player {
	
	// Abstract Player class to establish common soccer player's properties and functions:

	String name;
	int age;
	float height;
	float marketValue;
	int gamesPlayed;
	Position position;
	
	
	public Player(String name, int age, float height, Position position, float marketValue, int gamesPlayed) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.position = position;
		this.marketValue = marketValue;
		this.gamesPlayed = gamesPlayed > 0 ? gamesPlayed : 0;
	}
	
	public Player(String name, int age, float height, Position position) {
		this(name, age, height, position, 15000f, 0);
	}
	
	
	
	public Position getPosition() {
		return position;
	}
	
	public abstract double ratio();
	
	

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public float getHeight() {
		return height;
	}
	
	

	public float getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(float marketValue) {
		this.marketValue = marketValue;
	}

	@Override
	public String toString() {
		return "PLAYER : " + name + " - AGE : " + age + " - HEIGHT : " + height + "m - POSITION : " + position.name()
				+ " - GAMES PLAYED : " + gamesPlayed + " - MARKET VALUE : $" + marketValue;   
	}
	
	
	String printLine() {
		return "\n\n*********************************\n";
	}
	
	
}
