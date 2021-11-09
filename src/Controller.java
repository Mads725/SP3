import jdk.swing.interop.SwingInterOpUtils;

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

        System.out.println("* * * TOURNAMENT MENU * * *");
        System.out.println("Please select an option below");
        String userInput;
        boolean tournamentExist = false;

        //userInput = scan.nextLine();

        do {
            System.out.println("Type 'create' to create a new Tournament");
            System.out.println("Type 'run' to run an existing Tournament");
            System.out.println("Press Q to quit the program");
            userInput = scan.nextLine();

/*
        System.out.println("Type 'create' to create a new tournament. Type 'run' to run an existing tournament. ");
        userInput = scan.nextLine();


            if (userInput.equals("create")) {

                createTournament();

            } else if (userInput.equals("run")) {

                runTournament();


            } else if (tournamentExist) {
                System.out.println("Tournament does not exist, try a different one");

            } else if (userInput.equalsIgnoreCase("q")) {
                System.out.println("Quitting");
                tournamentExist = false;
            }

        }
*/
        int testCounter = 0;
        do {
            System.out.println("Type 'create' to create a new Tournament");
            System.out.println("Type 'run' to run an existing Tournament");
            System.out.println("Press W to add a new team to the Tournament");
            System.out.println("Press Q to quit the program");
            userInput = scan.nextLine();

            if (userInput.equalsIgnoreCase("create")) {

                createTournament();

            } else if (userInput.equalsIgnoreCase("run")) {

                startTournament();

            } else if (tournamentExist) {
                System.out.println("Tournament does not exist, try a different one");

            } else if (userInput.equalsIgnoreCase("w")) {


            } else if (userInput.equalsIgnoreCase("q")) {
                System.out.println("Quitting");
                tournamentExist = false;
            }
            //TODO indsæt do while løkke rundt om if else statements
            //TODO Add new team

        } while (tournamentExist);


        } while (tournamentExist);
    }

    public void createTournament() {

        String userInput;
        int userInputDate;
        int userInputMonth;
        boolean quit = false;


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
        userInputDate = Integer.parseInt(scan.nextLine());
        System.out.println("Type the month of the tournament. ");
        userInputMonth = Integer.parseInt(scan.nextLine());

        //LocalDate.of(CURRENT_YEAR,userInputMonth,userInputDate);

        try {
            File newTournament = new File("src/" + userInput + ".txt");
            BufferedWriter writeOut = new BufferedWriter(new FileWriter(newTournament));
            writeOut.write("The tournament " + userInput + " starts " + CURRENT_YEAR + "-" + userInputMonth + "-" + userInputDate);
            writeOut.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("Tournament created. ");

        //TODO lav en add method med teams og derefter run

        System.out.println("Would you like to start the game? ");
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            startTournament();
        } else if (input.equalsIgnoreCase("no")) {
            System.out.println("Quitting program");
            quit = false;
        }
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