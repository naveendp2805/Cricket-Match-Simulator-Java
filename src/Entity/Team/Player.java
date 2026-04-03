package Entity.Team;

public class Player {

    private final String name;
    private final PlayerType type;

    private int runs;
    private int balls;
    private int fours;
    private int sixes;
    private String dismissal = "Not Out";

    private int runsGiven;
    private int ballsBowled;
    private int wicketsTaken;

    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }

    public void setDismissalInfo(String info)
    {
        this.dismissal = info;
    }

    public void addBattingStats(int runs)
    {
        this.runs += runs;
        this.balls++;

        if(runs == 4) fours++;
        if(runs == 6) sixes++;
    }

    public void facedDotBall() {
        this.balls++;
    }

    public void addRunsOnly(int runs)
    {
        this.runs += runs;
        if(runs == 4) fours++;
        if(runs == 6) sixes++;
    }

    public void addBowlingStats(int runs, boolean isWicket)
    {
        this.ballsBowled++;
        this.runsGiven += runs;

        if(isWicket) this.wicketsTaken++;
    }

    public void addExtraRuns(int runs) {
        this.runsGiven += runs;
    }

    public double getStrikeRate() {
        if(balls == 0) return 0;
        return (runs * 100.0) / balls;
    }

    public String getOversBowled()
    {
        return ballsBowled/6 + "." + ballsBowled%6;
    }

    public double getEconomy()
    {
        if(ballsBowled == 0) return 0;
        return (runsGiven * 6.0) / ballsBowled;
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

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
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

    public String getDismissal() {
        return dismissal;
    }
}
