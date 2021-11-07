import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<Player> players;

    public Team(String teamName, ArrayList<Player> players) {
        this.teamName = teamName;
        this.players = players;
        //System.out.println(players);
        System.out.println(this.players);
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


    @Override
    public String toString() {
        String s = "Team " + teamName +  " - Players : " + players;
        return s;
        //TODO kan ikke få toString til at sige player navne ^
    }

}
