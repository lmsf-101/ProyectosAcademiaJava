package stream.soccer_scouts;

public class Player {
	

	String name;
	short age;
	float height;
	Position position;
	int gamesPlayed;
	
	
	public Player(String name, short age, Position position, int gamesPlayed) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.gamesPlayed = gamesPlayed > 0 ? gamesPlayed : 0;
	}
	
	public String getPosition() {
		return position.name();
	}
	
	

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

	public short getAge() {
		return age;
	}

	public float getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "PLAYER : " + name + "\nAGE : " + age + "\nHEIGHT : " + height + "\nPOSITION : " + getPosition() 
				+ "\nGAMES PLAYED : " + gamesPlayed;   
	}
	
	
}
