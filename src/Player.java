/**
 * The Player class creates a Player object and its methods to be used in the Driver and Team classes.
 * 
 * @author nana_
 * @since 2/2/18 4:00pm
 */
public class Player {

	private int[][] stats;
	private String name;
	private double playerAvgPoints, playerAvgReb, playerAvgAst;
	
	private static final double NUM_OF_GAMES = 3.0;
	private static final int PTS_COL = 0, REB_COL = 1, AST_COL = 2, GAME_1 = 0, GAME_2 = 1, GAME_3 = 2;
	
	/**
	 * The default constructor for a Player object that sets the Player's name to an empty String and the Player's
	 * statistics to an empty 3x3 2D array to hold the Player's statistics.
	 */
	public Player() {
		name = "";
		stats = new int[3][3];
	}
	
	/**
	 * A constructor for a Player object that creates a new Player with a name and an empty 3x3 2D array to hold the
	 * Player's statistics.
	 * @param name what the Player's name will be
	 */
	public Player(String name) {
		this.name = name;
		stats = new int[3][3];
	}
	
	/**
	 * A constructor for a Player object that creates a new Player with a name and a 3x3 2D array with statistics from 3
	 * games.
	 * @param name what the Player's name will be
	 * @param stats the Player's statistics from 3 game
	 */
	public Player (String name, int[][] stats) {
		this.name = name;
		this.stats = stats;
	}
	
	/**
	 * This is a copy constructor that creates a new Player object with the same attributes as another Player object
	 * @param aPlayer the Player whose attributes are going to be copied into the new Player
	 */
	public Player(Player aPlayer) {
		this(aPlayer.getName(), aPlayer.getStats());
	}
	
	/**
	 * This method returns the Player's name.
	 * @return the name of the Player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the Player's statistics that have accumulated over 3 games.
	 * @return the Player's statistics from 3 games
	 */
	public int[][] getStats() {
		return stats;
	}
	
	/**
	 * This method calculates the Player's average points from 3 games and returns this statistic as a double.
	 * @return the sum of the points the Player made during game 1, game 2, and game 3 divided by 3.0 (the number of games
	 * 			played)
	 */
	public double getPlayerAvgPts() {
		playerAvgPoints = (stats[GAME_1][PTS_COL] + stats[GAME_2][PTS_COL] + stats[GAME_3][PTS_COL]) / NUM_OF_GAMES;
		return playerAvgPoints;
	}
	
	/**
	 * This method calculates the Player's average rebounds from 3 games and returns this statistic as a double.
	 * @return the sum of the rebounds the Player made during game 1, game 2, and game 3 divided by 3.0 (the number of
	 * 			games played)
	 */
	public double getPlayerAvgReb() {
		playerAvgReb = (stats[GAME_1][REB_COL] + stats[GAME_2][REB_COL] + stats[GAME_3][REB_COL]) / NUM_OF_GAMES;
		return playerAvgReb;
	}
	
	/**
	 * This method calculates the Player's average assists from 3 games and returns this statistic as a double.
	 * @return the sum of the assists the Player made during game 1, game 2, and game 3 divided by 3.0 (the number of games
	 * 			played)
	 */
	public double getPlayerAvgAst() {
		playerAvgAst = (stats[GAME_1][AST_COL] + stats[GAME_2][AST_COL] + stats[GAME_3][AST_COL]) / NUM_OF_GAMES;
		return playerAvgAst;
	}
	
	
	/**
	 * This method adds another game's worth of statistics into the player's overall statistics.
	 * @param gameNumber which game number (out of 3 games) that the statistics are coming from
	 * @param gameStats the Player's statistics for one game
	 */
	public void addGame(int gameNumber, int[] gameStats) {
		stats[gameNumber][PTS_COL] = gameStats[0];
		stats[gameNumber][REB_COL] = gameStats[1];
		stats[gameNumber][AST_COL] = gameStats[2];
	}
	
	/**
	 * This method returns a String that contains the Player's name and the average points, rebounds, and assists made
	 * during the 3 games.
	 */
	public String toString() {
		return name + " has made an average of " + getPlayerAvgPts() + " points, " + getPlayerAvgReb() + " rebounds, and " +
				getPlayerAvgAst() + " assists.";
	}
}
