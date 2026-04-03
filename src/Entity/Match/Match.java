package Entity.Match;

import Entity.Team.Team;

public class Match {

    private Innings firstInnings;
    private Innings secondInnings;

    private final Team teamA;
    private final Team teamB;
    private final int totalOvers;

    public Match(Team teamA, Team teamB, int totalOvers) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.totalOvers = totalOvers;
    }

    public void startMatch() {
        firstInnings = new Innings(teamA, teamB, totalOvers);
        secondInnings = new Innings(teamB, teamA, totalOvers);
    }

    public Innings getFirstInnings() {
        return firstInnings;
    }

    public Innings getSecondInnings() {
        return secondInnings;
    }
}
