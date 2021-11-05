import java.util.Random;

public class Match {
    private String gameTime;
    private int teamAScore;
    private int teamBScore;
    private Team teamWinner;

    private Team teamA;
    private Team teamB;

    public Match(){
    }

    public void matchWinner() {

    }
    public void randomMatchWinner() {

        Random rand = new Random();
        int matchDecider = rand.nextInt(1,10);

        if (matchDecider <= 5) {
            teamWinner = teamB;
        } else {
            teamWinner = teamA;
        }

    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    @Override
    public String toString() {
        return ""+teamA+" played "+teamB+" and "+teamWinner+" won.";
    }
}
