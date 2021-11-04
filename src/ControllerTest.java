import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerTest {

    boolean tournamentFull = false;
    Scanner scan = new Scanner(System.in); //User input
    ArrayList<Team> joiningTeams = new ArrayList<>(); //ArrayListe på tilmeldte hold

    public void UI() {

        String userInput;


        System.out.print("Type 'run' to run a tournament. Type 'create' to create a tournament. ");

        userInput = scan.nextLine();

        if (userInput.equals("run")) { //Hvis igangværende turnering, kør videre på turneringen
            runTournament();
        } else if (userInput.equals("create")) { //hvis ingen igangværende turnering, lav en ny turnering
            createTournament();
        }

        System.out.println("TestControllerDone");
    }

    public void createTournament()  {

        String tournamentName; // Turneringsnavn
        String userInput; //

        System.out.print("Type tournament name: "); // User input. Bruger skal taste ind, hvilken turnering de deltager i(Turneringens navn)
        tournamentName = scan.nextLine();

        System.out.print("Type 'knockout' for Knockout tournament. Type 'group' for Group tournament. ");
        userInput = scan.nextLine();

        if (userInput.equals("knockout")) { //Tilføj Team hvis bruger input er "knockout"

            System.out.println(tournamentFull);
            while (tournamentFull == false) {
                System.out.println("call 'addTeam()'");
                try {
                    addTeam();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("tournamentfull true out");

            Knockout tournament = new Knockout(tournamentName, joiningTeams);
            joiningTeams.clear();

        } else if (userInput.equals("group")) { // Hvis der skal udvides med gruppespil

        }

    }

    public void addTeam() throws FileNotFoundException {

        File file = new File("src/Teams.txt"); //Læser Teams.txt fil som indeholder de forskellige hold.
        Scanner readFile = new Scanner(file);
        int addTeamID; // Lokal variabel. Tilføj Team ID
        String userInput;
        boolean teamFound = false;
        String[] teamValues = {""};


        System.out.print("Type team ID to add team: ");
        addTeamID = scan.nextInt();

        while (readFile.hasNextLine()) {
            teamValues = readFile.nextLine().split(","); //Læser vores txt fil, og splitter ved "."
            int teamID = Integer.parseInt(teamValues[0]); //[0] hold nr.

            if (teamID == addTeamID) {
                ArrayList<String> player = new ArrayList<>();
                player.add(teamValues[2]); //[2] spiller 1 på holdet
                player.add(teamValues[3]); //[3] spiller 2 på holdet
                Team t = new Team(teamValues[1],player); //[1] navnet på teamet
                joiningTeams.add(t);
                player.clear();
                teamFound = true;
            }
        }

        if (teamFound == false) {
            System.out.println("Team not found try again.");
        } else {
            System.out.print("Team added. Type 'add' to add more teams. Type 'done' to complete the tournament creation.");

            userInput = scan.nextLine();

            if (userInput.equals("done")) {
                tournamentFull = true;
            } else {

            }
        }
        System.out.println(tournamentFull);
    }

    public void createTeam() {

    }

    public void runTournament() {

    }
}
