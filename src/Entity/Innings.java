package Entity;

public class Innings {

    private final Team battingTeam;
    private final Team bowlingTeam;
    private final int totalOvers;

    private int totalRuns;
    private int wickets;
    private int currentOver;

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

    public void incrementOver() {
        this.currentOver++;
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

    public int getCurrentOver() {
        return currentOver;
    }

    public int getWickets() {
        return wickets;
    }

    public int getTotalRuns() {
        return totalRuns;
    }
}
