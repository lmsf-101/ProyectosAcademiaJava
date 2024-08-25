package stream.soccer_scouts;

public class GoalKeeper extends Player{
	
	private int numSaves;
	private int cleanSheetMatches;
	
	public GoalKeeper(String name, int age, float height) {
		super(name, age, height, Position.GK, 12000f, 0);
		numSaves = 0;
		cleanSheetMatches = 0;
	}
	
	public GoalKeeper(String name, int age, float height, int numSaves, int cleanSheetMatches, int gamesPlayed) {
		super(name, age, height, Position.GK, 12000f, gamesPlayed);
		this.numSaves = numSaves;
		this.cleanSheetMatches = cleanSheetMatches;
	}
	
	public GoalKeeper(String name, int age, float height, int numSaves, int cleanSheetMatches, float marketValue, int gamesPlayed) {
		super(name, age, height, Position.GK, marketValue, gamesPlayed);
		this.numSaves = numSaves;
		this.cleanSheetMatches = cleanSheetMatches;
	}
	
	
	
	public double cleanSheetRatio() {
		return gamesPlayed > 0 ? (double)cleanSheetMatches / gamesPlayed : 0;
	}
	
	public double savesRatio() {
		return gamesPlayed > 0 ? (double)numSaves / gamesPlayed : 0;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "\nNUMBER OF SAVES : " + numSaves + "\nNUM. OF MATCHES WITH CLEAN SHEET : " + cleanSheetMatches + printLine();
	}


	public int getNumSaves() {
		return numSaves;
	}

	public void setNumSaves(int numSaves) {
		this.numSaves = numSaves;
	}

	public int getCleanSheetMatches() {
		return cleanSheetMatches;
	}

	public void setCleanSheetMatches(int cleanSheetMatches) {
		this.cleanSheetMatches = cleanSheetMatches;
	}

	@Override
	public double ratio() {
		return (cleanSheetRatio() * 2 + savesRatio()) / 2;
	}
	
	
}
