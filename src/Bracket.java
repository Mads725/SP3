import java.util.ArrayList;
import java.util.Collections;

public class Bracket {

    private ArrayList<Team> teams;
     ArrayList<Match> matches;
    private int numberParticipatingTeams;

    public Bracket(int numberParticipatingTeams, ArrayList<Team> teams) {
        this.numberParticipatingTeams = numberParticipatingTeams;
        this.teams = teams;

    }

    public void randomSeeding() {

        int matchNumber = 0;
        Collections.shuffle(teams);

        for (int i = 0;i<numberParticipatingTeams;i++){

            if (numberParticipatingTeams%2 == 0) {
                Match m = new Match();
                m.setTeamA(teams.get(i));
                matches.add(m);
            } else if (numberParticipatingTeams%2 == 1){
                matches.get(matchNumber).setTeamB(teams.get(i));
                matchNumber++;
            }

        }

    }


    public void nextRound() {



    }

    public void matchHistory() {

        
        
    }

    public void nextMatchReminder() {
        
        

    }

    public void startMatch() {
        
        

    }

}
