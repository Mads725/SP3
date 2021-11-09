import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Tournament {

    private final String TournamentName;
    private Team tournamentWinner;
    private int tournamentStartTime; //useless
    private ArrayList<Team> teams;
    private ArrayList<Match> matches; //useless
    protected Bracket connectedBracket;

    public Tournament(String tournamentName, ArrayList<Team> teams) {
        this.TournamentName = tournamentName;
        this.teams = teams;
    }

    public abstract void runTournament();
/*
    private void saveTournamentData() { // Gemmer turneringsdata i en txt fil
        String tournamentData = "";

        for (Match m : matches) {
            tournamentData += m;
        }
        try {
            FileWriter writer = new FileWriter("src/TournamentData.txt");
            writer.write(tournamentData);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTournamentData() throws FileNotFoundException {
        File file = new File("src/MatchData.txt");
        Scanner scan = null;
        scan = new Scanner(file);

    }
*/
    public Team getTournamentWinner() {
        return tournamentWinner;
    }

    public void setTournamentWinner(Team tournamentWinner) {
        this.tournamentWinner = tournamentWinner;
    }

    public String getTournamentName() {
        return TournamentName;
    }

    public int getTournamentStartTime() {
        return tournamentStartTime;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

}
