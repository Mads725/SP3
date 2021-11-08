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
    public Team randomMatchWinner() {

        Random rand = new Random();
        int matchDecider = (int) Math.random()*10;

        if (matchDecider <= 5) {
            teamWinner = teamB;
            return teamB;
        } else {
            teamWinner = teamA;
            return teamA;
        }

    }

    public Team getTeamWinner() {
        return teamWinner;
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
