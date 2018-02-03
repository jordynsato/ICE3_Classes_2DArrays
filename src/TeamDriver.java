
public class TeamDriver {
	public static void main (String[]args) {
		int teamSize = 3;
		Player nana = new Player("Nana");
		Player jordyn = new Player("Jordyn");
		Player serena = new Player("Serena");
		
		System.out.println(nana.toString());
		int[]game1 = {9,3,4};
		int[]game2 = {2,3,4};
		int[]game3 = {2,3,4};
		
		jordyn.addGame(0,game1);
		jordyn.addGame(1,game2);
		jordyn.addGame(2,game3);
		System.out.println("Jordyn points: " + jordyn.getPlayerAvgPts());
		System.out.println(jordyn.toString());
		
		int[]game4 = {9,3,4};
		int[]game5 = {0,0,0};
		int[]game6 = {5, 6, 7};
		serena.addGame(0, game4);
		serena.addGame(1, game5);
		serena.addGame(2, game6);
		
		Player[]roster = {nana, jordyn, serena};
		Team taro = new Team (roster, "Taro");
		System.out.println(taro.getPlayerAtPos(2));
		System.out.println(taro.toString());
		
		System.out.println(taro.toString());
	}
}
