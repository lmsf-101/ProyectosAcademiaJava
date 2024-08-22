package stream.soccer_scouts;

public class GoalKeeper extends Player{
	
	int numSaves;
	int cleanSheetMatches;

	public GoalKeeper(String name, short age, int gamesPlayed) {
		super(name, age, Position.GK, gamesPlayed);
		numSaves = 0;
		cleanSheetMatches = 0;
	}
	
	public GoalKeeper(String name, short age, int gamesPlayed, int numSaves, int cleanSheetMatches) {
		super(name, age, Position.GK, gamesPlayed);
		this.numSaves = 0;
		this.cleanSheetMatches = 0;
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
	
	
}
