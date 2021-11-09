public class Player {

    private String name;

    public Player(String name) { //Constructor
        this.name = name;
    }

    @Override
    public String toString() { //toString
        return name;
    }
}