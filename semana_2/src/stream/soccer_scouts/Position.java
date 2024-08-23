package stream.soccer_scouts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Position {
	GK, LB, CB, RB, LM, CM, RM, LW, RW, CF, ST;
	
	private static final Position[] VALUES = values();
	
	
	static Position getRandomPosition(int min, int max) {
		List<Position> positions = Arrays.asList(VALUES);
		
		List<Position> subset = positions.subList(min, max+1);
		
		Collections.shuffle(subset);
		
		return subset.get(0);
	}
	
	static Position getRandomDefenderPosition() {
		return getRandomPosition(1, 3);
	}
	
	static Position getRandomMidfielderPosition() {
		return getRandomPosition(4, 6);
	}
	
	static Position getRandomStrikerPosition() {
		return getRandomPosition(7, 10);
	}
}
