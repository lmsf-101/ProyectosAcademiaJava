package stream.soccer_scouts;

public class Striker extends Player{
	
	private int numberOfGoals;
	private int shotsOnTarget;
	
	public Striker(String name, int age, float height, int numberOfGoals, int shotsOnTarget) {
		super(name, age, height, Position.getRandomStrikerPosition(), 20000f, 0);
		this.numberOfGoals = numberOfGoals;
		this.shotsOnTarget = shotsOnTarget;
	}
	
	public Striker(String name, int age, float height, int numberOfGoals, int shotsOnTarget, int gamesPlayed) {
		super(name, age, height, Position.getRandomStrikerPosition(), 20000f, gamesPlayed);
		this.numberOfGoals = numberOfGoals;
		this.shotsOnTarget = shotsOnTarget;
	}

	public Striker(String name, int age, float height, int numberOfGoals, int shotsOnTarget, float marketValue, int gamesPlayed) {
		super(name, age, height, Position.getRandomStrikerPosition(), marketValue, gamesPlayed);
		this.numberOfGoals = numberOfGoals;
		this.shotsOnTarget = shotsOnTarget;
	}
	
	
	public double getGoalsRatio() {
		return gamesPlayed > 0 ? (double)numberOfGoals / gamesPlayed : 0;
	}
	
	public double getTargetRatio() {
		return gamesPlayed > 0 ? (double)shotsOnTarget / gamesPlayed : 0;
	}
	
	
	public int getNumberOfGoals() {
		return numberOfGoals;
	}

	public void setNumberOfGoals(int numberOfGoals) {
		this.numberOfGoals = numberOfGoals;
	}

	public int getShotsOnTarget() {
		return shotsOnTarget;
	}

	public void setShotsOnTarget(int shotsOnTarget) {
		this.shotsOnTarget = shotsOnTarget;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nGOALS : " + numberOfGoals + "\nSHOTS ON TARGET : " + shotsOnTarget + printLine();
	}

	@Override
	public double ratio() {
		
		return (getGoalsRatio() * 2 + getTargetRatio()) / 2;
	}
	
	
	

}
