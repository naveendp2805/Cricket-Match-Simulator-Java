package Dto;

import Entity.Player;

public class OverResult {

    private final int runs;
    private final int wickets;
    private final Player striker;
    private final Player nonStriker;
    private final int nextBatsmanIndex;

    public OverResult(int runs, int wickets, Player striker, Player nonStriker, int nextBatsmanIndex) {
        this.runs = runs;
        this.wickets = wickets;
        this.striker = striker;
        this.nonStriker = nonStriker;
        this.nextBatsmanIndex = nextBatsmanIndex;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public Player getStriker() {
        return striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public int getNextBatsmanIndex() {
        return nextBatsmanIndex;
    }
}
