/**
 * 
 * @author Team Taro: Serena Ing, Nana Mimura, Jordyn Sato
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
		setPlayers(play);
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
	
	public Player getPlayerAtPos(int index) {
		if ( index <= teamSize && index>0) {
			index-=1;
			return players[index];
		}
		else 
			return players[0];
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
	public double getTeamAvgPts() {
		teamAvgPts = 0;
		for(int i = 0; i < players.length; i++) {
			teamAvgPts+=players[i].getPlayerAvgPts();
		}
		teamAvgPts/=players.length;
		teamAvgPts = (Math.round(teamAvgPts*100))/100.0;
		return teamAvgPts;
		
	}
	
	/*calculations are done in the accessor methods
	 */
	public double getTeamAvgReb() {
		teamAvgReb = 0;
		for(int i = 0; i < players.length; i++) {
			teamAvgReb+=players[i].getPlayerAvgReb();
		}
		teamAvgReb/=players.length;
		teamAvgReb = (Math.round(teamAvgReb*100))/100.0;
		return teamAvgReb;
	}
	
	public double getTeamAvgAst() {
		teamAvgAst = 0;
		for(int i = 0; i < players.length; i++) {
			teamAvgAst+=players[i].getPlayerAvgAst();
		}
		teamAvgAst/=players.length;
		teamAvgAst = (Math.round(teamAvgAst*100.0))/100.0;
		return teamAvgAst;
	}
	
	
	/*
	 * toString method for Team
	 */
	public String toString() {
		String toString = "";
		toString += "Team: "+ name + "\nTeam Size: "+ teamSize + "\nTeam Averages: \n\tPts: "
				+ getTeamAvgPts() +"\n\tReb: " + getTeamAvgReb() + "\n\tAst: "
				+ getTeamAvgAst() +"\n";
		for (int i = 0; i< players.length; i++) {
			toString += players[i].toString() + "\n";
		}
		
			return toString;
	}
}//end Team
