import java.util.Scanner;

/**
 * This class takes in user input to get a team's roster and each player's statistics.
 * 
 * Last update: 2/2/18 at 6:28 PM
 * @author Team Taro: Serena Ing, Nana Mimura, Jordyn Sato
 */
public class Driver {

	//Fields
	private static Player[] roster;

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
						scan.nextLine();
						continue;
					}
					stats[0] = points;
					rerunPoints = false;
				}
			} catch(Exception e) {
				System.out.println("Please enter in a valid number.");
				scan.nextLine();
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
						scan.nextLine();
						continue;
					}
					stats[1] = rebounds;
					rerunRebounds = false;
				}
			} catch(Exception e) {
				System.out.println("Please enter in a valid number.");
				scan.nextLine();
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
						scan.nextLine();
						continue;
					}
					stats[2] = assists;
					rerunAssists = false;
				}
			} catch(Exception e) {
				System.out.println("Please enter in a valid number.");
				scan.nextLine();
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
			//Gets the name for the team.
			String teamName = "";
			System.out.println("What is the team name?");
			if(scan.hasNextLine()) {
				teamName = scan.nextLine();
			}		
			
			//Asks and validates the user input on how many players are on the team.
			int maxRoster = 0;
			boolean rerunRoster = true;
			do {
				try {
					System.out.println("How many players are on the roster?");
					if(scan.hasNextLine()) {
						maxRoster = scan.nextInt();
						if(maxRoster != 6 && maxRoster != 7) {
							System.out.println("You can only have 6 or 7 players on your team, please try again.");
							scan.nextLine();
							continue;
						}
						rerunRoster = false;
						roster = new Player[maxRoster];
					}
				} catch(Exception e) {
					System.out.println("Please enter in a valid number of players.");
					scan.nextLine();
					continue;
				}
			} while(rerunRoster);
			
			//For loop that cycles through each player to get their name.
			for(int p = 0; p < maxRoster; p++) {
				System.out.printf("Please enter in player %d's name: \n", (p+1));
				String name = scan.next();
				Player player = new Player(name);
				roster[p] = player;
			}

			//For loop that cycles through each player to get stats for 3 games.
			for(Player p : roster) {
				for(int g = 0; g < 3; g++) {
					System.out.println("Please enter in the statistics of each player's game.");
					System.out.printf("Stats for game " + (g + 1) + " for %s:\n", p.getName());
					int[] stats = addStats(scan);
					p.addGame(g, stats);
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
			scan.nextLine();
		} while(rerunFlag);
		scan.close();
	}
}