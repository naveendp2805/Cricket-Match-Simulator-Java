package Service;

import Dto.BallResult;
import Dto.OverResult;
import Entity.Ball;
import Entity.Over;
import Entity.Player;
import Entity.PlayerType;

import java.util.List;

public class BallService {

    private final Over over;

    public BallService(Over over) {
        this.over = over;
    }

    public OverResult getScoreForOver(List<Player> batters, Player striker, Player nonStriker, Player bowler, int nextBatsmanIndex)
    {
        int totalRuns = 0;
        int wickets = 0;

        for(Ball ball : over.getBalls())
        {
            BallResult result = ball.getResult();

            if(result.isNoBall() || result.isWide())
            {
                totalRuns += result.getTotalRuns();
                bowler.addRunsGiven(result.getExtraRuns());
            }
            else if(result.isWicket())
            {
                striker.addBall();
                wickets++;

                bowler.addBallBowled();
                bowler.addWicket();

                if(nextBatsmanIndex < batters.size())
                    striker = batters.get(nextBatsmanIndex++);
                else
                    break;
            }
            else
            {
                int runs = result.getTotalRuns();

                striker.addRuns(result.getBatsmanRuns());
                striker.addBall();

                bowler.addRunsGiven(runs);
                bowler.addBallBowled();

                totalRuns += runs;

                if ((result.getBatsmanRuns() & 1) == 1)
                {
                    Player temp = striker;
                    striker = nonStriker;
                    nonStriker = temp;
                }
            }

        }

        Player temp = striker;
        striker = nonStriker;
        nonStriker = temp;

        return new OverResult(totalRuns, wickets, striker, nonStriker, nextBatsmanIndex);
    }

}
