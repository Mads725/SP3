import java.util.ArrayList;
import java.util.Collections;

public class Bracket {

    private ArrayList<Team> teams;
     ArrayList<Match> matches = new ArrayList<>();
     ArrayList<Match> tempMatches = new ArrayList<>();
    private int numberParticipatingTeams;

    public Bracket(int numberParticipatingTeams, ArrayList<Team> teams) {
        this.numberParticipatingTeams = numberParticipatingTeams;
        this.teams = teams;

    }

    public void randomSeeding() {

        int matchNumber = 0;
        Collections.shuffle(teams);

        for (int i = 0;i<numberParticipatingTeams;i++){

            if (i%2 == 0) {
                Match m = new Match();
                matches.add(m);
                matches.get(matchNumber).setTeamA(teams.get(i));
            } else if (i%2 == 1){
                matches.get(matchNumber).setTeamB(teams.get(i));
                matchNumber++;
            }

        }

    }


    public void nextRound() {

        int matchNumber = 0;
        tempMatches.clear();
        for (int i = 0;i < matches.size();i++) {

            if(i%2 == 0) {
                Match tm = new Match();
                tempMatches.add(tm);
                tempMatches.get(matchNumber).setTeamA(matches.get(i).getTeamWinner());
            } else if (i%2 == 1) {
                tempMatches.get(matchNumber).setTeamB(matches.get(i).getTeamWinner());
                matchNumber++;
            }

        }

        matches = tempMatches;
        tempMatches.clear();

        //TODO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>HER<<<<<<<<<<<<<<<<<<<<<<<<<<<<< måske startmatch()

    }

    public void matchHistory() {

        
        
    }

    public void nextMatchReminder() {
        
        

    }

    public void startMatch() {
        int thisMatch = 0;

        while (thisMatch < matches.size()) {
            matches.get(thisMatch).randomMatchWinner();
            System.out.println(matches.get(thisMatch).getTeamWinner());
            thisMatch++;
        }

        nextRound();

    }

}
