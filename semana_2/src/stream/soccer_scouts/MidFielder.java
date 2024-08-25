package stream.soccer_scouts;

public class MidFielder extends Player{
	
	private int numCompletedPasses;
	private int assists;
	
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
	
	
	
	public double assistRatio() {
		return (double)assists / gamesPlayed;
	}
	
	public double completePassRatio() {
		return (double)numCompletedPasses / gamesPlayed;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "\nCOMPLETED PASSES : " + numCompletedPasses + "\nASSISTS : " + assists + printLine();
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
	
	public void setAssists(int assists) {
		this.assists = assists;
	}
	
	@Override
	public double ratio() {
		return (assistRatio()*2 + completePassRatio()) / 2;
	}
	
	
}
