import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    Scanner scan = new Scanner(System.in); //User input

    public void UI() {

        String userInput;

        System.out.println("Type 'create' to create a new tournament. Type 'run' to run an existing tournament. ");
        userInput = scan.nextLine();

        if (userInput.equals("create")) {

            createTournament();

        } else if (userInput.equals("run")) {

            runTournament();

        }

    }

    public void createTournament(){

        String userInput;

        System.out.println("Type the name of the tournament: ");
        userInput = scan.nextLine();

        try {
            File newTournament = new File("src/"+userInput+".txt");
            newTournament.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File created. Please insert the teams for the tournament. ");

    }

    public void runTournament() {

        String userInput;
        ArrayList<Team> participatingTeams = new ArrayList<>();

        System.out.println("Type the name of the tournament to run it. ");
        userInput = scan.nextLine();



        Tournament tournament = new Knockout(userInput,participatingTeams);

    }

}
