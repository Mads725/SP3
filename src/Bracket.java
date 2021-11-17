import java.util.ArrayList;
import java.util.Collections;

public class Bracket {

    private ArrayList<Team> teams;
    ArrayList<Match> matches = new ArrayList<>();
    ArrayList<Match> tempMatches = new ArrayList<>();
    private final int numberParticipatingTeams;
    private int roundNumber = 0;

    public Bracket(int numberParticipatingTeams, ArrayList<Team> teams) {
        this.numberParticipatingTeams = numberParticipatingTeams;
        this.teams = teams;
    }

    public void randomSeeding() { // Randomize the seeding of the teams in the bracket
        int matchNumber = 0;
        Collections.shuffle(teams);

        for (Team t:teams) {
            System.out.println(t);
        }

        System.out.println(roundNumber);

        for (int i = 0; i < numberParticipatingTeams; i++) { // Takes every even team and sets it as teamA and every odd team as teamB

            if (i % 2 == 0) {
                Match m = new Match();
                matches.add(m);
                matches.get(matchNumber).setTeamA(teams.get(i)); // Inserts the first team in the match
            } else {
                matches.get(matchNumber).setTeamB(teams.get(i)); // Inserts the second team in the match
                matchNumber++;                  // Next match
            }
        }
    }

    public void startMatch() { // Plays the matches in order
        int thisMatch = 0;

        while (thisMatch < matches.size()) {

            nextMatchReminder(thisMatch);
            matches.get(thisMatch).matchWinner();

            thisMatch++;
        }

        nextRound();
    }

    public void nextRound() { // Creates the macthes for the next round

        if (matches.size() == 1) {
            System.out.println(matches.get(0).toString()); // If there was only one match played last round,
                                        // it was the final, and the winner is the winner of the tournament
            System.out.println("Congratulation winning the tournament team "+ matches.get(0).getTeamWinner().getTeamName()+"!!!");
        } else {                        // else the next round will be created with the winners of the last round.

            int matchNumber = 0;
            tempMatches.clear();

            for (int i = 0; i < matches.size(); i++) { // Takes every even winning team and sets it as teamA and every odd winning team as teamB

                if (i % 2 == 0) {
                    Match tm = new Match();
                    tempMatches.add(tm);
                    tempMatches.get(matchNumber).setTeamA(matches.get(i).getTeamWinner()); // Gets the winner of one match and sets it as teamA
                } else {
                    tempMatches.get(matchNumber).setTeamB(matches.get(i).getTeamWinner()); // Gets the winner of another match and set it as teamB
                    matchNumber++;
                }

            }
            matches.clear();

            for (Match m : tempMatches) { // Inserts the matches into the next round
                matches.add(m);
            }

            roundNumber++;
            System.out.println("Round number: "+roundNumber);

            startMatch(); // Recursive method call until there is only one match left
        }
    }

    public void nextMatchReminder(int currentMatch) { // Reminds the teams of the next match to be ready when a match starts

        if (currentMatch == matches.size()-1) {
            System.out.println("Next round will start shortly, be ready! ");
        } else {
            System.out.println(matches.get(currentMatch+1).getTeamA().getTeamName()+" and "
                    +matches.get(currentMatch+1).getTeamB().getTeamName()+", please get ready for the next match. ");
        }

    }
    public void matchHistory() {    } // Unused

}