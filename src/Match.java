public class Match {
    private String gameTime;
    private int teamAScore;
    private int teamBScore;
    private String teamWinner;

    public Match(String gameTime, int teamAScore, int teamBScore, String teamWinner) {
        this.gameTime = gameTime;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
        this.teamWinner = teamWinner;
    }

    public void matchWinner() {

    }

    @Override
    public String toString() {
        String s = "";
        return s;
    }
}
