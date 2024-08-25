package stream.soccer_scouts;

/*
 * STREAM EXERCISE - WEEK 2
 * Created by: Luis Miguel Sánchez Flores
 * 
 */


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {

	public static void main(String[] args) {
		
		// Generate the different scouting lists for the project:
		
		List<Player> scoutList1 = List.of(
				
				new GoalKeeper("Dida", 18, 1.90f, 105, 21, 25000f, 68),
				new Defender("Lucas", 17, 1.78f, 24, 17, 12),
				new Striker("Rafael", 19, 1.83f, 18, 50, 25000f, 34),
				new GoalKeeper("Valdes", 18, 1.85f, 80, 2, 20000f, 14),
				new Defender("Cameron", 19, 1.80f, 40, 22, 12000f, 25),
				new MidFielder("Kone", 16, 1.70f, 35, 4, 40)
				);
		
		List<Player> scoutList2 = List.of(
				
				new MidFielder("Liam", 25, 1.90f, 78, 63, 100000f, 223),
				new GoalKeeper("Logan", 28, 1.91f, 290, 84, 70000f, 366),
				new Defender("Alex", 24, 1.71f, 80, 67, 50000f, 190),
				new Striker("Adam", 25, 1.73f, 188, 234, 300000f, 312),
				new Striker("Al-Farsi", 31, 1.91f, 145, 429, 100000f, 530),
				new GoalKeeper("Leo", 32, 1.83f, 412, 102, 130000f, 390),
				new MidFielder("Stefano", 26, 1.80f, 278, 145, 90000f, 402)
		);
		
		List<Player> scoutList3 = List.of(
				
				new Defender("Joseph", 23, 1.68f, 59, 100, 120000f, 115),
				new Striker("Jamal", 28, 1.78f, 132, 225, 95000f, 286),
				new MidFielder("Jorginho", 32, 1.78f, 453, 233, 180000f, 489),
				new GoalKeeper("Zane", 24, 1.89f, 145, 24, 85000f, 108),
				new Striker("Omar", 20, 1.88f, 68, 152, 100000f, 108),
				new Striker("Garcia", 29, 1.76f, 105, 289, 110000f, 175),
				new MidFielder("Luis", 22, 1.87f, 203, 54, 150000f, 97),
				new Defender("Ronaldo", 25, 1.88f, 191, 360, 90000f, 273)
		);
		
		// 1. COMBINE ALL THE SCOUTING LISTS INTO ONE
		// 2. FILTER OUT THE PLAYERS THAT HAVE PLAYED LESS THAN 30 GAMES, AND HAVE A PERFORMANCE RATIO LESS THAN 0.75
		// 3. PRIORITIZE THE YOUNGER PLAYERS
		// 4. LEAVE OUT THE YOUNGEST PLAYER OF THE LIST
		// 5. LIMIT THE LIST TO THE TOP 10 IDEAL PLAYERS
		
		// Concatenate the scouting lists...
		Stream<List<Player>> listsOfPlayers = Stream.of(scoutList1, scoutList2, scoutList3);
	
		List<Player> optimalPlayers = listsOfPlayers.flatMap(l -> l.stream()) // Join each scouting list into a single one...
					.filter(plr -> plr.getGamesPlayed() >= 30 && plr.ratio() >= 0.75) // Filter out players based on the coach's criteria
					.sorted((p1, p2) -> p1.getAge() - p2.getAge()) // Sort the players by their age, in a ascending order
					.skip(1) // Skip the youngest player of the list
					.limit(10) // Retrieve only the top 10 players
					.collect(Collectors.toList()); // Transform the Stream into a List we can use later....
		

		// Print out the optimal players for the team!
		System.out.println("CANDIDATE PLAYERS : \n");
		optimalPlayers.forEach(System.out::println);
		
		
		System.out.println("\n\n\n");
		
		// 1. CONSIDER ONLY STRIKERS
		// 2. MUST HAVE A MARKET VALUE LESS-EQUAL THAN $110000
		// 3. REMOVE THE OLDEST STRIKER AVAILABLE
		// 4. PRIORITIZE GOALS
		// 5. LIMIT THE LIST TOP 3 PLAYERS (IF AVAILABLE)
		
		// Retrieve the best striker available from the top 3 (if applicable).
		
		// ----------------------------------------------

										// Transform the List of Players into a Stream
		 Optional<Striker> bestStriker = optimalPlayers.stream()
				 							// Remove players that don't belong in a Striker role.
											.filter(player -> Position.isStriker(player))
											// Cast the Player objects into Striker objects, as there are only strikers available on the stream as this point.
											.map(Striker.class::cast)
											// Remove the strikers who have a market value over $110,000
											.filter(strkr -> strkr.getMarketValue() <= 110000f)
											// Order the players by their age in a descending order...
											.sorted((s1, s2) -> s2.getAge() - s1.getAge())
											// ....then discard the oldest striker from the list.
											.skip(1)
											// Order the players again, but by their total number of goals, in a descending order...
											.sorted((s1, s2) -> s2.getNumberOfGoals() - s1.getNumberOfGoals())
											// Limit the list to only the top 3 strikers.
											.limit(3)
											// Retrieve the best matching striker (if there are any...): 
											.findFirst();
		
		 
		 // Print the best striker the Stream was able to find. If not, tell the bad news....
		 bestStriker.ifPresentOrElse(
			s -> System.out.println("\n----------BEST STRIKER AVAILABLE : -----------\n" + s),
			
			() -> System.err.println("There are no available strikers that meet the criteria....")
		);

	}

}
