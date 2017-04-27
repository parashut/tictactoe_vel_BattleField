package model;


public class Player {
    private String name;
    private int points;
    private Sign sign;

    public Player(String name, Sign sign) {
        this.name = name;
        this.points = 0;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public Sign getSign() {
        return sign;
    }

    public void addPoint() {
        this.points++;
    }
}
