package stream.soccer_scouts;

public class Defender extends Player {
	
	int duelsWon;
	int numIntercepcions;
	
	
	
	
	public Defender(String name, short age, Position position, int gamesPlayed, int duelsWon, int numIntercepcions) {
		super(name, age, Po, gamesPlayed);
		this.duelsWon = duelsWon;
		this.numIntercepcions = numIntercepcions;
	}
	
	
	
}
