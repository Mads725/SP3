import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    Scanner scan = new Scanner(System.in); //User input
    ArrayList<Team> joiningTeams = new ArrayList<>(); //ArrayListe på tilmeldte hold

    public void UI() {

        String userInput;

        System.out.println("Type 'create' to create a new tournament. Type 'run' to run an existing tournament. ");
        userInput = scan.nextLine();

        if (userInput.equals("create")) {

            createTournament();

        } else if (userInput.equals("run")) {

            try {
                runTournament();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void createTournament() {

        String userInput;

        System.out.println("Type the name of the tournament: ");
        userInput = scan.nextLine();

        try {
            File newTournament = new File("src/" + userInput + ".txt");
            newTournament.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File created. Please insert the teams for the tournament. ");

    }

    public void runTournament() throws FileNotFoundException {
        File file = new File("src/Teams.txt"); //Læser Teams.txt fil som indeholder de forskellige hold.
        Scanner readFile = new Scanner(file);
        boolean teamFound = false;
        int addTeamID; // Lokal variabel. Tilføj Team ID
        String[] teamValues = {""};
        String userInput;
        ArrayList<Team> participatingTeams = new ArrayList<>();

        System.out.println("Type the name of the tournament to run it. ");
        userInput = scan.nextLine();
        addTeamID = scan.nextInt();

        while (readFile.hasNextLine()) {
            teamValues = readFile.nextLine().split(","); //Læser vores txt fil, og splitter ved "."
            int teamID = Integer.parseInt(teamValues[0]); //[0] hold nr.
            if (teamID == addTeamID) {
                ArrayList<String> player = new ArrayList<>();
                player.add(teamValues[2]); //[2] spiller 1 på holdet
                player.add(teamValues[3]); //[3] spiller 2 på holdet
                Team t = new Team(teamValues[1], player); //[1] navnet på teamet
                joiningTeams.add(t);
                player.clear();
                teamFound = true;
            }
            Tournament tournament = new Knockout(userInput, participatingTeams);

        }

    }
}
