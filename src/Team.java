/**
 * 
<<<<<<< HEAD
 * @author Team Taro: Serena Ing, Nana Mimura, Jordyn Sato
=======
 * @author Taro: Serena Ing, Nana Mimura, Jordyn Sato
>>>>>>> 56f1028b63025f53b90742bf947b015d88e8133a
 * This class defines the Team
 * We have the team name as well as the players on the team listed in an array.
 * This class also calculates the average team player's points, rebounds, and assists.
 */
public class Team {
	/* 
	 * These are the private instance fields.
	 */
	private Player[] players;
	private String name;
	private int teamSize = 0;
	private double teamAvgPts, teamAvgReb, teamAvgAst;
	/*
	 * This is the constructor for Team
	 */
	public Team(Player[]play, String nam) {
		name = nam;
		teamSize = play.length;
		players = new Player[teamSize];
		teamAvgPts = 0.0;
		teamAvgReb = 0.0;
		teamAvgAst = 0.0;
	}
	/*These are the accessor and mutator methods for the instance fields
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String nam) {
		name = nam;
	}
	
	public int getTeamSize(){
		return teamSize;
	}
	
	public void setTeamSize(int num) {
		teamSize = num;
		//creating a new array for the new size
		Player[]temp = new Player[teamSize];
		//copying from old array to the new array
		for(int i = 0; i < players.length; i++) {
			temp[i] = players[i];
		}
		//changing array address to new array with more player space
		players = temp;	
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void setPlayers(Player[]play) {
		if (play.length == players.length) {
			Player temp;
			for (int i = 0; i < play.length; i++) {
				temp = new Player(play[i]);
				players[i] = temp;
			}
		}//end if
		else {
			System.out.println("Please check your roster size.");
		}
			
	}//end setPlayers
	
	/*
	 * Team average for points mutator/access methods
	 * calculations are done inside the mutator method
	 */
	public void setAvgPts() {
		double teamAvgPts = 0;
		for(int i = 0; i < players.length; i++) {
			teamAvgPts+=players[i].getPlayerAvgPts();
		}
		teamAvgPts/=players.length;
		System.out.println(teamAvgPts);
		
	}
	
	public double getTeamAvgPts() {
		setAvgPts();
		return teamAvgPts;
	}
	
	/*
	 * Team average for rebounds mutator/access methods
	 * calculations are done inside the mutator
	 */
	public void setAvgReb() {
		double teamAvgReb = 0;
		for(int i = 0; i < players.length; i++) {
			teamAvgReb+=players[i].getPlayerAvgReb();
		}
		teamAvgReb/=players.length;
		System.out.println(teamAvgReb);
	}
	
	public double getTeamAvgReb() {
		setAvgReb();
		return teamAvgReb;
	}
	/*
	 * Team average for assists mutator/access methods
	 * calculations are done inside the mutator
	 */
	public void setAvgAst() {
		double teamAvgAst = 0;
		for(int i = 0; i < players.length; i++) {
			teamAvgAst+=players[i].getPlayerAvgAst();
		}
		teamAvgAst/=players.length;
		System.out.println(teamAvgAst);
	}
	
	public double getTeamAvgAst() {
		setAvgAst();
		return teamAvgAst;
	}
	
	/*
	 * toString method for Team
	 */

	public String toString() {
		setAvgPts();
		setAvgReb();
		setAvgAst();
		String toString = "";
		toString += "Team: "+ name + "\nTeam Size: "+ teamSize + "\nTeam Averages: \n\tPts: "
				+ teamAvgPts +"\n\tReb: " + teamAvgReb + "\n\tAst: "
				+teamAvgAst +"\n";
		//for (int i = 0; i< players.length; i++) {
			//toString += players[i].toString() + "\n";
		//}
			return toString;
	}
}//end Team
