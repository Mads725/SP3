import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Tournament {


    private String name;
    private String tournamentWinner;
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    public Tournament(String name, ArrayList<Team> teams) {
        this.name = name;
        this.teams = teams;
    }

    public void createBracket() {

    }

    public void cancelBracket() {

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

    public abstract void runTournament();


    @Override
    public String toString() {
        String s = "";
        return s;
    }
}
