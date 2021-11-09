import java.util.Random;
import java.util.Scanner;

public class Match {
    private String gameTime; //useless
    private int teamAScore;
    private int teamBScore;
    private Team teamWinner;

    private Team teamA;
    private Team teamB;


    public void matchWinner() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Type team "+teamA.getTeamName()+" goals: ");
        try {
            teamAScore = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please type the number of goals team "+teamA.getTeamName()+" scored. ");
            teamAScore = Integer.parseInt(scan.nextLine());
        }

        System.out.println("Type team "+teamB.getTeamName()+" goals: ");
        try {
            teamBScore = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please type the number of goals team "+teamB.getTeamName()+" scored. ");
            teamBScore = Integer.parseInt(scan.nextLine());
        }
        if (teamAScore < teamBScore) {
            teamWinner = teamB;
            teamWinner.setTotalGoalScore(teamBScore-teamAScore);
        } else {
            teamWinner = teamA;
            teamWinner.setTotalGoalScore(teamAScore-teamBScore);
        }

        System.out.println("Team "+teamWinner.getTeamName()+" won the match. ");

    }
    public void randomMatchWinner() {

        Random random = new Random();
        int matchDecider = random.nextInt(10)+1;

        if (matchDecider <= 5) {
            teamWinner = teamB;
        } else {
            teamWinner = teamA;
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
        return ""+teamA.getTeamName()+" played "+teamB.getTeamName()+" and "+teamWinner.getTeamName()+" won.";
    }
}
