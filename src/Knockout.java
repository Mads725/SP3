import java.util.ArrayList;

public class Knockout extends Tournament {

    public Knockout(String name,ArrayList<Team> teams) {
        super(name,teams);

    }

    @Override
    public void runTournament() {

        System.out.println("The "+getTournamentName()+" tournament is starting. ");

        Bracket tournamentBracket = new Bracket(16,getTeams());
        connectedBracket = tournamentBracket;

        tournamentBracket.randomSeeding();

        tournamentBracket.startMatch();





    }

}
