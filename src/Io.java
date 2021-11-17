import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Io {

    private static ArrayList<Team> participatingTeams = new ArrayList<>();

    public static boolean createNewTournamentFile(String name, int year, int day, int month, int gameTime) { // Creates new file with the name of the tournament
        try {
            File createNewTournament = new File("src/" + name + ".txt");
            BufferedWriter writeOut = new BufferedWriter(new FileWriter(createNewTournament));
            writeOut.write("The tournament " + name + " starts on: " + year + "-" + day + "-" + month + "-" + gameTime); // first line in the file is the tournament start time and date
            writeOut.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }

    public static void startTheTournament(String tournamentName) {  // Reads the team data from either the database or the tournament file

        participatingTeams.clear(); //Maybe?

        if (Final.READ_LOCATION == "DATABASE") {

            DBConnector DB = new DBConnector();
            String[] temp = DB.readTeamsData();

            for (String s : temp) {

                String[] teamValues = s.split(",");
                ArrayList<Player> player = new ArrayList<>();
                Player player1 = new Player(teamValues[1]);
                Player player2 = new Player(teamValues[2]);
                player.add(player1);
                player.add(player2);

                Team t = new Team(teamValues[0],player); // Creates a team with a team name and an array of players
                participatingTeams.add(t);
                player.clear();
            }

            Tournament tournament = new Knockout(tournamentName, participatingTeams); // starts the tournament
            tournament.runTournament();

        } else {
            try {
                File file = new File("src/" + tournamentName + ".txt");
                Scanner readFile = new Scanner(file);

                readFile.nextLine(); // Skips the tournament date line

                while (readFile.hasNextLine()) {
                    String[] teamValues = readFile.nextLine().split(",");
                    ArrayList<Player> player = new ArrayList<>();
                    Player player1 = new Player(teamValues[1]);
                    Player player2 = new Player(teamValues[2]);
                    player.add(player1);
                    player.add(player2);

                    Team t = new Team(teamValues[0], player); // Creates a team with a team name and an array of players
                    participatingTeams.add(t);
                    player.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Tournament tournament = new Knockout(tournamentName, participatingTeams); // starts the tournament
            tournament.runTournament();

        }
    }
}
