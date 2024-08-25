package stream.soccer_scouts;

public class Defender extends Player {
	
	private int duelsWon;
	private int numInterceptions;
	
	
	public Defender(String name, int age, float height) {
		this(name, age, height, 0, 0, 10000f, 0);
	}
	
	
	public Defender(String name, int age, float height, int duelsWon, int numInterceptions, int gamesPlayed) {
		super(name, age, height, Position.getRandomDefenderPosition(), 10000f, gamesPlayed);
		this.duelsWon = duelsWon;
		this.numInterceptions = numInterceptions;
	}
	
	
	public Defender(String name, int age, float height, int duelsWon, int numInterceptions, float marketValue, int gamesPlayed) {
		super(name, age, height, Position.getRandomDefenderPosition(), marketValue, gamesPlayed);
		this.duelsWon = duelsWon;
		this.numInterceptions = numInterceptions;
	}
	
	
	
	public double duelsWonRatio() {
		return gamesPlayed > 0 ? (double)duelsWon / gamesPlayed : 0;
	}
	
	public double numInterceptionsRatio() {
		return gamesPlayed > 0 ? (double)numInterceptions / gamesPlayed : 0;
	}

	
	@Override
	public String toString() {
		return super.toString() + "\nDUELS WON : " + duelsWon + "\nNUMBER OF INTERCEPTIONS : " + numInterceptions + printLine();
	}


	public int getDuelsWon() {
		return duelsWon;
	}

	public void setDuelsWon(int duelsWon) {
		this.duelsWon = duelsWon;
	}
	
	public int getNumIntercepcions() {
		return numInterceptions;
	}

	public void setNumIntercepcions(int numIntercepcions) {
		this.numInterceptions = numIntercepcions;
	}


	@Override
	public double ratio() {
		return (duelsWonRatio() * 2 + numInterceptionsRatio()) / 2;
	}
	
	
	
	
	
}
