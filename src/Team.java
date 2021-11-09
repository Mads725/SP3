import java.util.ArrayList;

public class Team {
    private final String teamName;
    private int totalMålScore;
    private ArrayList<Player> players = new ArrayList<>();

    public Team(String teamName, ArrayList<Player> playersIn) {
        this.teamName = teamName;

        for (Player p : playersIn) {
            players.add(p);
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public String toString() {
        return "Team " + teamName +  " - Players : " + players;
    }

}
