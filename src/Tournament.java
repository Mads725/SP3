import java.util.ArrayList;

abstract public class Tournament {

    private final String TournamentName;
    private Team tournamentWinner;
    private int tournamentStartTime; //useless
    private ArrayList<Team> teams;
    private ArrayList<Match> matches; //useless
    protected Bracket connectedBracket;

    public Tournament(String tournamentName, ArrayList<Team> teams) {
        TournamentName = tournamentName;
        this.teams = teams;
    }

    public String getTournamentName() {
        return TournamentName;
    }

    public Team getTournamentWinner() {
        return tournamentWinner;
    }

    public void setTournamentWinner(Team tournamentWinner) {
        this.tournamentWinner = tournamentWinner;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public abstract void runTournament();

}
