import java.util.ArrayList;
import java.util.Collections;

public class Bracket {

    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private int numberParticipatingTeams;

    public Bracket(int numberParticipatingTeams, ArrayList<Team> teams) {
        this.numberParticipatingTeams = numberParticipatingTeams;
        this.teams = teams;

    }

    public void randomSeeding() {

        Collections.shuffle(teams);



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
