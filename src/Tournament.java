import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

abstract class Tournament {


    private String TournamentName;
    private String tournamentWinner;
    private int tournamentStartTime;
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    public Tournament(String tournamentName, ArrayList<Team> teams) {
        this.TournamentName = tournamentName;
        this.teams = teams;
    }

    public abstract void runTournament();

    public void shuffleTeams() {

        Collections.shuffle(teams);

    }

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

    public String getTournamentName() {
        return TournamentName;
    }

    public int getTournamentStartTime() {
        return tournamentStartTime;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    @Override
    public String toString() {
        String s = "";
        return s;
    }
}
