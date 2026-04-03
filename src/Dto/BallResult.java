package Dto;

import Entity.Match.BallType;

public class BallResult {

    private final int batsmanRuns;
    private final int extraRuns;
    private final BallType type;

    public BallResult(int batsmanRuns, int extraRuns, BallType type) {
        this.batsmanRuns = batsmanRuns;
        this.extraRuns = extraRuns;
        this.type = type;
    }

    public int getTotalRuns() {
        return batsmanRuns + extraRuns;
    }

    public boolean isWicket() {
        return type == BallType.WICKET;
    }

    public boolean isWide() {
        return type == BallType.WIDE;
    }

    public boolean isNoBall() {
        return type == BallType.NO_BALL;
    }

    public int getBatsmanRuns() {
        return batsmanRuns;
    }

    public int getExtraRuns() {
        return extraRuns;
    }

    public BallType getType() {
        return type;
    }

}
