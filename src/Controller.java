import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private final static int CURRENT_YEAR = 2021;
    private final static int TOURNAMENT_START_TIME = 1000;
    Scanner scan = new Scanner(System.in); //User input
    ArrayList<Team> participatingTeams = new ArrayList<>();//ArrayListe på tilmeldte hold
    String tournamentName;

    public void UI() {

        String userInput;

        System.out.println("Type 'create' to create a new tournament. Type 'run' to run an existing tournament. ");
        userInput = scan.nextLine();

        if (userInput.equals("create")) {

            createTournament();

        } else if (userInput.equals("run")) {

            startTournament();

        }

        //TODO Add new team

    }

    public void createTournament() {

        String userInput;
        int userInputDate;
        int userInputMonth;

        System.out.println("Type the name of the tournament: ");
        userInput = scan.nextLine();
/*
        try {
            File newTournament = new File("src/" + userInput + ".txt");
            newTournament.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        System.out.println("Type the day of the tournament. ");
        userInputDate = scan.nextInt();
        System.out.println("Type the month of the tournament. ");
        userInputMonth = scan.nextInt();

        //LocalDate.of(CURRENT_YEAR,userInputMonth,userInputDate);

        try {
            File newTournament = new File("src/" + userInput + ".txt");
            BufferedWriter writeOut = new BufferedWriter(new FileWriter(newTournament));
            writeOut.write("The tournament "+userInput+" starts "+CURRENT_YEAR+"-"+userInputMonth+"-"+userInputDate);
            writeOut.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("Tournament created. ");

    }

    public void startTournament() {

        //LocalDate tournamentDate;
        String userInput;

        System.out.println("Type the name of the tournament to run it. ");
        userInput = scan.nextLine();

        tournamentName = userInput;

        try {
            File file = new File("src/" + userInput + ".txt"); //Læser Teams.txt fil som indeholder de forskellige hold.

            Scanner readFile = new Scanner(file);

            //String[] dateValues = readFile.nextLine().split("-");
            //tournamentDate = LocalDate.of(CURRENT_YEAR,Integer.parseInt(dateValues[1]),Integer.parseInt(dateValues[2]));

            while (readFile.hasNextLine()) {

                readFile.nextLine();

                String[] teamValues = readFile.nextLine().split(","); //Læser vores txt fil, og splitter ved "."

                ArrayList<Player> player = new ArrayList<>();
                Player player1 = new Player(teamValues[2]);
                Player player2 = new Player(teamValues[3]);
                player.add(player1);
                player.add(player2);

                Team t = new Team(teamValues[1], player); //[1] navnet på teamet
                participatingTeams.add(t);
                player.clear();

            }

        } catch (IOException e) {
            e.printStackTrace();

            //TODO cant find tournament fail state

        }

        Tournament tournament = new Knockout(tournamentName, participatingTeams);
        tournament.runTournament();

    }

}
