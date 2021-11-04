import java.util.ArrayList;

public class Player {

    private String name;
    private int age;
    private String playerMail;
    private ArrayList<Player>players;

    public Player(String name, int age, String playerMail, ArrayList<Player> players) {
        this.name = name;
        this.age = age;
        this.playerMail = playerMail;
        this.players = players;
    }

    public void createTeam() {

    }

    public void leaveTeam() {

    }

    @Override
    public String toString() {
        String s = "";
        return s;
    }
}
