import java.util.Scanner;

public class Controller {

    private Scanner scan = new Scanner(System.in);

    public void Ui() { //UI = user inputs

        System.out.println(" *** WELCOME TO THE TOURNAMENT *** ");
        System.out.println(" Please select an option below to start ");
        System.out.println(" Type 'E' to create a new tournament ");
        System.out.println(" Type 'W' to run an existing tournament ");
        System.out.println(" Type 'Q' to quit the registration menu ");
        String userInput;
        userInput = scan.nextLine();
        boolean tournamentExist = false;

        do {

            if (userInput.equalsIgnoreCase("e")) {

                createTournament();

            } else if (userInput.equalsIgnoreCase("w")) {

                startTournament();

            } else if (tournamentExist) {
                System.out.println("The tournament does not exists, please try again ");

            } else if (userInput.equalsIgnoreCase("q")) {
                System.out.println("Quitting the registration program \n" + "Have a good day! ");
                tournamentExist = false;
            }
        }
        while (tournamentExist);
    }

    public void createTournament() { //Method to create a new tournament

        String userInput;
        int userInputDate;
        int userInputMonth;

        System.out.println("Type the name of the tournament: ");
        userInput = scan.nextLine();
        System.out.println("Type which day the tournament is held: ");
        userInputDate = Integer.parseInt(scan.nextLine());
        System.out.println("Type which month the tournament is held: ");
        userInputMonth = Integer.parseInt(scan.nextLine());


        /* Using a boolean expression as a try catch. if there is a problem making a file
        then I can catch it here, before it gets to the exception. Program stops if there is a
        problem writing a file.
         */
        boolean filedWritten = Io.createNewTournamentFile(
                userInput, Final.TOURNAMENT_START_YEAR, userInputDate, userInputMonth, Final.TOURNAMENT_START_TIME);
        if (!filedWritten) {
            System.out.println("Something went wrong, try again ");
            return;
        }

        System.out.println("Tournament created.");
        System.out.println("Would you like to start the tournament? ");
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("yes")) {

            System.out.println("Starting the tournament: ");
            Io.startTheTournament(userInput);

        } else if (input.equalsIgnoreCase("no")) {
            System.out.println("Quitting the registration menu \n" + "Have a good day!");
        }
    }

    public void startTournament() { //Method to select which tournament to start

        String userInput;

        System.out.println("Enter the name of the tournament, you wish to start: ");
        userInput = scan.nextLine();
        String tournamentName = userInput;

        Io.startTheTournament(tournamentName);

    }

}





