package Entity;

public class Player {

    private final String name;
    private final PlayerType type;
    private int runs;
    private int balls;

    private int runsGiven;
    private int ballsBowled;
    private int wicketsTaken;

    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }

    public void addRuns(int runs) {
        this.runs += runs;
    }

    public void addBall() {
        this.balls++;
    }

    public String getName() {
        return name;
    }

    public PlayerType getType() {
        return type;
    }

    public int getRuns() {
        return runs;
    }

    public int getBalls() {
        return balls;
    }

    public void addRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }

    public void addBallBowled() {
        this.ballsBowled++;
    }

    public void addWicket() {
        this.wicketsTaken++;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public int getBallsBowled() {
        return ballsBowled;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }
}
