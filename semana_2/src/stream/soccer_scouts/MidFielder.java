package stream.soccer_scouts;

public class MidFielder extends Player{
	
	int numCompletedPasses;
	int assists;
	
	public MidFielder(String name, int age, float height) {
		super(name, age, height, Position.getRandomMidfielderPosition(), 15000f, 0);
		numCompletedPasses = 0;
		assists = 0;
	}
	
	public MidFielder(String name, int age, float height, int numCompletedPasses, int assists, int gamesPlayed) {
		super(name, age, height, Position.getRandomMidfielderPosition(), 15000f, gamesPlayed);
		this.numCompletedPasses = numCompletedPasses;
		this.assists = assists;
	}
	
	public MidFielder(String name, int age, float height, int numCompletedPasses, int assists, float marketValue, int gamesPlayed) {
		super(name, age, height, Position.getRandomMidfielderPosition(), marketValue, gamesPlayed);
		this.numCompletedPasses = numCompletedPasses;
		this.assists = assists;
	}
	
	
	
	public double getCleanSheetRatio() {
		return (double)assists / gamesPlayed;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "\nNUMBER OF SAVES : " + numCompletedPasses + "\nNUM. OF MATCHES WITH CLEAN SHEET : " + assists + printLine();
	}


	public int getnumCompletedPasses() {
		return numCompletedPasses;
	}

	public void setnumCompletedPasses(int numCompletedPasses) {
		this.numCompletedPasses = numCompletedPasses;
	}

	public int getassists() {
		return assists;
	}
	
	@Override
	public double ratio() {
		return (double)(numCompletedPasses + assists * 2) / gamesPlayed;
	}
	
	
}
