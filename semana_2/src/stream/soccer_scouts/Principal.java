package stream.soccer_scouts;

import java.util.List;
import java.util.stream.Stream;

public class Principal {

	public static void main(String[] args) {
		
		List<Player> scoutList1 = List.of(
				
				new GoalKeeper("Dida", 20, 1.90f, 105, 21, 25000f, 68),
				new Defender("Lucas", 17, 1.78f, 24, 17, 12),
				new GoalKeeper("Valdes", 18, 1.85f, 80, 2, 20000f, 14),
				new Defender("Cameron", 19, 1.80f, 40, 22, 12000f, 25)
				);
		
		List<Player> scoutList2 = List.of(
				
				new Defender("Liam", 25, 1.90f, 78, 134, 100000f, 223),
				new GoalKeeper("Logan", 28, 1.91f, 290, 84, 70000f, 366),
				new Defender("Alex", 24, 1.71f, 80, 67, 50000f, 190),
				new GoalKeeper("Leo", 32, 1.83f, 412, 102, 130000f, 390),
				new Defender("Petrov", 18, 1.88f, 23, 52, 32)
				);
		
		
		Stream<List<Player>> listsOfPlayers = Stream.of(scoutList1, scoutList2);
		
		/*
		Stream<Player> singleList = listsOfPlayers.flatMap(l -> l.stream());
		
		
		
		Stream<Player> filterList = singleList.filter(plr -> plr.getMarketValue() <= 80000f);
		
		Stream<Player> ppek = filterList.peek(p -> System.out.println(p.getName() + "'s Performance's Ratio : " + p.ratio()));
		
		Stream<Player> filter2 = ppek.filter(plr -> plr.getGamesPlayed() >= 30 && plr.ratio() >= 0.25);
		
		Stream<Player> sorte = filter2.sorted((p1, p2) -> p1.getAge() - p2.getAge());
		
		Stream<Player> end = sorte.skip(2);
		
		end.forEach(c -> System.out.println("\nCANDIDATE: \n" + c));
		*/
		
		
		listsOfPlayers.flatMap(l -> l.stream())
					.filter(plr -> plr.getMarketValue() <= 80000f)
					.filter(plr -> plr.getGamesPlayed() >= 30 && plr.ratio() >= 0.25)
					.sorted((p1, p2) -> p1.getAge() - p2.getAge())
					.skip(2)
					.forEach(c -> System.out.println("\nCANDIDATE : \n" + c));
		
		
		//sorte.forEach(System.out::println);
		
		
		//filter2.forEach(System.out::println);
		
		//filterList.forEach(p -> System.out.println("YES"));
		
		
		//optimalPlayers.forEach(System.outprintln);
		

	}

}
