import java.util.ArrayList;

public class Knockout extends Tournament {

    public Knockout(String name, ArrayList<Team> teams) {
        super(name, teams);
    }

    @Override
    public void runTournament() { // The method that run the tournament

        System.out.println("The " + getTournamentName() + " tournament is starting. ");

        Bracket tournamentBracket = new Bracket(getTeams().size(), getTeams()); // Creates the knockout bracket and inputs the teams
        connectedBracket = tournamentBracket;

        System.out.println(getTeams().size()+" teams enter one team leaves! \n");

        tournamentBracket.randomSeeding(); // Randomize the seeding of the teams in the bracket

        tournamentBracket.startMatch(); // Starts the game algorithm

        setTournamentWinner(tournamentBracket.matches.get(0).getTeamWinner()); // Gets the remaining team at the end at sets it as the tournament winner

    }
}