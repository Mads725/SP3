import java.util.ArrayList;

public class Team {
    private String teamName;
    ArrayList<String> playerNames;
    ArrayList<Player> players = new ArrayList<Player>();


    public Team(String teamName, ArrayList playerName) {
        this.teamName = teamName;
        this.playerNames = playerName;
    }

    public void addPlayer(Player player) {
        players.add(player);

    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void joinTournament() {

    }

    public void leaveTournament() {

    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList getPlayerName() {
        return playerNames;
    }

    @Override
    public String toString() {
        String s = "Team : " + teamName + "\n" + "Players : " + playerNames;
        return s;
    }

}
