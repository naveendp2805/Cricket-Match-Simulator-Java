package Entity.Match;

import Dto.BallResult;

public class Ball {

    private final BallResult result;

    public Ball(BallResult result) {
        this.result = result;
    }

    public BallResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        if(result.isWicket()) return "W";
        if(result.isWide()) return "Wd";
        if(result.isNoBall()) return "NB";
        return String.valueOf(result.getBatsmanRuns());
    }
}
