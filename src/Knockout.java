import java.util.ArrayList;

public class Knockout extends Tournament {

    public Knockout(String name, ArrayList<Team> teams) {
        super(name, teams);
    }

    @Override
    public void runTournament() {

        System.out.println("The " + getTournamentName() + " tournament is starting. ");

        Bracket tournamentBracket = new Bracket(getTeams().size(), getTeams());
        connectedBracket = tournamentBracket;

        System.out.println(getTeams().size()+" teams enter one team leaves! \n");

        tournamentBracket.randomSeeding();

        tournamentBracket.startMatch();

        setTournamentWinner(tournamentBracket.matches.get(0).getTeamWinner());

        System.out.println(getTournamentWinner() + " -> testing tester");

    }
}