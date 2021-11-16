import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Io {

    public boolean createNewTournamentFile(String name, int year, int day, int month, int gameTime) {
        try {
            File createNewTournament = new File("src/" + name + ".txt");
            BufferedWriter writeOut = new BufferedWriter(new FileWriter(createNewTournament));
            writeOut.write("The tournament " + name + " starts on: " + year + "-" + day + "-" + month + "-" + gameTime);
            writeOut.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }

    public static void startTheTournament(String name) {
        try {
            File file = new File("scr/" + name + ".txt");
            Scanner readFile = new Scanner(file);

            while (readFile.hasNextLine()) {
                String[] teamValues = readFile.nextLine().split(",");
                ArrayList<Player> player = new ArrayList<>();
                Player player1 = new Player(teamValues[2]);
                Player player2 = new Player(teamValues[3]);
                player.add(player1);
                player.add(player2);

                Team t = new Team(teamValues[1], player); // Creates a team with a team name and an array of players
                Main.control.participatingTeams.add(t);
                player.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
