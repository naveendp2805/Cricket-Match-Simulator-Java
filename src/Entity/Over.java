package Entity;

import java.util.List;

public class Over {

    private final List<Ball> balls;
    private final int overNumber;

    public Over(List<Ball> balls, int overNumber) {
        this.balls = balls;
        this.overNumber = overNumber;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public int getOverNumber() {
        return overNumber;
    }

}
