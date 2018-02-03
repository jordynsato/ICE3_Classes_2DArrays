import java.util.Scanner;

/**
 * This class takes in user input to get a team's roster and each player's statistics.
 * 
 * Last update: 2/2/18 at 3:33 PM
 *
 */
public class Driver {

	//Fields
	private static Player[] roster;
	
	/**
	 * This method adds a player to the roster.
	 * 
	 * @param scan A Scanner that will be used to print to the console.
	 */
	public static void addPlayer(Scanner scan, int index) {
		String name;
		System.out.println("Please enter in the name of the player: ");
		name = scan.nextLine();
		Player p = new Player(name);
		roster[index] = p;
	}
	
	/**
	 * This method returns an int array of statistics for one player's game by asking for user input on points,
	 * rebounds, and assists.
	 * 
	 * @param scan A Scanner that will be used to print to the console.
	 * @return An int array of statistics for one player's game.
	 */
	public static int[] addStats(Scanner scan) {
		int[] stats = new int[3];
		boolean rerunPoints = true;
		boolean rerunRebounds = true;
		boolean rerunAssists = true;
		
		//Checking for user input on points
		do {
			System.out.println("Points: ");
			try {
				int points = 0;
				if(scan.hasNextLine()) {
					points = scan.nextInt();
					if(points < 0) {
						System.out.println("A player can't have negative points!");
						scan.next();
						continue;
					}
					stats[0] = points;
					rerunPoints = false;
				}
			} catch(Exception e) {
				System.out.println("Please enter in a valid number.");
				scan.next();
				continue;
			}
		} while(rerunPoints);
		
		//Checking for user input on rebounds
		do {
			System.out.println("Rebounds: ");
			try {
				int rebounds = 0;
				if(scan.hasNextLine()) {
					rebounds = scan.nextInt();
					if(rebounds < 0) {
						System.out.println("A player can't have negative rebounds!");
						scan.next();
						continue;
					}
					stats[1] = rebounds;
					rerunRebounds = false;
				}
			} catch(Exception e) {
				System.out.println("Please enter in a valid number.");
				scan.next();
				continue;
			}
		} while(rerunRebounds);
		
		//Checking for user input on assists
		do {
			System.out.println("Assists: ");
			try {
				int assists = 0;
				if(scan.hasNextLine()) {
					assists = scan.nextInt();
					if(assists < 0) {
						System.out.println("A player can't have negative assists!");
						scan.next();
						continue;
					}
					stats[2] = assists;
					rerunAssists = false;
				}
			} catch(Exception e) {
				System.out.println("Please enter in a valid number.");
				scan.next();
				continue;
			}
		} while(rerunAssists);
		
		return stats;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean rerunFlag = true;
		Team t;
		System.out.println("Welcome to MaxPreps!");
		
		do {
			int maxRoster = 0;
			
			//Gets the name for the team.
			System.out.println("What is the team name?");
			String teamName = scan.next();
			
			//Asks and validates the user input on how many players are on the team.
			System.out.println("How many players are on the roster?");
			try {
				if(scan.hasNextLine()) {
					maxRoster = scan.nextInt();
					if(maxRoster != 6 && maxRoster != 7) {
						System.out.println("You can only have 6 or 7 players on your team, please try again.");
						scan.next();
						continue;
					}
					roster = new Player[maxRoster];
				}
			} catch(Exception e) {
				System.out.println("Please enter in a valid number of players.");
				scan.next();
				continue;
			}
			
			//First for loop that cycles through each player to get their name.
			for(int p = 0; p < maxRoster; p++) {
				addPlayer(scan, p);
				//Second inner for loop that cycles through 3 games to add to each player for stats.
				for(int g = 0; g < 3; g++) {
					System.out.println("Please enter in the statistics for each player for the next 3 games.");
					roster[p].addGame(g, addStats(scan));
				}
			}
			t = new Team(roster, teamName);
			
			//Prints out each player's and team's statistics.
			System.out.println(t.toString());
			
			//Checks to see if the user wants to rerun the program with a new team.
			System.out.println("Would you like to make another team? (Y/N)");
			String response = scan.next();
			if(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("Yes")) {
				rerunFlag = false;
				System.out.println("Thank you for using this program!");
			}
		} while(rerunFlag);
		scan.close();
	}
}