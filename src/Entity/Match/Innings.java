package Entity.Match;

import Entity.Team.Team;

public class Innings {

    private final Team battingTeam;
    private final Team bowlingTeam;
    private final int totalOvers;

    private int totalRuns;
    private int wickets;
    private int wides;
    private int noBalls;

    private int totalBalls;

    public Innings(Team battingTeam, Team bowlingTeam, int totalOvers) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.totalOvers = totalOvers;
    }

    public void addRuns(int runs) {
        this.totalRuns += runs;
    }

    public void addWicket() {
        this.wickets++;
    }

    public void addWide(int runs) {
        this.wides += runs;
    }

    public void addNoBall(int runs) {
        this.noBalls += runs;
    }

    public void addBall() {
        this.totalBalls++;
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public int getTotalOvers() {
        return totalOvers;
    }

    public String getOvers() {
        return totalBalls/6 + "." + totalBalls%6;
    }

    public double getRunRate()
    {
        if(totalBalls == 0) return 0;
        return (totalRuns*6.0) / totalBalls;
    }

    public int getWickets() {
        return wickets;
    }

    public int getWides() {
        return wides;
    }

    public int getNoBalls() {
        return noBalls;
    }

    public int getWidesAndNoBalls() {
        return wides + noBalls;
    }

    public int getTotalRuns() {
        return totalRuns;
    }
}
