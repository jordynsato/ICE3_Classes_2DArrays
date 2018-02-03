
public class TeamDriver {
	public static void main (String[]args) {
		int teamSize = 2;
		Player nana = new Player("Nana");
		Player jordyn = new Player("Jordyn");
		
		System.out.println(nana.toString());
		int[]game1 = {9,3,4};
		int[]game2 = {2,3,4};
		int[]game3 = {2,3,4};
		
		jordyn.addGame(0,game1);
		jordyn.addGame(1,game2);
		jordyn.addGame(2,game3);
		System.out.println(jordyn.getPlayerAvgPts());
		System.out.println(jordyn.toString());
		Player[]roster = {nana, jordyn};
		Team taro = new Team (roster, "Taro");
		
		//taro.toString();
	}
}
